package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.data.Moveset;
import yesman.epicfight.registry.deferred.MovesetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredMoveset;

public class WeaponMovesets {

    private WeaponMovesets() {}

    public static final MovesetRegister REGISTRY = MovesetRegister.create(GreatSwordsman.MOD_ID);

    public static final DeferredMoveset BASTARDSWORD_1H = REGISTRY.registerMoveset("bastardsword_1h", () -> Moveset.builder()
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE1_IDLE, LivingMotions.IDLE, LivingMotions.JUMP, LivingMotions.KNEEL, LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE1_WALK, LivingMotions.WALK, LivingMotions.CHASE)
            .addLivingMotionModifier(LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE1_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE1_GUARD)
            .addComboAttacks(SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO2, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO3, SwordCraftAnimations.SWORDCRAFT_TYPE1_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE1_AIRSLASH)
            .addInnateSkill(((itemStack, playerPatch) -> SwordCraftSkills.COMBOSLASH.get()))
            .setPassiveSkill(SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_1H_TO_2H)
    );
    public static final DeferredMoveset BASTARDSWORD_2H = REGISTRY.registerMoveset("bastardsword_2h", () -> Moveset.builder()
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_IDLE, LivingMotions.IDLE, LivingMotions.FLY, LivingMotions.CREATIVE_FLY, LivingMotions.CREATIVE_IDLE)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_WALK, LivingMotions.WALK, LivingMotions.CHASE)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_KNEEL, LivingMotions.KNEEL)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_SNEAK, LivingMotions.SNEAK)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_SWIM, LivingMotions.SWIM)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_FLOAT, LivingMotions.FLOAT)
            .addLivingMotionsRecursive(SwordCraftAnimations.SWORDCRAFT_TYPE2_FALL, LivingMotions.FALL)
            .addLivingMotionModifier(LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE2_RUN)
            .addLivingMotionModifier(LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE2_GUARD)
            .addComboAttacks(SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE2_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE1_AIRSLASH)
            .addInnateSkill(((itemStack, playerPatch) -> SwordCraftSkills.BLIGHTWINDSLASH.get()))
            .setPassiveSkill(SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_2H_TO_1H)
    );


}
