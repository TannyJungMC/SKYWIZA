
package net.mcreator.skywiza.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.Commands;

import net.mcreator.skywiza.procedures.WorldGenLoopTickCommandProcedure;
import net.mcreator.skywiza.procedures.VillageLocationLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.VillageCenterLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.TxtStructurePlaceProcedure;
import net.mcreator.skywiza.procedures.TxtStructureExportProcedure;
import net.mcreator.skywiza.procedures.TxtFunctionProcedure;
import net.mcreator.skywiza.procedures.TestingCommandProcedure;
import net.mcreator.skywiza.procedures.SpawnerRespawnForceProcedure;
import net.mcreator.skywiza.procedures.SpawnerMobLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.SpawnerLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.QuestBoardResetProcedure;
import net.mcreator.skywiza.procedures.NpcLoopTickCommandProcedure;
import net.mcreator.skywiza.procedures.NpcLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.LootChestRefillForceProcedure;
import net.mcreator.skywiza.procedures.LootChestLoopSecondCommandProcedure;
import net.mcreator.skywiza.procedures.ConfigRepairProcedure;
import net.mcreator.skywiza.procedures.ConfigApplyProcedure;
import net.mcreator.skywiza.procedures.CommandTimeDetectionRealTimeProcedure;
import net.mcreator.skywiza.procedures.CommandTimeDetectionGameTimeProcedure;
import net.mcreator.skywiza.procedures.CityGeneratorLoopTickCommandProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class CommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("SKYWIZA").requires(s -> s.hasPermission(2)).then(Commands.literal("config").then(Commands.literal("repair").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ConfigRepairProcedure.execute(world, x, y, z);
			return 0;
		})).then(Commands.literal("apply").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ConfigApplyProcedure.execute(world, x, y, z);
			return 0;
		}))).then(Commands.literal("command").then(Commands.literal("time_detection").then(Commands.literal("game_time")
				.then(Commands.argument("from", DoubleArgumentType.doubleArg(1, 24000)).then(Commands.argument("to", DoubleArgumentType.doubleArg(1, 24000)).then(Commands.argument("command", MessageArgument.message()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CommandTimeDetectionGameTimeProcedure.execute(world, arguments, entity);
					return 0;
				}))))).then(
						Commands.literal("real_time")
								.then(Commands.literal("day")
										.then(Commands.argument("from_day", StringArgumentType.word())
												.then(Commands.argument("to_day", StringArgumentType.word()).then(Commands.literal("hhmm").then(Commands.argument("from_hhmm", StringArgumentType.word())
														.then(Commands.argument("to_hhmm", StringArgumentType.word()).then(Commands.literal("ddmmyyyy").then(Commands.argument("from_ddmmyyyy", StringArgumentType.word())
																.then(Commands.argument("to_ddmmyyyy", StringArgumentType.word()).then(Commands.literal("run").then(Commands.argument("command", MessageArgument.message()).executes(arguments -> {
																	Level world = arguments.getSource().getUnsidedLevel();
																	double x = arguments.getSource().getPosition().x();
																	double y = arguments.getSource().getPosition().y();
																	double z = arguments.getSource().getPosition().z();
																	Entity entity = arguments.getSource().getEntity();
																	if (entity == null && world instanceof ServerLevel _servLevel)
																		entity = FakePlayerFactory.getMinecraft(_servLevel);
																	Direction direction = Direction.DOWN;
																	if (entity != null)
																		direction = entity.getDirection();

																	CommandTimeDetectionRealTimeProcedure.execute(arguments, entity);
																	return 0;
																}))))))))))))))
				.then(Commands.literal("txt_function").then(Commands.argument("file", StringArgumentType.word()).then(Commands.argument("folder", MessageArgument.message()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					TxtFunctionProcedure.execute(world, x, y, z, arguments);
					return 0;
				})))).then(Commands.literal("txt_structure").then(Commands.literal("export").then(Commands.argument("from", BlockPosArgument.blockPos()).then(Commands.argument("to", BlockPosArgument.blockPos()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					TxtStructureExportProcedure.execute(world, x, y, z, arguments, entity);
					return 0;
				})))).then(Commands.literal("place").then(Commands.argument("height", DoubleArgumentType.doubleArg()).then(Commands.argument("rotation", DoubleArgumentType.doubleArg(0, 361))
						.then(Commands.argument("mirrored", DoubleArgumentType.doubleArg(0, 2)).then(Commands.argument("file", StringArgumentType.word()).then(Commands.argument("folder", MessageArgument.message()).executes(arguments -> {
							Level world = arguments.getSource().getUnsidedLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null && world instanceof ServerLevel _servLevel)
								entity = FakePlayerFactory.getMinecraft(_servLevel);
							Direction direction = Direction.DOWN;
							if (entity != null)
								direction = entity.getDirection();

							TxtStructurePlaceProcedure.execute(arguments, entity);
							return 0;
						})))))))))
				.then(Commands.literal("event").then(Commands.literal("quest_board_reset").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					QuestBoardResetProcedure.execute(world, x, y, z);
					return 0;
				})).then(Commands.literal("loot_chest").then(Commands.literal("refill").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					LootChestRefillForceProcedure.execute(world);
					return 0;
				}))).then(Commands.literal("spawner").then(Commands.literal("respawn").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SpawnerRespawnForceProcedure.execute(world);
					return 0;
				})))).then(Commands.literal("dev").then(Commands.literal("loot_chest").then(Commands.literal("loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					LootChestLoopSecondCommandProcedure.execute(world, entity);
					return 0;
				}))).then(Commands.literal("spawner").then(Commands.literal("loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SpawnerLoopSecondCommandProcedure.execute(world, x, y, z, entity);
					return 0;
				})).then(Commands.literal("mob_loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SpawnerMobLoopSecondCommandProcedure.execute(world, entity);
					return 0;
				}))).then(Commands.literal("village").then(Commands.literal("center_loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					VillageCenterLoopSecondCommandProcedure.execute(world, entity);
					return 0;
				})).then(Commands.literal("location_loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					VillageLocationLoopSecondCommandProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("npc").then(Commands.literal("loop_tick").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					NpcLoopTickCommandProcedure.execute(entity);
					return 0;
				})).then(Commands.literal("loop_second").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					NpcLoopSecondCommandProcedure.execute(world, x, y, z, entity);
					return 0;
				}))).then(Commands.literal("world_gen").then(Commands.literal("loop_tick").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					WorldGenLoopTickCommandProcedure.execute(entity);
					return 0;
				}))).then(Commands.literal("city_generator").then(Commands.literal("loop_tick").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					CityGeneratorLoopTickCommandProcedure.execute(entity);
					return 0;
				})))).then(Commands.literal("testing").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					TestingCommandProcedure.execute(entity);
					return 0;
				})));
	}
}
