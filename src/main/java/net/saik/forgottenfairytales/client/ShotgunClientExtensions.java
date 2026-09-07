package net.saik.forgottenfairytales.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class ShotgunClientExtensions implements IClientItemExtensions {

    @Override
    public HumanoidModel.ArmPose getArmPose(
            LivingEntity entity,
            InteractionHand hand,
            ItemStack stack
    ) {
        return HumanoidModel.ArmPose.CROSSBOW_HOLD;
    }
}