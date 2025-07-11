package tannyjung.skywiza.procedures;

import tannyjung.skywiza.SkywizaMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SpawnerRespawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		double loop = 0;
		String type = "";
		String command = "";
		if (!("Kill Mob").isEmpty()) {
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute as @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id")
									+ "\"}}] at @s run data merge entity @s {HandDropChances:[0f,0f],ArmorDropChances:[0f,0f,0f,0f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tp @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}] ~ -10000 ~"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("kill @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}]"));
			}
		}
		if (!("General Data").isEmpty()) {
			if (true) {
				command = "PersistenceRequired:1b,DeathLootTable:\"minecraft:empty\",Attributes:[{Name:\"minecraft:generic.follow_range\",Base:200d},{Name:\"minecraft:generic.max_health\",Base:" + ""
						+ entity.getPersistentData().getDouble("max_health") + "}" + entity.getPersistentData().getString("attribute_extra") + "],ForgeData:{spawner_id:\"" + entity.getPersistentData().getString("spawner_id") + "\",respawn:1b}";
				if (entity.getPersistentData().getBoolean("is_npc") == false) {
					command = command + "" + (",CustomName:'{\"text\":\"" + "" + entity.getPersistentData().getString("name") + "\",\"color\":\"" + entity.getPersistentData().getString("name_color") + "\"}',CustomNameVisible:1b");
				}
			}
		}
		if (!("Hand and Armor Items").isEmpty()) {
			if (true) {
				loop = 1;
				for (int index0 = 0; index0 < 20; index0++) {
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
										+ entity.getPersistentData().getDouble("leggings_drop_chance") + "f," + entity.getPersistentData().getDouble("boots_drop_chance") + "f]")));
			}
		}
		command = SummonEntityProcedure.execute(command, entity.getPersistentData().getString("entity_id"), "", "", "spawner / spawner_mob");
		for (int index1 = 0; index1 < (int) entity.getPersistentData().getDouble("group_count"); index1++) {
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
		}
	}
}