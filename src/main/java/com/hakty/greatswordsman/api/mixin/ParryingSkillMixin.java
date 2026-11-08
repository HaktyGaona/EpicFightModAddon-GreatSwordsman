package com.hakty.greatswordsman.api.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.event.types.entity.TakeDamageEvent;
import yesman.epicfight.registry.entries.EpicFightSkillDataKeys;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.damagesource.StunType;

@Mixin(ParryingSkill.class)
public class ParryingSkillMixin {

    @ModifyConstant(
            method = {"lambda$onInitiate$4", "lambda$startHolding$5"},
            constant = @org.spongepowered.asm.mixin.injection.Constant(intValue = 2),
            remap = false
    )
    private int greatswordsman$shrinkParryWindowMultiplier(int original) {
        return 2;
    }

    @Redirect(
            method = {"lambda$onInitiate$4", "lambda$startHolding$5"},
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/Integer;intValue()I"
            ),
            remap = false
    )
    private int greatswordsman$inclusiveParryWindow(Integer lastActive) {
        return lastActive - 1;
    }

    @Redirect(
            method = "guard",
            at = @At(
                    value = "INVOKE",
                    target = "Lyesman/epicfight/skill/SkillDataManager;setData(Lnet/neoforged/neoforge/registries/DeferredHolder;Ljava/lang/Object;)V"
            ),
            remap = false
    )
    private void greatswordsman$replaceLastActiveReset(
            yesman.epicfight.skill.SkillDataManager dataManager,
            net.neoforged.neoforge.registries.DeferredHolder<?, ?> key,
            Object value) {
        dataManager.setDataSync(EpicFightSkillDataKeys.PENALTY, 0.1F);
    }
    @Inject(
            method = "guard",
            at = @At(
                    value = "INVOKE",
                    target = "Lyesman/epicfight/api/event/types/entity/TakeDamageEvent$Income;setParried(Z)V",
                    shift = At.Shift.AFTER
            ),
            remap = false
    )
    private void greatswordsman$stunAttackerOnParry(
            SkillContainer container,
            yesman.epicfight.world.capabilities.item.CapabilityItem capability,
            yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch playerpatch,
            TakeDamageEvent.Income income,
            float knockback,
            float consume,
            boolean isLastAttack,
            CallbackInfo ci) {

        Entity offender = GuardSkill.getOffender(income.getDamageSource());
        if (!(offender instanceof LivingEntity living)) {
            return;
        }

        LivingEntityPatch<?> offenderPatch =
                EpicFightCapabilities.getEntityPatch(living, LivingEntityPatch.class);
        if (offenderPatch == null) {
            return;
        }

        // Apply a LONG stun. The float is the stun time in ticks (adjust to taste).
        offenderPatch.applyStun(StunType.LONG, 40.0F);
    }
}