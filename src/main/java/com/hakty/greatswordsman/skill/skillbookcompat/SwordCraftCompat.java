package com.hakty.greatswordsman.skill.skillbookcompat;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.world.capability.item.SwordWeaponCategories;
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
                        .addGuardMotion(SwordWeaponCategories.STILETTO, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(SwordWeaponCategories.SHORTSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(SwordWeaponCategories.KATZBALGER, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                        .addGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)

                        .addGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
                GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
                builder
                        .addGuardMotion(SwordWeaponCategories.STILETTO, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(SwordWeaponCategories.STILETTO, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(SwordWeaponCategories.SHORTSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(SwordWeaponCategories.SHORTSWORD, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(SwordWeaponCategories.KATZBALGER, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                        .addGuardBreakMotion(SwordWeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                        .addAdvancedGuardMotion(SwordWeaponCategories.KATZBALGER, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                                List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                        .addGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ?
                                        SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)
                        .addAdvancedGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                                item.getStyle(player) ==CapabilityItem.Styles.ONE_HAND ?
                                        List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2) : List.of(SwordCraftAnimations.SWORDCRAFT_TYPE2_DEFLECT1))

                        .addGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)
                        .addAdvancedGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                                List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2));
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "impact_guard"))) {
                GuardSkill.Builder builder = (GuardSkill.Builder) event.getSkillBuilder();
                builder
                        .addGuardMotion(SwordWeaponCategories.ZWEIHANDER, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.ZWEIHANDER, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)

                        .addGuardMotion(SwordWeaponCategories.FLAMEBLADEDSWORD, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                        .addGuardBreakMotion(SwordWeaponCategories.FLAMEBLADEDSWORD, (item, player) ->
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "swordmaster"))) {
                SwordmasterSkill.Builder builder = (SwordmasterSkill.Builder) event.getSkillBuilder();
                builder
                        .addAvailableWeaponCategory(SwordWeaponCategories.STILETTO)
                        .addAvailableWeaponCategory(SwordWeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(SwordWeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(SwordWeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(SwordWeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(SwordWeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(SwordWeaponCategories.FLAMEBLADEDSWORD);
            }
            if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "emergency_escape"))) {
                EmergencyEscapeSkill.Builder builder = (EmergencyEscapeSkill.Builder) event.getSkillBuilder();
                builder
                        .addAvailableWeaponCategory(SwordWeaponCategories.STILETTO)
                        .addAvailableWeaponCategory(SwordWeaponCategories.SHORTSWORD)
                        .addAvailableWeaponCategory(SwordWeaponCategories.KATZBALGER)
                        .addAvailableWeaponCategory(SwordWeaponCategories.BASTARDSWORD)
                        .addAvailableWeaponCategory(SwordWeaponCategories.CLAYMORE)
                        .addAvailableWeaponCategory(SwordWeaponCategories.ZWEIHANDER)
                        .addAvailableWeaponCategory(SwordWeaponCategories.FLAMEBLADEDSWORD)
                        .addAvailableWeaponCategory(SwordWeaponCategories.WARHAMMER)
                        .addAvailableWeaponCategory(SwordWeaponCategories.LUCERNEHAMMER);
            }
        });
        EpicFightClientEventHooks.Registry.WEAPON_CATEGORY_ICON.registerEvent(icon ->{
            icon.registerCategory(SwordWeaponCategories.BASTARDSWORD, new ItemStack(WeaponAddonItems.BASTARDSWORD_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.CLAYMORE, new ItemStack(WeaponAddonItems.CLAYMORE_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.SHORTSWORD, new ItemStack(WeaponAddonItems.SHORTSWORD_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.KATZBALGER, new ItemStack(WeaponAddonItems.KATZBALGER_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.PIKE, new ItemStack(WeaponAddonItems.PIKE_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.RANSEUR, new ItemStack(WeaponAddonItems.RANSEUR_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.GUISARME, new ItemStack(WeaponAddonItems.GUISARME_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.CONCAVEHALBERD, new ItemStack(WeaponAddonItems.CONCAVEHALBERD_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.LOCHABERAXE, new ItemStack(WeaponAddonItems.LOCHABERAXE_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.ZWEIHANDER, new ItemStack(WeaponAddonItems.ZWEIHANDER_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.FLAMEBLADEDSWORD, new ItemStack(WeaponAddonItems.FLAMEBLADEDSWORD_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.BLADEDSTICK, new ItemStack(WeaponAddonItems.BLADESTICK_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.WARHAMMER, new ItemStack(WeaponAddonItems.WARHAMMER_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.LUCERNEHAMMER, new ItemStack(WeaponAddonItems.LUCERNEHAMMER_TEMPLATE.get()));
            icon.registerCategory(SwordWeaponCategories.STILETTO, new ItemStack(WeaponAddonItems.STILETTO_TEMPLATE.get()));
        });
    }
}

