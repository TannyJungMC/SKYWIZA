package net.mcreator.skywiza.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class TxtStructureExportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		double posX = 0;
		double pos2Z = 0;
		double posZ = 0;
		double pos2X = 0;
		double scan_posY = 0;
		double scan_posX = 0;
		double scan_posZ = 0;
		double pos2Y = 0;
		double posY = 0;
		Entity exporter = null;
		boolean text_detected = false;
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("tellraw @a [{\"text\":\"SKYWIZA : " + "Exporting..." + "\",\"color\":\"dark_gray\"}]"));
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"kill @e[name=SKYWIZA-txt_structure]");
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon armor_stand ~ ~ ~ {CustomName:'{\"text\":\"SKYWIZA-txt_structure\"}',NoGravity:1b,ForgeData:{txt_structure:\"nothing\",txt_structure_entity:\"nothing\"}}");
		{
			final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getDisplayName().getString()).equals("SKYWIZA-txt_structure")) {
					exporter = entityiterator;
					break;
				}
			}
		}
		if (!(exporter == null)) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/SKYWIZA/custom/generated"), File.separator + "txt_structure.txt");
			if (!file.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			try {
				FileWriter filewriter = new FileWriter(file);
				BufferedWriter filebw = new BufferedWriter(filewriter);
				{
					filebw.write("");
				}
				filebw.close();
				filewriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			if (true) {
				posX = new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "from").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX();
				posY = new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "from").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY();
				posZ = new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "from").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ();
				pos2X = new Object() {
					public double getX() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "to").getX();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getX() - 1;
				pos2Y = new Object() {
					public double getY() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "to").getY();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getY() - 1;
				pos2Z = new Object() {
					public double getZ() {
						try {
							return BlockPosArgument.getLoadedBlockPos(arguments, "to").getZ();
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return 0;
						}
					}
				}.getZ() - 1;
				scan_posX = posX;
				scan_posY = posY;
				scan_posZ = posZ;
			}
			while (true) {
				try {
					FileWriter filewriter = new FileWriter(file);
					BufferedWriter filebw = new BufferedWriter(filewriter);
					if (world.isEmptyBlock(BlockPos.containing(scan_posX, scan_posY, scan_posZ))) {
						{
							filebw.write(("+b" + ("^" + (new java.text.DecimalFormat("##.##").format(scan_posX - posX + (posX - pos2X) * 0.5)).replace(".0", "") + "^" + (new java.text.DecimalFormat("##.##").format(scan_posY - posY)).replace(".0", "")
									+ "^" + (new java.text.DecimalFormat("##.##").format(scan_posZ - posZ + (posX - pos2X) * 0.5)).replace(".0", "")) + " air"));
							filebw.newLine();
						}
					} else {
						{
							Entity _ent = exporter;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data modify entity @s ForgeData.txt_structure set value \"nothing\"");
							}
						}
						{
							Entity _ent = exporter;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("data modify entity @s ForgeData.txt_structure set from block " + ((new java.text.DecimalFormat("##.##").format(scan_posX)).replace(".0", "") + " "
												+ (new java.text.DecimalFormat("##.##").format(scan_posY)).replace(".0", "") + " " + (new java.text.DecimalFormat("##.##").format(scan_posZ)).replace(".0", "")) + " {}"));
							}
						}
						{
							filebw.write(("+b"
									+ ("^" + (new java.text.DecimalFormat("##.##").format(scan_posX - posX + (posX - pos2X) * 0.5)).replace(".0", "") + "^" + (new java.text.DecimalFormat("##.##").format(scan_posY - posY)).replace(".0", "") + "^"
											+ (new java.text.DecimalFormat("##.##").format(scan_posZ - posZ + (posX - pos2X) * 0.5)).replace(".0", ""))
									+ " " + ((("" + world.getBlockState(BlockPos.containing(scan_posX, scan_posY, scan_posZ))).replace("}", "")).replace("Block{", "")).replace("minecraft:", "")
									+ ("" + exporter.getPersistentData().get("txt_structure")).replace("\"nothing\"", "")));
							filebw.newLine();
						}
					}
					{
						final Vec3 _center = new Vec3((scan_posX + 0.5), (scan_posY + 0.5), (scan_posZ + 0.5));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == null)) {
								if (!(entityiterator instanceof Player || (entityiterator.getDisplayName().getString()).equals("SKYWIZA-txt_structure"))) {
									{
										Entity _ent = exporter;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"data modify entity @s ForgeData.txt_structure_entity set value \"nothing\"");
										}
									}
									{
										Entity _ent = entityiterator;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands()
													.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
															_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"data modify entity @e[name=SKYWIZA-txt_structure,limit=1] ForgeData.txt_structure_entity set from entity @s {}");
										}
									}
									if (true) {
										{
											Entity _ent = exporter;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"data remove entity @s ForgeData.txt_structure_entity.UUID");
											}
										}
									}
									if (true) {
										text_detected = false;
										try {
											BufferedReader fileReader = new BufferedReader(new FileReader(file));
											String stringiterator = "";
											while ((stringiterator = fileReader.readLine()) != null) {
												if (stringiterator.contains("" + exporter.getPersistentData().get("txt_structure_entity"))) {
													text_detected = true;
													break;
												}
											}
											fileReader.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
									if (text_detected == false) {
										{
											filebw.write(("+e" + (ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).replace("minecraft:", "")
													+ ("^" + (new java.text.DecimalFormat("##.##").format(entityiterator.getX() - posX + (posX - pos2X) * 0.5)).replace(".0", "") + "^"
															+ (new java.text.DecimalFormat("##.##").format(entityiterator.getY() - posY)).replace(".0", "") + "^"
															+ (new java.text.DecimalFormat("##.##").format(entityiterator.getZ() - posZ + (posX - pos2X) * 0.5)).replace(".0", ""))
													+ " " + exporter.getPersistentData().get("txt_structure_entity")));
											filebw.newLine();
										}
									}
								}
							}
						}
					}
					filebw.close();
					filewriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				if (scan_posX < pos2X) {
					scan_posX = scan_posX + 1;
				} else {
					if (scan_posZ < pos2Z) {
						scan_posX = posX;
						scan_posZ = scan_posZ + 1;
					} else {
						if (scan_posY < pos2Y) {
							scan_posX = posX;
							scan_posZ = posZ;
							scan_posY = scan_posY + 1;
						} else {
							break;
						}
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @a [{\"text\":\"SKYWIZA : " + "Export Completed" + "\",\"color\":\"dark_gray\"}]"));
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"kill @e[name=SKYWIZA-txt_structure]");
	}
}
