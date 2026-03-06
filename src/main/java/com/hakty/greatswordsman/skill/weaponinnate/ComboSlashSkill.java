package com.hakty.greatswordsman.skill.weaponinnate;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.effect.EpicFightMobEffects;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener.EventType;

import java.util.List;
import java.util.UUID;

public class ComboSlashSkill extends WeaponInnateSkill {
    private static final UUID EVENT_UUID = UUID.fromString("1f6aea85-2194-4761-af8e-1a5c99c4f414");
    public final AssetAccessor<? extends AttackAnimation> first;
    public final AssetAccessor<? extends AttackAnimation> second;
    public final AssetAccessor<? extends AttackAnimation> third;
    public final AssetAccessor<? extends AttackAnimation> fourth;
    public final AssetAccessor<? extends AttackAnimation> fifth;
    public final AssetAccessor<? extends AttackAnimation> fail;

    public ComboSlashSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
        this.first = SwordCraftAnimations.COMBOSLASH_1;
        this.second = SwordCraftAnimations.COMBOSLASH_2;
        this.third = SwordCraftAnimations.COMBOSLASH_3;
        this.fourth = SwordCraftAnimations.COMBOSLASH_4;
        this.fifth = SwordCraftAnimations.COMBOSLASH_5;
        this.fail = SwordCraftAnimations.COMBOSLASH_FAIL;
    }

    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecutor().getEventListener().addEventListener(EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID, (event) -> {
            if (SwordCraftAnimations.COMBOSLASH_1.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.second);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("1 to 2 success");
                } else {
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("1 to 2 fail");
                }
            }
            else if (SwordCraftAnimations.COMBOSLASH_2.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.third);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("2 to 3 success");
                } else {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("2 to 3 fail");
                }
            }
            else if (SwordCraftAnimations.COMBOSLASH_3.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fourth);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("3 to 4 success");
                } else {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("3 to 4 fail");
                }
            }
            else if (SwordCraftAnimations.COMBOSLASH_4.equals(event.getAnimation())) {
                List<LivingEntity> hurtEntities = event.getPlayerPatch().getCurrentlyActuallyHitEntities();
                if (!hurtEntities.isEmpty() && hurtEntities.get(0).isAlive()) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fifth);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("4 to 5 success");
                } else {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                    System.out.println("4 to 5 fail");
                }
            }
            else if (SwordCraftAnimations.COMBOSLASH_5.equals(event.getAnimation())) {
                    event.getPlayerPatch().getServerAnimator().getPlayerFor(null).reset();
                    event.getPlayerPatch().reserveAnimation(this.fail);
                    event.getPlayerPatch().getCurrentlyActuallyHitEntities().clear();
                System.out.println("5 end");
            }
        });
    }
    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(EventType.ATTACK_ANIMATION_END_EVENT, EVENT_UUID);
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        container.getExecutor().playAnimationSynchronized(this.first, 0);
        LivingEntity target = container.getExecutor().getTarget();
        container.getExecutor().getOriginal().addEffect(new MobEffectInstance(EpicFightMobEffects.STUN_IMMUNITY.get(), 35, 0, true, false, false));
        if (target != null && target.isAlive()) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 35, 2));
        }
    }
    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(0), "Slash1:");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(1), "Slash2 to 4:");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(4), "Slash5:");
        return list;
    }
    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.second.get().phases[0].addProperties(this.properties.get(1).entrySet());
        this.third.get().phases[0].addProperties(this.properties.get(2).entrySet());
        this.fourth.get().phases[0].addProperties(this.properties.get(3).entrySet());
        this.fifth.get().phases[0].addProperties(this.properties.get(4).entrySet());
        return this;
    }
}
