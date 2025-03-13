package net.mcreator.skywiza.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class TxtStructurePlaceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double rotation = 0;
		double text_pos_from = 0;
		double text_pos_to = 0;
		double mirrored = 0;
		String text_replace = "";
		String north_to = "";
		String west_to = "";
		String east_to = "";
		String south_to = "";
		String file_name = "";
		String folder_directory = "";
		folder_directory = FMLPaths.GAMEDIR.get().toString() + "/config/SKYWIZA/custom/packs/" + (new Object() {
			public String getMessage() {
				try {
					return MessageArgument.getMessage(arguments, "folder").getString();
				} catch (CommandSyntaxException ignored) {
					return "";
				}
			}
		}).getMessage();
		if (!(StringArgumentType.getString(arguments, "file")).equals("-")) {
			file_name = StringArgumentType.getString(arguments, "file") + ".txt";
		} else {
			if (true) {
				File directory = new File(folder_directory);
				File[] list = directory.listFiles();
				File[] filter = (directory.listFiles());
				Random random = new Random();
				int n = 0;
				if (list != null) {
					for (int i = 0; i < list.length; i++) {
						if (list[i].isFile() && list[i].getName().endsWith(".txt")) {
							filter[n] = list[i];
							n = n + 1;
						}
					}
				}
				file_name = filter[random.nextInt(n)].getName();
			}
		}
		if (!(file_name).equals("")) {
			file = new File(folder_directory, File.separator + file_name);
			if (file.exists()) {
				if (true) {
					if (DoubleArgumentType.getDouble(arguments, "rotation") == 360) {
						rotation = Mth.nextInt(RandomSource.create(), 0, 3) * 90;
					} else if (DoubleArgumentType.getDouble(arguments, "rotation") == 361) {
						rotation = Math.round(entity.getYRot() / 90) * 90;
					} else {
						rotation = DoubleArgumentType.getDouble(arguments, "rotation");
					}
					if (rotation < 0) {
						rotation = rotation + 360;
					} else if (rotation > 360) {
						rotation = rotation - 360;
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp @s ~ ~ ~ " + rotation + " 0"));
						}
					}
					if (true) {
						mirrored = DoubleArgumentType.getDouble(arguments, "mirrored");
						if (mirrored == 0) {
							mirrored = Mth.nextInt(RandomSource.create(), 1, 2);
						}
					}
				}
				try {
					BufferedReader fileReader = new BufferedReader(new FileReader(file));
					String stringiterator = "";
					while ((stringiterator = fileReader.readLine()) != null) {
						text_replace = stringiterator;
						if (text_replace.contains("+b")) {
							if (true) {
								if (mirrored == 2) {
									text_replace = text_replace.replace("+b^", "+b^-");
									text_replace = text_replace.replace("+b^--", "+b^");
								}
								text_replace = text_replace.replace("+b", "setblock");
								if (Math.floor(rotation / 90) == 0) {
									north_to = "facing=north";
									west_to = "facing=west";
									east_to = "facing=east";
									south_to = "facing=south";
									if (mirrored == 2) {
										west_to = "facing=east";
										east_to = "facing=west";
									}
								} else if (Math.floor(rotation / 90) == 1) {
									north_to = "facing=east";
									west_to = "facing=north";
									east_to = "facing=south";
									south_to = "facing=west";
									if (mirrored == 2) {
										west_to = "facing=south";
										east_to = "facing=north";
									}
								} else if (Math.floor(rotation / 90) == 2) {
									north_to = "facing=south";
									west_to = "facing=east";
									east_to = "facing=west";
									south_to = "facing=north";
									if (mirrored == 2) {
										west_to = "facing=west";
										east_to = "facing=east";
									}
								} else if (Math.floor(rotation / 90) == 3) {
									north_to = "facing=west";
									west_to = "facing=south";
									east_to = "facing=north";
									south_to = "facing=east";
									if (mirrored == 2) {
										west_to = "facing=north";
										east_to = "facing=south";
									}
								}
								if (mirrored == 2) {
									if (text_replace.contains("facing=north") || text_replace.contains("facing=south")) {
										if (text_replace.contains("hinge=left")) {
											text_replace = text_replace.replace("hinge=left", "hinge=right");
										} else if (text_replace.contains("hinge=right")) {
											text_replace = text_replace.replace("hinge=right", "hinge=left");
										}
									}
								}
								if (text_replace.contains("facing=north")) {
									text_replace = text_replace.replace("facing=north", north_to);
								} else if (text_replace.contains("facing=west")) {
									text_replace = text_replace.replace("facing=west", west_to);
								} else if (text_replace.contains("facing=east")) {
									text_replace = text_replace.replace("facing=east", east_to);
								} else if (text_replace.contains("facing=south")) {
									text_replace = text_replace.replace("facing=south", south_to);
								}
							}
						} else if (text_replace.contains("+e")) {
							if (true) {
								if (mirrored == 2) {
									rotation = rotation + 180;
								}
								text_replace = text_replace.replace("+e", "summon ");
								text_pos_from = 0;
								text_pos_to = 1;
								while (true) {
									if (!(text_replace.substring(0, (int) text_pos_to)).contains("Rotation:[")) {
										text_pos_to = text_pos_to + 1;
									} else {
										if (text_pos_from == 0) {
											text_pos_from = text_pos_to;
										} else {
											if (!(text_replace.substring((int) text_pos_from, (int) text_pos_to)).contains("f")) {
												text_pos_to = text_pos_to + 1;
											} else {
												text_pos_to = text_pos_to - 1;
												text_replace = text_replace.substring(0, (int) text_pos_from) + "" + (new Object() {
													double convert(String s) {
														try {
															return Double.parseDouble(s.trim());
														} catch (Exception e) {
														}
														return 0;
													}
												}.convert(text_replace.substring((int) text_pos_from, (int) text_pos_to)) + rotation) + text_replace.substring((int) text_pos_to, (int) (text_replace).length());
												break;
											}
										}
									}
								}
							}
						}
						text_replace = text_replace.replace("^", " ^");
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("execute positioned ~ ~" + DoubleArgumentType.getDouble(arguments, "height") + " ~ run " + text_replace));
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
}
