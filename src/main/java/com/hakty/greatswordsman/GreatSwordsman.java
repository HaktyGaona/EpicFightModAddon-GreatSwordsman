package com.hakty.greatswordsman;

import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import com.hakty.greatswordsman.skill.skillbookcompat.SwordCraftCompat;
import com.hakty.greatswordsman.world.capability.item.WeaponCategoryPresets;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import com.hakty.greatswordsman.world.item.WeaponCreativeTab;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yesman.epicfight.world.capabilities.item.WeaponCategory;


@Mod(GreatSwordsman.MOD_ID)
public class GreatSwordsman {
    public static final String MOD_ID = "greatswordsman";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public GreatSwordsman(IEventBus bus) {
        WeaponCreativeTab.register(bus);
        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, WeaponCategory.class);

        SwordCraftSounds.register(bus);
        SwordCraftSkills.REGISTRY.register(bus);
        WeaponAddonItems.ITEMS.register(bus);
        new SwordCraftCompat(bus);

        bus.addListener(SwordCraftAnimations::registerAnimations);
        bus.addListener(this::commonStuff);
        bus.addListener(this::addCreative);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    public void commonStuff(FMLCommonSetupEvent event) {
        event.enqueueWork(WeaponCategoryPresets::registerMovesets);
    }
}
