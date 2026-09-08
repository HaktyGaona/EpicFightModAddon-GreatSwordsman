package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class WeaponAddonItems {

    private WeaponAddonItems() {}
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(GreatSwordsman.MOD_ID);


    public static final DeferredItem<Item> SHORTSWORD = REGISTRY.register("shortsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> KATZBALGER = REGISTRY.register("katzbalger", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BASTARDSWORD = REGISTRY.register("bastardsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CLAYMORE = REGISTRY.register("claymore", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> PIKE = REGISTRY.register("pike", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> RANSEUR = REGISTRY.register("ranseur", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> GUISARME = REGISTRY.register("guisarme", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> CONCAVEHALBERD = REGISTRY.register("concavehalberd", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LOCHABERAXE = REGISTRY.register("lochaberaxe", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> ZWEIHANDER = REGISTRY.register("zweihander", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> FLAMEBLADEDSWORD = REGISTRY.register("flamebladedsword", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> BLADEDSTICK = REGISTRY.register("bladedstick", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> WARHAMMER = REGISTRY.register("warhammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> LUCERNEHAMMER = REGISTRY.register("lucernehammer", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));
    public static final DeferredItem<Item> STILETTO = REGISTRY.register("stylet", () ->
            new SwordItem(new Item.Properties().durability(100).attributes(SwordItem.createWeaponAttributes(Tiers.IRON)), Tiers.IRON));


    public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);
    }
}
