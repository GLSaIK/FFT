package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

public class ReloadPriNazhatiiKlavishiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double itemn = 0;
		double loops = 0;
		double needammotoreload = 0;
		double avaible = 0;
		double ToLoad = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.KATANA.get()) {
			if ((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev")) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) != true) {
					{
						final String _tagName = "KT1";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.NOZNI.get()) {
						{
							final String _tagName = "KT1";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) == true) {
					{
						final String _tagName = "KT1";
						final boolean _tagValue = false;
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.NOZNI.get()) {
						{
							final String _tagName = "KT1";
							final boolean _tagValue = false;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
						}
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.GAGARINHAMMER.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("loaded", false) == false
					&& (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get())) || getEntityGameType(entity) == GameType.CREATIVE || entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch > 0)) {
				if (Mth.nextInt(RandomSource.create(), 1, 8) == 8) {
					{
						final int _animState = 1;
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
							tag.putInt("oldAnimState", 10000);
							tag.putInt("animState", _animState);
						});
					}
					ForgottenFairyTalesMod.queueServerWork(18, () -> {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.GAGARINHAMMER.get()) {
							{
								final String _tagName = "loaded";
								final boolean _tagValue = true;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
							}
							if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
								if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch > 0) {
									if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get()))) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									} else {
										{
											ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
											_vars.needammo = 1;
											_vars.markSyncDirty();
										}
									}
								} else {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
							}
						}
						{
							final int _animState = -1 - 1;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
								tag.putInt("oldAnimState", 10000);
								tag.putInt("animState", _animState);
							});
						}
					});
				} else {
					{
						final int _animState = 0;
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
							tag.putInt("oldAnimState", 10000);
							tag.putInt("animState", _animState);
						});
					}
					ForgottenFairyTalesMod.queueServerWork(16, () -> {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.GAGARINHAMMER.get()) {
							{
								final String _tagName = "loaded";
								final boolean _tagValue = true;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
							}
							if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
								if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch > 0) {
									if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get()))) {
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
									} else {
										{
											ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
											_vars.needammo = 1;
											_vars.markSyncDirty();
										}
									}
								} else {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								}
							}
						}
						{
							final int _animState = -1 - 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
								tag.putInt("oldAnimState", 10000);
								tag.putInt("animState", _animState);
							});
						}
					});
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.COFFE.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack55 = new ItemStack(ForgottenFairyTalesModItems.CACAO.get()).copy();
				_setstack55.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack55);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.CACAO.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack58 = new ItemStack(ForgottenFairyTalesModItems.COFFE.get()).copy();
				_setstack58.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack58);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		loops = 0;
		itemn = 0;
		for (int index0 = 0; index0 < 36; index0++) {
			if (ForgottenFairyTalesModItems.BULLETSHOTGUN.get() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler59 ? _modHandler59.getStackInSlot((int) loops).copy() : ItemStack.EMPTY)
					.getItem()) {
				itemn = itemn + (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler61 ? _modHandler61.getStackInSlot((int) loops).copy() : ItemStack.EMPTY).getCount();
			}
			loops = loops + 1;
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.SHOTGUN.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == false) {
				needammotoreload = 2 - (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("ammo", 0);
				avaible = itemn + entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch;
				if (needammotoreload <= avaible) {
					ToLoad = needammotoreload;
				} else {
					ToLoad = avaible;
				}
				if (getEntityGameType(entity) == GameType.CREATIVE || ToLoad > 0) {
					{
						final String _tagName = "reloading";
						final boolean _tagValue = true;
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
					}
					if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
						if (itemn <= ToLoad) {
							{
								final String _tagName = "invammo";
								final double _tagValue = itemn;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "pouchammo";
								final double _tagValue = (ToLoad - itemn);
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
						} else {
							{
								final String _tagName = "invammo";
								final double _tagValue = ToLoad;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "pouchammo";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
					} else if (getEntityGameType(entity) == GameType.CREATIVE) {
						ToLoad = 2 - (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("ammo", 0);
					}
					if (ToLoad == 2) {
						{
							final int _animState = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
								tag.putInt("oldAnimState", 10000);
								tag.putInt("animState", _animState);
							});
						}
						ForgottenFairyTalesMod.queueServerWork(18, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
							ForgottenFairyTalesMod.queueServerWork(10, () -> {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								}
								ForgottenFairyTalesMod.queueServerWork(18, () -> {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
										{
											final String _tagName = "ammo";
											final double _tagValue = 2;
											CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(),
													(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("invammo", 0)),
													_player.inventoryMenu.getCraftSlots());
										}
										{
											ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
											_vars.needammo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("pouchammo", 0);
											_vars.markSyncDirty();
										}
										{
											final String _tagName = "invammo";
											final double _tagValue = 0;
											CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
										}
										{
											final String _tagName = "pouchammo";
											final double _tagValue = 0;
											CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
										}
									}
									{
										final String _tagName = "reloading";
										final boolean _tagValue = false;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
									}
									{
										final int _animState = -1 - 0;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
											tag.putInt("oldAnimState", 10000);
											tag.putInt("animState", _animState);
										});
									}
								});
							});
						});
					} else if (ToLoad == 1) {
						{
							final int _animState = 1;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
								tag.putInt("oldAnimState", 10000);
								tag.putInt("animState", _animState);
							});
						}
						ForgottenFairyTalesMod.queueServerWork(19, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
							ForgottenFairyTalesMod.queueServerWork(17, () -> {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
									{
										final String _tagName = "ammo";
										final double _tagValue = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("ammo", 0) + 1);
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(),
												(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("invammo", 0)),
												_player.inventoryMenu.getCraftSlots());
									}
									{
										ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
										_vars.needammo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("pouchammo", 0);
										_vars.markSyncDirty();
									}
									{
										final String _tagName = "invammo";
										final double _tagValue = 0;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
									{
										final String _tagName = "pouchammo";
										final double _tagValue = 0;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
								}
								{
									final String _tagName = "reloading";
									final boolean _tagValue = false;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
								}
								{
									final int _animState = -1 - 1;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
										tag.putInt("oldAnimState", 10000);
										tag.putInt("animState", _animState);
									});
								}
							});
						});
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.BFS.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == false) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("ammo", 0) == 0) {
					avaible = itemn + entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch;
					if (getEntityGameType(entity) == GameType.CREATIVE || avaible >= 4) {
						if (!(getEntityGameType(entity) == GameType.CREATIVE)) {
							if (itemn < 4) {
								{
									final String _tagName = "invammo";
									final double _tagValue = itemn;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
								{
									final String _tagName = "pouchammo";
									final double _tagValue = (4 - itemn);
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
							} else {
								{
									final String _tagName = "invammo";
									final double _tagValue = 4;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
								{
									final String _tagName = "pouchammo";
									final double _tagValue = 0;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
							}
						}
						{
							final int _animState = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
								tag.putInt("oldAnimState", 10000);
								tag.putInt("animState", _animState);
							});
						}
						{
							final String _tagName = "reloading";
							final boolean _tagValue = true;
							CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
						}
						ForgottenFairyTalesMod.queueServerWork(20, () -> {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
							ForgottenFairyTalesMod.queueServerWork(7, () -> {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
								}
								ForgottenFairyTalesMod.queueServerWork(6, () -> {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
									ForgottenFairyTalesMod.queueServerWork(6, () -> {
										if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("forgotten_fairy_tales:load")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
										}
										ForgottenFairyTalesMod.queueServerWork(4, () -> {
											if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("reloading", false) == true) {
												{
													final String _tagName = "ammo";
													final double _tagValue = 1;
													CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
												}
												if (entity instanceof Player _player) {
													ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
													_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(),
															(int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("invammo", 0)),
															_player.inventoryMenu.getCraftSlots());
												}
												{
													ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
													_vars.needammo = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("pouchammo",
															0);
													_vars.markSyncDirty();
												}
												{
													final String _tagName = "invammo";
													final double _tagValue = 0;
													CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
												}
												{
													final String _tagName = "pouchammo";
													final double _tagValue = 0;
													CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
												}
											}
											{
												final String _tagName = "reloading";
												final boolean _tagValue = false;
												CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
											}
											{
												final int _animState = -1 - 0;
												CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> {
													tag.putInt("oldAnimState", 10000);
													tag.putInt("animState", _animState);
												});
											}
										});
									});
								});
							});
						});
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}