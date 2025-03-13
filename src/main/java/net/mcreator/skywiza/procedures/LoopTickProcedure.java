package net.mcreator.skywiza.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.skywiza.network.SkywizaModVariables;
import net.mcreator.skywiza.SkywizaMod;

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
				if (!("").equals("Spawner")) {
					SpawnerLoopSecondProcedure.execute(world, x, y, z);
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
		if (true) {
			if (!("").equals("WorldGen")) {
				if (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute at @p as @e[name=SKYWIZA-world_gen,tag=!SKYWIZA-world_gen_set,limit=1,sort=nearest] at @s " + "if loaded ~16 ~ ~16 if loaded ~16 ~ ~-16 if loaded ~-16 ~ ~16 if loaded ~-16 ~ ~-16"
										+ " run SKYWIZA dev world_gen loop_tick"));
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute at @p as @e[name=SKYWIZA-world_gen,tag=!SKYWIZA-world_gen_set,limit=1,sort=nearest] at @s run SKYWIZA dev world_gen loop_tick");
				}
			}
		}
	}
}
