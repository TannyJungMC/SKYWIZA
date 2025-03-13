package net.mcreator.skywiza.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class CityGeneratorBuildingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("building_chance") > Math.random()) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^" + entity.getPersistentData().getDouble("frequency") + " ^ ^")
									+ " unless entity @e[name=SKYWIZA-city,distance=..0.5] run summon armor_stand ~ ~ ~ {Tags:[\"SKYWIZA-city_building\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"SKYWIZA-city\"}',Rotation:["
									+ (entity.getYRot() + -90) + "f]}"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " as @e[tag=SKYWIZA-city_building,tag=!SKYWIZA-city_placed,distance=..0.5] at @s run "
									+ entity.getPersistentData().getString("building")));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " run tag @e[tag=SKYWIZA-city_building,tag=!SKYWIZA-city_placed,distance=..0.5] add SKYWIZA-city_placed"));
				}
			}
		}
		if (entity.getPersistentData().getDouble("building_chance") > Math.random()) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^-" + entity.getPersistentData().getDouble("frequency") + " ^ ^")
									+ " unless entity @e[name=SKYWIZA-city,distance=..0.5] run summon armor_stand ~ ~ ~ {Tags:[\"SKYWIZA-city_building\"],NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"SKYWIZA-city\"}',Rotation:["
									+ (entity.getYRot() + 90) + "f]}"));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^-" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " as @e[tag=SKYWIZA-city_building,tag=!SKYWIZA-city_placed,distance=..0.5] at @s run "
									+ entity.getPersistentData().getString("building")));
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							("execute positioned " + ("^-" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " run tag @e[tag=SKYWIZA-city_building,tag=!SKYWIZA-city_placed,distance=..0.5] add SKYWIZA-city_placed"));
				}
			}
		}
	}
}
