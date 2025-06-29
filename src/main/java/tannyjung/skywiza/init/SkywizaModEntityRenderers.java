
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.client.renderer.NpcRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SkywizaModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SkywizaModEntities.NPC.get(), NpcRenderer::new);
	}
}
