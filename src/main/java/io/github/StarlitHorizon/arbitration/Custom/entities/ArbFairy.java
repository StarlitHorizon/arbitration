package io.github.StarlitHorizon.arbitration.Custom.entities;

import io.github.StarlitHorizon.arbitration.ArbItems;
import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import io.github.StarlitHorizon.arbitration.Custom.effect.ArbEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArbFairy extends ThrowableItemProjectile {
	private int life=0;
	public ArbFairy(final EntityType<? extends ArbFairy> type, final Level level) {
		super(type, level);
	}

	public ArbFairy(final Level level, final LivingEntity mob, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_FAIRY, mob, level, itemStack);
	}

	public ArbFairy(final Level level, final double x, final double y, final double z, final ItemStack itemStack) {
		super(ArbEntTypes.ARB_FAIRY, x, y, z, level, itemStack);
	}

	protected void onHit(final HitResult hitResult) {
		super.onHit(hitResult);
		if (this.level() instanceof ServerLevel serverLevel) {
			serverLevel.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ANVIL_PLACE, this.getSoundSource(),0.5F,1);
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
			var6.hurtServer(serverLevel, damageSource, 6.0F);
			serverLevel.playSound(null,var6.getX(), var6.getY(), var6.getZ(), SoundEvents.TRIDENT_HIT_GROUND, this.getSoundSource());
			if (var6 instanceof LivingEntity livingEntity) {
				var instance = new MobEffectInstance(ArbEffects.FAIRY, 20 * 20, 0, false, false, true);
				livingEntity.hurtArmor(damageSource,10);
				livingEntity.addEffect(instance);
				livingEntity.playSound(SoundEvents.AMETHYST_BLOCK_STEP, 2F, 1F); // plays a sound for the entity hit only
			}
		}
		this.discard();
	}

	@Override
	protected Item getDefaultItem() {
		return ArbItems.BINAH_FAIRY;
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
