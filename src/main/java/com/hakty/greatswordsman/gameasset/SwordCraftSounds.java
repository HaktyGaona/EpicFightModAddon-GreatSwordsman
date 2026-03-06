package com.hakty.greatswordsman.gameasset;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import com.hakty.greatswordsman.GreatSwordsman;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SwordCraftSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, GreatSwordsman.MOD_ID);

    public static final Supplier<SoundEvent> SWORD_HIT = registerActionSound("entity.weapon.sword_hit");
    public static final Supplier<SoundEvent> SWORD_WHACK = registerActionSound("entity.weapon.sword_whack");
    public static final Supplier<SoundEvent> SWORD_SWING = registerActionSound("entity.weapon.sword_swing");
    public static final Supplier<SoundEvent> SWORD_SLASH = registerActionSound("entity.weapon.sword_slash");
    public static final Supplier<SoundEvent> SWORD_GUARD = registerActionSound("entity.weapon.sword_guard");
    public static final Supplier<SoundEvent> POISE = registerActionSound("entity.weapon.poise");

    private static Supplier<SoundEvent> registerActionSound(String name) {
        ResourceLocation greatswordsmansound = ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(greatswordsmansound));
    }
    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
