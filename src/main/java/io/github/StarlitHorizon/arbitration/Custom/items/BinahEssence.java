package io.github.StarlitHorizon.arbitration.Custom.items;

import io.github.StarlitHorizon.arbitration.Custom.entities.ArbEntTypes;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;


public class BinahEssence extends Item {
	public BinahEssence(Properties properties) {
		super(properties);
	}
	@Override
	public InteractionResult use(Level level, Player user, InteractionHand hand) {

		ArbPillar arbPillar = new ArbPillar(ArbEntTypes.ARB_PILLAR, level);
		arbPillar.setPos(user.position());
		level.addFreshEntity(arbPillar);

		return InteractionResult.SUCCESS;
	}
}
