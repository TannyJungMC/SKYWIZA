package tannyjung.skywiza.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class COMMANDSpawnerLoopSecondMobProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				if (entityiterator.getPersistentData().getBoolean("go_back") == false) {
					if (Math.abs(entityiterator.getX() - entityiterator.getPersistentData().getDouble("spawner_posX")) > entityiterator.getPersistentData().getDouble("distance_back")
							|| Math.abs(entityiterator.getZ() - entityiterator.getPersistentData().getDouble("spawner_posZ")) > entityiterator.getPersistentData().getDouble("distance_back")
							|| Math.abs(entityiterator.getY() - entityiterator.getPersistentData().getDouble("spawner_posY")) > entityiterator.getPersistentData().getDouble("distance_back")) {
						entityiterator.getPersistentData().putBoolean("distance_back_true", true);
					}
				} else {
					if (Math.abs(entityiterator.getX() - entityiterator.getPersistentData().getDouble("spawner_posX")) <= 3 && Math.abs(entityiterator.getZ() - entityiterator.getPersistentData().getDouble("spawner_posZ")) <= 3
							&& Math.abs(entityiterator.getY() - entityiterator.getPersistentData().getDouble("spawner_posY")) <= 3) {
						entity.getPersistentData().putBoolean("distance_back_true", false);
					}
					if (entityiterator instanceof Mob _entity)
						_entity.getNavigation().moveTo((entityiterator.getPersistentData().getDouble("spawner_posX")), (entityiterator.getPersistentData().getDouble("spawner_posY")), (entityiterator.getPersistentData().getDouble("spawner_posZ")), 2);
					if (entityiterator instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}