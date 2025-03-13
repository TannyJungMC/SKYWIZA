package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class LootChestPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String pos = "";
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("is_loot_chest", true);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		pos = "~ ~ ~";
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock()) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock()) {
				pos = "~0.5 ~ ~";
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock()) {
				pos = "~-0.5 ~ ~";
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock()) {
				pos = "~ ~ ~0.5";
			} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock()) {
				pos = "~ ~ ~-0.5";
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("double_chest", true);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute positioned ~0.5 ~0.5 ~0.5 run summon armor_stand " + pos + " {NoGravity:1b,Invisible:1b,Marker:1b,Tags:[\"SKYWIZA\",\"SKYWIZA-loot_chest\",\"SKYWIZA-loot_chest_main\"],CustomName:'{\"text\":\"" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name")) + "\",\"color\":\"" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name_color")) + "\"}',ArmorItems:[{id:\"chest\",Count:1b,tag:{LootTable:\"" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "loot_id")) + "\"}},{},{},{}]}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute positioned ~0.5 ~0.2 ~0.5 run summon armor_stand " + pos + " {NoGravity:1b,Invisible:1b,Marker:1b,Tags:[\"SKYWIZA\",\"SKYWIZA-loot_chest\",\"SKYWIZA-loot_chest_time\"],CustomName:'{\"text\":\"\"}'}"));
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute positioned ~0.5 ~0.5 ~0.5 run data modify entity @e[tag=SKYWIZA-loot_chest_main,distance=..1,limit=1] ForgeData set from block ~ ~ ~ ForgeData");
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
