package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

public class PathManagerClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @a [{\"text\":\"SKYWIZA : " + "Set Destination" + "\",\"color\":\"dark_gray\"}]"));
			itemstack.getOrCreateTag().putDouble("posX", x);
			itemstack.getOrCreateTag().putDouble("posY", y);
			itemstack.getOrCreateTag().putDouble("posZ", z);
		} else {
			if (SkywizaModVariables.MapVariables.get(world).pathway_gen == false) {
				SkywizaModVariables.MapVariables.get(world).pathway_gen = true;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @a [{\"text\":\"SKYWIZA : " + "Start" + "\",\"color\":\"dark_gray\"}]"));
				PathStartProcedure.execute(entity);
			} else {
				SkywizaModVariables.MapVariables.get(world).pathway_gen = false;
				SkywizaModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @a [{\"text\":\"SKYWIZA : " + "Stop" + "\",\"color\":\"dark_gray\"}]"));
				PathEndProcedure.execute(world, x, y, z);
			}
		}
	}
}
