package tannyjung.skywiza_handcode.config;

import net.minecraft.world.level.LevelAccessor;
import tannyjung.core.GameUtils;
import tannyjung.skywiza_handcode.Handcode;
import tannyjung.core.FileManager;

public class ConfigRepairAll {

	public static void start () {

		// GameUtils.misc.sendChatMessage(level, "@a", "gray", "THT : Repaired The Config");

		FileManager.createFolder(Handcode.directory_world_data + "/regions");
		FileManager.createFolder(Handcode.directory_world_data + "/surface_test");
		FileManager.createFolder(Handcode.directory_world_data + "/place");
		FileManager.createFolder(Handcode.directory_world_data + "/generators");

		ConfigMain.repair();
		ConfigPlacement.start();

	}

}