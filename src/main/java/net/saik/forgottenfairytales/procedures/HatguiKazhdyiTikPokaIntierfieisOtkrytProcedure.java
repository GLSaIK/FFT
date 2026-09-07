package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;

public class HatguiKazhdyiTikPokaIntierfieisOtkrytProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER_HELMET
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.CHAINMAIL_HELMET
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_HELMET) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LEATHER_HELMET) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ForgottenFairyTalesModMobEffects.ARMOR);
					ForgottenFairyTalesMod.queueServerWork(2, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.ARMOR, (int) Double.POSITIVE_INFINITY, 1, false, false));
					});
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.CHAINMAIL_HELMET
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_HELMET
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.GOLDEN_HELMET) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ForgottenFairyTalesModMobEffects.ARMOR);
					ForgottenFairyTalesMod.queueServerWork(2, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.ARMOR, (int) Double.POSITIVE_INFINITY, 2, false, false));
					});
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_HELMET
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(0).getItem() : ItemStack.EMPTY)
								.getItem() == Items.NETHERITE_HELMET) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(ForgottenFairyTalesModMobEffects.ARMOR);
					ForgottenFairyTalesMod.queueServerWork(2, () -> {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.ARMOR, (int) Double.POSITIVE_INFINITY, 3, false, false));
					});
				}
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(ForgottenFairyTalesModMobEffects.ARMOR);
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:leather_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack36 = new ItemStack(Items.LEATHER_HELMET).copy();
						_setstack36.setCount(1);
						_menu.getSlots().get(0).set(_setstack36);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:chainmail_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack41 = new ItemStack(Items.CHAINMAIL_HELMET).copy();
						_setstack41.setCount(1);
						_menu.getSlots().get(0).set(_setstack41);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:iron_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack46 = new ItemStack(Items.IRON_HELMET).copy();
						_setstack46.setCount(1);
						_menu.getSlots().get(0).set(_setstack46);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:golden_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack51 = new ItemStack(Items.GOLDEN_HELMET).copy();
						_setstack51.setCount(1);
						_menu.getSlots().get(0).set(_setstack51);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:diamond_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack56 = new ItemStack(Items.DIAMOND_HELMET).copy();
						_setstack56.setCount(1);
						_menu.getSlots().get(0).set(_setstack56);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getStringOr("helm", ""))
						.equals("minecraft:netherite_helmet")) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack61 = new ItemStack(Items.NETHERITE_HELMET).copy();
						_setstack61.setCount(1);
						_menu.getSlots().get(0).set(_setstack61);
						_player.containerMenu.broadcastChanges();
					}
					{
						final String _tagName = "helm";
						final String _tagValue = "none";
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu64 ? _menu64.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
						ItemStack _setstack66 = new ItemStack(Blocks.AIR).copy();
						_setstack66.setCount(1);
						_menu.getSlots().get(0).set(_setstack66);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}