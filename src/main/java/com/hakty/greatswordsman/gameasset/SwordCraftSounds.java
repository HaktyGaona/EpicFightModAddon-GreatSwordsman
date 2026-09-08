package com.hakty.greatswordsman.gameasset;

import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SwordCraftSounds {

    private SwordCraftSounds() {}

    public static final DeferredRegister<SoundEvent> REGISTRY =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, GreatSwordsman.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_HIT = registerActionSound("entity.weapon.sword_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_WHACK = registerActionSound("entity.weapon.sword_whack");
    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_SWING = registerActionSound("entity.weapon.sword_swing");
    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_SLASH = registerActionSound("entity.weapon.sword_slash");
    public static final DeferredHolder<SoundEvent, SoundEvent> SWORD_GUARD = registerActionSound("entity.weapon.sword_guard");
    public static final DeferredHolder<SoundEvent, SoundEvent> POISE = registerActionSound("entity.weapon.poise");

    private static DeferredHolder<SoundEvent, SoundEvent> registerActionSound(String name) {
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(GreatSwordsman.identifier(name)));
    }
}
