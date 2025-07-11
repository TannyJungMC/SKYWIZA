package tannyjung.skywiza.procedures;

import tannyjung.skywiza.network.SkywizaModVariables;
import tannyjung.skywiza.SkywizaMod;

import net.minecraft.world.level.LevelAccessor;

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