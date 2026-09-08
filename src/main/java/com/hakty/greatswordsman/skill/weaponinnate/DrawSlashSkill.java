package com.hakty.greatswordsman.skill.weaponinnate;

import com.hakty.greatswordsman.gameasset.SwordCraftAnimations;
import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class DrawSlashSkill extends WeaponInnateSkill {

    public final AssetAccessor<? extends AttackAnimation> first;

    public DrawSlashSkill(WeaponInnateSkill.Builder<?> builder) {
        super(builder);
        this.first = SwordCraftAnimations.DRAW_SLASH;
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener) {
        super.onInitiate(container, eventListener);

        eventListener.registerEvent(
                EpicFightEventHooks.Animation.END, event -> {
                    if (SwordCraftAnimations.DRAW_SLASH.equals(event.getAnimation())) {
                        this.switchToTwoHanded(container);
                        System.out.println("[GreatSwordsman] Ready to switch 1 to 2");
                    }
                },
                this
        );
    }

    public void switchToTwoHanded(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            // 当前处于 1H 姿态时才切换
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H)) {
                // 离开 1H 姿态
                // 进入 2H 姿态
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, true);
                System.out.println("[GreatSwordsman] succeed 1 to 2");
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
        });
    }
}
