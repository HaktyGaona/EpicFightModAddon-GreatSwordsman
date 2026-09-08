package com.hakty.greatswordsman.registry;

import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import com.hakty.greatswordsman.world.capability.item.WeaponCategoryPresets;
import com.hakty.greatswordsman.world.capability.item.WeaponMovesets;
import com.hakty.greatswordsman.world.capability.item.WeaponProviderConditionals;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import com.hakty.greatswordsman.world.item.WeaponCreativeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModRegistries {
    public static List<DeferredRegister<?>> REGISTRIES = List.of(
            WeaponCategoryPresets.REGISTRY,
            WeaponMovesets.REGISTRY,
            WeaponAddonItems.REGISTRY,
            WeaponProviderConditionals.REGISTRY,
            WeaponCreativeTab.REGISTRY,
            SwordCraftSkills.REGISTRY,
            SwordCraftSounds.REGISTRY,
            SwordCraftSkillDataKeys.REGISTRY
    );
}
