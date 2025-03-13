package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class QuestBoardPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String direction = "";
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon armor_stand ~0.07 ~0.415 ~0.025 {Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,Marker:1b,Rotation:[0f],CustomName:'{\"text\":\"SKYWIZA-quest_board_" + "" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name")) + "\"}'}"));
			direction = "90";
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon armor_stand ~0.025 ~0.415 ~-0.07 {Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,Marker:1b,Rotation:[270f],CustomName:'{\"text\":\"SKYWIZA-quest_board_" + "" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name")) + "\"}'}"));
			direction = "0";
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon armor_stand ~-0.025 ~0.415 ~0.07 {Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,Marker:1b,Rotation:[90f],CustomName:'{\"text\":\"SKYWIZA-quest_board_" + "" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name")) + "\"}'}"));
			direction = "180";
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), (y - 1.5), (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("summon armor_stand ~-0.07 ~0.415 ~-0.025 {Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,Marker:1b,Rotation:[180f],,CustomName:'{\"text\":\"SKYWIZA-quest_board_" + "" + (new Object() {
							public String getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getString(tag);
								return "";
							}
						}.getValue(world, BlockPos.containing(x, y, z), "name")) + "\"}'}"));
			direction = "270";
		}
		if (true) {
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^ ^-0.25 ^0.21"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^0.55 ^-0.25 ^0.21"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-0.55 ^-0.25 ^0.21"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.1 ^-0.25 ^0.21"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.1 ^-0.25 ^0.21"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if ((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "size")).equals("5x2")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.65 ^-0.25 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.65 ^-0.25 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^2.2 ^-0.25 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-2.2 ^-0.25 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
				}
			}
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^0.825 ^0.05 ^0.22"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-0.825 ^0.05 ^0.22"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^0.275 ^0.05 ^0.22"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-0.275 ^0.05 ^0.22"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if ((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "size")).equals("5x2")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.925 ^0.05 ^0.22"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.925 ^0.05 ^0.22"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.375 ^0.05 ^0.22"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.375 ^0.05 ^0.22"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
				}
			}
			if (true) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^ ^0.325 ^0.23"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^0.55 ^0.325 ^0.23"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.1 ^0.325 ^0.23"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-0.55 ^0.325 ^0.23"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getString(tag);
									return "";
								}
							}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.1 ^0.325 ^0.23"
									+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
									+ "" + direction + "f]}"));
				if ((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "size")).equals("5x2")) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^1.65 ^0.325 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-1.65 ^0.325 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^2.2 ^0.325 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((x + 0.5), y, (z + 0.5)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								((("execute at @e[name=SKYWIZA-quest_board_" + (new Object() {
									public String getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity blockEntity = world.getBlockEntity(pos);
										if (blockEntity != null)
											return blockEntity.getPersistentData().getString(tag);
										return "";
									}
								}.getValue(world, BlockPos.containing(x, y, z), "name")) + ",limit=1,sort=nearest] run summon armor_stand ") + "^-2.2 ^0.325 ^0.21"
										+ " {CustomName:'{\"text\":\"SKYWIZA-quest_board_paper\"}',Tags:[\"LOTW-ally\",\"SKYWIZA\",\"SKYWIZA-quest_board\"],Invisible:1b,NoGravity:1b,ShowArms:1b,Pose:{RightArm:[-90f,-90f,0f]},HandItems:[{},{}],Rotation:[")
										+ "" + direction + "f]}"));
				}
			}
		}
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		QuestBoardResetProcedure.execute(world, x, y, z);
	}
}
