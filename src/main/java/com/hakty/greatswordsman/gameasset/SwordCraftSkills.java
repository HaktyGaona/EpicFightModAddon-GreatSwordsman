package com.hakty.greatswordsman.gameasset;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.skill.guard.NeoParryingSkill;
import com.hakty.greatswordsman.skill.weaponinnate.ComboSlashSkill;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.registry.EpicFightRegistries;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

public class SwordCraftSkills {

    public static final DeferredRegister<Skill> REGISTRY = DeferredRegister.create(EpicFightRegistries.Keys.SKILL, GreatSwordsman.MOD_ID);

    public static final DeferredHolder<Skill, ComboSlashSkill> COMBOSLASH = REGISTRY.register("comboslash", key ->
            WeaponInnateSkill.createWeaponInnateBuilder(ComboSlashSkill::new).setCategory(SkillCategories.WEAPON_INNATE)
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

    public static final DeferredHolder<Skill, NeoParryingSkill> ADVANCED_PARRYING = REGISTRY.register("advanced_parrying", key ->
            NeoParryingSkill.createActiveGuardBuilder().build(key)
    );

}
