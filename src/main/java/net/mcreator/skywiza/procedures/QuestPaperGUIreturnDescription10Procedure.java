package net.mcreator.skywiza.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class QuestPaperGUIreturnDescription10Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("description10");
	}
}
