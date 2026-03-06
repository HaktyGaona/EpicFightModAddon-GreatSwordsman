package com.hakty.greatswordsman.gameasset;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.skill.weaponinnate.ComboSlashSkill;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import yesman.epicfight.api.animation.property.AnimationProperty.AttackPhaseProperty;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
import yesman.epicfight.world.damagesource.ExtraDamageInstance;
import yesman.epicfight.world.damagesource.StunType;

import java.util.Set;

@Mod.EventBusSubscriber(modid = GreatSwordsman.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SwordCraftSkills {
    public static Skill COMBOSLASH;

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build) {
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(GreatSwordsman.MOD_ID);

        WeaponInnateSkill comboslash = modRegistry.build("comboslash", ComboSlashSkill::new, WeaponInnateSkill.createWeaponInnateBuilder());
        comboslash
                .newProperty()
                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(-7.5f))
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.HOLD)
                .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .newProperty()
                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(-7.5f))
                .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .newProperty()
                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(-7.5f))
                .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .newProperty()
                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(2))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(-7.5f))
                .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE))
                .newProperty()
                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(3))
                .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.adder(0.5f))
                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN)
                .addProperty(AttackPhaseProperty.EXTRA_DAMAGE, Set.of(ExtraDamageInstance.SWEEPING_EDGE_ENCHANTMENT.create()))
                .addProperty(AttackPhaseProperty.SOURCE_TAG, Set.of(EpicFightDamageTypeTags.WEAPON_INNATE, EpicFightDamageTypeTags.GUARD_PUNCTURE, EpicFightDamageTypeTags.FINISHER));
        COMBOSLASH = comboslash;
    }
    public SwordCraftSkills() {}
    public static void registerSwordCraftSkills(RegisterEvent bus) {};
}
