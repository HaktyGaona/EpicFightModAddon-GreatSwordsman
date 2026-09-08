package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class WeaponCreativeTab {

    private WeaponCreativeTab() {}

    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GreatSwordsman.MOD_ID);

    public static final Supplier<CreativeModeTab> SWORDS_TAB = REGISTRY.register("swords_tab", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(WeaponAddonItems.ZWEIHANDER.get()))
                    .title(Component.translatable("creativetab.swords.tab"))
                    .displayItems((parames, output) -> {
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
                        output.accept(WeaponAddonItems.BLADEDSTICK.get());
                        output.accept(WeaponAddonItems.WARHAMMER.get());
                        output.accept(WeaponAddonItems.LUCERNEHAMMER.get());
                        output.accept(WeaponAddonItems.STILETTO.get());
                    })
                    .build()
    );

    public static void register (IEventBus eventBus){
        REGISTRY.register(eventBus);
    }
}
