package net.mcreator.skywiza.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.skywiza.SkywizaMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkywizaModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SkywizaMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					SkywizaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					SkywizaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					SkywizaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "skywiza_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				SkywizaMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "skywiza_mapvars";
		public boolean debug_village = false;
		public boolean long_time = false;
		public double long_time_custom = 0;
		public double long_time_offset = 0;
		public double loop_second = 0;
		public boolean loot_chest = false;
		public boolean loot_chest_show_name = false;
		public String quest_board_time_stamp = "";
		public boolean spawner = false;
		public boolean spawner_mob_show_name = false;
		public boolean spawner_respawn_force = false;
		public boolean spawner_show_name = false;
		public double loop_minute = 0;
		public boolean loot_chest_refill_force = false;
		public boolean pathway_gen = false;
		public double txt_structure_manager_tick = 0;
		public double txt_structure_posX = 0;
		public double txt_structure_posY = 0;
		public double txt_structure_posZ = 0;
		public double txt_structure_pos2X = 0;
		public double txt_structure_pos2Y = 0;
		public double txt_structure_pos2Z = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			debug_village = nbt.getBoolean("debug_village");
			long_time = nbt.getBoolean("long_time");
			long_time_custom = nbt.getDouble("long_time_custom");
			long_time_offset = nbt.getDouble("long_time_offset");
			loop_second = nbt.getDouble("loop_second");
			loot_chest = nbt.getBoolean("loot_chest");
			loot_chest_show_name = nbt.getBoolean("loot_chest_show_name");
			quest_board_time_stamp = nbt.getString("quest_board_time_stamp");
			spawner = nbt.getBoolean("spawner");
			spawner_mob_show_name = nbt.getBoolean("spawner_mob_show_name");
			spawner_respawn_force = nbt.getBoolean("spawner_respawn_force");
			spawner_show_name = nbt.getBoolean("spawner_show_name");
			loop_minute = nbt.getDouble("loop_minute");
			loot_chest_refill_force = nbt.getBoolean("loot_chest_refill_force");
			pathway_gen = nbt.getBoolean("pathway_gen");
			txt_structure_manager_tick = nbt.getDouble("txt_structure_manager_tick");
			txt_structure_posX = nbt.getDouble("txt_structure_posX");
			txt_structure_posY = nbt.getDouble("txt_structure_posY");
			txt_structure_posZ = nbt.getDouble("txt_structure_posZ");
			txt_structure_pos2X = nbt.getDouble("txt_structure_pos2X");
			txt_structure_pos2Y = nbt.getDouble("txt_structure_pos2Y");
			txt_structure_pos2Z = nbt.getDouble("txt_structure_pos2Z");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("debug_village", debug_village);
			nbt.putBoolean("long_time", long_time);
			nbt.putDouble("long_time_custom", long_time_custom);
			nbt.putDouble("long_time_offset", long_time_offset);
			nbt.putDouble("loop_second", loop_second);
			nbt.putBoolean("loot_chest", loot_chest);
			nbt.putBoolean("loot_chest_show_name", loot_chest_show_name);
			nbt.putString("quest_board_time_stamp", quest_board_time_stamp);
			nbt.putBoolean("spawner", spawner);
			nbt.putBoolean("spawner_mob_show_name", spawner_mob_show_name);
			nbt.putBoolean("spawner_respawn_force", spawner_respawn_force);
			nbt.putBoolean("spawner_show_name", spawner_show_name);
			nbt.putDouble("loop_minute", loop_minute);
			nbt.putBoolean("loot_chest_refill_force", loot_chest_refill_force);
			nbt.putBoolean("pathway_gen", pathway_gen);
			nbt.putDouble("txt_structure_manager_tick", txt_structure_manager_tick);
			nbt.putDouble("txt_structure_posX", txt_structure_posX);
			nbt.putDouble("txt_structure_posY", txt_structure_posY);
			nbt.putDouble("txt_structure_posZ", txt_structure_posZ);
			nbt.putDouble("txt_structure_pos2X", txt_structure_pos2X);
			nbt.putDouble("txt_structure_pos2Y", txt_structure_pos2Y);
			nbt.putDouble("txt_structure_pos2Z", txt_structure_pos2Z);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				SkywizaMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
