package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.DaedalusbowZnachieniieSvoistvaProcedure;
import net.saik.forgottenfairytales.procedures.DaedalusbowPriPriekrashchieniiIspolzovaniiaProcedure;
import net.saik.forgottenfairytales.procedures.DaedalusbowKazhdyiTikVInvientarieProcedure;
import net.saik.forgottenfairytales.procedures.DaedalusbowKazhdyiTikPriIspolzovaniiProcedure;
import net.saik.forgottenfairytales.entity.BuchofarrowsEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class DaedalusbowItem extends Item {
	public DaedalusbowItem(Item.Properties properties) {
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
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		DaedalusbowKazhdyiTikVInvientarieProcedure.execute();
	}

	@Override
	public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
		DaedalusbowPriPriekrashchieniiIspolzovaniiaProcedure.execute(entity);
		if (!world.isClientSide() && entity instanceof ServerPlayer player) {
			float pullingPower = BowItem.getPowerForTime(this.getUseDuration(itemstack, player) - time);
			if (pullingPower < 0.1)
				return false;
			ItemStack stack = findAmmo(player);
			if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
				BuchofarrowsEntity projectile = BuchofarrowsEntity.shoot(world, entity, world.getRandom(), pullingPower);
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
		DaedalusbowKazhdyiTikPriIspolzovaniiProcedure.execute(entity);
	}

	private ItemStack findAmmo(Player player) {
		ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == BuchofarrowsEntity.PROJECTILE_ITEM.getItem());
		if (stack == ItemStack.EMPTY) {
			for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
				ItemStack teststack = player.getInventory().getItem(i);
				if (teststack != null && teststack.getItem() == BuchofarrowsEntity.PROJECTILE_ITEM.getItem()) {
					stack = teststack;
					break;
				}
			}
		}
		return stack;
	}

	public record PullingProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<PullingProperty> MAP_CODEC = MapCodec.unit(new PullingProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) DaedalusbowZnachieniieSvoistvaProcedure.execute(entity);
		}

		@Override
		public MapCodec<PullingProperty> type() {
			return MAP_CODEC;
		}
	}
}