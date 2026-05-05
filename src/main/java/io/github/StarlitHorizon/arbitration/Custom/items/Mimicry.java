package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import io.github.StarlitHorizon.arbitration.Custom.effect.ArbEffects;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.fabricmc.fabric.api.particle.v1.FabricBlockParticleOption;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ARGB;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class Mimicry extends Item {
	public Mimicry(Properties properties) {
		super(properties);
	}
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel) {
			user.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 5*20, 0));
			user.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5*20, 0));
			user.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 10*20, 0));
			AreaEffectCloud shockwave = new AreaEffectCloud(serverLevel, user.getX(), user.getEyeY()-1, user.getZ());
			user.invulnerableTime=10;
			shockwave.setOwner(user);
			shockwave.setCustomParticle(new DustParticleOptions(ARGB.color(158, 0, 0), 1.5F));
			shockwave.setRadius(5F);
			shockwave.setWaitTime(0);
			shockwave.setDuration(2);
			shockwave.setRadiusPerTick(0F);
			shockwave.setPotionDurationScale(1);
			serverLevel.addFreshEntity(shockwave);
			List<LivingEntity> targets = user.level().getEntitiesOfClass(LivingEntity.class, shockwave.getBoundingBox());
			for (LivingEntity entity : targets) {
				if (entity!=user) {
					entity.hurtServer(serverLevel,
						new DamageSource(
							level.registryAccess()
								.lookupOrThrow(Registries.DAMAGE_TYPE)
								.get(ArbDamageTypes.BLEED_DAMAGE.identifier()).orElseThrow()),
						10F);
					entity.forceAddEffect(new MobEffectInstance(ArbEffects.BLEED, 15*20, 1),user);
				}
			}
			level.playSound(null,user, SoundEvents.PLAYER_ATTACK_SWEEP,user.getSoundSource(),1,1);
			level.playSound(null,user, SoundEvents.PLAYER_ATTACK_CRIT,user.getSoundSource(),1,1);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
		super.hurtEnemy(itemStack, mob, attacker);
		mob.forceAddEffect(new MobEffectInstance(ArbEffects.BLEED,100,0,false,false,true),attacker);
	}
}
