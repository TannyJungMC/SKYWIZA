package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class NpcScheduleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double gametime = 0;
		Entity center = null;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			entity.getPersistentData().putString("schedule_text", ("Attacking " + ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getDisplayName().getString())));
		} else {
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
			if (center == null) {
				if (true) {
					entity.getPersistentData().putDouble("center_posX", 0);
					entity.getPersistentData().putDouble("center_posY", 0);
					entity.getPersistentData().putDouble("center_posZ", 0);
				}
				if ((entity.getPersistentData().getString("schedule_text")).equals("Going To Center")) {
					NpcSchdulePathFixerProcedure.execute(world, entity);
				} else {
					entity.getPersistentData().putString("schedule_text", "Wandering");
				}
			} else {
				if (true) {
					gametime = world.dayTime();
					gametime = (gametime / 24000 - Math.floor(gametime / 24000)) * 24000;
					entity.getPersistentData().putBoolean("schedule_lock", false);
					entity.getPersistentData().putString("schedule_at", "");
					entity.getPersistentData().putString("schedule_text_find", "");
					entity.getPersistentData().putString("schedule_text_go", "");
					entity.getPersistentData().putString("schedule_text_work", "");
					entity.getPersistentData().putDouble("schedule", 1);
				}
				for (int index0 = 0; index0 < 10; index0++) {
					if (gametime >= entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_from"))
							&& gametime < entity.getPersistentData().getDouble(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_to"))) {
						entity.getPersistentData().putString("schedule_at",
								(entity.getPersistentData().getString(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_at"))));
						entity.getPersistentData().putString("schedule_text_find",
								(entity.getPersistentData().getString(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_text_find"))));
						entity.getPersistentData().putString("schedule_text_go",
								(entity.getPersistentData().getString(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_text_go"))));
						entity.getPersistentData().putString("schedule_text_work",
								(entity.getPersistentData().getString(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_text_work"))));
						entity.getPersistentData().putBoolean("schedule_lock",
								(entity.getPersistentData().getBoolean(("schedule" + (new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("schedule"))).replace(".0", "") + "_lock"))));
						break;
					}
					entity.getPersistentData().putDouble("schedule", (entity.getPersistentData().getDouble("schedule") + 1));
				}
				if ((entity.getPersistentData().getString("schedule_at")).equals("")) {
					entity.getPersistentData().putString("schedule_text", "Wandering Around");
				} else {
					if (entity.getPersistentData().getBoolean("path_fixer") == false) {
						NpcScheduleFindPlaceProcedure.execute(world, entity);
					} else {
						NpcSchdulePathFixerProcedure.execute(world, entity);
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("data merge entity @e[tag=SKYWIZA-npc_info_do,nbt={ForgeData:{npc_id:\"" + "" + entity.getPersistentData().getString("npc_id") + "\"}},limit=1] {CustomName:'{\"text\":\"" + entity.getPersistentData().getString("schedule_text")
							+ "\",\"color\":\"gray\"}'}"));
	}
}
