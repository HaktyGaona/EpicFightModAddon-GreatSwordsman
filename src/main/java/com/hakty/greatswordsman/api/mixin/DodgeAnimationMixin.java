package com.hakty.greatswordsman.api.mixin;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.animation.types.DodgeAnimation;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Function;

@Mixin(DodgeAnimation.class)
public class DodgeAnimationMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"), remap = false)
    private static void onClassInit(CallbackInfo ci) {
        try {
            // 获取DODGEABLE_SOURCE_VALIDATOR字段
            Field field = DodgeAnimation.class.getDeclaredField("DODGEABLE_SOURCE_VALIDATOR");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            Function<DamageSource, AttackResult.ResultType> newValidator = (damagesource) -> {
                if (
                        damagesource.getEntity() != null
//                                && !damagesource.is(DamageTypeTags.IS_EXPLOSION)
//                                && !damagesource.is(DamageTypes.MAGIC)
                                && !damagesource.is(DamageTypeTags.BYPASSES_ARMOR)
                                && !damagesource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)
                                && !damagesource.is(EpicFightDamageTypeTags.BYPASS_DODGE)
                ) {
                    return AttackResult.ResultType.MISSED;
                }

                return AttackResult.ResultType.SUCCESS;
            };

            field.set(null, newValidator);
            System.out.println("[GreatSwordsman] Successfully removed magic damage check from DODGEABLE_SOURCE_VALIDATOR");

        } catch (Exception e) {
            System.err.println("[GreatSwordsman] Failed to modify DODGEABLE_SOURCE_VALIDATOR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}