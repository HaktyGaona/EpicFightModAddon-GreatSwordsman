package com.hakty.greatswordsman.api.mixin;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.api.animation.types.DodgeAnimation;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;

import java.lang.reflect.Field;
import java.util.function.Function;

@Mixin(DodgeAnimation.class)
public class DodgeAnimationMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"), remap = false)
    private static void modifyDodgeValidator(CallbackInfo ci) {
        try {
            Field field = DodgeAnimation.class.getDeclaredField("DODGEABLE_SOURCE_VALIDATOR");

            modifyStaticFinalField(field, mDK_1_21_1_ModDevGradle_main$createNewValidator());

            System.out.println("[GreatSwordsman] Successfully modified DODGEABLE_SOURCE_VALIDATOR using Unsafe");

        } catch (Exception e) {
            System.err.println("[GreatSwordsman] Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void modifyStaticFinalField(Field field, Object newValue) throws Exception {
        Field unsafeField = null;
        for (Field f : sun.misc.Unsafe.class.getDeclaredFields()) {
            if (f.getType() == sun.misc.Unsafe.class) {
                unsafeField = f;
                break;
            }
        }

        if (unsafeField == null) {
            throw new RuntimeException("Could not find Unsafe field");
        }

        unsafeField.setAccessible(true);
        sun.misc.Unsafe unsafe = (sun.misc.Unsafe) unsafeField.get(null);

        Object staticFieldBase = unsafe.staticFieldBase(field);
        long staticFieldOffset = unsafe.staticFieldOffset(field);

        unsafe.putObject(staticFieldBase, staticFieldOffset, newValue);
    }

    @Unique
    private static Function<DamageSource, AttackResult.ResultType> mDK_1_21_1_ModDevGradle_main$createNewValidator() {
        return (damagesource) -> {
            System.out.println("[GreatSwordsman] Custom validator called for damage: " + damagesource.type());

            if (damagesource.getEntity() != null
                    && !damagesource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)
                    && !damagesource.is(EpicFightDamageTypeTags.BYPASS_DODGE)) {
                return AttackResult.ResultType.MISSED;
            }
            return AttackResult.ResultType.SUCCESS;
        };
    }
}