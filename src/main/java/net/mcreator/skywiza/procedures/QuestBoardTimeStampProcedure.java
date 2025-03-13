package net.mcreator.skywiza.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.skywiza.network.SkywizaModVariables;

import java.util.Calendar;

public class QuestBoardTimeStampProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String day_text = "";
		String month_text = "";
		String year_text = "";
		double repeat = 0;
		double day = 0;
		double month = 0;
		double year = 0;
		double time_stamp_day = 0;
		if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("sunday")) {
			time_stamp_day = 1;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("monday")) {
			time_stamp_day = 2;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("tuesday")) {
			time_stamp_day = 3;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("wednesday")) {
			time_stamp_day = 4;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("thursday")) {
			time_stamp_day = 5;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("friday")) {
			time_stamp_day = 6;
		} else if ((SkywizaModVariables.MapVariables.get(world).quest_board_time_stamp).equals("saturday")) {
			time_stamp_day = 7;
		}
		if (true) {
			day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			month = Calendar.getInstance().get(Calendar.MONTH);
			year = Calendar.getInstance().get(Calendar.YEAR);
			if (time_stamp_day >= Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
				day = day + time_stamp_day - Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
			} else {
				day = day + (7 + time_stamp_day) - Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
			}
			month = month + 1;
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if (day > 31) {
					day = day - 31;
					month = month + 1;
					if (month > 12) {
						month = 1;
					}
				}
			} else if (month == 2) {
				if ((year - 4) - Math.floor(year - 4) == 0) {
					if (day > 29) {
						day = day - 29;
						month = month + 1;
					}
				} else {
					if (day > 28) {
						day = day - 28;
						month = month + 1;
					}
				}
			} else {
				if (day > 30) {
					day = day - 30;
					month = month + 1;
				}
			}
			if (day >= 10) {
				day_text = (new java.text.DecimalFormat("##.#").format(day)).replace(".0", "");
			} else {
				day_text = "0" + (new java.text.DecimalFormat("##.#").format(day)).replace(".0", "");
			}
			if (month >= 10) {
				month_text = (new java.text.DecimalFormat("##.#").format(month)).replace(".0", "");
			} else {
				month_text = "0" + (new java.text.DecimalFormat("##.#").format(month)).replace(".0", "");
			}
			if (year >= 10) {
				year_text = (new java.text.DecimalFormat("##.#").format(year)).replace(".0", "");
			} else {
				year_text = "0" + (new java.text.DecimalFormat("##.#").format(year)).replace(".0", "");
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("execute as @e[name=SKYWIZA-quest_board_paper] at @s run data modify entity @s HandItems[0].tag.display.Name set value \"{\\\"text\\\":\\\"End in " + "" + (day_text + "/" + month_text + "/" + year_text)
							+ "\\\",\\\"color\\\":\\\"dark_gray\\\"}\""));
		repeat = 0;
		for (int index0 = 0; index0 < 100; index0++) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						(("execute as @e[tag=SKYWIZA-npc_quest_board] at @s run data modify entity @s Offers.Recipes[" + (new java.text.DecimalFormat("##.#").format(repeat)).replace(".0", "") + "].buy.tag.display.Name set value '{\"text\":\"End in ")
								+ "" + (day_text + "/" + month_text + "/" + year_text) + "\",\"color\":\"dark_gray\"}'"));
			repeat = repeat + 1;
		}
	}
}
