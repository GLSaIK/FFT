
package net.saik.forgottenfairytales.procedures;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;


/**
 * Декоративный слой, отображающий предмет
 * из PLAYER_VARIABLES.backToolItem на спине игрока.
 */
public class ScabbardRendererProcedure
        extends RenderLayer<PlayerRenderState, PlayerModel> {


    public ScabbardRendererProcedure(
            RenderLayerParent<PlayerRenderState, PlayerModel> parent) {

        super(parent);
    }


    @Override
    public void render(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            PlayerRenderState renderState,
            float yRot,
            float xRot) {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.level == null) {
            return;
        }


        /*
         * renderState.id — это ID сущности,
         * а не UUID.
         *
         * Поэтому получаем сущность через getEntity().
         */
        if (!(minecraft.level.getEntity(renderState.id)
                instanceof Player player)) {

            return;
        }


        /*
         * Получаем предмет из переменной игрока.
         */
		ItemStack stack = player.getData(
		        ForgottenFairyTalesModVariables.PLAYER_VARIABLES
		).scabbardItem;
		
		if (stack == null || stack.isEmpty()) {
		    return;
		}
		
		if (!stack.is(ItemTags.create(ResourceLocation.parse("minecraft:allswords")))) {
		    return;
		}


        poseStack.pushPose();


        /*
         * ---------------------------------------------------------
         * ПОЗИЦИЯ ПРЕДМЕТА
         * ---------------------------------------------------------
         */

        poseStack.translate(
                0.25D,
                0.8D,
                -0.15D
        );

        poseStack.mulPose(
                Axis.XP.rotationDegrees(60.0F)
        );

        poseStack.mulPose(
                Axis.YP.rotationDegrees(0.0F)
        );
        poseStack.mulPose(
    			Axis.ZP.rotationDegrees(0.0F)
		);


        /*
         * ---------------------------------------------------------
         * РАЗМЕР
         * ---------------------------------------------------------
         */

        poseStack.scale(
                1.0F,
                1.0F,
                1.0F
        );


        /*
         * ---------------------------------------------------------
         * ПОЛУЧАЕМ МОДЕЛЬ ITEMSTACK
         * ---------------------------------------------------------
         *
         * ItemModelResolver сам определяет модель
         * конкретного предмета.
         */
		ItemStackRenderState itemRenderState = new ItemStackRenderState();
		
		minecraft.getItemModelResolver().updateForLiving(
		        itemRenderState,
		        stack,
		        ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
		        player
		);


        /*
         * ---------------------------------------------------------
         * РЕНДЕР
         * ---------------------------------------------------------
         */
		
		itemRenderState.render(
		        poseStack,
		        bufferSource,
		        packedLight,
		        0
		);


        poseStack.popPose();
    }
}