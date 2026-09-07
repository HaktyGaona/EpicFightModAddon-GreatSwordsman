package com.hakty.greatswordsman.gameasset;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.skill.weaponinnate.ComboSlash;
import com.hakty.greatswordsman.skill.weaponpassive.BastardSwordPostureCharge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

public class SwordCraftSkills {

    public static final DeferredRegister<Skill> REGISTRY = DeferredRegister.create(EpicFightRegistries.Keys.SKILL, GreatSwordsman.MOD_ID);

    public static final DeferredHolder<Skill, ComboSlash> COMBOSLASH = REGISTRY.register("comboslash", key ->
            WeaponInnateSkill.createWeaponInnateBuilder(ComboSlash::new).setCategory(SkillCategories.WEAPON_INNATE)
                    .newProperty()
                    .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                    .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                    .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                    .newProperty()
                    .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                    .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                    .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                    .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                    .newProperty()
                    .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                    .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                    .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                    .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                    .newProperty()
                    .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                    .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                    .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                    .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                    .newProperty()
                    .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                    .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(0.5f))
                    .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                    .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                    .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER))
                    .build(key));


    public static final DeferredHolder<Skill, BastardSwordPostureCharge> BASTARDSWORD_POSTURE_CHARGE_1H_TO_2H = REGISTRY.register("bastardsword_posture_charge_1h_to_2h", key ->
            Skill.createBuilder(BastardSwordPostureCharge::new)
                    .setCategory(SkillCategories.WEAPON_PASSIVE)
                    .setActivateType(Skill.ActivateType.ONE_SHOT)
                    .setResource(Skill.Resource.COOLDOWN)
                    .build(key));

    public static final DeferredHolder<Skill, BastardSwordPostureCharge> BASTARDSWORD_POSTURE_CHARGE_2H_TO_1H = REGISTRY.register("bastardsword_posture_charge_2h_to_1h", key ->
            Skill.createBuilder(BastardSwordPostureCharge::new)
                    .setCategory(SkillCategories.WEAPON_PASSIVE)
                    .setActivateType(Skill.ActivateType.ONE_SHOT)
                    .setResource(Skill.Resource.COOLDOWN)
                    .build(key));

    public static final DeferredHolder<Skill, SimpleWeaponInnateSkill> BLIGHTWINDSLASH = REGISTRY.register("bright_wind_slash", key ->
            SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                    .setAnimations(SwordCraftAnimations.BRIGHTWINDSLASH)
                    .newProperty()
                    .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                    .addProperty(AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(0.0f))
                    .newProperty()
                    .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                    .addProperty(AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.setter(0.0f))
                    .build(key));
}
