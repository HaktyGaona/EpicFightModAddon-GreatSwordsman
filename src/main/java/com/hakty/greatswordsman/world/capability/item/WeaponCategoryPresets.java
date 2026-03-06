package com.hakty.greatswordsman.world.capability.item;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import com.hakty.greatswordsman.gameasset.WeaponColliderPreset;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.CapabilityItem.Styles;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

public class WeaponCategoryPresets {
    public static final Function<Item, WeaponCapability.Builder> BASTARDSWORD = (item) -> {
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(SwordWeaponCategories.BASTARDSWORD)
                .collider(WeaponColliderPreset.BASTARDSWORD)
                .styleProvider((playerpatch) -> playerpatch.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == CapabilityItem.WeaponCategories.FIST ? Styles.TWO_HAND : Styles.ONE_HAND)
                .newStyleCombo(Styles.ONE_HAND, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO2, SwordCraftAnimations.SWORDCRAFT_TYPE1_AUTO3, SwordCraftAnimations.SWORDCRAFT_TYPE1_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE1_AIRSLASH)
                .newStyleCombo(Styles.TWO_HAND, SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO1, SwordCraftAnimations.SWORDCRAFT_TYPE2_AUTO2, SwordCraftAnimations.SWORDCRAFT_TYPE2_DASH, SwordCraftAnimations.SWORDCRAFT_TYPE2_AIRSLASH)
                .innateSkill(Styles.ONE_HAND, (ItemStack) -> SwordCraftSkills.COMBOSLASH.get())
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.IDLE, SwordCraftAnimations.SWORDCRAFT_TYPE1_IDLE)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.WALK, SwordCraftAnimations.SWORDCRAFT_TYPE1_WALK)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.CHASE, SwordCraftAnimations.SWORDCRAFT_TYPE1_WALK)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE1_RUN)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_LONGSWORD)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_LONGSWORD)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.FLOAT, Animations.BIPED_HOLD_LONGSWORD)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.FALL, Animations.BIPED_HOLD_LONGSWORD)
                .livingMotionModifier(Styles.ONE_HAND, LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE1_GUARD)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.IDLE, SwordCraftAnimations.SWORDCRAFT_TYPE2_IDLE)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.JUMP, SwordCraftAnimations.SWORDCRAFT_TYPE2_JUMP)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.WALK, SwordCraftAnimations.SWORDCRAFT_TYPE2_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.CHASE, SwordCraftAnimations.SWORDCRAFT_TYPE2_WALK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.RUN, SwordCraftAnimations.SWORDCRAFT_TYPE2_RUN)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.KNEEL, SwordCraftAnimations.SWORDCRAFT_TYPE2_KNEEL)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SNEAK, SwordCraftAnimations.SWORDCRAFT_TYPE2_SNEAK)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.SWIM, SwordCraftAnimations.SWORDCRAFT_TYPE2_SWIM)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.FLOAT, SwordCraftAnimations.SWORDCRAFT_TYPE2_FLOAT)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.FALL, SwordCraftAnimations.SWORDCRAFT_TYPE2_FALL)
                .livingMotionModifier(Styles.TWO_HAND, LivingMotions.BLOCK, SwordCraftAnimations.SWORDCRAFT_TYPE2_GUARD);
        return builder;
    };

    public static void registerMovesets() {
        EpicFightEventHooks.Registry.WEAPON_CAPABILITY_PRESET.registerEvent(event ->{
            event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "bastardsword"), BASTARDSWORD);
        });
    }

}
