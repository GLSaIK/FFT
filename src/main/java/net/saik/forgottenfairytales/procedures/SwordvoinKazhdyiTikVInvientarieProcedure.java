package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class SwordvoinKazhdyiTikVInvientarieProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (entity instanceof LivingEntity _entity) {
				AttributeModifier modifier = new AttributeModifier(ResourceLocation.parse("forgotten_fairy_tales:bigsword"), 2.5, AttributeModifier.Operation.ADD_VALUE);
				if (!_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).hasModifier(modifier.id())) {
					_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).addPermanentModifier(modifier);
				}
			}
		} else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem())) {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(ResourceLocation.parse("forgotten_fairy_tales:bigsword"));
			}
		}
	}
}