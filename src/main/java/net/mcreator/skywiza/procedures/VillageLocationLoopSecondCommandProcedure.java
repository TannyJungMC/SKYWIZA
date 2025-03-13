package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.util.List;
import java.util.Comparator;

public class VillageLocationLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity center = null;
		if (!(world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))).is(BlockTags.create(new ResourceLocation("skywiza:passable_blocks")))) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
				}
			}
		}
		if (SkywizaModVariables.MapVariables.get(world).debug_village == true) {
			if ((entity.getPersistentData().getString("npc_id")).equals("")) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:block_marker barrier ~ ~1.25 ~ 0 0 0 0 1 force");
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:block_marker barrier ~ ~1.25 ~ 0 0 0 0 1 force");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle minecraft:block_marker barrier ~ ~2.25 ~ 0 0 0 0 1 force");
			}
		}
		{
			final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("center_posX")), (entity.getPersistentData().getDouble("center_posY")), (entity.getPersistentData().getDouble("center_posZ")));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator.getPersistentData().getString("village_name")).equals("")) {
					center = entityiterator;
					break;
				}
			}
		}
		if (center == null) {
			if (true) {
				entity.getPersistentData().putDouble("center_posX", 0);
				entity.getPersistentData().putDouble("center_posY", 0);
				entity.getPersistentData().putDouble("center_posZ", 0);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {ForgeData:{npc_id:0}}");
				}
			}
		} else {
			if (!(entity.getPersistentData().getString("npc_id")).equals("")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("execute unless entity @e[tag=SKYWIZA-npc,nbt={ForgeData:{npc_id:\"" + "" + entity.getPersistentData().getString("npc_id") + "\"}}] run data merge entity @s {ForgeData:{npc_id:0}}"));
					}
				}
			}
		}
	}
}
