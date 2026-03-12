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

import java.util.function.Function;

@Mixin(DodgeAnimation.class)
public class DodgeAnimationMixin {

    @Inject(method = "<clinit>", at = @At("HEAD"), remap = false)
    private static void onClassInit(CallbackInfo ci) {
        System.out.println("=== [GreatSwordsman] SimpleTestMixin: DodgeAnimation class is loading! ===");
    }
}