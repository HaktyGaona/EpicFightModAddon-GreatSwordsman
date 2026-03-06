package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WeaponCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GreatSwordsman.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SWORDS_TAB = CREATIVE_MODE_TABS.register("swords_tab", () -> CreativeModeTab.builder().icon(() ->
            new ItemStack(WeaponAddonItems.ZWEIHANDER.get()))
            .title(Component.translatable("creativetab.swords.tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(WeaponAddonItems.ZWEIHANDER.get());
                output.accept(WeaponAddonItems.FLAMEBLADEDSWORD.get());
                output.accept(WeaponAddonItems.BASTARDSWORD.get());
                output.accept(WeaponAddonItems.CLAYMORE.get());
                output.accept(WeaponAddonItems.SHORTSWORD.get());
                output.accept(WeaponAddonItems.KATZBALGER.get());
                output.accept(WeaponAddonItems.PIKE.get());
                output.accept(WeaponAddonItems.RANSEUR.get());
                output.accept(WeaponAddonItems.GUISARME.get());
                output.accept(WeaponAddonItems.CONCAVEHALBERD.get());
                output.accept(WeaponAddonItems.LOCHABERAXE.get());
                output.accept(WeaponAddonItems.BLADESTICK.get());
                output.accept(WeaponAddonItems.WARHAMMER.get());
                output.accept(WeaponAddonItems.LUCERNEHAMMER.get());
                output.accept(WeaponAddonItems.STYLET.get());
            }).build());

    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
