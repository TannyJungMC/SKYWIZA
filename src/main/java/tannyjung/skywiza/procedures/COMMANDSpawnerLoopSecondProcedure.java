package tannyjung.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class COMMANDSpawnerLoopSecondProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))) {
			if (!("Auto Remove").isEmpty()) {
				if (true) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id")
										+ "\"}}] at @s run data merge entity @s {HandDropChances:[0f,0f],ArmorDropChances:[0f,0f,0f,0f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("kill @e[tag=SKYWIZA-spawner,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}]"));
				}
			}
		} else {
			if (!("Respawn").isEmpty()) {
				if (true) {
					RealTimeCountdownProcedure.execute(entity);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("execute as @e[tag=SKYWIZA-spawner_time,distance=..1] at @s run data merge entity @s {text:'{\"text\":\"respawn in " + "" + entity.getPersistentData().getString("reset_time_text") + "\",\"color\":\"gray\"}'}"));
					if (entity.getPersistentData().getBoolean("reset_time_run") == true) {
						entity.getPersistentData().putBoolean("reset_time_run", false);
						SpawnerRespawnProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}
}
