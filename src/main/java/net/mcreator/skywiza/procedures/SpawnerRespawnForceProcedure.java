package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.skywiza.network.SkywizaModVariables;
import net.mcreator.skywiza.SkywizaMod;

public class SpawnerRespawnForceProcedure {
	public static void execute(LevelAccessor world) {
		SkywizaModVariables.MapVariables.get(world).spawner_respawn_force = true;
		SkywizaModVariables.MapVariables.get(world).syncData(world);
		SkywizaMod.queueServerWork(21, () -> {
			SkywizaModVariables.MapVariables.get(world).spawner_respawn_force = false;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
