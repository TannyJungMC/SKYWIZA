
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skywiza.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.skywiza.world.inventory.QuestPaperGUIMenu;
import net.mcreator.skywiza.world.inventory.NpcGUIMenu;
import net.mcreator.skywiza.world.inventory.NpcGUI2Menu;
import net.mcreator.skywiza.world.inventory.CoinPouchGUIMenu;
import net.mcreator.skywiza.SkywizaMod;

public class SkywizaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SkywizaMod.MODID);
	public static final RegistryObject<MenuType<QuestPaperGUIMenu>> QUEST_PAPER_GUI = REGISTRY.register("quest_paper_gui", () -> IForgeMenuType.create(QuestPaperGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUIMenu>> NPC_GUI = REGISTRY.register("npc_gui", () -> IForgeMenuType.create(NpcGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUI2Menu>> NPC_GUI_2 = REGISTRY.register("npc_gui_2", () -> IForgeMenuType.create(NpcGUI2Menu::new));
	public static final RegistryObject<MenuType<CoinPouchGUIMenu>> COIN_POUCH_GUI = REGISTRY.register("coin_pouch_gui", () -> IForgeMenuType.create(CoinPouchGUIMenu::new));
}
