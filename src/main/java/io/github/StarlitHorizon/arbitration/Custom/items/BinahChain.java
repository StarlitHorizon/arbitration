package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.Custom.entities.ArbChain;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbFairy;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class BinahChain extends Item{
	public BinahChain(Properties properties) {
		super(properties);
	}
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		if (level instanceof ServerLevel serverLevel) {
			Projectile.spawnProjectileFromRotation(ArbChain::new, serverLevel, user.getItemInHand(hand), user, 0.0F, 5F, 0);
		}
		return InteractionResult.SUCCESS;
	}
}
