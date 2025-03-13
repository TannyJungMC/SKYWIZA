package net.mcreator.skywiza.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ConfigApplyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"SKYWIZA : Applied the config\",\"color\":\"light_purple\"}]");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "\\config\\SKYWIZA"), File.separator + "config.txt");
		if (file.exists() == true) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					if (!("").equals("Long Time")) {
						if (true) {
							if (stringiterator.contains("long_time_enable : ")) {
								SkywizaModVariables.MapVariables.get(world).long_time = (stringiterator.replace("long_time_enable : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
							if (stringiterator.contains("long_time_custom : ")) {
								SkywizaModVariables.MapVariables.get(world).long_time_custom = new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(stringiterator.replace("long_time_custom : ", ""));
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
							if (stringiterator.contains("long_time_offset : ")) {
								SkywizaModVariables.MapVariables.get(world).long_time_offset = new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(stringiterator.replace("long_time_offset : ", ""));
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
					if (!("").equals("Spawner")) {
						if (true) {
							if (stringiterator.contains("spawner_enable : ")) {
								SkywizaModVariables.MapVariables.get(world).spawner = (stringiterator.replace("spawner_enable : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
							if (stringiterator.contains("spawner_show_name : ")) {
								SkywizaModVariables.MapVariables.get(world).spawner_show_name = (stringiterator.replace("spawner_show_name : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
							if (stringiterator.contains("spawner_mob_show_name : ")) {
								SkywizaModVariables.MapVariables.get(world).spawner_mob_show_name = (stringiterator.replace("spawner_mob_show_name : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
					if (!("").equals("Loot Chest")) {
						if (true) {
							if (stringiterator.contains("loot_chest_enable : ")) {
								SkywizaModVariables.MapVariables.get(world).loot_chest = (stringiterator.replace("loot_chest_enable : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
							if (stringiterator.contains("loot_chest_show_name : ")) {
								SkywizaModVariables.MapVariables.get(world).loot_chest_show_name = (stringiterator.replace("loot_chest_show_name : ", "")).equals("true");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
					if (!("").equals("Quest Board")) {
						if (true) {
							if (stringiterator.contains("quest_board_time_stamp : ")) {
								SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp = stringiterator.replace("quest_board_time_stamp : ", "");
								SkywizaModVariables.MapVariables.get(world).syncData(world);
							}
						}
					}
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
