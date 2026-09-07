package com.hakty.greatswordsman.gameasset;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.hakty.greatswordsman.GreatSwordsman;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;


public class WeaponColliderPreset {
    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation resourceLocation, Collider collider) {
        if (PRESETS.containsKey(resourceLocation)) {
            throw new IllegalStateException("Collider named " + resourceLocation + " already registered.");
        }
        PRESETS.put(resourceLocation, collider);
        return collider;
    }

    public static final Collider SHORTSWORD = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "shortsword"),
            new MultiOBBCollider(9, 0.4D, 0.4D, 0.7D, 0.0D, 0.0D, -0.35D));
    public static final Collider KATZBALGER = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "katzbalger"),
            new MultiOBBCollider(9, 0.4D, 0.4D, 0.7D, 0.0D, 0.0D, -0.35D));
    public static final Collider BASTARDSWORD = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "bastardsword"),
            new MultiOBBCollider(9, 0.3D, 0.3D, 0.8D, 0.0D, 0.0D, -0.9D));
    public static final Collider CLAYMORE = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "claymore"),
            new MultiOBBCollider(9, 0.3D, 0.3D, 0.9D, 0.0D, 0.0D, -0.95D));
    public static final Collider PIKE = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "pike"),
            new MultiOBBCollider(9, 0.3D, 0.3D, 1.9D, 0.0D, 0.0D, -1.0D));
    public static final Collider RANSEUR = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "ranseur"),
            new MultiOBBCollider(9, 0.3D, 0.3D, 1.6D, 0.0D, 0.0D, -0.9D));
    public static final Collider GUISARME = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "guisarme"),
            new MultiOBBCollider(9, 0.3D, 0.3D, 1.5D, 0.0D, 0.0D, -1.1D));
    public static final Collider CONCAVEHALBERD = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "concavehalberd"),
            new MultiOBBCollider(9, 0.3D, 0.6D, 1.5D, 0.0D, 0.0D, -1.1D));
    public static final Collider LOCHABERAXE = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "lochaveraxe"),
            new MultiOBBCollider(9, 0.3D, 0.4D, 1.3D, 0.0D, -0.4D, -0.9D));
    public static final Collider ZWEIHANDER = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "zweihander"),
            new MultiOBBCollider(9, 0.3D, 0.6D, 1.3D, 0.0D, 0.0D, -1.0D));
    public static final Collider FLAMEBLADEDSWORD = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "flamebladedsword"),
            new MultiOBBCollider(9, 0.3D, 0.6D, 1.3D, 0.0D, 0.0D, -1.0D));
    public static final Collider BLADEDSTICK = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "bladedstick"),
            new MultiOBBCollider(9, 0.4D, 0.4D, 1.3D, 0.0D, 0.0D, 0.0D));
    public static final Collider WARHAMMER = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "warhammer"),
            new MultiOBBCollider(9, 0.3D, 0.4D, 0.8D, 0.0D, 0.0D, -0.55D));
    public static final Collider LUCERNEHAMMER = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "lucernehammer"),
            new MultiOBBCollider(9, 0.3D, 0.4D, 0.9D, 0.0D, 0.0D, -0.65D));
    public static final Collider STILETTO = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "stiletto"),
            new MultiOBBCollider(9, 0.4D, 0.4D, 0.5D, 0.0D, 0.0D, -0.35D));

    public static final Collider COMBOSLASH = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "comboslash"),
            new MultiOBBCollider(9, 2.2D, 0.8D, 2.2D, 0.0D, 1.0D, -1.6D));
    public static final Collider SWORD_TYPE2_DASH = registerCollider(ResourceLocation.fromNamespaceAndPath(GreatSwordsman.MOD_ID, "sword_type2_dash"),
            new MultiOBBCollider(9, 2.0D, 0.8D, 1.25D, 0.0D, 1.0D, -1.6D));
}
