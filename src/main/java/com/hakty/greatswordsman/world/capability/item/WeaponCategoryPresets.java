package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import com.hakty.greatswordsman.gameasset.WeaponColliderPreset;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

public class WeaponCategoryPresets {
    public static final Function<Item, WeaponCapability.Builder> BASTARDSWORD = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(WeaponCategories.BASTARDSWORD)
                .collider(WeaponColliderPreset.BASTARDSWORD)
                .canBePlacedOffhand(false)
                .setTierValues(0, 0d, 0.0, 0.0)
                .addMoveset(Styles.ONE_HAND, WeaponMovesets.BASTARDSWORD_1H)
                .addMoveset(Styles.TWO_HAND, WeaponMovesets.BASTARDSWORD_2H)
                .addConditionals(WeaponProviderConditionals.BASTARDSWORD_2H, WeaponProviderConditionals.BASTARDSWORD_1H);
        return builder;
    };

    public static void registerMovesets() {
        EpicFightEventHooks.Registry.WEAPON_CAPABILITY_PRESET.registerEvent(event ->{
            event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "bastardsword"), BASTARDSWORD);
        });
    }

}
