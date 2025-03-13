package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.List;
import java.util.Comparator;

public class SpawnerMobLoopSecondCommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String countdown = "";
		Entity spawner = null;
		Entity no_entity = null;
		{
			final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("spawner_posX")), (entity.getPersistentData().getDouble("spawner_posY")), (entity.getPersistentData().getDouble("spawner_posZ")));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entity.getPersistentData().getBoolean("is_spawner") == true) {
					spawner = entityiterator;
					break;
				}
			}
		}
		if (!(spawner == null)) {
			if (Math.abs(entity.getX() - entity.getPersistentData().getDouble("spawner_posX")) > entity.getPersistentData().getDouble("distance_back")
					|| Math.abs(entity.getY() - entity.getPersistentData().getDouble("spawner_posY")) > entity.getPersistentData().getDouble("distance_back")
					|| Math.abs(entity.getZ() - entity.getPersistentData().getDouble("spawner_posZ")) > entity.getPersistentData().getDouble("distance_back")) {
				entity.getPersistentData().putBoolean("distance_back_true", true);
			}
			if (entity.getPersistentData().getBoolean("distance_back_true") == true) {
				if (Math.abs(entity.getX() - entity.getPersistentData().getDouble("spawner_posX")) <= 3 && Math.abs(entity.getY() - entity.getPersistentData().getDouble("spawner_posY")) <= 3
						&& Math.abs(entity.getZ() - entity.getPersistentData().getDouble("spawner_posZ")) <= 3) {
					entity.getPersistentData().putBoolean("distance_back_true", false);
				}
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("spawner_posX")), (entity.getPersistentData().getDouble("spawner_posY")), (entity.getPersistentData().getDouble("spawner_posZ")), 2);
				if (entity instanceof Mob _entity && no_entity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		}
	}
}
