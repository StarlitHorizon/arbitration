package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.Custom.entities.ArbFairy;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class BinahPillar extends Item implements ProjectileItem {
	public BinahPillar(Properties properties) {
		super(properties);
	}
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel) {
			Projectile.spawnProjectileFromRotation(ArbPillar::new, serverLevel, user.getItemInHand(hand), user, 0.0F, 10F, 0);
		}
		return InteractionResult.SUCCESS;
	}
	public Projectile asProjectile(final Level level, final Position position, final ItemStack itemStack, final Direction direction) {
		return new ArbPillar(level, position.x(), position.y(), position.z(), itemStack);
	}
}
