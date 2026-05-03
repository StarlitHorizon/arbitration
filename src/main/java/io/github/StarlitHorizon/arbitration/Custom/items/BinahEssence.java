package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.ArbItems;
import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.component.ArbComponents;
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


public class BinahEssence extends Item implements ProjectileItem {
	public BinahEssence(Properties properties) {
		super(properties);
	}
	double index = 2;
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		ItemStack itemStack = user.getItemInHand(hand);
		String[] modes = {"Fairy","Chain","Pillar","Lock","Shockwave"};
		String mode = itemStack.getOrDefault(ArbComponents.ESSENCE_MODE,"Pillar");
		if (user.isShiftKeyDown()) {
			Arbitration.LOGGER.info("Incrementing");
			index+=0.5;
			itemStack.set(ArbComponents.ESSENCE_MODE,modes[(int) (index%5)]);
		}
		else if (level instanceof ServerLevel serverLevel && mode.equals("Pillar")) {
			Projectile.spawnProjectileFromRotation(ArbPillar::new, serverLevel, itemStack, user, 0.0F, 5F, 0);
		}
		else if (level instanceof ServerLevel serverLevel && mode.equals("Fairy")) {
			Projectile.spawnProjectileFromRotation(ArbFairy::new, serverLevel, ArbItems.FAIRY.getDefaultInstance(), user, 0.0F, 4.5F, 0);
		}
		return InteractionResult.SUCCESS;
	}

	public Projectile asProjectile(final Level level, final Position position, final ItemStack itemStack, final Direction direction) {
		return new ArbPillar(level, position.x(), position.y(), position.z(), itemStack);
	}
}
