/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.client.model.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class ForgottenFairyTalesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcolomnnew.LAYER_LOCATION, Modelcolomnnew::createBodyLayer);
		event.registerLayerDefinition(Modelbeam.LAYER_LOCATION, Modelbeam::createBodyLayer);
		event.registerLayerDefinition(Modelbarrelik.LAYER_LOCATION, Modelbarrelik::createBodyLayer);
		event.registerLayerDefinition(ModelSwerh.LAYER_LOCATION, ModelSwerh::createBodyLayer);
		event.registerLayerDefinition(ModelBunchOfArrowsR.LAYER_LOCATION, ModelBunchOfArrowsR::createBodyLayer);
		event.registerLayerDefinition(Modelshotgunnew.LAYER_LOCATION, Modelshotgunnew::createBodyLayer);
		event.registerLayerDefinition(Modelmaska_Converted.LAYER_LOCATION, Modelmaska_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelgagarinshammer.LAYER_LOCATION, Modelgagarinshammer::createBodyLayer);
		event.registerLayerDefinition(Modelshotgun.LAYER_LOCATION, Modelshotgun::createBodyLayer);
		event.registerLayerDefinition(Modelzgutik.LAYER_LOCATION, Modelzgutik::createBodyLayer);
		event.registerLayerDefinition(ModelMimicHat.LAYER_LOCATION, ModelMimicHat::createBodyLayer);
		event.registerLayerDefinition(Modelbullet.LAYER_LOCATION, Modelbullet::createBodyLayer);
		event.registerLayerDefinition(ModelFlagellantsChestplate.LAYER_LOCATION, ModelFlagellantsChestplate::createBodyLayer);
		event.registerLayerDefinition(Modelcolomn.LAYER_LOCATION, Modelcolomn::createBodyLayer);
		event.registerLayerDefinition(Modelmaska.LAYER_LOCATION, Modelmaska::createBodyLayer);
		event.registerLayerDefinition(ModelBFS.LAYER_LOCATION, ModelBFS::createBodyLayer);
		event.registerLayerDefinition(Modelpomoshnick.LAYER_LOCATION, Modelpomoshnick::createBodyLayer);
		event.registerLayerDefinition(Modelhat.LAYER_LOCATION, Modelhat::createBodyLayer);
		event.registerLayerDefinition(Modelstrausingo.LAYER_LOCATION, Modelstrausingo::createBodyLayer);
	}
}