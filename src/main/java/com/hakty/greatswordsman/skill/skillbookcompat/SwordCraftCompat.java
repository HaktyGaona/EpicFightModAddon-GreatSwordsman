package com.hakty.greatswordsman.skill.skillbookcompat;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.world.capability.item.MoreWeaponCategories;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.client.event.types.registry.RegisterWeaponCategoryIconEvent;
import yesman.epicfight.api.event.types.registry.SkillBuilderModificationEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.passive.EmergencyEscapeSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class SwordCraftCompat{

    public static void onEmergencyEscapeSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.EMERGENCY_ESCAPE.getId())) {
            if (event.getSkillBuilder() instanceof EmergencyEscapeSkill.Builder builder) {
                builder.addAvailableWeaponCategory(MoreWeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.PIKE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.RANSEUR)
                        .addAvailableWeaponCategory(MoreWeaponCategories.GUISARME)
                        .addAvailableWeaponCategory(MoreWeaponCategories.CONCAVEHALBERD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.LOCHABERAXE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.FLAMEBLADEDSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.BLADEDSTICK)
                        .addAvailableWeaponCategory(MoreWeaponCategories.WARHAMMER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.LUCERNEHAMMER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.STILETTO);
            }
        }
    }
    public static void onSwordMasterSkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(EpicFightSkills.EMERGENCY_ESCAPE.getId())) {
            if (event.getSkillBuilder() instanceof EmergencyEscapeSkill.Builder builder) {
                builder.addAvailableWeaponCategory(MoreWeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.PIKE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.RANSEUR)
                        .addAvailableWeaponCategory(MoreWeaponCategories.GUISARME)
                        .addAvailableWeaponCategory(MoreWeaponCategories.CONCAVEHALBERD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.LOCHABERAXE)
                        .addAvailableWeaponCategory(MoreWeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.FLAMEBLADEDSWORD)
                        .addAvailableWeaponCategory(MoreWeaponCategories.BLADEDSTICK)
                        .addAvailableWeaponCategory(MoreWeaponCategories.WARHAMMER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.LUCERNEHAMMER)
                        .addAvailableWeaponCategory(MoreWeaponCategories.STILETTO);
            }
        }
    }

    public static void onParrySkillCreation(SkillBuilderModificationEvent event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("efn","efn_parry"))) {
            GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
            builder.addGuardMotion(MoreWeaponCategories.STILETTO, (item, player) ->
                    item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(MoreWeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(MoreWeaponCategories.STILETTO, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(MoreWeaponCategories.SHORTSWORD, (item, player) ->
                            item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(MoreWeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(MoreWeaponCategories.SHORTSWORD, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(MoreWeaponCategories.KATZBALGER, (item, player) ->
                            item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(MoreWeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(MoreWeaponCategories.KATZBALGER, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(MoreWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                    SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                    .addGuardBreakMotion(MoreWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                    SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)
                    .addAdvancedGuardMotion(MoreWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                    List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2) : List.of(SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO2))

                    .addGuardMotion(MoreWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                    .addGuardBreakMotion(MoreWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)
                    .addAdvancedGuardMotion(MoreWeaponCategories.CLAYMORE, (item, player) ->
                            List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2));
        }
    }

    public static void onWeaponCategoryIconCreation(RegisterWeaponCategoryIconEvent icon) {
        icon.registerCategory(MoreWeaponCategories.BASTARDSWORD, new ItemStack(WeaponAddonItems.BASTARDSWORD.get()));
        icon.registerCategory(MoreWeaponCategories.CLAYMORE, new ItemStack(WeaponAddonItems.CLAYMORE.get()));
        icon.registerCategory(MoreWeaponCategories.SHORTSWORD, new ItemStack(WeaponAddonItems.SHORTSWORD.get()));
        icon.registerCategory(MoreWeaponCategories.KATZBALGER, new ItemStack(WeaponAddonItems.KATZBALGER.get()));
        icon.registerCategory(MoreWeaponCategories.PIKE, new ItemStack(WeaponAddonItems.PIKE.get()));
        icon.registerCategory(MoreWeaponCategories.RANSEUR, new ItemStack(WeaponAddonItems.RANSEUR.get()));
        icon.registerCategory(MoreWeaponCategories.GUISARME, new ItemStack(WeaponAddonItems.GUISARME.get()));
        icon.registerCategory(MoreWeaponCategories.CONCAVEHALBERD, new ItemStack(WeaponAddonItems.CONCAVEHALBERD.get()));
        icon.registerCategory(MoreWeaponCategories.LOCHABERAXE, new ItemStack(WeaponAddonItems.LOCHABERAXE.get()));
        icon.registerCategory(MoreWeaponCategories.ZWEIHANDER, new ItemStack(WeaponAddonItems.ZWEIHANDER.get()));
        icon.registerCategory(MoreWeaponCategories.FLAMEBLADEDSWORD, new ItemStack(WeaponAddonItems.FLAMEBLADEDSWORD.get()));
        icon.registerCategory(MoreWeaponCategories.BLADEDSTICK, new ItemStack(WeaponAddonItems.BLADEDSTICK.get()));
        icon.registerCategory(MoreWeaponCategories.WARHAMMER, new ItemStack(WeaponAddonItems.WARHAMMER.get()));
        icon.registerCategory(MoreWeaponCategories.LUCERNEHAMMER, new ItemStack(WeaponAddonItems.LUCERNEHAMMER.get()));
        icon.registerCategory(MoreWeaponCategories.STILETTO, new ItemStack(WeaponAddonItems.STILETTO.get()));
    }
}

