package com.hakty.greatswordsman.gameasset;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.skill.weaponpassive.BastardSwordPostureCharge1To2;
import com.hakty.greatswordsman.skill.weaponpassive.BastardSwordPostureCharge2To1;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.SkillDataKey;

public final class SwordCraftSkillDataKeys {

    private SwordCraftSkillDataKeys () {}

    public static final DeferredRegister<SkillDataKey<?>> REGISTRY = DeferredRegister.create(EpicFightRegistries.SKILL_DATA_KEY, GreatSwordsman.MOD_ID);

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> POSTURE_CHARGE_1H = REGISTRY.register("posture_charge_1h", () ->
            SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, true, false, BastardSwordPostureCharge1To2.class, BastardSwordPostureCharge2To1.class));

    public static final DeferredHolder<SkillDataKey<?>, SkillDataKey<Boolean>> POSTURE_CHARGE_2H = REGISTRY.register("posture_charge_2h", () ->
            SkillDataKey.createSkillDataKey(ByteBufCodecs.BOOL, false, false, BastardSwordPostureCharge1To2.class, BastardSwordPostureCharge2To1.class));
}
