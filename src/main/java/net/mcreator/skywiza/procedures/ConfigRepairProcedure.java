package net.mcreator.skywiza.procedures;

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
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class ConfigRepairProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		File file = new File("");
		double finding_text_position2 = 0;
		double loop_next = 0;
		double loop = 0;
		double finding_text_position = 0;
		String set = "";
		String old_version = "";
		String description = "";
		String default_value = "";
		String current_value = "";
		String name = "";
		String category = "";
		boolean category_true = false;
		ConfigRepair2Procedure.execute();
		if (true) {
			FileWriter filewriter;
			BufferedWriter filebw;
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/SKYWIZA"), File.separator + "config.txt");
			if (file.exists() == false) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("execute if entity @e[type=player,distance=..0.01] run tellraw @a [{\"text\":\"SKYWIZA : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "config.txt" + "\",\"color\":\"white\"}]"));
			}
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					old_version = old_version + "$" + stringiterator;
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (true) {
				try {
					filewriter = new FileWriter(file, false);
					filebw = new BufferedWriter(filewriter);
					if (true) {
						{
							filebw.write("- Apply the changes by run this command [ /SKYWIZA config apply ] or restart the world");
							filebw.newLine();
						}
						{
							filebw.write("- Repair missing values by run this command [ /SKYWIZA config repair ] or restart the world");
							filebw.newLine();
						}
						{
							filebw.write("");
							filebw.newLine();
						}
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			loop = 1;
			for (int index0 = 0; index0 < 100; index0++) {
				loop_next = 1;
				category_true = false;
				if (true) {
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Long Time";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "long_time_enable";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).long_time;
									default_value = "" + false;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "long_time_custom";
									current_value = ("" + SkywizaModVariables.MapVariables.get(world).long_time_custom).replace(".0", "");
									default_value = ("" + 1440).replace(".0", "");
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "long_time_offset";
									current_value = ("" + SkywizaModVariables.MapVariables.get(world).long_time_offset).replace(".0", "");
									default_value = ("" + 6000).replace(".0", "");
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Spawner";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "spawner_enable";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).spawner;
									default_value = "" + true;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "spawner_show_name";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).spawner_show_name;
									default_value = "" + true;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "spawner_mob_show_name";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).spawner_mob_show_name;
									default_value = "" + true;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Loot Chest";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "loot_chest_enable";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).loot_chest;
									default_value = "" + true;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
							if (true) {
								if (loop == loop_next) {
									name = "loot_chest_show_name";
									current_value = "" + SkywizaModVariables.MapVariables.get(world).loot_chest_show_name;
									default_value = "" + true;
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
						}
					}
					if (true) {
						if (true) {
							if (loop == loop_next) {
								category = "Quest Board";
								category_true = true;
							}
							loop_next = loop_next + 1;
						}
						if (true) {
							if (true) {
								if (loop == loop_next) {
									name = "quest_board_time_stamp";
									current_value = SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp;
									default_value = "sunday";
									description = "// ";
								}
								loop_next = loop_next + 1;
							}
						}
					}
				}
				if (loop != loop_next) {
					loop = loop + 1;
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (true) {
								if (category_true == true) {
									{
										filebw.write(
												"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										filebw.newLine();
									}
									{
										filebw.write(category);
										filebw.newLine();
									}
									{
										filebw.write(
												"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										filebw.newLine();
									}
									{
										filebw.write("");
										filebw.newLine();
									}
								} else {
									set = "";
									finding_text_position = 0;
									finding_text_position2 = 0;
									for (int index1 = 0; index1 < (int) (old_version).length(); index1++) {
										finding_text_position2 = finding_text_position2 + 1;
										if ((old_version.substring((int) finding_text_position, (int) finding_text_position2)).contains("$")) {
											if ((old_version.substring((int) finding_text_position, (int) finding_text_position2)).contains(name + " : ")) {
												set = old_version.substring((int) finding_text_position, (int) (finding_text_position2 - 1));
												break;
											} else {
												finding_text_position = finding_text_position2;
											}
										}
									}
									if ((set).equals("")) {
										set = name + " : " + default_value;
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													("execute if entity @e[type=player,distance=..0.01] run tellraw @a [\"\",{\"text\":\"SKYWIZA : Repaired \",\"color\":\"yellow\"},{\"text\":\"" + "" + ("config.txt" + " > " + name)
															+ "\",\"color\":\"white\"}]"));
									}
									{
										filebw.write(set);
										filebw.newLine();
									}
									{
										filebw.write(description);
										filebw.newLine();
									}
									{
										filebw.write(("// Default is " + default_value));
										filebw.newLine();
									}
									{
										filebw.write("");
										filebw.newLine();
									}
								}
							}
							filebw.close();
							filewriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
				} else {
					if (true) {
						try {
							filewriter = new FileWriter(file, true);
							filebw = new BufferedWriter(filewriter);
							if (true) {
								{
									filebw.write(
											"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
									filebw.newLine();
								}
							}
							filebw.close();
							filewriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
}
