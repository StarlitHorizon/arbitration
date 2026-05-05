package io.github.StarlitHorizon.arbitration.Custom.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Serumr extends Item {
	public Serumr(Properties properties) {
		super(properties);
	}

	public InteractionResult use(Level level, Player user, InteractionHand hand) {
		user.playSound(SoundEvents.BREWING_STAND_BREW);
		user.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 10*20, 2));
		user.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 10*20, 1));
		ItemStack heldStack = user.getItemInHand(hand);
		heldStack.consumeAndReturn(1,user);
		return InteractionResult.SUCCESS;
	}
}
