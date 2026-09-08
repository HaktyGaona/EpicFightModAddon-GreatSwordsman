package com.hakty.greatswordsman;

import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import com.hakty.greatswordsman.registry.ModRegistries;
import com.hakty.greatswordsman.skill.skillbookcompat.SwordCraftCompat;
import com.hakty.greatswordsman.world.capability.item.WeaponCategoryPresets;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import com.hakty.greatswordsman.world.item.WeaponCreativeTab;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import yesman.epicfight.EpicFight;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.main.EpicFightSharedConstants;
import yesman.epicfight.world.capabilities.item.WeaponCategory;


@Mod(GreatSwordsman.MOD_ID)
public class GreatSwordsman {
    public static final String MOD_ID = "greatswordsman";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
    public GreatSwordsman(IEventBus bus) {
        WeaponCategory.ENUM_MANAGER.registerEnumCls(MOD_ID, WeaponCategory.class);

        ModRegistries.REGISTRIES.forEach(value -> value.register(bus));

        bus.addListener(SwordCraftAnimations::registerAnimations);
        bus.addListener(this::addCreative);

        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(SwordCraftCompat::onEmergencyEscapeSkillCreation, 1);
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(SwordCraftCompat::onSwordMasterSkillCreation, 1);
        if (EpicFightSharedConstants.isPhysicalClient() && ModList.get().isLoaded("efn")) {
            EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(SwordCraftCompat::onParrySkillCreation, 2);
        }
        EpicFightClientEventHooks.Registry.WEAPON_CATEGORY_ICON.registerEvent(SwordCraftCompat::onWeaponCategoryIconCreation, 1);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {}

}
