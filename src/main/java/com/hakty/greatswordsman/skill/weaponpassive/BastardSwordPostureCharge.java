package com.hakty.greatswordsman.skill.weaponpassive;

import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

public class BastardSwordPostureCharge extends Skill {
    public BastardSwordPostureCharge(SkillBuilder<?> builder) {
        super(builder);
    }
    @Override
    public void onInitiate(SkillContainer skillContainer, EntityEventListener eventListener) {
        super.onInitiate(skillContainer, eventListener);

        eventListener.registerEvent(
                EpicFightEventHooks.Player.CONSUME_SKILL, event -> {
                    if (!event.getEntityPatch().isLogicalClient()) {
                        this.onPostureCharge(skillContainer);
                    }
                },
                this
        );
        eventListener.registerEvent(EpicFightEventHooks.Player.USE_ITEM, event -> {
                    this.onReset(skillContainer);
                },
                this
        );
    }


    @Override
    public void onPostureCharge(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H_TO_1H)) {
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H_TO_1H, false);
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H_TO_2H, true);
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
        });
    }
    @Override
    public void onReset(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H_TO_2H)) {
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H_TO_2H, false);
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H_TO_1H, true);
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
        });
    }

    @Override
    public boolean shouldDeactivateAutomatically(PlayerPatch<?> executer) {
        return true;
    }
}

