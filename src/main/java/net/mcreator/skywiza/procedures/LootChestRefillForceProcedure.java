package net.mcreator.skywiza.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.skywiza.network.SkywizaModVariables;
import net.mcreator.skywiza.SkywizaMod;

public class LootChestRefillForceProcedure {
	public static void execute(LevelAccessor world) {
		SkywizaModVariables.MapVariables.get(world).loot_chest_refill_force = true;
		SkywizaModVariables.MapVariables.get(world).syncData(world);
		SkywizaMod.queueServerWork(20, () -> {
			SkywizaModVariables.MapVariables.get(world).loot_chest_refill_force = false;
			SkywizaModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
