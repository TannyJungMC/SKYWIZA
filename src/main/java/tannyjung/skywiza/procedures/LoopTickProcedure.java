package tannyjung.skywiza.procedures;

import tannyjung.skywiza.network.SkywizaModVariables;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class LoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		SkywizaMod.queueServerWork(1, () -> {
			if ((world.isClientSide() ? Minecraft.getInstance().getConnection().getOnlinePlayers().size() : ServerLifecycleHooks.getCurrentServer().getPlayerCount()) > 0) {
				LoopTickProcedure.execute(world, x, y, z, entity);
			}
		});
		if (SkywizaModVariables.MapVariables.get(world).loop_second < 20) {
			SkywizaModVariables.MapVariables.get(world).loop_second = SkywizaModVariables.MapVariables.get(world).loop_second + 1;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
		} else {
			SkywizaModVariables.MapVariables.get(world).loop_second = 1;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
			if (true) {
				if (!("").equals("Loot Chest")) {
					if (SkywizaModVariables.MapVariables.get(world).loot_chest == true) {
						LootChestLoopSecondProcedure.execute(world, x, y, z);
					}
				}
				if (!("").equals("Long Time")) {
					if (SkywizaModVariables.MapVariables.get(world).long_time == true) {
						LongTimeLoopSecondProcedure.execute(world);
					}
				}
				if (!("").equals("Village")) {
					VillageLoopSecondProcedure.execute(world, x, y, z);
				}
				if (!("").equals("NPC")) {
					NpcLoopSecondProcedure.execute(world, x, y, z, entity);
				}
			}
			if (SkywizaModVariables.MapVariables.get(world).loop_minute < 60) {
				SkywizaModVariables.MapVariables.get(world).loop_minute = SkywizaModVariables.MapVariables.get(world).loop_minute + 1;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
			} else {
				SkywizaModVariables.MapVariables.get(world).loop_minute = 1;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
				if (true) {
					if (!("").equals("NPC")) {
						NpcLoopMinuteProcedure.execute(world, x, y, z);
					}
				}
			}
		}
		if (true) {
			if (!("").equals("NPC")) {
				NpcLoopTickProcedure.execute(world, x, y, z);
			}
		}
	}
}
