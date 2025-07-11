/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.world.inventory.QuestPaperGUIMenu;
import tannyjung.skywiza.world.inventory.NpcGUIMenu;
import tannyjung.skywiza.world.inventory.NpcGUI2Menu;
import tannyjung.skywiza.world.inventory.CoinPouchGUIMenu;
import tannyjung.skywiza.network.MenuStateUpdateMessage;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class SkywizaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SkywizaMod.MODID);
	public static final RegistryObject<MenuType<QuestPaperGUIMenu>> QUEST_PAPER_GUI = REGISTRY.register("quest_paper_gui", () -> IForgeMenuType.create(QuestPaperGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUIMenu>> NPC_GUI = REGISTRY.register("npc_gui", () -> IForgeMenuType.create(NpcGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUI2Menu>> NPC_GUI_2 = REGISTRY.register("npc_gui_2", () -> IForgeMenuType.create(NpcGUI2Menu::new));
	public static final RegistryObject<MenuType<CoinPouchGUIMenu>> COIN_POUCH_GUI = REGISTRY.register("coin_pouch_gui", () -> IForgeMenuType.create(CoinPouchGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				SkywizaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof SkywizaModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				SkywizaMod.PACKET_HANDLER.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}