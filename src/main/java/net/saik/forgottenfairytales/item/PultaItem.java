package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.PultaZnachieniieSvoistvaProcedure;
import net.saik.forgottenfairytales.procedures.PultaPriPriekrashchieniiIspolzovaniiaProcedure;
import net.saik.forgottenfairytales.procedures.PultaKazhdyiTikPriIspolzovaniiProcedure;
import net.saik.forgottenfairytales.entity.FireballlEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class PultaItem extends Item {
	public PultaItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
		return 72000;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = InteractionResult.FAIL;
		if (entity.getAbilities().instabuild || findAmmo(entity) != ItemStack.EMPTY) {
			ar = InteractionResult.SUCCESS;
			entity.startUsingItem(hand);
		}
		return ar;
	}

	@Override
	public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		PultaPriPriekrashchieniiIspolzovaniiaProcedure.execute(entity);
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			float pullingPower = BowItem.getPowerForTime(this.getUseDuration(itemstack, player) - time);
			if (pullingPower < 0.1)
				return false;
			ItemStack stack = findAmmo(player);
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				FireballlEntity projectile = FireballlEntity.shoot(world, entity, world.getRandom(), pullingPower);
				if (player.getAbilities().instabuild) {
					projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
				} else {
					if (stack.isDamageableItem()) {
						if (world instanceof ServerLevel serverLevel)
							stack.hurtAndBreak(1, serverLevel, player, _stkprov -> {
							});
					} else {
						stack.shrink(1);
					}
				}
			}
		}
		return super.releaseUsing(itemstack, world, entity, time);
	}

	@Override
	public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int time) {
		PultaKazhdyiTikPriIspolzovaniiProcedure.execute(entity);
	}

	private ItemStack findAmmo(Player player) {
		return new ItemStack(FireballlEntity.PROJECTILE_ITEM.getItem());
	}

	public record PullProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<PullProperty> MAP_CODEC = MapCodec.unit(new PullProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) PultaZnachieniieSvoistvaProcedure.execute(entity);
		}

		@Override
		public MapCodec<PullProperty> type() {
			return MAP_CODEC;
		}
	}
}