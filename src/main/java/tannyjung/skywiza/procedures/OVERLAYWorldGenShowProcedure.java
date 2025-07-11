package tannyjung.skywiza.procedures;

import tannyjung.skywiza_handcode.Handcode;

public class OVERLAYWorldGenShowProcedure {
	public static boolean execute() {
		return !(Handcode.overlay_world_gen_step).equals("");
	}
}