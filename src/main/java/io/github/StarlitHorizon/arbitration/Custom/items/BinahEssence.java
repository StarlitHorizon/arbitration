package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.ArbItems;
import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import io.github.StarlitHorizon.arbitration.Custom.component.ArbComponents;
import io.github.StarlitHorizon.arbitration.Custom.effect.ArbEffects;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbChain;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbFairy;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbLock;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.fabricmc.fabric.api.particle.v1.FabricBlockParticleOption;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.PowerParticleOption;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;


public class BinahEssence extends Item implements ProjectileItem {
	public BinahEssence(Properties properties) {
		super(properties);
	}
	int index = 0;
	List<String> modes = List.of("Fairy","Chain","Pillar","Lock","Shockwave");
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		ItemStack itemStack = user.getItemInHand(hand);
		String mode = itemStack.getOrDefault(ArbComponents.ESSENCE_MODE, "Fairy");
		if (user.isShiftKeyDown()) {
			index = modes.indexOf(mode) + 1;
			level.playSound(null,user, SoundEvents.END_PORTAL_FRAME_FILL,user.getSoundSource(),0.75F,1.5F);

		}
		else if (level instanceof ServerLevel serverLevel && mode.equals("Fairy")) {
			Projectile.spawnProjectileFromRotation(ArbFairy::new, serverLevel, ArbItems.BINAH_FAIRY.getDefaultInstance(), user, 0.0F, 4.5F, 0);
		} else if (level instanceof ServerLevel serverLevel && mode.equals("Chain")) {
			Projectile.spawnProjectileFromRotation(ArbChain::new, serverLevel, ArbItems.BINAH_CHAIN.getDefaultInstance(), user, 0.0F, 4.5F, 0);
		} else if (level instanceof ServerLevel serverLevel && mode.equals("Pillar")) {
			Projectile.spawnProjectileFromRotation(ArbPillar::new, serverLevel, itemStack, user, 0.0F, 5F, 0);
		} else if (level instanceof ServerLevel serverLevel && mode.equals("Lock")) {
			Projectile.spawnProjectileFromRotation(ArbLock::new, serverLevel, ArbItems.BINAH_LOCK.getDefaultInstance(), user, 0.0F, 5F, 0);
		} else if (level instanceof ServerLevel serverLevel && mode.equals("Shockwave")) {
			AreaEffectCloud shockwave = new AreaEffectCloud(serverLevel, user.getX(), user.getY(), user.getZ());
			user.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 300, 3));
			shockwave.setOwner(user);
			shockwave.setCustomParticle(FabricBlockParticleOption.create(ParticleTypes.BLOCK_CRUMBLE,user.getBlockStateOn(),new BlockPos(user.getBlockX(), user.getBlockX()-1, user.getBlockX())));
			shockwave.setRadius(0.5F);
			shockwave.setWaitTime(0);
			shockwave.setDuration(12);
			shockwave.setRadiusPerTick(1F);
			shockwave.setPotionDurationScale(1);
			serverLevel.addFreshEntity(shockwave);
			List<LivingEntity> targets = user.level().getEntitiesOfClass(LivingEntity.class, shockwave.getBoundingBox());
			for (LivingEntity entity : targets) {
				if (entity!=user) {
					entity.hurtServer(serverLevel,
						new DamageSource(
							level.registryAccess()
								.lookupOrThrow(Registries.DAMAGE_TYPE)
								.get(ArbDamageTypes.PULVERISE_DAMAGE.identifier()).orElseThrow()),
						15);
					entity.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 3));
					entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 300, 1));
					entity.addEffect(new MobEffectInstance(ArbEffects.LOCK, 300, 2));
				}
			}
			level.playSound(null,user, SoundEvents.MACE_SMASH_GROUND_HEAVY,user.getSoundSource(),1,1);
		}
		itemStack.set(ArbComponents.ESSENCE_MODE, modes.get(index % 5));
		return InteractionResult.SUCCESS;
	}

	public Projectile asProjectile(final Level level, final Position position, final ItemStack itemStack, final Direction direction) {
		return new ArbPillar(level, position.x(), position.y(), position.z(), itemStack);
	}
}
