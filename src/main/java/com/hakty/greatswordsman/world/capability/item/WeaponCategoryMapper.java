package com.hakty.greatswordsman.world.capability.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<MoreWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(MoreWeaponCategories.BASTARDSWORD, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(MoreWeaponCategories.CLAYMORE, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(MoreWeaponCategories.PIKE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.RANSEUR, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.GUISARME, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.CONCAVEHALBERD, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.LOCHABERAXE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.SHORTSWORD, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(MoreWeaponCategories.KATZBALGER, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(MoreWeaponCategories.ZWEIHANDER, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(MoreWeaponCategories.FLAMEBLADEDSWORD, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(MoreWeaponCategories.BLADEDSTICK, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(MoreWeaponCategories.STILETTO, CapabilityItem.WeaponCategories.DAGGER);
    }

    public static WeaponCapability.Builder apply(Item item, MoreWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (WeaponCapability.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
