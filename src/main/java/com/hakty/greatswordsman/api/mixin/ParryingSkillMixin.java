package com.hakty.greatswordsman.api.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.event.types.entity.TakeDamageEvent;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.guard.ParryingSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.damagesource.StunType;

@Mixin(ParryingSkill.class)
public class ParryingSkillMixin {

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
            yesman.epicfight.skill.SkillContainer container,
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