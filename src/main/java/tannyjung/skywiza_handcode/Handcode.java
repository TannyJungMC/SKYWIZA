package tannyjung.skywiza_handcode;

import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.server.ServerLifecycleEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import tannyjung.core.GameUtils;
import tannyjung.skywiza.SkywizaMod;
import tannyjung.skywiza_handcode.config.ConfigMain;
import tannyjung.skywiza_handcode.config.ConfigRepairAll;
import tannyjung.skywiza_handcode.systems.Loop;
import tannyjung.skywiza_handcode.systems.world_gen.FeatureLast;

@Mod.EventBusSubscriber
public class Handcode {

	// ----------------------------------------------------------------------------------------------------

	public static double data_structure_version = 1.0;
	public static String tanny_pack_version = "Alpha";

	// ----------------------------------------------------------------------------------------------------

	public static String directory_game = FMLPaths.GAMEDIR.get().toString();
	public static String directory_config = directory_game + "/config/skywiza";
	public static String directory_world_data = directory_game + "/saves/skywiza-error/directory_world_data";
	public static String directory_world_generated = directory_game + "/saves/skywiza-error/directory_world_generated";
	public static String tanny_pack_version_name = ""; // Make this because version can swap to "WIP" by config

	public static boolean world_active = false;
	public static String overlay_world_gen_step = "";

	public Handcode () {}

	public static void startGame () {

		new Handcode();

		// Basic Registries
		{

			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

			DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, SkywizaMod.MODID);
			REGISTRY.register("spawner", FeatureLast::new);
			REGISTRY.register(bus);

		}

		ConfigRepairAll.start();
		ConfigMain.apply();

	}

	@SubscribeEvent
	public static void worldAboutToStart (ServerAboutToStartEvent event) {

		world_active = true;
		SkywizaMod.LOGGER.info("Turned ON world systems");

		String world_path = String.valueOf(event.getServer().getWorldPath(new LevelResource(".")));
		directory_world_data = world_path + "/data/skywiza";
		directory_world_generated = world_path + "/generated/skywiza";

		// ConfigMain.repairAll(null);
		// ConfigMain.apply(null);

	}

	@SubscribeEvent
	public static void worldStarted (ServerStartedEvent event) {

		LevelAccessor level_accessor = event.getServer().overworld();

		if (level_accessor instanceof ServerLevel level_server) {

			Loop.start(level_accessor, level_server);

		}

	}

	@SubscribeEvent
	public static void worldStopped (ServerStoppingEvent event) {

		world_active = false;
		SkywizaMod.LOGGER.info("Turned OFF world systems");

	}


}
