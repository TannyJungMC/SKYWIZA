package tannyjung.skywiza.procedures;

import tannyjung.skywiza.entity.NpcEntity;

import net.minecraft.world.entity.Entity;

public class NpcSkinSteveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof NpcEntity _datEntS ? _datEntS.getEntityData().get(NpcEntity.DATA_Skin) : "").equals("steve");
	}
}