package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

public class LootChestLoopSecondProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @e[tag=SKYWIZA-loot_chest_main] at @s run SKYWIZA dev loot_chest loop_second");
		if (SkywizaModVariables.MapVariables.get(world).loot_chest_show_name == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest_main,tag=!SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest_time,tag=!SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest_main] at @s run data merge entity @s {CustomNameVisible:0b}");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest_time] at @s run data merge entity @s {CustomNameVisible:0b}");
		}
		if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest,tag=SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:1b}");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute as @e[tag=SKYWIZA-loot_chest,tag=SKYWIZA-village] at @s run data merge entity @s {CustomNameVisible:0b}");
		}
	}
}
