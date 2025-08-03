package tannyjung.skywiza_handcode.config;

import tannyjung.core.OutsideUtils;
import tannyjung.skywiza_handcode.Handcode;
import tannyjung.core.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ConfigMain {

	public static boolean auto_check_update = false;
	public static boolean auto_update = false;
	public static boolean wip_version = false;
	
	public static double region_scan_percentage = 0.0;
	public static int surrounding_area_detection_size = 0;

	public static void repair () {

		StringBuilder write = new StringBuilder();

		{

			write.append("""
			- To apply this config, run this command [ /tanshugetrees config apply ] or restart the world.
			- To repair missing values, run this command [ /tanshugetrees config repair ] or restart the world.
			
			----------------------------------------------------------------------------------------------------
			TannyJung's Tree Pack
			----------------------------------------------------------------------------------------------------
	
			auto_check_update = true
			| Check for the new update from GitHub every time the world starts
			| Default is true
	
			auto_update = false
			| Auto update the pack every time the world starts, if there's a new update from GitHub. To use this feature, the "auto_check_update" config must be enable.
			| Default is false
	
			wip_version = false
			| Use WIP version instead of release version. It's development version before full version, may contain new trees that still work in progress. Warning that not recommended for game play.
			| Default is false
	
			----------------------------------------------------------------------------------------------------
			""");

		}

		FileManager.writeConfigTXT(Handcode.directory_config + "/config.txt", write.toString());

	}

	public static void apply () {

		auto_check_update = Get.logic("auto_check_update");
		auto_update = Get.logic("auto_update");
		wip_version = Get.logic("wip_version");

		// WIP Version Applying
		{

			if (wip_version == true) {

				Handcode.tanny_pack_version_name = "WIP";

			} else {

				Handcode.tanny_pack_version_name = Handcode.tanny_pack_version;

			}

		}

		region_scan_percentage = Get.numberDouble("region_scan_percentage");
		surrounding_area_detection_size = Get.numberInt("surrounding_area_detection_size");

	}
	
	private static class Get {

		private static boolean logic (String name) {

			boolean return_logic = false;
			String get = read(name);

			if (get.equals("") == false) {

				return_logic = Boolean.parseBoolean(get);

			}

			return return_logic;

		}

		private static int numberInt (String name) {

			int return_number = 0;
			String get = read(name);

			if (get.equals("") == false) {

				return_number = Integer.parseInt(get);

			}

			return return_number;

		}

		private static double numberDouble (String name) {

			double return_number = 0.0;
			String get = read(name);

			if (get.equals("") == false) {

				return_number = Double.parseDouble(get);

			}

			return return_number;

		}

		private static String read (String name) {

			String return_text = "";
			name = name + " = ";

			{

				File file = new File(Handcode.directory_config + "/config.txt");

				{

					try { BufferedReader buffered_reader = new BufferedReader(new FileReader(file), 65536); String read_all = ""; while ((read_all = buffered_reader.readLine()) != null) {

						{

							if (read_all.startsWith("|") == false) {

								if (read_all.startsWith(name) == true) {

									return_text = read_all.replace(name, "");
									break;

								}

							}

						}

					} buffered_reader.close(); } catch (Exception exception) { OutsideUtils.exception(new Exception(), exception); }

				}

			}

			return return_text;

		}

	}
	
}