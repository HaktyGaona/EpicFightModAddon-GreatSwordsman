package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.data.Moveset;
import yesman.epicfight.registry.deferred.MovesetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredMoveset;
import yesman.epicfight.skill.guard.GuardSkill;

public class WeaponMovesets {

    private WeaponMovesets() {}

    public static final MovesetRegister REGISTRY = MovesetRegister.create(GreatSwordsman.MOD_ID);

    public static final DeferredMoveset BASTARDSWORD_1H = REGISTRY.registerMoveset("bastardsword_1h", () -> Moveset.builder()
            .addComboAttacks(
                    SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO2, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO3,
                    SwordCraftAnimations.SWORDCRAFT_TYPE1_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE1_AIRSLASH
            )
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE1_IDLE,
                    LivingMotions.IDLE, LivingMotions.JUMP, LivingMotions.KNEEL, LivingMotions.SNEAK)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE1_WALK,
                    LivingMotions.WALK, LivingMotions.CHASE)
            .addLivingMotionModifier(LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE1_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE1_GUARD)
            .addGuardAnimations(GuardSkill.BlockType.GUARD, SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
            .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)
            .addInnateSkill((itemStack, playerPatch) -> SwordCraftSkills.DRAW_SLASH.get())
            .setPassiveSkill(SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_1H_TO_2H)

    );
    public static final DeferredMoveset BASTARDSWORD_2H = REGISTRY.registerMoveset("bastardsword_2h", () -> Moveset.builder()
            .addComboAttacks(SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE2_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE1_AIRSLASH)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_IDLE, LivingMotions.IDLE)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_WALK, LivingMotions.WALK, LivingMotions.CHASE)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_KNEEL, LivingMotions.KNEEL)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_SNEAK, LivingMotions.SNEAK)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_SWIM, LivingMotions.SWIM)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_FLOAT, LivingMotions.FLOAT)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_FALL, LivingMotions.FALL)
            .addLivingMotionModifier(LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE2_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE2_GUARD)
            .addGuardAnimations(GuardSkill.BlockType.GUARD, SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
            .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD, SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO2)
            .addInnateSkill((itemStack, playerPatch) -> SwordCraftSkills.BRIGHTWINDSLASH.get())
            .setPassiveSkill(SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_2H_TO_1H)
    );


}
