package com.hakty.greatswordsman.world.capability.item;

import net.minecraft.world.item.Item;

import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.function.Function;

public enum SwordWeaponCategories implements WeaponCategory, Function<Item, CapabilityItem.Builder> {
    BASTARDSWORD,
    CLAYMORE,
    SHORTSWORD,
    KATZBALGER,
    PIKE,
    RANSEUR,
    GUISARME,
    CONCAVEHALBERD,
    LOCHABERAXE,
    ZWEIHANDER,
    FLAMEBLADEDSWORD,
    BLADEDSTICK,
    WARHAMMER,
    LUCERNEHAMMER,
    STILETTO;

    final int id;

    SwordWeaponCategories(){
        this.id = WeaponCategory.ENUM_MANAGER.assign(this);
    }
    @Override
    public int universalOrdinal() {
        return this.id;
    }

    @Override
    public CapabilityItem.Builder apply(Item item) {
        return WeaponCategoryMapper.apply(item, this);
    }
}