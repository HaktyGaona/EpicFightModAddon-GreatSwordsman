package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import yesman.epicfight.api.ex_cap.provider.ProviderConditional;
import yesman.epicfight.registry.deferred.ProviderConditionalRegister;
import yesman.epicfight.registry.deferred.holders.DeferredConditional;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public final class WeaponProviderConditionals {
    private WeaponProviderConditionals() {}

    public static final ProviderConditionalRegister REGISTRY = ProviderConditionalRegister.create(GreatSwordsman.MOD_ID);

    public static final DeferredConditional BASTARDSWORD_DEFAULT = REGISTRY.registerConditional(
            "bastardsword_default",
            () -> ProviderConditional.createDefault(CapabilityItem.Styles.ONE_HAND, true)
    );

    public static final DeferredConditional BASTARDSWORD_1H = REGISTRY.registerConditional(
            "bastardsword_1h_wield_style",
            () -> ProviderConditional.createSkillDataKey(CapabilityItem.Styles.ONE_HAND, SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_1H_TO_2H, SkillSlots.WEAPON_PASSIVE, SwordCraftSkillDataKeys.POSTURE_CHARGE_1H, false));

    public static final DeferredConditional BASTARDSWORD_2H = REGISTRY.registerConditional(
            "bastardsword_2h_wield_style",
            () -> ProviderConditional.createSkillDataKey(CapabilityItem.Styles.TWO_HAND, SwordCraftSkills.BASTARDSWORD_POSTURE_CHARGE_2H_TO_1H, SkillSlots.WEAPON_PASSIVE, SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, false)
    );
}
