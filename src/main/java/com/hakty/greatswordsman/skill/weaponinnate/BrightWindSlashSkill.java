package com.hakty.greatswordsman.skill.weaponinnate;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class BrightWindSlashSkill extends WeaponInnateSkill {

    public final AssetAccessor<? extends AttackAnimation> first;

    public BrightWindSlashSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
        this.first = SwordCraftAnimations.BRIGHTWINDSLASH;
    }
}
