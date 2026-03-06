package com.hakty.greatswordsman.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import yesman.epicfight.world.item.TieredWeaponItem;

public class SwordItem extends TieredWeaponItem {
    public static ItemAttributeModifiers createWeaponAttributes(Tier tier) {
        return TieredWeaponItem.createAttributes(tier, 12.0F, -2.4F, 0.0F);
    }
    public SwordItem(Item.Properties build, Tier materialIn) {
        super(materialIn, build);
    }
}
