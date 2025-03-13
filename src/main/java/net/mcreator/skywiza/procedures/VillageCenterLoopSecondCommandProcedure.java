package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.util.List;
import java.util.Comparator;

public class VillageCenterLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
				}
			}
		} else {
			if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
				if (true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~ ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ (entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~ ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ (entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~") + " "
											+ ("0 0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4) + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~") + " "
											+ ("0 0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4) + " 0 100 force"));
						}
					}
				}
				if (true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~ ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ (entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~ ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ (entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~") + " "
											+ ("0 0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4) + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~") + " "
											+ ("0 0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4) + " 0 100 force"));
						}
					}
				}
				if (true) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~ ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ ("0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~ ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ ("0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~ ~" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ ("0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0") + " 0 100 force"));
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									("particle end_rod " + ("~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5 + " ~ ~-" + entity.getPersistentData().getDouble("village_square_size") * 0.5) + " "
											+ ("0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0") + " 0 100 force"));
						}
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
								("particle totem_of_undying ~ ~ ~ " + ("0 " + entity.getPersistentData().getDouble("village_square_size") * 0.4 + " 0") + " 0 100 force"));
					}
				}
			}
			if (entity.getPersistentData().getDouble("tick") < 1) {
				entity.getPersistentData().putDouble("tick", (entity.getPersistentData().getDouble("tick") + 1));
			} else {
				entity.getPersistentData().putDouble("tick", 1);
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((entity.getPersistentData().getDouble("village_square_size")) / 2d), e -> true).stream()
							.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof ArmorStand) {
							if ((entityiterator.getDisplayName().getString()).equals("SKYWIZA-village_info")) {
								if (!(entityiterator.getPersistentData().getDouble("center_posX") == entity.getX() && entityiterator.getPersistentData().getDouble("center_posY") == entity.getY()
										&& entityiterator.getPersistentData().getDouble("center_posZ") == entity.getZ())) {
									if (true) {
										entityiterator.getPersistentData().putDouble("center_posX", (entity.getX()));
										entityiterator.getPersistentData().putDouble("center_posY", (entity.getY()));
										entityiterator.getPersistentData().putDouble("center_posZ", (entity.getZ()));
									}
									if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tellraw @a [{\"text\":\"SKYWIZA : Added Info for " + "" + entity.getPersistentData().getString("village_name") + "\",\"color\":\"dark_gray\"}]"));
											}
										}
									}
									break;
								} else {
									RealTimeCountdownProcedure.execute(entity);
									{
										Entity _ent = entityiterator;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
															_ent.getDisplayName(), _ent.level().getServer(), _ent),
													("execute if block ~ ~-1 ~ lectern run data merge block ~ ~-1 ~ {Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"-------------------\\\\nInformation\\\\n-------------------\\\\n\\\\n"
															+ ""
															+ (entity.getPersistentData().getString("village_name") + ""
																	+ ("\\\\n\\\\nLocation : " + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("location_count"))).replace(".0", ""))
																	+ ("\\\\nLoot Chest : " + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("loot_chest_count"))).replace(".0", ""))
																	+ ("\\\\nNPC (Alive) : " + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("npc_count"))).replace(".0", ""))
																	+ ("\\\\nNPC (Dead) : "
																			+ (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("npc_count_all") - entity.getPersistentData().getDouble("npc_count"))).replace(".0", ""))
																	+ ("\\\\n\\\\nReset in " + entity.getPersistentData().getString("reset_time_text")))
															+ "\\\\n\\\\n-------------------\"}']}}}"));
										}
									}
									if (true) {
										entity.getPersistentData().putDouble("npc_count", 0);
										entity.getPersistentData().putDouble("npc_count_all", 0);
										entity.getPersistentData().putDouble("location_count", 0);
										entity.getPersistentData().putDouble("spawner_count", 0);
										entity.getPersistentData().putDouble("loot_chest_count", 0);
									}
								}
							}
							if (!(entityiterator.getPersistentData().getString("location_name")).equals("")) {
								entity.getPersistentData().putDouble("location_count", (entity.getPersistentData().getDouble("location_count") + 1));
								if (!(entityiterator.getPersistentData().getDouble("center_posX") == entity.getX() && entityiterator.getPersistentData().getDouble("center_posY") == entity.getY()
										&& entityiterator.getPersistentData().getDouble("center_posZ") == entity.getZ())) {
									if (true) {
										entityiterator.getPersistentData().putDouble("center_posX", (entity.getX()));
										entityiterator.getPersistentData().putDouble("center_posY", (entity.getY()));
										entityiterator.getPersistentData().putDouble("center_posZ", (entity.getZ()));
									}
									if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tellraw @a [{\"text\":\"SKYWIZA : Added " + "" + entityiterator.getPersistentData().getString("location_name") + " to " + entity.getPersistentData().getString("village_name")
																+ "\",\"color\":\"dark_gray\"}]"));
											}
										}
									}
									break;
								}
							}
							if (entityiterator.getPersistentData().getBoolean("is_spawner") == true) {
								entity.getPersistentData().putDouble("spawner_count", (entity.getPersistentData().getDouble("spawner_count") + 1));
								if (!(entityiterator.getPersistentData().getDouble("center_posX") == entity.getX() && entityiterator.getPersistentData().getDouble("center_posY") == entity.getY()
										&& entityiterator.getPersistentData().getDouble("center_posZ") == entity.getZ())) {
									if (true) {
										entityiterator.getPersistentData().putDouble("center_posX", (entity.getX()));
										entityiterator.getPersistentData().putDouble("center_posY", (entity.getY()));
										entityiterator.getPersistentData().putDouble("center_posZ", (entity.getZ()));
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"tag @e[tag=SKYWIZA-spawner,distance=..1] add SKYWIZA-village");
										}
									}
									if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tellraw @a [{\"text\":\"SKYWIZA : Added " + "" + entityiterator.getPersistentData().getString("name") + " to " + entity.getPersistentData().getString("village_name")
																+ "\",\"color\":\"dark_gray\"}]"));
											}
										}
									}
									break;
								}
							}
							if (entityiterator.getPersistentData().getBoolean("is_loot_chest") == true) {
								entity.getPersistentData().putDouble("loot_chest_count", (entity.getPersistentData().getDouble("loot_chest_count") + 1));
								if (!(entityiterator.getPersistentData().getDouble("center_posX") == entity.getX() && entityiterator.getPersistentData().getDouble("center_posY") == entity.getY()
										&& entityiterator.getPersistentData().getDouble("center_posZ") == entity.getZ())) {
									if (true) {
										entityiterator.getPersistentData().putDouble("center_posX", (entity.getX()));
										entityiterator.getPersistentData().putDouble("center_posY", (entity.getY()));
										entityiterator.getPersistentData().putDouble("center_posZ", (entity.getZ()));
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"tag @e[tag=SKYWIZA-loot_chest,distance=..1] add SKYWIZA-village");
										}
									}
									if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tellraw @a [{\"text\":\"SKYWIZA : Added " + "" + entityiterator.getPersistentData().getString("name") + " to " + entity.getPersistentData().getString("village_name")
																+ "\",\"color\":\"dark_gray\"}]"));
											}
										}
									}
									break;
								}
							}
							if (entityiterator.getPersistentData().getBoolean("is_npc") == true) {
								entity.getPersistentData().putDouble("npc_count_all", (entityiterator.getPersistentData().getDouble("group_count") + entity.getPersistentData().getDouble("npc_count_all")));
							}
						} else {
							if (entityiterator.getPersistentData().getBoolean("is_npc") == true) {
								entity.getPersistentData().putDouble("npc_count", (entity.getPersistentData().getDouble("npc_count") + 1));
								if (!(entityiterator.getPersistentData().getDouble("center_posX") == entity.getX() && entityiterator.getPersistentData().getDouble("center_posY") == entity.getY()
										&& entityiterator.getPersistentData().getDouble("center_posZ") == entity.getZ())) {
									if (true) {
										entityiterator.getPersistentData().putDouble("center_posX", (entity.getX()));
										entityiterator.getPersistentData().putDouble("center_posY", (entity.getY()));
										entityiterator.getPersistentData().putDouble("center_posZ", (entity.getZ()));
									}
									if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
										{
											Entity _ent = entityiterator;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														("tellraw @a [{\"text\":\"SKYWIZA : \",\"color\":\"dark_gray\"},{\"text\":\"" + "" + entityiterator.getPersistentData().getString("name") + "\",\"color\":\"dark_gray\"},{\"text\":\" joined "
																+ entity.getPersistentData().getString("village_name") + "\",\"color\":\"dark_gray\"}]"));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
