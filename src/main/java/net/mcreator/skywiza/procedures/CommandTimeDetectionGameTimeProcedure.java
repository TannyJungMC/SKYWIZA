package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CommandTimeDetectionGameTimeProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double time = 0;
		double variable_number = 0;
		double variable_number2 = 0;
		double variable_number3 = 0;
		boolean variable_logic = false;
		variable_number = DoubleArgumentType.getDouble(arguments, "from");
		variable_number2 = DoubleArgumentType.getDouble(arguments, "to");
		variable_number3 = (world.dayTime() / 24000 - Math.floor(world.dayTime() / 24000)) * 24000;
		if (variable_number <= variable_number2) {
			if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
				variable_logic = false;
			}
		} else {
			if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
				variable_logic = false;
			}
		}
		if (variable_logic == true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (new Object() {
								public String getMessage() {
									try {
										return MessageArgument.getMessage(arguments, "command").getString();
									} catch (CommandSyntaxException ignored) {
										return "";
									}
								}
							}).getMessage());
				}
			}
		}
	}
}
