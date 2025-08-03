package tannyjung.skywiza_handcode.systems.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import tannyjung.core.GameUtils;
import tannyjung.skywiza.procedures.RealTimeCountdownProcedure;
import tannyjung.skywiza.procedures.SpawnerRespawnProcedure;

public class Spawner {

    public static void loopSecond (ServerLevel level_server) {

        GameUtils.command.run(level_server, 0, 0, 0, "execute as @e[tag=SKYWIZA-spawner_center] at @s run SKYWIZA dev spawner loop_second");
        GameUtils.command.run(level_server, 0, 0, 0, "execute as @e[tag=SKYWIZA-spawner_mob] at @s run SKYWIZA dev spawner loop_second_mob");

    }

    public static void loopSecondCenter (LevelAccessor level_accessor, Entity entity) {

        if (level_accessor instanceof ServerLevel level_server) {

            if (GameUtils.block.isTaggedAs(level_accessor.getBlockState(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), "skywiza:passable_blocks") == false) {

                remove(level_server, entity);

            } else {

                // Countdown and Respawning
                {

                    RealTimeCountdownProcedure.execute(entity);
                    GameUtils.command.runEntity(entity, "execute as @e[tag=SKYWIZA-spawner_time,distance=..2] at @s run data merge entity @s {text:'{\"text\":\"respawn in " + GameUtils.nbt.entity.getText(entity, "reset_time_text") + "\",\"color\":\"gray\"}'}");

                    if (GameUtils.nbt.entity.getLogic(entity, "reset_time_run") == true) {

                        GameUtils.nbt.entity.setLogic(entity, "reset_time_run", false);
                        respawn(level_accessor, entity);

                    }

                }

            }

        }

    }

    public static void place (LevelAccessor level_accessor, double x, double y, double z) {

        if (level_accessor instanceof ServerLevel level_server) {

            BlockPos pos = new BlockPos((int) x, (int) y, (int) z);
            String id = pos.getX() + "/" + pos.getY() + "/" + pos.getZ();

            // Summon Center
            {

                GameUtils.command.run(level_server, x, y, z, "execute positioned ~0.5 ~0.5 ~0.5 run " + GameUtils.entity.summonCommand("marker", "SKYWIZA / SKYWIZA-spawner / SKYWIZA-spawner_center", "Spawner Center", ""));
                GameUtils.nbt.block.setText(level_accessor, pos, "spawner_id", id);
                GameUtils.command.run(level_server, x, y, z, "execute positioned ~0.5 ~0.5 ~0.5 run data modify entity @e[tag=SKYWIZA-spawner_center,distance=..1,limit=1] ForgeData set from block ~ ~ ~ ForgeData");

            }

            // Summon Displays
            {

                String display_name = "'{\"text\":\"" + GameUtils.nbt.block.getText(level_accessor, pos, "name") + "\",\"color\":\"" + GameUtils.nbt.block.getText(level_accessor, pos, "name_color") + "\"}'";
                GameUtils.command.run(level_server, x, y, z, "execute positioned ~0.5 ~1.5 ~0.5 run " + GameUtils.entity.summonCommand("text_display", "SKYWIZA / SKYWIZA-spawner / SKYWIZA-spawner_name", "Spawner Name", "ForgeData:{spawner_id:\"" + id + "\"},transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[1.0f,1.0f,1.0f]},billboard:vertical,text:" + display_name));
                GameUtils.command.run(level_server, x, y, z, "execute positioned ~0.5 ~1.2 ~0.5 run " + GameUtils.entity.summonCommand("text_display", "SKYWIZA / SKYWIZA-spawner / SKYWIZA-spawner_time", "Spawner Time", "ForgeData:{spawner_id:\"" + id + "\"},transformation:{left_rotation:[0f,0f,0f,1f],right_rotation:[0f,0f,0f,1f],translation:[0f,0f,0f],scale:[1.0f,1.0f,1.0f]},billboard:vertical,text:''"));

            }

            level_accessor.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);

        }

    }

    public static void remove (ServerLevel level_server, Entity entity) {

        String id = GameUtils.nbt.entity.getText(entity, "spawner_id");
        GameUtils.command.run(level_server, 0, 0, 0, "execute as @e[tag=SKYWIZA-spawner_mob,nbt={ForgeData:{spawner_id:\"" + id + "\"}}] at @s run data merge entity @s {HandDropChances:[0f,0f],ArmorDropChances:[0f,0f,0f,0f]}");
        GameUtils.command.run(level_server, 0, 0, 0, "kill @e[tag=SKYWIZA-spawner,nbt={ForgeData:{spawner_id:\"" + id + "\"}}]");

    }

    public static void respawn (LevelAccessor level_accessor, Entity entity) {

        System.out.println("RESPAWN");
        SpawnerRespawnProcedure.execute(level_accessor, 0, 0, 0, entity);

    }

}
