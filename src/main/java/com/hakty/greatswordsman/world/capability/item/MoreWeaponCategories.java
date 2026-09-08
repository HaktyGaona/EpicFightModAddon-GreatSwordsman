package com.hakty.greatswordsman.world.capability.item;

import com.google.common.collect.ImmutableList;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.List;

public enum MoreWeaponCategories implements WeaponCategory {
    BASTARDSWORD(CapabilityItem.WeaponCategories.LONGSWORD),
    CLAYMORE(BASTARDSWORD),
    SHORTSWORD(CapabilityItem.WeaponCategories.SWORD),
    KATZBALGER(SHORTSWORD),
    PIKE(CapabilityItem.WeaponCategories.SPEAR),
    RANSEUR(PIKE),
    GUISARME(PIKE),
    CONCAVEHALBERD(PIKE),
    LOCHABERAXE(PIKE),
    ZWEIHANDER(CapabilityItem.WeaponCategories.GREATSWORD),
    FLAMEBLADEDSWORD(ZWEIHANDER),
    BLADEDSTICK(BASTARDSWORD),
    WARHAMMER(ZWEIHANDER),
    LUCERNEHAMMER(ZWEIHANDER),
    STILETTO(CapabilityItem.WeaponCategories.DAGGER);

    final List<WeaponCategory> parents;
    final int id;

    MoreWeaponCategories() {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        this.parents = ImmutableList.of();
    }

    MoreWeaponCategories(WeaponCategory... parents) {
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
        this.parents = ImmutableList.copyOf(parents);
    }

    @Override
    public List<WeaponCategory> getParents() {
        return WeaponCategory.super.getParents();
    }

    @Override
    public int universalOrdinal() {
        return this.id;
    }
}