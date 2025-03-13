package net.mcreator.skywiza.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class TestingCommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean place_front = false;
		boolean place_left = false;
		boolean place_right = false;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tag @s add set");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute positioned " + ("^ ^ ^" + entity.getPersistentData().getDouble("frequency") * 2) + " if entity @e[name=test,tag=set,distance=..0.5] run data merge entity @s {ForgeData:{distance:"
								+ entity.getPersistentData().getDouble("distance_max") + "}}"));
			}
		}
		if (entity.getPersistentData().getDouble("distance") < entity.getPersistentData().getDouble("distance_max")) {
			if (entity.getPersistentData().getDouble("road_branch_chance") > Math.random()
					&& entity.getPersistentData().getDouble("distance") / entity.getPersistentData().getDouble("grid") - Math.floor(entity.getPersistentData().getDouble("distance") / entity.getPersistentData().getDouble("grid")) == 0
					&& entity.getPersistentData().getDouble("distance") > 1) {
				entity.getPersistentData().putDouble("distance", 1);
				if (entity.getPersistentData().getDouble("road_sub_chance") > Math.random()) {
					place_front = true;
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						place_left = true;
					} else {
						place_right = true;
					}
				} else if (entity.getPersistentData().getDouble("road_three_chance") > Math.random()) {
					place_left = true;
					place_right = true;
				} else if (entity.getPersistentData().getDouble("road_turn_chance") > Math.random()) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						place_left = true;
					} else {
						place_right = true;
					}
				} else {
					place_front = true;
					place_left = true;
					place_right = true;
				}
			} else {
				entity.getPersistentData().putDouble("distance", (entity.getPersistentData().getDouble("distance") + 1));
				place_front = true;
				CityGeneratorBuildingProcedure.execute(entity);
			}
			if (true) {
				if (place_front == true) {
					if (true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^ ^ ^" + entity.getPersistentData().getDouble("frequency"))
												+ " unless entity @e[name=test,distance=..0.5] run summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"test\"}',Rotation:[" + (entity.getYRot() + 0) + "f]}"));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^ ^ ^" + entity.getPersistentData().getDouble("frequency")) + " run data modify entity @e[name=test,tag=!set,distance=..0.5,limit=1] ForgeData set from entity @s ForgeData"));
							}
						}
					}
				}
				if (place_left == true) {
					if (true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^" + entity.getPersistentData().getDouble("frequency") + " ^ ^")
												+ " unless entity @e[name=test,distance=..0.5] run summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"test\"}',Rotation:[" + (entity.getYRot() + -90) + "f]}"));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " run data modify entity @e[name=test,tag=!set,distance=..0.5,limit=1] ForgeData set from entity @s ForgeData"));
							}
						}
					}
				}
				if (place_right == true) {
					if (true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^-" + entity.getPersistentData().getDouble("frequency") + " ^ ^")
												+ " unless entity @e[name=test,distance=..0.5] run summon armor_stand ~ ~ ~ {NoGravity:1b,Invisible:1b,Marker:1b,CustomName:'{\"text\":\"test\"}',Rotation:[" + (entity.getYRot() + 90) + "f]}"));
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("execute positioned " + ("^-" + entity.getPersistentData().getDouble("frequency") + " ^ ^") + " run data modify entity @e[name=test,tag=!set,distance=..0.5,limit=1] ForgeData set from entity @s ForgeData"));
							}
						}
					}
				}
			}
			if (place_front == true && (place_left == true && place_right == false || place_left == false && place_right == true)) {
				if (place_left == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_sub1")));
						}
					}
				} else if (place_right == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_sub2")));
						}
					}
				}
			} else if (place_front == false && place_left == true && place_right == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_three")));
					}
				}
			} else if (place_front == false && (place_left == true && place_right == false || place_left == false && place_right == true)) {
				if (place_left == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_turn1")));
						}
					}
				} else if (place_right == true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_turn2")));
						}
					}
				}
			} else if (place_front == true && place_left == true && place_right == true) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_cross")));
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road")));
					}
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (entity.getPersistentData().getString("road_end")));
				}
			}
		}
	}
}
