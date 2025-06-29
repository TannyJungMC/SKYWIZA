
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.world.inventory.QuestPaperGUIMenu;
import tannyjung.skywiza.world.inventory.NpcGUIMenu;
import tannyjung.skywiza.world.inventory.NpcGUI2Menu;
import tannyjung.skywiza.world.inventory.CoinPouchGUIMenu;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import javax.annotation.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkywizaModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SkywizaMod.MODID);
	public static final RegistryObject<MenuType<QuestPaperGUIMenu>> QUEST_PAPER_GUI = REGISTRY.register("quest_paper_gui", () -> IForgeMenuType.create(QuestPaperGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUIMenu>> NPC_GUI = REGISTRY.register("npc_gui", () -> IForgeMenuType.create(NpcGUIMenu::new));
	public static final RegistryObject<MenuType<NpcGUI2Menu>> NPC_GUI_2 = REGISTRY.register("npc_gui_2", () -> IForgeMenuType.create(NpcGUI2Menu::new));
	public static final RegistryObject<MenuType<CoinPouchGUIMenu>> COIN_POUCH_GUI = REGISTRY.register("coin_pouch_gui", () -> IForgeMenuType.create(CoinPouchGUIMenu::new));

	public static void setText(String boxname, String value, @Nullable ServerPlayer player) {
		if (player != null) {
			SkywizaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new GuiSyncMessage(boxname, value));
		} else {
			SkywizaMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new GuiSyncMessage(boxname, value));
		}
	}

	public static class GuiSyncMessage {
		private final String textboxid;
		private final String data;

		public GuiSyncMessage(FriendlyByteBuf buffer) {
			this.textboxid = buffer.readComponent().getString();
			this.data = buffer.readComponent().getString();
		}

		public GuiSyncMessage(String textboxid, String data) {
			this.textboxid = textboxid;
			this.data = data;
		}

		public static void buffer(GuiSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeComponent(Component.literal(message.textboxid));
			buffer.writeComponent(Component.literal(message.data));
		}

		public static void handleData(GuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					SkywizaModScreens.handleTextBoxMessage(message);
				}
			});
			context.setPacketHandled(true);
		}

		String editbox() {
			return this.textboxid;
		}

		String value() {
			return this.data;
		}
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SkywizaMod.addNetworkMessage(GuiSyncMessage.class, GuiSyncMessage::buffer, GuiSyncMessage::new, GuiSyncMessage::handleData);
	}
}
