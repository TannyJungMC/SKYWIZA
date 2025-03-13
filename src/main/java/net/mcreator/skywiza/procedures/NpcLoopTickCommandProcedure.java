package net.mcreator.skywiza.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class NpcLoopTickCommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute anchored eyes positioned ^ ^ ^ positioned ~ ~" + 1.1 + " ~ run tp @e[tag=SKYWIZA-npc_info_name,nbt={ForgeData:{npc_id:\"" + entity.getPersistentData().getString("npc_id") + "\"}}] ~ ~ ~"));
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute anchored eyes positioned ^ ^ ^ positioned ~ ~" + 0.75 + " ~ run tp @e[tag=SKYWIZA-npc_info_do,nbt={ForgeData:{npc_id:\"" + entity.getPersistentData().getString("npc_id") + "\"}}] ~ ~ ~"));
			}
		}
	}
}
