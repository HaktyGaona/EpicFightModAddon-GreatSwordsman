package com.hakty.greatswordsman.gameasset;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.hakty.greatswordsman.GreatSwordsman;

public class SwordCraftSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GreatSwordsman.MOD_ID);

    public static final RegistryObject<SoundEvent> SWORD_HIT = registerActionSound("entity.weapon.sword_hit");
    public static final RegistryObject<SoundEvent> SWORD_WHACK = registerActionSound("entity.weapon.sword_whack");
    public static final RegistryObject<SoundEvent> SWORD_SWING = registerActionSound("entity.weapon.sword_swing");
    public static final RegistryObject<SoundEvent> SWORD_SLASH = registerActionSound("entity.weapon.sword_slash");
    public static final RegistryObject<SoundEvent> SWORD_GUARD = registerActionSound("entity.weapon.sword_guard");
    public static final RegistryObject<SoundEvent> POISE = registerActionSound("entity.weapon.poise");

    public SwordCraftSounds() {
    }

    private static RegistryObject<SoundEvent> registerActionSound(String name) {
        ResourceLocation greatswordsmansound = ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, name);
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(greatswordsmansound));
    }
}
