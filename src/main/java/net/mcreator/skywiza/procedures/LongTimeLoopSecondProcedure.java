package net.mcreator.skywiza.procedures;

import org.checkerframework.checker.units.qual.A;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.util.Calendar;

public class LongTimeLoopSecondProcedure {
	public static void execute(LevelAccessor world) {
		double world_time = 0;
		double hour = 0;
		double minute = 0;
		double A = 0;
		double B = 0;
		double second = 0;
		if (true) {
			world_time = world.dayTime();
			world_time = world_time + SkywizaModVariables.MapVariables.get(world).long_time_offset;
			hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			hour = hour * 3600;
			minute = Calendar.getInstance().get(Calendar.MINUTE);
			minute = minute * 60;
			second = Calendar.getInstance().get(Calendar.SECOND);
		}
		A = (world_time / 24000 - Math.floor(world_time / 24000)) * 24000;
		B = ((hour + minute + second) / (SkywizaModVariables.MapVariables.get(world).long_time_custom * 60) - Math.floor((hour + minute + second) / (SkywizaModVariables.MapVariables.get(world).long_time_custom * 60))) * 24000;
		if (world_time >= SkywizaModVariables.MapVariables.get(world).long_time_offset) {
			world_time = world_time - SkywizaModVariables.MapVariables.get(world).long_time_offset;
		} else {
			world_time = SkywizaModVariables.MapVariables.get(world).long_time_offset - world_time;
		}
		if (B != 0) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world_time + B - A));
		} else {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world_time + 24000 - A));
		}
	}
}
