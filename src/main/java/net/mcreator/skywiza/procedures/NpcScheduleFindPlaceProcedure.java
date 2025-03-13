package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.util.List;
import java.util.Comparator;

public class NpcScheduleFindPlaceProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double entity_count = 0;
		double place_random_select = 0;
		Entity center = null;
		Entity location = null;
		if (true) {
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("center_posX")), (entity.getPersistentData().getDouble("center_posY")), (entity.getPersistentData().getDouble("center_posZ")));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator.getPersistentData().getString("village_name")).equals("")) {
						center = entityiterator;
						break;
					}
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"))),
						(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"))),
						(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"))));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getPersistentData().getString("location_name")).equals(entity.getPersistentData().getString("schedule_at"))
							&& (entityiterator.getPersistentData().getString("npc_id")).equals(entity.getPersistentData().getString("npc_id"))) {
						location = entityiterator;
						break;
					}
				}
			}
		}
		if (location == null) {
			if (!(Math.abs(entity.getX() - center.getX()) <= 1.5 && Math.abs(entity.getY() - center.getY()) <= 1.5 && Math.abs(entity.getZ() - center.getZ()) <= 1.5)) {
				if (true) {
					entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"), 0);
					entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"), 0);
					entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"), 0);
				}
				if (true) {
					entity.getPersistentData().putDouble("schedule_at_posX", (center.getX()));
					entity.getPersistentData().putDouble("schedule_at_posY", (center.getY()));
					entity.getPersistentData().putDouble("schedule_at_posZ", (center.getZ()));
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("schedule_at_posX")), (entity.getPersistentData().getDouble("schedule_at_posY")), (entity.getPersistentData().getDouble("schedule_at_posZ")), 1);
					entity.getPersistentData().putString("schedule_text", "Going To Center");
				}
				NpcSchdulePathFixerProcedure.execute(world, entity);
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s slowness 2 100 true");
					}
				}
				if (true) {
					if (true) {
						entity.getPersistentData().putDouble("path_fixer_tick", 0);
						entity.getPersistentData().putString("path_fixer_fixed_save", "");
						entity.getPersistentData().putDouble("path_fixer_save_posX", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posY", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posZ", 0);
					}
					if (true) {
						entity.getPersistentData().putString("schedule_text", (entity.getPersistentData().getString("schedule_text_find")));
						entity_count = 0;
						{
							final Vec3 _center = new Vec3((center.getX()), (center.getY()), (center.getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((center.getPersistentData().getDouble("village_square_size")) / 2d), e -> true).stream()
									.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if ((entityiterator.getPersistentData().getString("location_name")).equals(entity.getPersistentData().getString("schedule_at")) && (entityiterator.getPersistentData().getString("npc_id")).equals("")) {
									entity_count = entity_count + 1;
								}
							}
						}
						if (entity_count > 0) {
							place_random_select = Mth.nextInt(RandomSource.create(), 1, (int) entity_count);
							entity_count = 0;
							{
								final Vec3 _center = new Vec3((center.getX()), (center.getY()), (center.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((center.getPersistentData().getDouble("village_square_size")) / 2d), e -> true).stream()
										.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if ((entityiterator.getPersistentData().getString("location_name")).equals(entity.getPersistentData().getString("schedule_at")) && (entityiterator.getPersistentData().getString("npc_id")).equals("")) {
										entity_count = entity_count + 1;
										if (entity_count == place_random_select) {
											if (true) {
												entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"),
														(entityiterator.getX()));
												entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"),
														(entityiterator.getY()));
												entity.getPersistentData().putDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"),
														(entityiterator.getZ()));
											}
											entityiterator.getPersistentData().putString("npc_id", (entity.getPersistentData().getString("npc_id")));
											if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
												{
													Entity _ent = entity;
													if (!_ent.level().isClientSide() && _ent.getServer() != null) {
														_ent.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																("tellraw @a [{\"text\":\"SKYWIZA : \",\"color\":\"dark_gray\"},{\"text\":\"" + "" + entity.getPersistentData().getString("name") + "\",\"color\":\"dark_gray\"},{\"text\":\" has a new "
																		+ entity.getPersistentData().getString("schedule_at") + "\",\"color\":\"dark_gray\"}]"));
													}
												}
											}
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (!("").equals("Go To XXX")) {
				if (!(Math.abs(entity.getX() - entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"))) <= 1.5
						&& Math.abs(entity.getY() - entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"))) <= 1.5
						&& Math.abs(entity.getZ() - entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"))) <= 1.5)) {
					if (true) {
						entity.getPersistentData().putDouble("schedule_at_posX",
								(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"))));
						entity.getPersistentData().putDouble("schedule_at_posY",
								(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"))));
						entity.getPersistentData().putDouble("schedule_at_posZ",
								(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"))));
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("schedule_at_posX")), (entity.getPersistentData().getDouble("schedule_at_posY")), (entity.getPersistentData().getDouble("schedule_at_posZ")), 1);
						entity.getPersistentData().putString("schedule_text", (entity.getPersistentData().getString("schedule_text_go")));
					}
					NpcSchdulePathFixerProcedure.execute(world, entity);
				} else {
					if (true) {
						entity.getPersistentData().putDouble("path_fixer_tick", 0);
						entity.getPersistentData().putString("path_fixer_fixed_save", "");
						entity.getPersistentData().putDouble("path_fixer_save_posX", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posY", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posZ", 0);
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s slowness 2 100 true");
						}
					}
					entity.getPersistentData().putString("schedule_text", (entity.getPersistentData().getString("schedule_text_work")));
				}
			}
		}
	}
}
