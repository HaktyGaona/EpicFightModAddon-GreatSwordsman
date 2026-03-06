package com.hakty.greatswordsman.world.capability.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<SwordWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(SwordWeaponCategories.BASTARDSWORD, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(SwordWeaponCategories.CLAYMORE, CapabilityItem.WeaponCategories.LONGSWORD);
        categoryMap.put(SwordWeaponCategories.PIKE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.RANSEUR, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.GUISARME, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.CONCAVEHALBERD, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.LOCHABERAXE, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.SHORTSWORD, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(SwordWeaponCategories.KATZBALGER, CapabilityItem.WeaponCategories.SWORD);
        categoryMap.put(SwordWeaponCategories.ZWEIHANDER, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(SwordWeaponCategories.FLAMEBLADEDSWORD, CapabilityItem.WeaponCategories.GREATSWORD);
        categoryMap.put(SwordWeaponCategories.BLADEDSTICK, CapabilityItem.WeaponCategories.SPEAR);
        categoryMap.put(SwordWeaponCategories.STILETTO, CapabilityItem.WeaponCategories.DAGGER);
    }

    public static CapabilityItem.Builder apply(Item item, SwordWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (CapabilityItem.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
