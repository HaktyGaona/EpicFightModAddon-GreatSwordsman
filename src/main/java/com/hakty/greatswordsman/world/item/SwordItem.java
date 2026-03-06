package com.hakty.greatswordsman.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class SwordItem extends WeaponItem {
    public SwordItem(Item.Properties build, Tier materialIn) {
        super(materialIn, 12, -2.6f, build);
    }
}
