package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

public class TxtStructureManagerTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean text_detected = false;
		double pos2Z = 0;
		double pos2X = 0;
		double scan_posY = 0;
		double scan_posX = 0;
		double scan_posZ = 0;
		double pos2Y = 0;
		double step = 0;
		double posX = 0;
		double posY = 0;
		double posZ = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("pos2") == false) {
			if (SkywizaModVariables.MapVariables.get(world).txt_structure_manager_tick < 20) {
				SkywizaModVariables.MapVariables.get(world).txt_structure_manager_tick = SkywizaModVariables.MapVariables.get(world).txt_structure_manager_tick + 1;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
			} else {
				SkywizaModVariables.MapVariables.get(world).txt_structure_manager_tick = 1;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
				if (true) {
					posX = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("from_posX") - 1;
					posY = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("from_posY") - 1;
					posZ = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("from_posZ") - 1;
					pos2X = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("to_posX");
					pos2Y = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("to_posY");
					pos2Z = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("to_posZ");
					if (true) {
						scan_posX = posX;
						scan_posY = posY;
						scan_posZ = posZ;
					}
				}
				step = 1;
				while (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(scan_posX, scan_posY, scan_posZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"particle end_rod ~0.5 ~0.5 ~0.5 0 0 0 0 1 force");
					if (true) {
						if (true) {
							if (step == 1) {
								if (scan_posY < pos2Y) {
									scan_posY = scan_posY + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posX = pos2X;
								}
							}
							if (step == 2) {
								if (scan_posY < pos2Y) {
									scan_posY = scan_posY + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posZ = pos2Z;
								}
							}
							if (step == 3) {
								if (scan_posY < pos2Y) {
									scan_posY = scan_posY + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posX = pos2X;
									scan_posZ = pos2Z;
								}
							}
							if (step == 4) {
								if (scan_posY < pos2Y) {
									scan_posY = scan_posY + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
								}
							}
						}
						if (true) {
							if (step == 5) {
								if (scan_posX < pos2X) {
									scan_posX = scan_posX + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posY = pos2Y;
								}
							}
							if (step == 6) {
								if (scan_posX < pos2X) {
									scan_posX = scan_posX + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posZ = pos2Z;
								}
							}
							if (step == 7) {
								if (scan_posX < pos2X) {
									scan_posX = scan_posX + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posY = pos2Y;
									scan_posZ = pos2Z;
								}
							}
							if (step == 8) {
								if (scan_posX < pos2X) {
									scan_posX = scan_posX + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
								}
							}
						}
						if (true) {
							if (step == 9) {
								if (scan_posZ < pos2Z) {
									scan_posZ = scan_posZ + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posY = pos2Y;
								}
							}
							if (step == 10) {
								if (scan_posZ < pos2Z) {
									scan_posZ = scan_posZ + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posX = pos2X;
								}
							}
							if (step == 11) {
								if (scan_posZ < pos2Z) {
									scan_posZ = scan_posZ + 1;
								} else {
									step = step + 1;
									if (true) {
										scan_posX = posX;
										scan_posY = posY;
										scan_posZ = posZ;
									}
									scan_posX = pos2X;
									scan_posY = pos2Y;
								}
							}
							if (step >= 12) {
								if (scan_posZ < pos2Z) {
									scan_posZ = scan_posZ + 1;
								} else {
									break;
								}
							}
						}
					}
				}
			}
		}
	}
}
