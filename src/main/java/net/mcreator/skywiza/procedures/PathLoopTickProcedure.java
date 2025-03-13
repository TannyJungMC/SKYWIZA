package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PathLoopTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute at @e[name=SKYWIZA-path] unless entity @e[name=SKYWIZA-path_point,distance=..100] run summon armor_stand ~ ~ ~ {NoGravity:1b,CustomName:'{\"text\":\"SKYWIZA-path_point\"}'}");
		}
		if (true) {
			if (true) {
				if (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=SKYWIZA-path] "
										+ (("at @s positioned ~ ~1 ~1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " " + ("at @s positioned ~ ~-1 ~1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " "
												+ ("at @s positioned ~ ~ ~1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]"))
										+ " run summon armor_stand ~ ~ ~ {NoGravity:1b,CustomName:'{\"text\":\"SKYWIZA-path_scan\"}',Rotation:[" + "0" + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=SKYWIZA-path] at @s "
										+ (("at @s positioned ~ ~1 ~-1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " " + ("at @s positioned ~ ~-1 ~-1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " "
												+ ("at @s positioned ~ ~ ~-1" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]"))
										+ " run summon armor_stand ~ ~ ~ {NoGravity:1b,CustomName:'{\"text\":\"SKYWIZA-path_scan\"}',Rotation:[" + "180" + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=SKYWIZA-path] at @s "
										+ (("at @s positioned ~1 ~1 ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " " + ("at @s positioned ~1 ~-1 ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " "
												+ ("at @s positioned ~1 ~ ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]"))
										+ " run summon armor_stand ~ ~ ~ {NoGravity:1b,CustomName:'{\"text\":\"SKYWIZA-path_scan\"}',Rotation:[" + "270" + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[name=SKYWIZA-path] at @s "
										+ (("at @s positioned ~-1 ~1 ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " " + ("at @s positioned ~-1 ~-1 ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]") + " "
												+ ("at @s positioned ~-1 ~ ~" + " unless entity @e[name=SKYWIZA-path_scan,distance=..0.5]"))
										+ " run summon armor_stand ~ ~ ~ {NoGravity:1b,CustomName:'{\"text\":\"SKYWIZA-path_scan\"}',Rotation:[" + "90" + "f]}"));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s if block ~ ~-1 ~ #skywiza:passable_blocks unless block ~ ~-1 ~ water run tp @s ~ ~-1 ~");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s unless block ~ ~ ~ #skywiza:passable_blocks run tp @s ~ ~1 ~");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s if block ~ ~-1 ~ #skywiza:passable_blocks run kill @s");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s unless block ~ ~ ~ #skywiza:passable_blocks run kill @s");
				if (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s unless block ^ ^2 ^1 #skywiza:passable_blocks run kill @s");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s if block ^ ^-2 ^1 #skywiza:passable_blocks unless block ^ ^-2 ^1 water run kill @s");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s if block ^1 ^-2 ^ #skywiza:passable_blocks unless block ^1 ^-2 ^ water run kill @s");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"execute at @e[name=SKYWIZA-path] as @e[name=SKYWIZA-path_scan,distance=..3] at @s if block ^-1 ^-2 ^ #skywiza:passable_blocks unless block ^-1 ^-2 ^ water run kill @s");
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("execute as @e[name=SKYWIZA-path] at @s run tp @s ~ ~ ~ facing " + (itemstack.getOrCreateTag().getDouble("posX") + " " + itemstack.getOrCreateTag().getDouble("posY") + " " + itemstack.getOrCreateTag().getDouble("posZ"))));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @e[name=SKYWIZA-path] at @s positioned ^ ^ ^50 run tp @s @e[name=SKYWIZA-path_scan,tag=!SKYWIZA-path_scan_select,limit=1,sort=nearest]");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute at @e[name=SKYWIZA-path] run tag @e[name=SKYWIZA-path_scan,tag=!path_scan_select,limit=1,sort=nearest] add SKYWIZA-path_scan_select");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute at @e[name=SKYWIZA-path] run forceload add ~5 ~5 ~-5 ~-5");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"effect give @e[tag=SKYWIZA-path_scan_select] glowing infinite 1 true");
		if (true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute at @e[name=SKYWIZA-path] run fill ^2 ^-1 ^ ^-2 ^-1 ^ cobblestone");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"execute at @e[name=SKYWIZA-path] run fill ^2 ^ ^ ^-2 ^ ^ air");
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute at @e[name=SKYWIZA-path] run kill @e[type=item,distance=..5]");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute as @e[name=SKYWIZA-path_scan] at @s unless entity @e[name=SKYWIZA-path,distance=..100] run kill @s");
	}
}
