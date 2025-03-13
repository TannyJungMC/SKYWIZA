package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

public class SpawnerLoopSecondProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @e[tag=SKYWIZA-spawner_main] at @s run SKYWIZA dev spawner loop_second");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @e[tag=SKYWIZA-spawner_mob] at @s run SKYWIZA dev spawner mob_loop_second");
		if (SkywizaModVariables.MapVariables.get(world).spawner_show_name == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_main,tag=!SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_time,tag=!SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_main] at @s run data merge entity @s {CustomNameVisible:0b}");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_time] at @s run data merge entity @s {CustomNameVisible:0b}");
		}
		if (SkywizaModVariables.MapVariables.get(world).spawner_mob_show_name == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_mob,tag=!SKYWIZA-npc] at @s unless data entity @s data merge entity @s {CustomNameVisible:1b}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner_mob,tag=!SKYWIZA-npc] at @s run data merge entity @s {CustomNameVisible:0b}");
		}
		if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner,tag=!SKYWIZA-spawner_mob,tag=SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-spawner,tag=!SKYWIZA-spawner_mob,tag=SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:0b}");
		}
	}
}
