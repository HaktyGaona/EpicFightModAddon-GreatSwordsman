package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WeaponAddonItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(GreatSwordsman.MOD_ID);

    public static final DeferredItem<Item> SHORTSWORD = ITEMS.register("shortsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item>  KATZBALGER = ITEMS.register("katzbalger", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BASTARDSWORD = ITEMS.register("bastardsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CLAYMORE = ITEMS.register("claymore", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> PIKE = ITEMS.register("pike", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> RANSEUR = ITEMS.register("ranseur", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> GUISARME = ITEMS.register("guisarme", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CONCAVEHALBERD = ITEMS.register("concavehalberd", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LOCHABERAXE = ITEMS.register("lochaberaxe", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> ZWEIHANDER = ITEMS.register("zweihander", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> FLAMEBLADEDSWORD = ITEMS.register("flamebladedsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BLADESTICK = ITEMS.register("bladedstick", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> WARHAMMER = ITEMS.register("warhammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LUCERNEHAMMER = ITEMS.register("lucernehammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> STILETTO = ITEMS.register("stylet", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
