package tannyjung.skywiza.command;

import tannyjung.skywiza.procedures.ConfigRepairProcedure;
import tannyjung.skywiza.procedures.ConfigApplyProcedure;
import tannyjung.skywiza.procedures.CommandTimeDetectionRealTimeProcedure;
import tannyjung.skywiza.procedures.CommandTimeDetectionGameTimeProcedure;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class COMMANDCommand {
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
																}))))))))))))))));
	}

}