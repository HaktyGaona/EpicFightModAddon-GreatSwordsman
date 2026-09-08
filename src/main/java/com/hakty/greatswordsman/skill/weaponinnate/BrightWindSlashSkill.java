package com.hakty.greatswordsman.skill.weaponinnate;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class BrightWindSlashSkill extends WeaponInnateSkill {

    public final AssetAccessor<? extends AttackAnimation> first;

    public BrightWindSlashSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
        this.first = SwordCraftAnimations.BRIGHTWINDSLASH;
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);

        eventListener.registerEvent(
                EpicFightEventHooks.Animation.END, event -> {
                    if (SwordCraftAnimations.BRIGHTWINDSLASH.equals(event.getAnimation())) {
                        this.switchToOneHanded(container);
                        System.out.println("[GreatSwordsman] Ready to switch 2 to 1");
                    }
                },
                this
        );
    }

    private void switchToOneHanded(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            // 当前处于 2H 姿态时才切换
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H)) {
                // 离开 2H 姿态
                // 进入 1H 姿态
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, false);
                System.out.println("[GreatSwordsman] succeed 2 to 1");
            }
        });
    }
}
