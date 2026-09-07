package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.component.DataComponents;

public class SwordslogicProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("True", false) == false) {
			if (((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev"))
					&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) != true) {
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), 97);
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7d\u041E\u0431\u0435\u043B\u0438\u0441\u043A \u21163"));
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), 3);
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), 3);
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), 3);
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), 3);
				itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), 1);
				{
					final String _tagName = "True";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
		} else {
			if (!((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev"))) {
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS))));
				itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A7d\u041E\u0431\u0435\u043B\u0438\u0441\u043A \u21163"));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE))));
				{
					final String _tagName = "True";
					final boolean _tagValue = false;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) == true) {
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING))));
				EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE))));
				{
					final String _tagName = "True";
					final boolean _tagValue = false;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
			}
		}
		if (((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev"))
				&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) != true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 10, 3, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 10, 3, false, false));
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("forgotten_fairy_tales:katana"), 2, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).addTransientModifier(modifier);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.KATANA_PARTICLE.get()), (x + 4), y, z, 1, 1, 1, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.KATANA_PARTICLE.get()), (x - 4), y, z, 1, 1, 1, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.KATANA_PARTICLE.get()), x, y, (z + 4), 1, 1, 1, 1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.KATANA_PARTICLE.get()), x, y, (z - 4), 1, 1, 1, 1, 0);
		}
		if (!((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev"))) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("KD", 0) < 140) {
				{
					final String _tagName = "KD";
					final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("KD", 0) + 1);
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
		}
	}
}