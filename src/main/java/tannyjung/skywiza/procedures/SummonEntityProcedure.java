package tannyjung.skywiza.procedures;

public class SummonEntityProcedure {
	public static String execute(String custom, String id, String name, String name_color, String tag) {
		if (custom == null || id == null || name == null || name_color == null || tag == null)
			return "";
		String variable_text = "";
		variable_text = "summon " + id + " ~ ~ ~ {Tags:[\"SKYWIZA\",\"SKYWIZA-" + tag.replace(" / ", "\",\"SKYWIZA-") + "\"]";
		if (!(name).equals("")) {
			variable_text = variable_text + "," + ("CustomName:'{\"text\":\"" + "" + name + "\",\"color\":\"" + name_color + "\"}'");
		}
		if (!(custom).equals("")) {
			variable_text = variable_text + "," + custom;
		}
		return variable_text + "}";
	}
}