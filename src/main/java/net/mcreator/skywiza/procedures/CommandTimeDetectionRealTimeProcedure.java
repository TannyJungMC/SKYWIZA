package net.mcreator.skywiza.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Calendar;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class CommandTimeDetectionRealTimeProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		boolean variable_logic = false;
		double variable_number = 0;
		double variable_number2 = 0;
		double variable_number3 = 0;
		variable_logic = true;
		if (true) {
			if (!((StringArgumentType.getString(arguments, "from_hhmm")).substring(0, 2)).equals("--") && !((StringArgumentType.getString(arguments, "to_hhmm")).substring(0, 2)).equals("--")) {
				if (true) {
					variable_number = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "from_hhmm")).substring(0, 2));
					variable_number2 = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "to_hhmm")).substring(0, 2));
					variable_number3 = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
					if (variable_number <= variable_number2) {
						if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					} else {
						if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					}
				}
			}
			if (!((StringArgumentType.getString(arguments, "from_hhmm")).substring(2, 4)).equals("--") && !((StringArgumentType.getString(arguments, "to_hhmm")).substring(2, 4)).equals("--")) {
				if (true) {
					variable_number = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "from_hhmm")).substring(2, 4));
					variable_number2 = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "to_hhmm")).substring(2, 4));
					variable_number3 = Calendar.getInstance().get(Calendar.MINUTE);
					if (variable_number <= variable_number2) {
						if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					} else {
						if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					}
				}
			}
		}
		if (!(StringArgumentType.getString(arguments, "from_day")).equals("-") && !(StringArgumentType.getString(arguments, "to_day")).equals("-")) {
			if ((StringArgumentType.getString(arguments, "from_day")).equals("sunday")) {
				variable_number = 1;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("monday")) {
				variable_number = 2;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("tuesday")) {
				variable_number = 3;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("wednesday")) {
				variable_number = 4;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("thursday")) {
				variable_number = 5;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("friday")) {
				variable_number = 6;
			} else if ((StringArgumentType.getString(arguments, "from_day")).equals("saturday")) {
				variable_number = 7;
			}
			if ((StringArgumentType.getString(arguments, "to_day")).equals("sunday")) {
				variable_number2 = 1;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("monday")) {
				variable_number2 = 2;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("tuesday")) {
				variable_number2 = 3;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("wednesday")) {
				variable_number2 = 4;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("thursday")) {
				variable_number2 = 5;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("friday")) {
				variable_number2 = 6;
			} else if ((StringArgumentType.getString(arguments, "to_day")).equals("saturday")) {
				variable_number2 = 7;
			}
			variable_number3 = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
			if (variable_number <= variable_number2) {
				if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
					variable_logic = false;
				}
			} else {
				if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
					variable_logic = false;
				}
			}
		}
		if (true) {
			if (!((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(0, 2)).equals("--") && !((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(0, 2)).equals("--")) {
				if (true) {
					variable_number = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(0, 2));
					variable_number2 = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(0, 2));
					variable_number3 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					if (variable_number <= variable_number2) {
						if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					} else {
						if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					}
				}
			}
			if (!((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(2, 4)).equals("--") && !((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(2, 4)).equals("--")) {
				if (true) {
					variable_number = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(2, 4));
					variable_number2 = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(2, 4));
					variable_number3 = Calendar.getInstance().get(Calendar.MONTH);
					if (variable_number <= variable_number2) {
						if (!(variable_number3 >= variable_number) || !(variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					} else {
						if (!(variable_number3 >= variable_number && variable_number3 >= variable_number2 || variable_number3 <= variable_number && variable_number3 <= variable_number2)) {
							variable_logic = false;
						}
					}
				}
			}
			if (!((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(4, 8)).equals("----") && !((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(4, 8)).equals("----")) {
				if (!(Calendar.getInstance().get(Calendar.YEAR) >= new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((StringArgumentType.getString(arguments, "from_ddmmyyyy")).substring(4, 8))) || !(Calendar.getInstance().get(Calendar.YEAR) <= new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((StringArgumentType.getString(arguments, "to_ddmmyyyy")).substring(4, 8)))) {
					variable_logic = false;
				}
			}
		}
		if (variable_logic == true) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (new Object() {
								public String getMessage() {
									try {
										return MessageArgument.getMessage(arguments, "command").getString();
									} catch (CommandSyntaxException ignored) {
										return "";
									}
								}
							}).getMessage());
				}
			}
		}
	}
}
