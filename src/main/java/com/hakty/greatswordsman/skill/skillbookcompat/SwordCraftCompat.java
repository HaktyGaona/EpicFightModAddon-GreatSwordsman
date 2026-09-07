package com.hakty.greatswordsman.skill.skillbookcompat;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.world.capability.item.WeaponCategories;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.neoforged.bus.api.IEventBus;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.passive.EmergencyEscapeSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class SwordCraftCompat{
    public SwordCraftCompat(IEventBus bus) {
        EpicFightEventHooks.Registry.MODIFY_SKILL_BUILDER.registerEvent(event -> {
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "guard"))) {
                GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
                builder
                        .addGuardMotion(WeaponCategories.STILETTO, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(WeaponCategories.SHORTSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(WeaponCategories.KATZBALGER, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(WeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                        .addGuardBreakMotion(WeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)

                        .addGuardMotion(WeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(WeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
                GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
                builder
                        .addGuardMotion(WeaponCategories.STILETTO, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(WeaponCategories.STILETTO, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(WeaponCategories.SHORTSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(WeaponCategories.SHORTSWORD, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(WeaponCategories.KATZBALGER, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(WeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(WeaponCategories.KATZBALGER, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(WeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                        .addGuardBreakMotion(WeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)
                        .addAdvancedGuardMotion(WeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                        List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2) : List.of(SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO2))

                        .addGuardMotion(WeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(WeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)
                        .addAdvancedGuardMotion(WeaponCategories.CLAYMORE, (item, player) ->
                                List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2));
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "impact_guard"))) {
                GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
                builder
                        .addGuardMotion(WeaponCategories.ZWEIHANDER, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(WeaponCategories.ZWEIHANDER, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)

                        .addGuardMotion(WeaponCategories.FLAMEBLADEDSWORD, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(WeaponCategories.FLAMEBLADEDSWORD, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "swordmaster"))) {
                SwordmasterSkill.Builder builder = (SwordmasterSkill.Builder) event.getSkillBuilder();
                builder
                        .addAvailableWeaponCategory(WeaponCategories.STILETTO)
                        .addAvailableWeaponCategory(WeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(WeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(WeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(WeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(WeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(WeaponCategories.FLAMEBLADEDSWORD);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "emergency_escape"))) {
                EmergencyEscapeSkill.Builder builder = (EmergencyEscapeSkill.Builder) event.getSkillBuilder();
                builder
                        .addAvailableWeaponCategory(WeaponCategories.STILETTO)
                        .addAvailableWeaponCategory(WeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(WeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(WeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(WeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(WeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(WeaponCategories.FLAMEBLADEDSWORD)
                        .addAvailableWeaponCategory(WeaponCategories.WARHAMMER)
                        .addAvailableWeaponCategory(WeaponCategories.LUCERNEHAMMER);
            }
        });
        EpicFightClientEventHooks.Registry.WEAPON_CATEGORY_ICON.registerEvent(icon ->{
            icon.registerCategory(WeaponCategories.BASTARDSWORD, new ItemStack(WeaponAddonItems.BASTARDSWORD.get()));
            icon.registerCategory(WeaponCategories.CLAYMORE, new ItemStack(WeaponAddonItems.CLAYMORE.get()));
            icon.registerCategory(WeaponCategories.SHORTSWORD, new ItemStack(WeaponAddonItems.SHORTSWORD.get()));
            icon.registerCategory(WeaponCategories.KATZBALGER, new ItemStack(WeaponAddonItems.KATZBALGER.get()));
            icon.registerCategory(WeaponCategories.PIKE, new ItemStack(WeaponAddonItems.PIKE.get()));
            icon.registerCategory(WeaponCategories.RANSEUR, new ItemStack(WeaponAddonItems.RANSEUR.get()));
            icon.registerCategory(WeaponCategories.GUISARME, new ItemStack(WeaponAddonItems.GUISARME.get()));
            icon.registerCategory(WeaponCategories.CONCAVEHALBERD, new ItemStack(WeaponAddonItems.CONCAVEHALBERD.get()));
            icon.registerCategory(WeaponCategories.LOCHABERAXE, new ItemStack(WeaponAddonItems.LOCHABERAXE.get()));
            icon.registerCategory(WeaponCategories.ZWEIHANDER, new ItemStack(WeaponAddonItems.ZWEIHANDER.get()));
            icon.registerCategory(WeaponCategories.FLAMEBLADEDSWORD, new ItemStack(WeaponAddonItems.FLAMEBLADEDSWORD.get()));
            icon.registerCategory(WeaponCategories.BLADEDSTICK, new ItemStack(WeaponAddonItems.BLADESTICK.get()));
            icon.registerCategory(WeaponCategories.WARHAMMER, new ItemStack(WeaponAddonItems.WARHAMMER.get()));
            icon.registerCategory(WeaponCategories.LUCERNEHAMMER, new ItemStack(WeaponAddonItems.LUCERNEHAMMER.get()));
            icon.registerCategory(WeaponCategories.STILETTO, new ItemStack(WeaponAddonItems.STILETTO.get()));
        });
    }
}

