package com.hakty.greatswordsman.skill.weaponpassive;

import com.hakty.greatswordsman.gameasset.SwordCraftSkillDataKeys;
import com.hakty.greatswordsman.gameasset.SwordCraftSkills;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

public class BastardSwordPostureCharge1To2 extends Skill {

    public BastardSwordPostureCharge1To2(SkillBuilder<?> builder) {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer skillContainer, EntityEventListener eventListener) {
        super.onInitiate(skillContainer, eventListener);

        eventListener.registerEvent(
                EpicFightEventHooks.Player.CAST_SKILL, event -> {
                    if (!event.getPlayerPatch().isLogicalClient()) {
                        Skill usedSkill = event.getSkillContainer().getSkill();
                        ResourceLocation usedSkillId = usedSkill.getRegistryName();
                        if (usedSkillId != null && usedSkillId.equals(SwordCraftSkills.DRAW_SLASH.getId())) {
                            System.out.println("[GreatSwordsman] Ready to switch 1 to 2");
                            this.switchToTwoHanded(skillContainer);
                        }
                    }
                },
                this
        );
    }

    private void switchToTwoHanded(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            // 当前处于 1H 姿态时才切换
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H)) {
                // 离开 1H 姿态
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H, false);
                // 进入 2H 姿态
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, true);
                System.out.println("[GreatSwordsman] succeed 1 to 2");
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
            else System.out.println("[GreatSwordsman] Posture has ready in state of 2H");
        });
    }

    @Override
    public boolean shouldDeactivateAutomatically(PlayerPatch<?> executer) {
        // 被动技能需要持续激活以监听事件，不应自动停用
        return false;
    }
}
