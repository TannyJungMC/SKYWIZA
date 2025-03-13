package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class NpcLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute unless entity @e[tag=SKYWIZA-npc_info_name,nbt={ForgeData:{npc_id:\"" + "" + entity.getPersistentData().getString("npc_id") + "\"}}] anchored eyes positioned ^ ^ ^ positioned ~ ~" + 1.1
								+ " ~ run summon armor_stand ~ ~ ~ {Tags:[\"SKYWIZA\",\"SKYWIZA-npc_info\",\"SKYWIZA-npc_info_name\"],Marker:1b,Invisible:1b,CustomName:'{\"text\":\"" + entity.getPersistentData().getString("name") + "\",\"color\":\""
								+ entity.getPersistentData().getString("name_color") + "\"}',ForgeData:{npc_id:\"" + entity.getPersistentData().getString("npc_id") + "\"},CustomNameVisible:1b}"));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute unless entity @e[tag=SKYWIZA-npc_info_do,nbt={ForgeData:{npc_id:\"" + "" + entity.getPersistentData().getString("npc_id") + "\"}}] anchored eyes positioned ^ ^ ^ positioned ~ ~" + 0.75
								+ " ~ run summon armor_stand ~ ~ ~ {Tags:[\"SKYWIZA\",\"SKYWIZA-npc_info\",\"SKYWIZA-npc_info_do\"],Marker:1b,Invisible:1b,CustomName:'{\"text\":\"\"}',ForgeData:{npc_id:\""
								+ entity.getPersistentData().getString("npc_id") + "\"},CustomNameVisible:1b}"));
			}
		}
		NpcScheduleProcedure.execute(world, x, y, z, entity);
	}
}
