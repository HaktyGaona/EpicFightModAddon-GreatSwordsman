package com.hakty.greatswordsman.gameasset;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.hakty.greatswordsman.GreatSwordsman;

import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.AnimationManager.AnimationRegistryEvent;
import yesman.epicfight.api.animation.AnimationManager.AnimationAccessor;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty.*;
import yesman.epicfight.api.animation.property.MoveCoordFunctions;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.damagesource.StunType;

import javax.annotation.Nullable;

public class SwordCraftAnimations {
    public static DirectStaticAnimation EMPTY_ANIMATION = new DirectStaticAnimation() {
        @Override
        public void loadAnimation() {
        }

        @Override
        public AnimationClip getAnimationClip() {
            return AnimationClip.EMPTY_CLIP;
        }
    };
    public static AnimationAccessor<StaticAnimation> PICK_IDLE;
    public static AnimationAccessor<MovementAnimation> PICK_WALK;
    public static AnimationAccessor<MovementAnimation> PICK_RUN;
    public static AnimationAccessor<MovementAnimation> PICK_SNEAK;
    public static AnimationAccessor<BasicAttackAnimation> PICK_AUTO1;
    public static AnimationAccessor<DashAttackAnimation> PICK_DASH;
    public static AnimationAccessor<AirSlashAnimation> PICK_AIRSLASH;

    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE1_IDLE;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE1_WALK;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE1_RUN;
    public static AnimationAccessor<BasicAttackAnimation> SWORDCRAFT_TYPE1_AUTO1;
    public static AnimationAccessor<BasicAttackAnimation> SWORDCRAFT_TYPE1_AUTO2;
    public static AnimationAccessor<BasicAttackAnimation> SWORDCRAFT_TYPE1_AUTO3;
    public static AnimationAccessor<DashAttackAnimation> SWORDCRAFT_TYPE1_DASH;
    public static AnimationAccessor<AirSlashAnimation> SWORDCRAFT_TYPE1_AIRSLASH;

    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_IDLE;
    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_JUMP;
    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_FALL;
    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_FLOAT;
    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_KNEEL;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE2_WALK;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE2_RUN;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE2_SNEAK;
    public static AnimationAccessor<MovementAnimation> SWORDCRAFT_TYPE2_SWIM;
    public static AnimationAccessor<BasicAttackAnimation> SWORDCRAFT_TYPE2_AUTO1;
    public static AnimationAccessor<BasicAttackAnimation> SWORDCRAFT_TYPE2_AUTO2;
    public static AnimationAccessor<DashAttackAnimation> SWORDCRAFT_TYPE2_DASH;
    public static AnimationAccessor<AirSlashAnimation> SWORDCRAFT_TYPE2_AIRSLASH;

    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE1_GUARD;
    public static AnimationAccessor<StaticAnimation> SWORDCRAFT_TYPE2_GUARD;
    public static AnimationAccessor<GuardAnimation> SWORDCRAFT_TYPE1_HIT1;
    public static AnimationAccessor<GuardAnimation> SWORDCRAFT_TYPE2_HIT1;
    public static AnimationAccessor<GuardAnimation> SWORDCRAFT_TYPE1_DEFLECT1;
    public static AnimationAccessor<GuardAnimation> SWORDCRAFT_TYPE1_DEFLECT2;
    public static AnimationAccessor<GuardAnimation> SWORDCRAFT_TYPE2_DEFLECT1;
    public static AnimationAccessor<LongHitAnimation> SWORDCRAFT_TYPE1_NEUTRALIZED;
    public static AnimationAccessor<LongHitAnimation> SWORDCRAFT_TYPE2_NEUTRALIZED;

    public static AnimationAccessor<AttackAnimation> COMBOSLASH_1;
    public static AnimationAccessor<AttackAnimation> COMBOSLASH_2;
    public static AnimationAccessor<AttackAnimation> COMBOSLASH_3;
    public static AnimationAccessor<AttackAnimation> COMBOSLASH_4;
    public static AnimationAccessor<AttackAnimation> COMBOSLASH_5;
    public static AnimationAccessor<AttackAnimation> COMBOSLASH_FAIL;

    public static AnimationAccessor<StaticAnimation> STICK_IDLE;
    public static AnimationAccessor<BasicAttackAnimation> STICK_AUTO1;
    public static AnimationAccessor<BasicAttackAnimation> STICK_AUTO2;


    @SubscribeEvent
    public static void registerAnimations(AnimationRegistryEvent event) {
        event.newBuilder(GreatSwordsman.MOD_ID, SwordCraftAnimations::build);
    }

