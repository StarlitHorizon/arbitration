package io.github.StarlitHorizon.arbitration.Custom.entities;

import io.github.StarlitHorizon.arbitration.ArbItems;
import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import io.github.StarlitHorizon.arbitration.Custom.effect.ArbEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ArbChain extends ThrowableItemProjectile {
	private int life=0;
	public ArbChain(final EntityType<? extends ArbChain> type, final Level level) {
		super(type, level);
	}

	public ArbChain(final Level level, final LivingEntity mob, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_CHAIN, mob, level, itemStack);
	}

	public ArbChain(final Level level, final double x, final double y, final double z, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_CHAIN, x, y, z, level, itemStack);
	}

	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.IRON_BREAK, this.getSoundSource());
		}
		this.discard();
	}

	protected void onHitEntity(final EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			Entity var6 = hitResult.getEntity();
			DamageSource damageSource = new DamageSource(
				serverLevel.registryAccess()
					.lookupOrThrow(Registries.DAMAGE_TYPE)
					.get(ArbDamageTypes.FAIRY_DAMAGE.identifier()).orElseThrow()
			);
			var6.hurtServer(serverLevel, damageSource, 8.0F);
			serverLevel.playSound(null,var6.getX(), var6.getY(), var6.getZ(), SoundEvents.TRIDENT_HIT_GROUND, this.getSoundSource());
			if (var6 instanceof LivingEntity livingEntity) {
				var instance1 = new MobEffectInstance(MobEffects.SLOWNESS, 10 * 20, 1, false, false, true);
				var instance2 = new MobEffectInstance(MobEffects.MINING_FATIGUE, 10 * 20, 1, false, false, true);
				livingEntity.addEffect(instance1);
				livingEntity.addEffect(instance2);
				livingEntity.playSound(SoundEvents.AMETHYST_BLOCK_STEP, 2F, 1F); // plays a sound for the entity hit only
			}
		}
		this.discard();
	}

	@Override
	protected Item getDefaultItem() {
		return ArbItems.BINAH_CHAIN;
	}

	public void tick() {
		super.tick();
		this.setInvulnerable(true);
		this.setNoGravity(true);
		this.tickDespawn();
	}

	protected void tickDespawn() {
		this.life++;
		if (this.life >= 300) {
			this.discard();
		}
	}
}
