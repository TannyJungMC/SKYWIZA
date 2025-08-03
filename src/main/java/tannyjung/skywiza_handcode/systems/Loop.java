package tannyjung.skywiza_handcode.systems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import tannyjung.core.GameUtils;
import tannyjung.skywiza.SkywizaMod;
import tannyjung.skywiza_handcode.Handcode;
import tannyjung.skywiza_handcode.systems.spawner.Spawner;

public class Loop {

    private static int second = 0;

    public static void start (LevelAccessor level_accessor, ServerLevel level_server) {

        if (Handcode.world_active == true) {

            SkywizaMod.queueServerWork(1, () -> {

                start(level_accessor, level_server);

            });

            // if (PackUpdate.install_pause_systems == false) {

            tick(level_accessor, level_server);

            // Second Loop
            {

                second = second + 1;

                if (second > 20) {

                    second = 0;
                    second(level_server);

                }

            }

        }

    }

    private static void tick (LevelAccessor level_accessor, ServerLevel level_server) {



    }

    private static void second (ServerLevel level_server) {

        Spawner.loopSecond(level_server);

    }

}
