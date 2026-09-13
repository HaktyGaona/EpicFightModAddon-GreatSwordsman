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

public class BastardSwordPostureCharge extends Skill {

    public BastardSwordPostureCharge(SkillBuilder<?> builder) {
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
                        if (usedSkillId != null && usedSkillId.equals(SwordCraftSkills.BRIGHTWINDSLASH.getId())) {
                            System.out.println("[GreatSwordsman] Ready to switch 2 to 1");
                            this.switchToOneHanded(skillContainer);
                        }
                    }
                },
                this
        );
    }
    private void switchToOneHanded(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H)) {
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, false);
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H, true);
                System.out.println("[GreatSwordsman] succeed 2 to 1");
            }
        });
    }

    private void switchToTwoHanded(SkillContainer container) {
        container.runOnServer(serverExecutor -> {
            if (container.getDataManager().getDataValue(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H)) {
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_1H, false);
                container.getDataManager().setDataSync(SwordCraftSkillDataKeys.POSTURE_CHARGE_2H, true);
                System.out.println("[GreatSwordsman] succeed 1 to 2");
                serverExecutor.modifyLivingMotionByCurrentItem(false);
            }
            else System.out.println("[GreatSwordsman] Posture has ready in state of 2H");
        });
    }

    @Override
    public boolean shouldDeactivateAutomatically(PlayerPatch<?> executer) {
        return true;
    }
}
