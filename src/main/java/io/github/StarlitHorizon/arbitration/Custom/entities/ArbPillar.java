package io.github.StarlitHorizon.arbitration.Custom.entities;

import net.minecraft.network.syncher.SynchedEntityData.Builder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ArbPillar extends Projectile {
	private int life=0;
	public ArbPillar(final EntityType<? extends ArbPillar> type, final Level level) {
		super(type, level);
	}
	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			boolean grief = serverLevel.getGameRules().get(GameRules.MOB_GRIEFING);
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 10, grief, Level.ExplosionInteraction.MOB);
			serverLevel.playSound(null, this.getX(),this.getY(),this.getZ(), SoundEvents.MACE_SMASH_GROUND_HEAVY, this.getSoundSource());
		}
	}

	protected void onHitEntity(final EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			Entity var6 = hitResult.getEntity();
			DamageSource damageSource = this.damageSources().flyIntoWall();
			var6.hurtServer(serverLevel, damageSource, 30.0F);
			serverLevel.playSound(null,var6.getX(), var6.getY(), var6.getZ(), SoundEvents.MACE_SMASH_GROUND, this.getSoundSource());
		}
	}
	@Override
	protected void defineSynchedData(final Builder entityData) {
	}

	public void tick() {
		this.isNoGravity();
		this.tickDespawn();
	}

	protected void tickDespawn() {
		this.life++;
		if (this.life >= 600) {
			if (this.level() instanceof ServerLevel serverLevel) {
				this.level().explode(this, this.getX(), this.getY(), this.getZ(), 10, serverLevel.getGameRules().get(GameRules.MOB_GRIEFING), Level.ExplosionInteraction.MOB);
			}
			this.discard();
		}
	}

}
