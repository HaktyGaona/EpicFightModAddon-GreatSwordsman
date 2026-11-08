package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import com.hakty.greatswordsman.gameasset.WeaponColliderPreset;
import yesman.epicfight.EpicFight;
import yesman.epicfight.registry.deferred.ItemPresetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredWeapon;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;


public final class WeaponCategoryPresets {
    private WeaponCategoryPresets() {}
    public static final ItemPresetRegister REGISTRY = ItemPresetRegister.create(GreatSwordsman.MOD_ID);

    public static final DeferredWeapon BASTARDSWORD = REGISTRY.registerWeapon("bastardsword", () -> WeaponCapability.builder()
            .category(MoreWeaponCategories.BASTARDSWORD)
            .hitSound(EpicFightSounds.BLADE_HIT)
            .swingSound(SwordCraftSounds.LONGSWORD_SLASH)
            .collider(WeaponColliderPreset.BASTARDSWORD)
            .canBePlacedOffhand(false)
            .setTierValues(0, 0d, 0.0, 0.0)
            .addMoveset(CapabilityItem.Styles.ONE_HAND, WeaponMovesets.BASTARDSWORD_1H)
            .addMoveset(CapabilityItem.Styles.TWO_HAND, WeaponMovesets.BASTARDSWORD_2H)
            .addConditionals(
                    WeaponProviderConditionals.BASTARDSWORD_2H,
                    WeaponProviderConditionals.BASTARDSWORD_1H
            )
            .addTag(EpicFight.identifier("longsword"))
    );

}
