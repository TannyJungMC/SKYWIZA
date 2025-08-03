package tannyjung.skywiza_handcode.systems.world_gen;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import tannyjung.core.GameUtils;
import tannyjung.core.OutsideUtils;
import tannyjung.skywiza_handcode.Handcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WorldGenSpawner {

    public static void start (LevelAccessor level_accessor, ChunkPos chunk_pos) {

        File file = new File(Handcode.directory_config + "/config_world_gen_spawner.txt");

        if (file.exists() == true && file.isDirectory() == false) {

            int posX = chunk_pos.x * 16;
            int posZ = chunk_pos.z * 16;
            int posY = level_accessor.getHeight(Heightmap.Types.MOTION_BLOCKING, posX, posZ);
            BlockPos pos = new BlockPos(posX, posY, posZ);

            boolean start_test = false;
            boolean skip = true;
            String id = "";

            // Read Placement Config
            {

                try { BufferedReader buffered_reader = new BufferedReader(new FileReader(file), 65536); String read_all = ""; while ((read_all = buffered_reader.readLine()) != null) {

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

                                                if (GameUtils.outside.configTestBiome(level_accessor.getBiome(pos), read_all.replace("biome = ", "")) == false) {

                                                    skip = true;

                                                }

                                            }

                                        } else if (read_all.startsWith("ground_block = ") == true) {

                                            {

                                                if (GameUtils.outside.configTestBlock(level_accessor.getBlockState(new BlockPos(posX, posY - 1, posZ)), read_all.replace("ground_block = ", "")) == false) {

                                                    skip = true;

                                                }

                                            }

                                        } else if (read_all.startsWith("rarity = ") == true) {

                                            {

                                                if (Math.random() >= Double.parseDouble(read_all.replace("rarity = ", "")) * 0.01) {

                                                    skip = true;

                                                }

                                            }

                                            if (skip == false) {

                                                place(level_accessor, id, pos);
                                                break;

                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }

                } buffered_reader.close(); } catch (Exception exception) { OutsideUtils.exception(new Exception(), exception); }

            }

        }

    }

    private static void place (LevelAccessor level_accessor, String id, BlockPos pos) {

        File file = new File(Handcode.directory_config + "/custom_packs/.organized/spawner/" + id + ".txt");

        if (file.exists() == true && file.isDirectory() == false) {

            StringBuilder get = new StringBuilder();

            // Get Data
            {

                try { BufferedReader buffered_reader = new BufferedReader(new FileReader(file), 65536); String read_all = ""; while ((read_all = buffered_reader.readLine()) != null) {

                    {

                        get.append(read_all);

                    }

                } buffered_reader.close(); } catch (Exception exception) { OutsideUtils.exception(new Exception(), exception); }

            }

            String data = GameUtils.block.textFromItemText(get.substring("give @p ".length()));
            level_accessor.setBlock(pos, GameUtils.block.fromText(data), 2);
            level_accessor.getBlockEntity(pos).load(GameUtils.nbt.textToCompoundTag(data));
            level_accessor.scheduleTick(pos, level_accessor.getBlockState(pos).getBlock(), 20);

        }

    }

}