package io.github.StarlitHorizon.arbitration.Custom.entities;

import io.github.StarlitHorizon.arbitration.ArbItems;
import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArbPillar extends ThrowableItemProjectile {
	private int life=0;
	private boolean exploded = false;
	public ArbPillar(final EntityType<? extends ArbPillar> type, final Level level) {
		super(type, level);
	}

	public ArbPillar(final Level level, final LivingEntity mob, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_PILLAR, mob, level, itemStack);
	}

	public ArbPillar(final Level level, final double x, final double y, final double z, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_PILLAR, x, y, z, level, itemStack);
	}

	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			if (!exploded) {
				this.level().explode(this, this.getX(), this.getY(), this.getZ(), 4, serverLevel.getGameRules().get(GameRules.MOB_GRIEFING), Level.ExplosionInteraction.MOB);
				serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.MACE_SMASH_GROUND_HEAVY, this.getSoundSource());
				exploded = true;
			}
		}
	}

	protected void onHitEntity(final EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			Entity var6 = hitResult.getEntity();
			DamageSource damageSource = new DamageSource(
				serverLevel.registryAccess()
					.lookupOrThrow(Registries.DAMAGE_TYPE)
					.get(ArbDamageTypes.PULVERISE_DAMAGE.identifier()).orElseThrow()
			);
			var6.hurtServer(serverLevel, damageSource, 15.0F);
			serverLevel.playSound(null,var6.getX(), var6.getY(), var6.getZ(), SoundEvents.MACE_SMASH_GROUND, this.getSoundSource());
		}
	}

	@Override
	protected Item getDefaultItem() {
		return ArbItems.BINAH_ESSENCE;
	}

	public void tick() {
		super.tick();
		this.setInvulnerable(true);
		this.setNoGravity(true);
		this.tickDespawn(300);
		BlockPos blockPos = this.blockPosition();
		BlockState blockState = this.level().getBlockState(blockPos);
		if (!blockState.isAir()) {
			this.tickDespawn(100);
		}
	}


	protected void tickDespawn(int x) {
		this.life++;
		if (this.life >= x) {
			if (this.level() instanceof ServerLevel serverLevel) {
				this.level().explode(this, this.getX(), this.getY(), this.getZ(), 10, serverLevel.getGameRules().get(GameRules.MOB_GRIEFING), Level.ExplosionInteraction.MOB);
			}
			this.discard();
		}
	}
}
