package com.hakty.greatswordsman.world.soundevent;

import com.hakty.greatswordsman.GreatSwordsman;
import com.hakty.greatswordsman.gameasset.SwordCraftSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import yesman.epicfight.registry.entries.EpicFightMobEffects;

@EventBusSubscriber(modid = GreatSwordsman.MOD_ID)
public class SkillPoiseSound {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Post event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(EpicFightMobEffects.STUN_IMMUNITY)) {
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
