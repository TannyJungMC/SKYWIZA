
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skywiza.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.skywiza.client.gui.QuestPaperGUIScreen;
import net.mcreator.skywiza.client.gui.NpcGUIScreen;
import net.mcreator.skywiza.client.gui.NpcGUI2Screen;
import net.mcreator.skywiza.client.gui.CoinPouchGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SkywizaModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SkywizaModMenus.QUEST_PAPER_GUI.get(), QuestPaperGUIScreen::new);
			MenuScreens.register(SkywizaModMenus.NPC_GUI.get(), NpcGUIScreen::new);
			MenuScreens.register(SkywizaModMenus.NPC_GUI_2.get(), NpcGUI2Screen::new);
			MenuScreens.register(SkywizaModMenus.COIN_POUCH_GUI.get(), CoinPouchGUIScreen::new);
		});
	}
}
