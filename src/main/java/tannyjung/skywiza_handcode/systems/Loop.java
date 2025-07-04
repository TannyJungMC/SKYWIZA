package tannyjung.skywiza_handcode.systems;

import net.minecraft.world.level.LevelAccessor;
import tannyjung.core.GameUtils;
import tannyjung.skywiza.SkywizaMod;
import tannyjung.skywiza_handcode.systems.spawner.Spawner;

public class Loop {

    private static int second = 1;
    private static int living_tree_mechanics_tick = 0;

    public static void start (LevelAccessor level) {

        if (GameUtils.misc.playerCount(level) > 0) {

            SkywizaMod.queueServerWork(1, () -> {

                start(level);

            });

            tick(level);

            // Second Loop
            {

                second = second + 1;

                if (second > 20) {

                    second = 0;
                    second(level);

                }

            }

        }

    }

    private static void tick (LevelAccessor level) {



    }

    private static void second (LevelAccessor level) {

        Spawner.loopSecond(level);

    }

}
