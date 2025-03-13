package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.SkywizaMod;

import java.util.List;
import java.util.Comparator;

public class SpawnerRespawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double loop = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		String command = "";
		String type = "";
		String name = "";
		Entity spawner = null;
		if (true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute as @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id")
								+ "\"}}] at @s run data merge entity @s {HandDropChances:[0f,0f],ArmorDropChances:[0f,0f,0f,0f]}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute as @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}] at @s run tp @s ~ -10000 ~"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("kill @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}]"));
		}
		for (int index0 = 0; index0 < (int) entity.getPersistentData().getDouble("group_count"); index0++) {
			if (true) {
				if (entity.getPersistentData().getBoolean("is_npc") == false) {
					name = "CustomName:'{\"text\":\"" + "" + entity.getPersistentData().getString("name") + "\",\"color\":\"" + entity.getPersistentData().getString("name_color") + "\"}',";
				}
				command = "summon " + entity.getPersistentData().getString("entity_id")
						+ " ~ ~ ~ {Tags:[\"SKYWIZA\",\"SKYWIZA-spawner\",\"SKYWIZA-spawner_mob\"],DeathLootTable:\"minecraft:empty\",PersistenceRequired:1b,Attributes:[{Name:\"minecraft:generic.follow_range\",Base:200d},{Name:\"minecraft:generic.max_health\",Base:"
						+ entity.getPersistentData().getDouble("max_health") + "}" + entity.getPersistentData().getString("attribute_extra") + "]," + name + "ForgeData:{spawner_id:\"" + entity.getPersistentData().getString("spawner_id")
						+ "\",respawn:1b}";
				loop = 1;
				for (int index1 = 0; index1 < 20; index1++) {
					type = "";
					if (true) {
						if (loop == 1) {
							command = command + ",HandItems:[{";
						}
						if (loop == 2) {
							type = "left_hand";
						}
						if (loop == 3) {
							command = command + "},{";
						}
						if (loop == 4) {
							type = "right_hand";
						}
						if (loop == 5) {
							command = command + "}],ArmorItems:[{";
						}
						if (loop == 6) {
							type = "boots";
						}
						if (loop == 7) {
							command = command + "},{";
						}
						if (loop == 8) {
							type = "leggings";
						}
						if (loop == 9) {
							command = command + "},{";
						}
						if (loop == 10) {
							type = "chestplate";
						}
						if (loop == 11) {
							command = command + "},{";
						}
						if (loop == 12) {
							type = "helmet";
						}
						if (loop == 13) {
							command = command + "}],";
						}
						if (loop == 14) {
							break;
						}
					}
					if (!(type).equals("")) {
						command = command + ""
								+ ("id:\"" + "" + entity.getPersistentData().getString((type + "_id")) + "\",Count:1b,tag:{display:{Name:\"{\\\"text\\\":\\\"" + entity.getPersistentData().getString((type + "_name")) + "\\\",\\\"color\\\":\\\""
										+ entity.getPersistentData().getString("name_color")
										+ "\\\"}\",Lore:[\"{\\\"color\\\":\\\"dark_gray\\\",\\\"text\\\":\\\"--------------------\\\"}\",\"{\\\"color\\\":\\\"dark_gray\\\",\\\"text\\\":\\\"Drop From : " + entity.getPersistentData().getString("name")
										+ "\\\"}\",\"{\\\"color\\\":\\\"dark_gray\\\",\\\"text\\\":\\\"Default Selling Price : " + entity.getPersistentData().getString((type + "_price"))
										+ "\\\"}\",\"{\\\"color\\\":\\\"dark_gray\\\",\\\"text\\\":\\\"--------------------\\\"}\"]}}" + entity.getPersistentData().getString((type + "_extra")));
					}
					loop = loop + 1;
				}
				command = command + ""
						+ (("HandDropChances:[" + (entity.getPersistentData().getDouble("left_hand_drop_chance") + "f," + entity.getPersistentData().getDouble("right_hand_drop_chance") + "f]")) + ","
								+ ("ArmorDropChances:[" + (entity.getPersistentData().getDouble("helmet_drop_chance") + "f," + entity.getPersistentData().getDouble("chestplate_drop_chance") + "f,"
										+ entity.getPersistentData().getDouble("leggings_drop_chance") + "f," + entity.getPersistentData().getDouble("boots_drop_chance") + "f]"))
								+ "}");
				if (true) {
					posX = entity.getX() + Mth.nextDouble(RandomSource.create(), entity.getPersistentData().getDouble("respawn_random_radius") * (-1), entity.getPersistentData().getDouble("respawn_random_radius"));
					posY = entity.getY() + Mth.nextDouble(RandomSource.create(), entity.getPersistentData().getDouble("respawn_random_height") * (-1), entity.getPersistentData().getDouble("respawn_random_height"));
					posZ = entity.getZ() + Mth.nextDouble(RandomSource.create(), entity.getPersistentData().getDouble("respawn_random_radius") * (-1), entity.getPersistentData().getDouble("respawn_random_radius"));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute positioned " + (posX + " " + posY + " " + posZ) + " if block ~ ~ ~ #skywiza:passable_blocks if block ~ ~1 ~ #skywiza:passable_blocks run " + command));
				if (entity.getPersistentData().getBoolean("debug_mode") == true) {
					SkywizaMod.LOGGER.info(command);
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("data modify entity @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\",respawn:1b}},limit=1] ForgeData set from entity @s ForgeData"));
					}
				}
				{
					final Vec3 _center = new Vec3(posX, posY, posZ);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator.getPersistentData().getString("spawner_id")).equals(entity.getPersistentData().getString("spawner_id"))) {
							if (entity.getPersistentData().getBoolean("is_npc") == true) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tag @s add SKYWIZA-npc");
									}
								}
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("data merge entity @s {ForgeData:{npc_id:\"" + "" + (new java.text.DecimalFormat("##.##").format(Mth.nextInt(RandomSource.create(), 1, 1000000))).replace(".0", "") + "\"}}"));
									}
								}
							}
							if (entityiterator instanceof LivingEntity _livEnt48 && _livEnt48.getMobType() == MobType.UNDEAD) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"effect give @s instant_damage 1 100 true");
									}
								}
							} else {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"effect give @s instant_health 1 100 true");
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
