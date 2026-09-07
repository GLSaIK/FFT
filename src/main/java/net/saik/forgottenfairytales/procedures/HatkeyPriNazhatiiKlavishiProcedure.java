package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.world.inventory.HatguiMenu;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class HatkeyPriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack t = ItemStack.EMPTY;
		ItemStack t2 = ItemStack.EMPTY;
		if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.HAT_HELMET.get()) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					_ent.openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("Hatgui");
						}

						@Override
						public boolean shouldTriggerClientSideContainerClosingOnOpen() {
							return false;
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new HatguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		} else if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin) {
			if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).scabbardTrue) {
				t = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack5 = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).scabbardItem.copy();
					_setstack5.setCount(entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).scabbardItem.getCount());
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack5);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				{
					ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
					_vars.scabbardItem = t.copy();
					_vars.markSyncDirty();
				}
			}
		}
	}
}