package tannyjung.skywiza_handcode;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraftforge.event.server.ServerLifecycleEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import tannyjung.skywiza.SkywizaMod;
import tannyjung.skywiza_handcode.config.ConfigMain;
import tannyjung.skywiza_handcode.config.ConfigRepairAll;
import tannyjung.skywiza_handcode.world_gen.spawner.FeatureSpawner;

@Mod.EventBusSubscriber
public class Handcode {

	// --------------------------------------------------

	public static double mod_version = 1.0;
	public static String tanny_pack_version = "Alpha";

	// --------------------------------------------------

	public static String directory_game = FMLPaths.GAMEDIR.get().toString();
	public static String directory_config = directory_game + "/config/skywiza";
	public static String directory_world_data = directory_game + "/config/skywiza-error";
	public static String tanny_pack_version_name = "";

	public static int overlay_world_gen = 0;
	public static String overlay_world_gen_step = "";

	public static int grid_distance_set = 2;
	public static int grid_size = 1;

	public Handcode () {}

	public static void startGame () {

		new Handcode();

		// Basic Registries
		{

			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
			DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, SkywizaMod.MODID);

			REGISTRY.register("spawner", FeatureSpawner::new);

			REGISTRY.register(bus);

		}

		ConfigRepairAll.start(null);
		ConfigMain.apply(null);

	}

	@SubscribeEvent
	public static void startWorld (ServerLifecycleEvent event) {

		directory_world_data = event.getServer().getWorldPath(new LevelResource(".")) + "/data/skywiza";
		ConfigRepairAll.start(null);
		ConfigMain.apply(null);

	}

}
