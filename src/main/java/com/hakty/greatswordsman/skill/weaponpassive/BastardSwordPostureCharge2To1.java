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

public class BastardSwordPostureCharge2To1 extends Skill {

    public BastardSwordPostureCharge2To1(SkillBuilder<?> builder) {
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
                        System.out.println("[GreatSwordsman] Gatting 2 to 1 Res ID...");
                        if (usedSkillId != null && usedSkillId.equals(SwordCraftSkills.BLIGHTWINDSLASH.getId())) {
                            this.switchToOneHanded(skillContainer);
                            System.out.println("[GreatSwordsman] Ready to switch 2 to 1");
                        }
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
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, false);
                // 进入 1H 姿态
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H, true);
                System.out.println("[GreatSwordsman] succeed 2 to 1");
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
        });
    }
}
