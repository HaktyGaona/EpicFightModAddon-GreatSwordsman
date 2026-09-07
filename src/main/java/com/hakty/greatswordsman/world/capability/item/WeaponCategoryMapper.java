package com.hakty.greatswordsman.world.capability.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<WeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(WeaponCategories.BASTARDSWORD, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(WeaponCategories.CLAYMORE, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(WeaponCategories.PIKE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.RANSEUR, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.GUISARME, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.CONCAVEHALBERD, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.LOCHABERAXE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.SHORTSWORD, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(WeaponCategories.KATZBALGER, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(WeaponCategories.ZWEIHANDER, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(WeaponCategories.FLAMEBLADEDSWORD, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(WeaponCategories.BLADEDSTICK, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(WeaponCategories.STILETTO, CapabilityItem.WeaponCategories.DAGGER);
    }

    public static WeaponCapability.Builder apply(Item item, WeaponCategories category) {
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
