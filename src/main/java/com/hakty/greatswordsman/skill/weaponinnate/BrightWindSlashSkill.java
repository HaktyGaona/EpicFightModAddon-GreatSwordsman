package com.hakty.greatswordsman.skill.weaponinnate;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.registry.entries.EpicFightMobEffects;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class BrightWindSlashSkill extends WeaponInnateSkill {

    public final AssetAccessor<? extends AttackAnimation> first;

    public BrightWindSlashSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
        this.first = SwordCraftAnimations.BRIGHTWINDSLASH;
    }

    @Override
    public void executeOnServer(SkillContainer container, CompoundTag arguments) {
        container.getExecutor().playAnimationSynchronized(this.first, 0);
        super.executeOnServer(container, arguments);
        ((ServerPlayer) container.getExecutor().getOriginal()).addEffect(
                new MobEffectInstance(BuiltInRegistries.MOB_EFFECT.wrapAsHolder(EpicFightMobEffects.STUN_IMMUNITY.get()),
                        30, 0, true, false, false)
        );
        ((ServerPlayer) container.getExecutor().getOriginal()).addEffect(
                new MobEffectInstance(MobEffects.REGENERATION, 30, 4, true,false, false)
        );
    }

    @Override
    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerCap) {
        List<Component> list = super.getTooltipOnItem(itemStack, cap, playerCap);
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(0), "Slash1:");
        this.generateTooltipforPhase(list, itemStack, cap, playerCap, this.properties.get(1), "Slash2:");
        return list;
    }
    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.first.get().phases[0].addProperties(this.properties.get(0).entrySet());
        this.first.get().phases[1].addProperties(this.properties.get(1).entrySet());
        return this;
    }
}
