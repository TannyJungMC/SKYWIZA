package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class LootChestLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))
				|| (world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[tag=SKYWIZA-loot_chest,distance=..1]");
				}
			}
		} else {
			if (!(entity.getPersistentData().getDouble("loot_chest_posX") == entity.getX() && entity.getPersistentData().getDouble("loot_chest_posY") == entity.getY() && entity.getPersistentData().getDouble("loot_chest_posZ") == entity.getZ())) {
				if (true) {
					entity.getPersistentData().putDouble("loot_chest_posX", (entity.getX()));
					entity.getPersistentData().putDouble("loot_chest_posY", (entity.getY()));
					entity.getPersistentData().putDouble("loot_chest_posZ", (entity.getZ()));
				}
				entity.getPersistentData().putString("loot_chest_id", (entity.getX() + "-" + entity.getY() + "-" + entity.getZ()));
			} else {
				RealTimeCountdownProcedure.execute(entity);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute as @e[tag=SKYWIZA-loot_chest_time,distance=..1] at @s run data merge entity @s {CustomName:'{\"text\":\"refill in " + "" + entity.getPersistentData().getString("reset_time_text")
										+ "\",\"color\":\"gray\"}'}"));
					}
				}
				if (entity.getPersistentData().getBoolean("reset_time_run") == true) {
					entity.getPersistentData().putBoolean("reset_time_run", false);
					LootChestRefillProcedure.execute(entity);
				}
			}
		}
	}
}
