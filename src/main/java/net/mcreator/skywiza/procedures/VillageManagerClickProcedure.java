package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

public class VillageManagerClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SkywizaModVariables.MapVariables.get(world).debug_village == false) {
			SkywizaModVariables.MapVariables.get(world).debug_village = true;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @a [{\"text\":\"SKYWIZA : " + "Turned ON Debug Mode" + "\",\"color\":\"dark_gray\"}]"));
		} else {
			SkywizaModVariables.MapVariables.get(world).debug_village = false;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @a [{\"text\":\"SKYWIZA : " + "Turned OFF Debug Mode" + "\",\"color\":\"dark_gray\"}]"));
		}
	}
}
