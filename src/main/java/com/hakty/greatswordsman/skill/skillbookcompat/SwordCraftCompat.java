package com.hakty.greatswordsman.skill.skillbookcompat;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.world.capability.item.SwordWeaponCategories;
import com.hakty.greatswordsman.world.item.WeaponAddonItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent.ModRegistryWorker.SkillCreateEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.passive.EmergencyEscapeSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;

import java.util.List;

@Mod.EventBusSubscriber(modid = GreatSwordsman.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SwordCraftCompat {
    public static void forceGuard(SkillBuildEvent bus) {}

    @SubscribeEvent
    public static void onGuardSkillCreate(SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder
                    .addGuardMotion(SwordWeaponCategories.STILETTO, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                    .addGuardMotion(SwordWeaponCategories.SHORTSWORD, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                    .addGuardMotion(SwordWeaponCategories.KATZBALGER, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)

                    .addGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) -> {
                        return item.getStyle(player) == Styles.ONE_HAND ?
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1;
                    })
                    .addGuardBreakMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) -> {
                        return item.getStyle(player) == Styles.ONE_HAND ?
                                SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED;
                    })

                    .addGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                    .addGuardBreakMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED);
                }
    }
    @SubscribeEvent
    public static void onParrySkillCreate(SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
            builder
                    .addGuardMotion(SwordWeaponCategories.STILETTO, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.STILETTO, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(SwordWeaponCategories.STILETTO, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(SwordWeaponCategories.SHORTSWORD, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.SHORTSWORD, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(SwordWeaponCategories.SHORTSWORD, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(SwordWeaponCategories.KATZBALGER, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardBreakMotion(SwordWeaponCategories.KATZBALGER, (item, player) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(SwordWeaponCategories.KATZBALGER, (itemCap, playerpatch) -> itemCap.getStyle(playerpatch) == CapabilityItem.Styles.ONE_HAND ?
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1, Animations.SWORD_GUARD_ACTIVE_HIT2) : List.of(Animations.SWORD_GUARD_ACTIVE_HIT2, Animations.SWORD_GUARD_ACTIVE_HIT3))

                    .addGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ?
                                    SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1 : SwordCraftAnimations.SWORDCRAFT_TYPE2_HIT1)
                    .addGuardBreakMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ?
                                    SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED : SwordCraftAnimations.SWORDCRAFT_TYPE2_NEUTRALIZED)
                    .addAdvancedGuardMotion(SwordWeaponCategories.BASTARDSWORD, (item, player) ->
                            item.getStyle(player) == Styles.ONE_HAND ?
                                    List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2) : List.of(SwordCraftAnimations.SWORDCRAFT_TYPE2_DEFLECT1))

                    .addGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_HIT1)
                    .addGuardBreakMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                            SwordCraftAnimations.SWORDCRAFT_TYPE1_NEUTRALIZED)
                    .addAdvancedGuardMotion(SwordWeaponCategories.CLAYMORE, (item, player) ->
                            List.of(SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT1, SwordCraftAnimations.SWORDCRAFT_TYPE1_DEFLECT2));
                }
    }
    @SubscribeEvent
    public static void onImpactGuardSkillCreate(SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "impact_guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();
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
    }
    @SubscribeEvent
    public static void onSwordSkillCreate(SkillCreateEvent<SwordmasterSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "swordmaster"))) {
            SwordmasterSkill.Builder builder = event.getSkillBuilder();
            builder
                    .addAvailableWeaponCategory(SwordWeaponCategories.STILETTO)
                    .addAvailableWeaponCategory(SwordWeaponCategories.SHORTSWORD)
                    .addAvailableWeaponCategory(SwordWeaponCategories.KATZBALGER)
                    .addAvailableWeaponCategory(SwordWeaponCategories.BASTARDSWORD)
                    .addAvailableWeaponCategory(SwordWeaponCategories.CLAYMORE)
                    .addAvailableWeaponCategory(SwordWeaponCategories.ZWEIHANDER)
                    .addAvailableWeaponCategory(SwordWeaponCategories.FLAMEBLADEDSWORD);
        }
    }
    @SubscribeEvent
    public static void onEmergencyEscapeeSkillCreate(SkillCreateEvent<EmergencyEscapeSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "emergency_escape"))) {
            EmergencyEscapeSkill.Builder builder = event.getSkillBuilder();
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

    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon) {
        icon.registerCategory(SwordWeaponCategories.BASTARDSWORD, new ItemStack(WeaponAddonItems.BASTARDSWORD.get()));
        icon.registerCategory(SwordWeaponCategories.CLAYMORE, new ItemStack(WeaponAddonItems.CLAYMORE.get()));
        icon.registerCategory(SwordWeaponCategories.SHORTSWORD, new ItemStack(WeaponAddonItems.SHORTSWORD.get()));
        icon.registerCategory(SwordWeaponCategories.KATZBALGER, new ItemStack(WeaponAddonItems.KATZBALGER.get()));
        icon.registerCategory(SwordWeaponCategories.PIKE, new ItemStack(WeaponAddonItems.PIKE.get()));
        icon.registerCategory(SwordWeaponCategories.RANSEUR, new ItemStack(WeaponAddonItems.RANSEUR.get()));
        icon.registerCategory(SwordWeaponCategories.GUISARME, new ItemStack(WeaponAddonItems.GUISARME.get()));
        icon.registerCategory(SwordWeaponCategories.CONCAVEHALBERD, new ItemStack(WeaponAddonItems.CONCAVEHALBERD.get()));
        icon.registerCategory(SwordWeaponCategories.LOCHABERAXE, new ItemStack(WeaponAddonItems.LOCHABERAXE.get()));
        icon.registerCategory(SwordWeaponCategories.ZWEIHANDER, new ItemStack(WeaponAddonItems.ZWEIHANDER.get()));
        icon.registerCategory(SwordWeaponCategories.FLAMEBLADEDSWORD, new ItemStack(WeaponAddonItems.FLAMEBLADEDSWORD.get()));
        icon.registerCategory(SwordWeaponCategories.BLADEDSTICK, new ItemStack(WeaponAddonItems.BLADESTICK.get()));
        icon.registerCategory(SwordWeaponCategories.WARHAMMER, new ItemStack(WeaponAddonItems.WARHAMMER.get()));
        icon.registerCategory(SwordWeaponCategories.LUCERNEHAMMER, new ItemStack(WeaponAddonItems.LUCERNEHAMMER.get()));
        icon.registerCategory(SwordWeaponCategories.STILETTO, new ItemStack(WeaponAddonItems.STYLET.get()));
    }
}
