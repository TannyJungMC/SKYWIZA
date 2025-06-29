package tannyjung.skywiza_handcode.world_gen.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import tannyjung.misc.FileManager;
import tannyjung.misc.GameUtils;
import tannyjung.misc.MiscUtils;
import tannyjung.skywiza.SkywizaMod;
import tannyjung.skywiza_handcode.Handcode;
import tannyjung.skywiza_handcode.misc.Misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Spawner {

    public static void start (FeaturePlaceContext <NoneFeatureConfiguration> context) {

        WorldGenLevel world_gen = context.level();
        File file = new File(Handcode.directory_config + "/config_placement.txt");

        if (file.exists() == true) {

            int posX = context.origin().getX();
            int posZ = context.origin().getZ();
            int posY = world_gen.getHeight(Heightmap.Types.MOTION_BLOCKING, posX, posZ);
            BlockPos pos = new BlockPos(posX, posY, posZ);

            boolean start_test = false;
            boolean skip = true;
            String id = "";

            // Read / Test / Get Values
            {

                try { BufferedReader buffered_reader = new BufferedReader(new FileReader(file)); String read_all = ""; while ((read_all = buffered_reader.readLine()) != null) {

                    {

                        if (read_all.equals("") == false) {

                            if (start_test == false) {

                                if (read_all.startsWith("---") == true) {

                                    start_test = true;

                                }

                            } else {

                                if (read_all.startsWith("[") == true) {

                                    if (read_all.startsWith("[INCOMPATIBLE] ") == true) {

                                        skip = true;

                                    } else {

                                        // Reset The Test
                                        {

                                            id = read_all.substring(read_all.indexOf("]") + 2).replace(" > ", "/");
                                            skip = false;

                                        }

                                    }

                                } else {

                                    if (skip == false) {

                                        if (read_all.startsWith("world_gen = ") == true) {

                                            {

                                                if (read_all.replace("world_gen = ", "").equals("true") == false) {

                                                    skip = true;

                                                }

                                            }

                                        } else if (read_all.startsWith("biome = ") == true) {

                                            {

                                                if (MiscUtils.configTestBiome(world_gen.getBiome(pos), read_all.replace("biome = ", "")) == false) {

                                                    skip = true;

                                                }

                                            }

                                        } else if (read_all.startsWith("ground_block = ") == true) {

                                            {

                                                if (MiscUtils.configTestBlock(world_gen.getBlockState(new BlockPos(posX, posY - 1, posZ)), read_all.replace("ground_block = ", "")) == false) {

                                                    skip = true;

                                                }

                                            }

                                        } else if (read_all.startsWith("rarity = ") == true) {

                                            {

                                                if (Math.random() >= Double.parseDouble(read_all.replace("rarity = ", "")) * 0.01) {

                                                    skip = true;

                                                }

                                            }

                                            // If it not skips that tree to the end of test, it will run this.
                                            if (skip == false) {

                                                break;

                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                } buffered_reader.close(); } catch (Exception e) { SkywizaMod.LOGGER.error(e.getMessage()); }

            }

            if (skip == false) {

                String block = """
                        skywiza:spawner{ForgeData:{debug_mode:false,name:"Day Guard (Lv.5)",name_color:"red",entity_id:"minecraft:skeleton",max_health:100,group_count:5,distance_back:20,respawn_random_radius:1,respawn_random_height:0,reset_time_minute:0,reset_time_hour:1,reset_time_day:0,reset_time_offset:0,attribute_extra:"",nbt_extra:"",left_hand_drop_chance:0.1,right_hand_drop_chance:0.1,helmet_drop_chance:0.1,chestplate_drop_chance:0.1,leggings_drop_chance:0.1,boots_drop_chance:0.1,left_hand_id:"minecraft:shield",left_hand_name:"",left_hand_price:"",left_hand_extra:"",right_hand_id:"minecraft:iron_sword",right_hand_name:"",right_hand_price:"",right_hand_extra:"",helmet_id:"minecraft:iron_helmet",helmet_name:"",helmet_price:"",helmet_extra:"",chestplate_id:"minecraft:iron_chestplate",chestplate_name:"",chestplate_price:"",chestplate_extra:"",leggings_id:"minecraft:iron_leggings",leggings_name:"",leggings_price:"",leggings_extra:"",boots_id:"minecraft:iron_boots",boots_name:"",boots_price:"",boots_extra:"",is_npc:false,job:"Unemployed",schedule1_at:"Bed",schedule1_from:12000,schedule1_to:20000,schedule1_text_find:"Looking For Bed",schedule1_text_go:"Going To Bed",schedule1_text_work:"Resting",schedule2_at:"Surveillance Point",schedule2_from:0,schedule2_to:6000,schedule2_text_find:"Looking For Surveillance Point",schedule2_text_go:"Patrolling",schedule2_text_work:"Watch Out For Enemies",schedule3_at:"Surveillance Point",schedule3_from:6000,schedule3_to:12000,schedule3_text_find:"Looking For Surveillance Point 2",schedule3_text_go:"Patrolling 2",schedule3_text_work:"Watch Out For Enemies 2"}}
                        """;

                world_gen.setBlock(pos, GameUtils.block.fromText(block), 2);
                world_gen.getBlockEntity(pos).load(GameUtils.NBT.block.textToCompoundTag(block));
                world_gen.scheduleTick(pos, world_gen.getBlockState(pos).getBlock(), 20);

            }

        }

    }

}