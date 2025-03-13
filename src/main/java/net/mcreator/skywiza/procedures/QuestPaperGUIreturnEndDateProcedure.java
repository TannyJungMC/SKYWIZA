package net.mcreator.skywiza.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class QuestPaperGUIreturnEndDateProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "End in " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("end_date"));
	}
}
