package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SpawnerLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String reset_time_text = "";
		if (!(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[tag=SKYWIZA-spawner,distance=..1]");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("kill @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}]"));
				}
			}
		} else {
			if (!(entity.getPersistentData().getDouble("spawner_posX") == entity.getX() && entity.getPersistentData().getDouble("spawner_posY") == entity.getY() && entity.getPersistentData().getDouble("spawner_posZ") == entity.getZ())) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
								("kill @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + "" + entity.getPersistentData().getString("spawner_id") + "\"}}]"));
					}
				}
				if (true) {
					entity.getPersistentData().putDouble("spawner_posX", (entity.getX()));
					entity.getPersistentData().putDouble("spawner_posY", (entity.getY()));
					entity.getPersistentData().putDouble("spawner_posZ", (entity.getZ()));
				}
				entity.getPersistentData().putString("spawner_id", (entity.getX() + "-" + entity.getY() + "-" + entity.getZ()));
			} else {
				RealTimeCountdownProcedure.execute(entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute as @e[tag=SKYWIZA-spawner_time,distance=..1] at @s run data merge entity @s {CustomName:'{\"text\":\"respawn in " + "" + entity.getPersistentData().getString("reset_time_text") + "\",\"color\":\"gray\"}'}"));
					}
				}
				if (entity.getPersistentData().getBoolean("reset_time_run") == true) {
					entity.getPersistentData().putBoolean("reset_time_run", false);
					SpawnerRespawnProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
