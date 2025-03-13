package net.mcreator.skywiza.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.skywiza.entity.NpcEntity;

public class NpcSkinSteveProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof NpcEntity _datEntS ? _datEntS.getEntityData().get(NpcEntity.DATA_Skin) : "").equals("steve");
	}
}
