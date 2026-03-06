package com.hakty.greatswordsman.world.soundevent;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.world.effect.EpicFightMobEffects;

@Mod.EventBusSubscriber(modid = GreatSwordsman.MOD_ID)
public class SkillPoiseSound {

    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(EpicFightMobEffects.STUN_IMMUNITY.get())) {
                Level level = player.level();
                if (!level.isClientSide()) {
                    level.playSound(
                            null,
                            player.getX(),
                            player.getY() + 1.0,
                            player.getZ(),
                            SwordCraftSounds.POISE.get(),
                            SoundSource.PLAYERS,
                            0.8F,
                            1.0F
                    );
                }
            }
        }
    }
}
