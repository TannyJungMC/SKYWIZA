
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.init.SkywizaModMenus.GuiSyncMessage;
import tannyjung.skywiza.client.gui.QuestPaperGUIScreen;
import tannyjung.skywiza.client.gui.NpcGUIScreen;
import tannyjung.skywiza.client.gui.NpcGUI2Screen;
import tannyjung.skywiza.client.gui.CoinPouchGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

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

	static void handleTextBoxMessage(GuiSyncMessage message) {
		String editbox = message.editbox();
		String value = message.value();
		Screen currentScreen = Minecraft.getInstance().screen;
		if (currentScreen instanceof WidgetScreen sc) {
			HashMap<String, Object> widgets = sc.getWidgets();
			Object obj = widgets.get("text:" + editbox);
			if (obj instanceof EditBox box) {
				box.setValue(value);
			}
		}
	}

	public interface WidgetScreen {
		HashMap<String, Object> getWidgets();
	}
}