    public static void build(AnimationManager.AnimationBuilder builder){
        //矛
        PICK_IDLE = builder.nextAccessor("biped/living/pick/pick_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        PICK_AUTO1 = builder.nextAccessor("biped/combat/pick/pick_attack1", (accessor) ->
                new BasicAttackAnimation(0.05f, 0.16f, 0.2f, 0.3f, 0.45f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED));
        //混种剑类型1
        SWORDCRAFT_TYPE1_IDLE = builder.nextAccessor("biped/living/bastardsword/sword_type1_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_WALK = builder.nextAccessor("biped/living/bastardsword/sword_type1_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_RUN = builder.nextAccessor("biped/living/bastardsword/sword_type1_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_AUTO1 = builder.nextAccessor("biped/combat/bastardsword/sword_type1_attack1", (accessor) ->
                new BasicAttackAnimation(0.05f, 0.08f, 0.1f, 0.33f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, true));
        SWORDCRAFT_TYPE1_AUTO2 = builder.nextAccessor("biped/combat/bastardsword/sword_type1_attack2", (accessor) ->
                new BasicAttackAnimation(0.05f, 0.14f, 0.2f, 0.3f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AttackAnimationProperty.CANCELABLE_MOVE, true));
        SWORDCRAFT_TYPE1_AUTO3 = builder.nextAccessor("biped/combat/bastardsword/sword_type1_attack3", (accessor) ->
                new BasicAttackAnimation(0.05f, 0.05f, 0.15f, 0.36f, 0.6f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AttackAnimationProperty.CANCELABLE_MOVE, true));
        SWORDCRAFT_TYPE1_DASH = builder.nextAccessor("biped/combat/bastardsword/sword_type1_dash", (accessor) ->
                new DashAttackAnimation(0.15f, 0.03f, 0.1f, 0.2f, 0.4f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f)
                        .addProperty(AttackAnimationProperty.CANCELABLE_MOVE, false));
        SWORDCRAFT_TYPE1_AIRSLASH = builder.nextAccessor("biped/combat/bastardsword/sword_type1_airslash", (accessor) ->
                new AirSlashAnimation(0.05f, 0.15f, 0.33f, 0.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0f))
                        .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.0f))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f)
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, false));
        SWORDCRAFT_TYPE1_GUARD = builder.nextAccessor("biped/guard/bastardsword/sword_type1_guard", (accessor) ->
                new StaticAnimation(0.07f, true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_HIT1 = builder.nextAccessor("biped/guard/bastardsword/sword_type1_hit1", (accessor) ->
                new GuardAnimation(0.05f, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_DEFLECT1 = builder.nextAccessor("biped/guard/bastardsword/sword_type1_parrying1", (accessor) ->
                new GuardAnimation(0.05f, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_DEFLECT2 = builder.nextAccessor("biped/guard/bastardsword/sword_type1_parrying2", (accessor) ->
                new GuardAnimation(0.05f, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE1_NEUTRALIZED = builder.nextAccessor("biped/guard/bastardsword/sword_type1_neutralized", (accessor) ->
                new LongHitAnimation(0.05f, accessor, Armatures.BIPED));

        COMBOSLASH_1 = builder.nextAccessor("biped/skill/comboslash1", (accessor) ->
                new AttackAnimation(0.1f, 0.02f, 0.06f, 0.26f, 0.26f, WeaponColliderPreset.COMBOSLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.0f)
                        .addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_DISTANCE)
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.01F, 0.16F))
                        .addProperty(AttackAnimationProperty.CANCELABLE_MOVE, true)
                        .addState(EntityState.LOCKON_ROTATE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        COMBOSLASH_2 = builder.nextAccessor("biped/skill/comboslash2", (accessor) ->
                new AttackAnimation(0.1f, 0.02f, 0.05f, 0.26f, 0.26f, WeaponColliderPreset.COMBOSLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.0f)
                        .addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.01F, 0.16F))
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        COMBOSLASH_3 = builder.nextAccessor("biped/skill/comboslash3", (accessor) ->
                new AttackAnimation(0.1f, 0.02f, 0.05f, 0.26f, 0.26f, WeaponColliderPreset.COMBOSLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.0f)
                        .addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.01F, 0.16F))
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        COMBOSLASH_4 = builder.nextAccessor("biped/skill/comboslash4", (accessor) ->
                new AttackAnimation(0.1f, 0.02f, 0.05f, 0.26f, 0.26f, WeaponColliderPreset.COMBOSLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 3.0f)
                        .addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.01F, 0.16F))
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        COMBOSLASH_5 = builder.nextAccessor("biped/skill/comboslash5", (accessor) ->
                new AttackAnimation(0.02f, 0.02f, 0.05f, 0.26f, 0.26f, WeaponColliderPreset.COMBOSLASH, Armatures.BIPED.get().rootJoint, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.HIT_PRIORITY, HitEntityList.Priority.TARGET)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 2.0f)
                        .addProperty(ActionAnimationProperty.COORD_SET_BEGIN, MoveCoordFunctions.TRACE_ORIGIN_AS_DESTINATION)
                        .addProperty(ActionAnimationProperty.COORD_SET_TICK, MoveCoordFunctions.TRACE_TARGET_LOCATION_ROTATION)
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.01F, 0.16F))
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(ActionAnimationProperty.CANCELABLE_MOVE, true)
                        .addState(EntityState.MOVEMENT_LOCKED, true));
        COMBOSLASH_FAIL= builder.nextAccessor("biped/skill/comboslash_fail", (accessor) ->
                new AttackAnimation(0.35F, 0.05F, 0.1F, 0.5F, 0.6F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.SWING_SOUND, SwordCraftSounds.SWORD_SLASH.get())
                        .addProperty(AttackPhaseProperty.HIT_SOUND, SwordCraftSounds.SWORD_WHACK.get())
                        .addProperty(ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0F, 0.2F))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.4F));
        //混种剑类型2
        SWORDCRAFT_TYPE2_IDLE = builder.nextAccessor("biped/living/bastardsword/sword_type2_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_JUMP = builder.nextAccessor("biped/living/bastardsword/sword_type2_jump", (accessor) -> new StaticAnimation(false, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_FALL = builder.nextAccessor("biped/living/bastardsword/sword_type2_fall", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_KNEEL = builder.nextAccessor("biped/living/bastardsword/sword_type2_kneel", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_FLOAT = builder.nextAccessor("biped/living/bastardsword/sword_type2_float", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_WALK = builder.nextAccessor("biped/living/bastardsword/sword_type2_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_RUN = builder.nextAccessor("biped/living/bastardsword/sword_type2_run", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_SNEAK = builder.nextAccessor("biped/living/bastardsword/sword_type2_sneak", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_SWIM = builder.nextAccessor("biped/living/bastardsword/sword_type2_swim", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_AUTO1 = builder.nextAccessor("biped/combat/bastardsword/sword_type2_attack1", (accessor) ->
                new BasicAttackAnimation(0.05f, 0.0f, 0.02f, 0.18f, 0.41f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0f)
                        .addProperty(AttackAnimationProperty.CANCELABLE_MOVE, false));
        SWORDCRAFT_TYPE2_AUTO2 = builder.nextAccessor("biped/combat/bastardsword/sword_type2_attack2", (accessor) ->
                new BasicAttackAnimation(0.05f, accessor, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0f, 0.05f, 0.1f, 0.2f, 0.26f, 0.26f, Armatures.BIPED.get().toolR, null)
                                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1)),
                        new AttackAnimation.Phase(0.26f, 0.28f, 0.28f, 0.43f, 0.5f, 0.55f, Armatures.BIPED.get().toolR, null)
                                .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(1))
                                .addProperty(AttackPhaseProperty.STUN_TYPE, StunType.SHORT))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f));
        SWORDCRAFT_TYPE2_DASH = builder.nextAccessor("biped/combat/bastardsword/sword_type2_dash", (accessor) ->
                new DashAttackAnimation(0.05f, 0.0f, 0.05f, 0.16f, 0.36f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f));
        SWORDCRAFT_TYPE2_AIRSLASH = builder.nextAccessor("biped/combat/bastardsword/sword_type2_airslash", (accessor) ->
                new AirSlashAnimation(0.05f, 0.08f, 0.21f, 0.36f, null, Armatures.BIPED.get().toolR, accessor , Armatures.BIPED)
                        .addProperty(AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(9))
                        .addProperty(AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2.0f))
                        .addProperty(AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(1.0f))
                        .addProperty(AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6f)
                        .addProperty(ActionAnimationProperty.MOVE_VERTICAL, false));
        SWORDCRAFT_TYPE2_GUARD = builder.nextAccessor("biped/guard/bastardsword/sword_type2_guard", (accessor) ->
                new StaticAnimation(0.07f, true, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_HIT1 = builder.nextAccessor("biped/guard/bastardsword/sword_type2_hit1", (accessor) ->
                new GuardAnimation(0.05f, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_DEFLECT1 = builder.nextAccessor("biped/guard/bastardsword/sword_type2_parrying1", (accessor) ->
                new GuardAnimation(0.05f, accessor, Armatures.BIPED));
        SWORDCRAFT_TYPE2_NEUTRALIZED = builder.nextAccessor("biped/guard/bastardsword/sword_type2_neutralized", (accessor) ->
                new LongHitAnimation(0.05f, accessor, Armatures.BIPED));
    }



    public interface IProxy {
        @Nullable
        Entity getClientPlayer();
    }
    public static class ClientProxy implements IProxy {
        @Override
        public Entity getClientPlayer() {
            return Minecraft.getInstance().player;
        }
    }
    public static class ServerProxy implements IProxy {
        @Override
        public Entity getClientPlayer() {
            return null;
        }
    }
}
