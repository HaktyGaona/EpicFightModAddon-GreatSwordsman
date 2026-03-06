package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.tools.obfuscation.ext.SpecialPackages;

public class WeaponAddonItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GreatSwordsman.MOD_ID);

//    public static final RegistryObject<Item> MAGENTA_SWORD =
//            ITEMS.register("magenta_sword", () -> new SwordItem(new Item.Properties().fireResistant().rarity(Rarity.RARE).defaultDurability(1685), Tiers.DIAMOND));
    public static final RegistryObject<Item> SHORTSWORD =
            ITEMS.register("shortsword", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item>  KATZBALGER =
            ITEMS.register("katzbalger", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> BASTARDSWORD =
            ITEMS.register("bastardsword", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> CLAYMORE =
            ITEMS.register("claymore", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> PIKE =
            ITEMS.register("pike", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> RANSEUR =
            ITEMS.register("ranseur", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> GUISARME =
            ITEMS.register("guisarme", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> CONCAVEHALBERD =
            ITEMS.register("concavehalberd", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> LOCHABERAXE =
            ITEMS.register("lochaberaxe", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> ZWEIHANDER =
            ITEMS.register("zweihander", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> FLAMEBLADEDSWORD =
            ITEMS.register("flamebladedsword", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> BLADESTICK =
            ITEMS.register("bladedstick", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> WARHAMMER =
            ITEMS.register("warhammer", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> LUCERNEHAMMER =
            ITEMS.register("lucernehammer", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));
    public static final RegistryObject<Item> STYLET =
            ITEMS.register("stylet", () -> new SwordItem(new Item.Properties().defaultDurability(100), Tiers.IRON));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
