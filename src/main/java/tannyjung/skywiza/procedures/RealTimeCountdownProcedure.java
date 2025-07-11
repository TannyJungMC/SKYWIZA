package tannyjung.skywiza.procedures;

import net.minecraft.world.entity.Entity;

import java.util.Calendar;

public class RealTimeCountdownProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double reset_time_text_minute = 0;
		double reset_time_text_hour = 0;
		double reset_time_text_second = 0;
		double reset_time_text_day = 0;
		if (true) {
			entity.getPersistentData().putDouble("reset_time",
					(60 * entity.getPersistentData().getDouble("reset_time_minute") + 3600 * entity.getPersistentData().getDouble("reset_time_hour") + 86400 * entity.getPersistentData().getDouble("reset_time_day")));
			entity.getPersistentData().putDouble("reset_time_test", (Calendar.getInstance().get(Calendar.SECOND) + 60 * Calendar.getInstance().get(Calendar.MINUTE) + 3600 * Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
					+ 86400 * Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + entity.getPersistentData().getDouble("reset_time_offset")));
			if (entity.getPersistentData().getDouble("reset_time_test") >= entity.getPersistentData().getDouble("reset_time_next")) {
				entity.getPersistentData().putDouble("reset_time_next", (Math.floor((entity.getPersistentData().getDouble("reset_time_test") + entity.getPersistentData().getDouble("reset_time")) / entity.getPersistentData().getDouble("reset_time"))
						* entity.getPersistentData().getDouble("reset_time")));
				entity.getPersistentData().putBoolean("reset_time_run", true);
			}
		}
		if (!("Calculation").isEmpty()) {
			if (true) {
				reset_time_text_second = 60 * ((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 60
						- Math.floor((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 60)) - 1;
				if (reset_time_text_second < 0) {
					reset_time_text_second = 0;
				}
				if (entity.getPersistentData().getDouble("reset_time") >= 60) {
					reset_time_text_minute = Math.floor(((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 3600
							- Math.floor((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 3600)) * 60);
				}
				if (entity.getPersistentData().getDouble("reset_time") >= 3600) {
					reset_time_text_hour = Math.floor(((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 86400
							- Math.floor((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 86400)) * 24);
				}
				if (entity.getPersistentData().getDouble("reset_time") >= 86400) {
					reset_time_text_day = Math.floor((entity.getPersistentData().getDouble("reset_time_next") - entity.getPersistentData().getDouble("reset_time_test")) / 86400);
				}
			}
		}
		if (!("Display").isEmpty()) {
			if (entity.getPersistentData().getDouble("reset_time") <= 60) {
				entity.getPersistentData().putString("reset_time_text", ((new java.text.DecimalFormat("##.##").format(reset_time_text_second)).replace(".0", "") + "s"));
			} else if (entity.getPersistentData().getDouble("reset_time") <= 3600) {
				entity.getPersistentData().putString("reset_time_text",
						((new java.text.DecimalFormat("##.##").format(reset_time_text_minute)).replace(".0", "") + "m " + (new java.text.DecimalFormat("##.##").format(reset_time_text_second)).replace(".0", "") + "s"));
			} else if (entity.getPersistentData().getDouble("reset_time") <= 86400) {
				entity.getPersistentData().putString("reset_time_text", ((new java.text.DecimalFormat("##.##").format(reset_time_text_hour)).replace(".0", "") + "h "
						+ (new java.text.DecimalFormat("##.##").format(reset_time_text_minute)).replace(".0", "") + "m " + (new java.text.DecimalFormat("##.##").format(reset_time_text_second)).replace(".0", "") + "s"));
			} else {
				entity.getPersistentData().putString("reset_time_text",
						((new java.text.DecimalFormat("##.##").format(reset_time_text_day)).replace(".0", "") + "d " + (new java.text.DecimalFormat("##.##").format(reset_time_text_hour)).replace(".0", "") + "h "
								+ (new java.text.DecimalFormat("##.##").format(reset_time_text_minute)).replace(".0", "") + "m " + (new java.text.DecimalFormat("##.##").format(reset_time_text_second)).replace(".0", "") + "s"));
			}
		}
	}
}