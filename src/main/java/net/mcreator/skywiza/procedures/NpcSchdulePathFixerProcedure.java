package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class NpcSchdulePathFixerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity center = null;
		{
			final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("center_posX")), (entity.getPersistentData().getDouble("center_posY")), (entity.getPersistentData().getDouble("center_posZ")));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator.getPersistentData().getString("village_name")).equals("")) {
					center = entityiterator;
					break;
				}
			}
		}
		if (!(center == null)) {
			if (entity.getPersistentData().getDouble("path_fixer_tick") < 10) {
				entity.getPersistentData().putDouble("path_fixer_tick", (entity.getPersistentData().getDouble("path_fixer_tick") + 1));
			} else {
				entity.getPersistentData().putDouble("path_fixer_tick", 1);
				if (!(Math.abs(entity.getX() - entity.getPersistentData().getDouble("path_fixer_save_posX")) <= 1.5 && Math.abs(entity.getY() - entity.getPersistentData().getDouble("path_fixer_save_posY")) <= 1.5
						&& Math.abs(entity.getZ() - entity.getPersistentData().getDouble("path_fixer_save_posZ")) <= 1.5)) {
					if (true) {
						entity.getPersistentData().putDouble("path_fixer_save_posX", (entity.getX()));
						entity.getPersistentData().putDouble("path_fixer_save_posY", (entity.getY()));
						entity.getPersistentData().putDouble("path_fixer_save_posZ", (entity.getZ()));
					}
				} else {
					if (true) {
						entity.getPersistentData().putDouble("path_fixer_save_posX", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posY", 0);
						entity.getPersistentData().putDouble("path_fixer_save_posZ", 0);
					}
					entity.getPersistentData().putBoolean("path_fixer", true);
					if ((entity.getPersistentData().getString("schedule_text")).equals("Going To Center")) {
						entity.getPersistentData().putString("path_fixer_fixed_save",
								(entity.getPersistentData().getDouble("schedule_at_posX") + " " + entity.getPersistentData().getDouble("schedule_at_posY") + " " + entity.getPersistentData().getDouble("schedule_at_posZ")));
					}
				}
			}
			if (entity.getPersistentData().getBoolean("path_fixer") == true) {
				if (!(entity.getPersistentData().getString("path_fixer_fixed_save"))
						.equals(entity.getPersistentData().getDouble("schedule_at_posX") + " " + entity.getPersistentData().getDouble("schedule_at_posY") + " " + entity.getPersistentData().getDouble("schedule_at_posZ"))) {
					if (!(Math.abs(entity.getX() - center.getX()) <= 1.5 && Math.abs(entity.getY() - center.getY()) <= 1.5 && Math.abs(entity.getZ() - center.getZ()) <= 1.5)) {
						if (true) {
							entity.getPersistentData().putDouble("schedule_at_posX", (center.getX()));
							entity.getPersistentData().putDouble("schedule_at_posY", (center.getY()));
							entity.getPersistentData().putDouble("schedule_at_posZ", (center.getZ()));
						}
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("schedule_at_posX")), (entity.getPersistentData().getDouble("schedule_at_posY")), (entity.getPersistentData().getDouble("schedule_at_posZ")), 1);
						entity.getPersistentData().putString("schedule_text", "Going To Center");
					} else {
						if (true) {
							entity.getPersistentData().putDouble("schedule_at_posX",
									(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posX"))));
							entity.getPersistentData().putDouble("schedule_at_posY",
									(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posY"))));
							entity.getPersistentData().putDouble("schedule_at_posZ",
									(entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at_posZ"))));
						}
						entity.getPersistentData().putString("path_fixer_fixed_save",
								(entity.getPersistentData().getDouble("schedule_at_posX") + " " + entity.getPersistentData().getDouble("schedule_at_posY") + " " + entity.getPersistentData().getDouble("schedule_at_posZ")));
						entity.getPersistentData().putBoolean("path_fixer", false);
						entity.getPersistentData().putDouble("path_fixer_tick", 0);
						entity.getPersistentData().putDouble("path_fixer_center_tick", 0);
					}
				} else {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("tp " + entity.getPersistentData().getString("path_fixer_fixed_save")));
						}
					}
					if (true) {
						if (true) {
							entity.getPersistentData().putDouble("path_fixer_save_posX", 0);
							entity.getPersistentData().putDouble("path_fixer_save_posY", 0);
							entity.getPersistentData().putDouble("path_fixer_save_posZ", 0);
						}
						entity.getPersistentData().putString("path_fixer_fixed_save", "");
						entity.getPersistentData().putBoolean("path_fixer", false);
						entity.getPersistentData().putDouble("path_fixer_tick", 0);
						entity.getPersistentData().putDouble("path_fixer_center_tick", 0);
					}
				}
			}
		}
	}
}
