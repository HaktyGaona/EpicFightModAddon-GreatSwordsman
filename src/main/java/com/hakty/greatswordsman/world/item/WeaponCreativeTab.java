package com.hakty.greatswordsman.world.item;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class WeaponCreativeTab {
    private WeaponCreativeTab() {}

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GreatSwordsman.MOD_ID);

    public static final Supplier<CreativeModeTab> SWORDS_TAB = CREATIVE_MODE_TABS.register("swords_tab", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(WeaponAddonItems.ZWEIHANDER_TEMPLATE.get()))
                    .title(Component.translatable("creativetab.swords.tab"))
                    .displayItems((parames, output) -> {
                        output.accept(WeaponAddonItems.ZWEIHANDER_TEMPLATE.get());
                        output.accept(WeaponAddonItems.FLAMEBLADEDSWORD_TEMPLATE.get());
                        output.accept(WeaponAddonItems.BASTARDSWORD_TEMPLATE.get());
                        output.accept(WeaponAddonItems.CLAYMORE_TEMPLATE.get());
                        output.accept(WeaponAddonItems.SHORTSWORD_TEMPLATE.get());
                        output.accept(WeaponAddonItems.KATZBALGER_TEMPLATE.get());
                        output.accept(WeaponAddonItems.PIKE_TEMPLATE.get());
                        output.accept(WeaponAddonItems.RANSEUR_TEMPLATE.get());
                        output.accept(WeaponAddonItems.GUISARME_TEMPLATE.get());
                        output.accept(WeaponAddonItems.CONCAVEHALBERD_TEMPLATE.get());
                        output.accept(WeaponAddonItems.LOCHABERAXE_TEMPLATE.get());
                        output.accept(WeaponAddonItems.BLADESTICK_TEMPLATE.get());
                        output.accept(WeaponAddonItems.WARHAMMER_TEMPLATE.get());
                        output.accept(WeaponAddonItems.LUCERNEHAMMER_TEMPLATE.get());
                        output.accept(WeaponAddonItems.STILETTO_TEMPLATE.get());
                    })
                    .build()
    );

    public static void register (IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
