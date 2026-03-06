package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class WeaponAddonItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(GreatSwordsman.MOD_ID);

    public static final DeferredItem<Item> SHORTSWORD_TEMPLATE = ITEMS.register("shortsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item>  KATZBALGER_TEMPLATE = ITEMS.register("katzbalger", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BASTARDSWORD_TEMPLATE = ITEMS.register("bastardsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CLAYMORE_TEMPLATE = ITEMS.register("claymore", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> PIKE_TEMPLATE = ITEMS.register("pike", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> RANSEUR_TEMPLATE = ITEMS.register("ranseur", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> GUISARME_TEMPLATE = ITEMS.register("guisarme", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CONCAVEHALBERD_TEMPLATE = ITEMS.register("concavehalberd", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LOCHABERAXE_TEMPLATE = ITEMS.register("lochaberaxe", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> ZWEIHANDER_TEMPLATE = ITEMS.register("zweihander", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> FLAMEBLADEDSWORD_TEMPLATE = ITEMS.register("flamebladedsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BLADESTICK_TEMPLATE = ITEMS.register("bladedstick", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> WARHAMMER_TEMPLATE = ITEMS.register("warhammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LUCERNEHAMMER_TEMPLATE = ITEMS.register("lucernehammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> STILETTO_TEMPLATE = ITEMS.register("stylet", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
