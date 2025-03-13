package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class VillageInfoPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"summon armor_stand ~0.5 ~1.5 ~0.5 {CustomName:'{\"text\":\"SKYWIZA-village_info\"}',Tags:[\"SKYWIZA\",\"SKYWIZA-village\"],NoGravity:1b,Invisible:1b,Marker:1b}");
		if (true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute unless block ~ ~ ~1 #skywiza:passable_blocks run setblock ~ ~ ~ lectern[facing=" + "north"
								+ ",has_book=true]{Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"Center Not Found\"}']}}}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute unless block ~ ~ ~-1 #skywiza:passable_blocks run setblock ~ ~ ~ lectern[facing=" + "south"
								+ ",has_book=true]{Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"Center Not Found\"}']}}}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute unless block ~1 ~ ~ #skywiza:passable_blocks run setblock ~ ~ ~ lectern[facing=" + "west"
								+ ",has_book=true]{Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"Center Not Found\"}']}}}"));
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("execute unless block ~-1 ~ ~ #skywiza:passable_blocks run setblock ~ ~ ~ lectern[facing=" + "east"
								+ ",has_book=true]{Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"Center Not Found\"}']}}}"));
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"execute unless block ~ ~ ~ lectern run setblock ~ ~ ~ lectern[has_book=true]{Book:{id:\"minecraft:written_book\",Count:1b,tag:{title:\"Book\",author:\"TannyJung\",pages:['{\"text\":\"Center Not Found\"}']}}}");
		if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.LECTERN)) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
