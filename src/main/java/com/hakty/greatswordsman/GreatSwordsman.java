package com.hakty.greatswordsman;

import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import com.hakty.greatswordsman.skill.SwordSkillDataKeys;
import com.hakty.greatswordsman.skill.skillbookcompat.SwordCraftCompat;
import com.hakty.greatswordsman.world.item.WeaponCreativeTab;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;

import yesman.epicfight.world.capabilities.item.WeaponCategory;


@Mod(GreatSwordsman.MOD_ID)
public class GreatSwordsman {
    public static final String MOD_ID = "greatswordsman";
    public static SwordCraftAnimations.IProxy proxy;

    public GreatSwordsman(FMLJavaModLoadingContext eventBus) {
        IEventBus bus = eventBus.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, WeaponCategory.class);
        WeaponCreativeTab.register(bus);
        WeaponAddonItems.register(bus);
        SwordCraftSounds.SOUNDS.register(bus);
        SwordSkillDataKeys.DATA_KEYS.register(bus);

        bus.addListener(SwordCraftAnimations::registerAnimations);
        bus.addListener(com.hakty.greatswordsman.gameasset.SwordCraftSkills::registerSwordCraftSkills);
        bus.addListener(SwordCraftCompat::forceGuard);
        bus.addListener(this::addCreative);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> bus.addListener(SwordCraftCompat::onIconCreate));

        if (FMLEnvironment.dist == Dist.CLIENT) {
            proxy = new SwordCraftAnimations.ClientProxy();
        } else {
            proxy = new SwordCraftAnimations.ServerProxy();
        }
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }
}
