package tannyjung.skywiza_handcode.misc;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class Misc {

	public static void sendChatMessage (LevelAccessor level, String target, String color, String text) {

		if (level == null) {

			return;

		}

		level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, level.getServer().overworld(), 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(), "tellraw " + target + " [{\"text\":\"" + text + "\",\"color\":\"" + color + "\"}]");

	}

	public static void runCommand (LevelAccessor level, double posX, double posY, double posZ, String command) {

		if (level == null) {

			return;

		}

		level.getServer().execute(() -> {

			level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(posX, posY, posZ), Vec2.ZERO, level.getServer().overworld(), 4, "", Component.literal(""), level.getServer(), null).withSuppressedOutput(), command);

		});

	}

	public static boolean testConfigBiome (Holder<Biome> biome_center, String config_value) {

		boolean return_logic = false;

		{

			String biome_centerID = Misc.biomeToBiomeID(biome_center);

			for (String split : config_value.split(" / ")) {

				return_logic = true;

				for (String split2 : split.split(" & ")) {

					String split_get = split2.replaceAll("[#!]", "");

					{

						if (split2.contains("#") == false) {

							if (biome_centerID.equals(split_get) == false) {

								return_logic = false;

							}

						} else {

							if (Misc.isBiomeTaggedAs(biome_center, split_get) == false) {

								return_logic = false;

							}

						}

						if (split2.contains("!") == true) {

							return_logic = !return_logic;

						}

					}

					if (return_logic == false) {

						break;

					}

				}

				if (return_logic == true) {

					break;

				}

			}

		}

		return return_logic;

	}

	public static boolean testConfigGroundBlock (BlockState ground_block, String config_value) {

		boolean return_logic = false;

		{

			for (String split : config_value.split(" / ")) {

				return_logic = true;

				for (String split2 : split.split(" & ")) {

					String split_get = split2.replaceAll("[#!]", "");

					{

						if (split2.contains("#") == false) {

							if (ForgeRegistries.BLOCKS.getKey(ground_block.getBlock()).toString().equals(split_get) == false) {

								return_logic = false;

							}

						} else {

							if (Misc.isBlockTaggedAs(ground_block, split_get) == false) {

								return_logic = false;

							}

						}

						if (split2.contains("!") == true) {

							return_logic = !return_logic;

						}

					}

					if (return_logic == false) {

						break;

					}

				}

				if (return_logic == true) {

					break;

				}

			}

		}

		return return_logic;

	}

	public static boolean isBlockTaggedAs (BlockState block, String tag) {

		return block.is(BlockTags.create(new ResourceLocation(tag)));

	}

	public static BlockState textToBlock (String id) {

		BlockState return_block = Blocks.AIR.defaultBlockState();

		{
			try {

				return_block = BlockStateParser.parseForBlock(BuiltInRegistries.BLOCK.asLookup(), id, true).blockState();

			} catch (Exception e) {

				return_block = Blocks.AIR.defaultBlockState();

			}

		}

		return return_block;

	}

	public static CompoundTag textToNBT (String id) {

		CompoundTag return_NBT = new CompoundTag();

		{

            try {

				return_NBT = TagParser.parseTag(id.substring(id.indexOf("{")));

            } catch (Exception ignored) {



			}

        }

		return return_NBT;

	}

	public static String blockToText (BlockState block) {

		String return_text = "";

		{

			return_text = block.toString();
			return_text = return_text.replace("Block{", "").replace("}", "");

		}

		return return_text;

	}

	public static String blockToTextID (BlockState block) {

		String return_text = "";

		{

			return_text = blockToText(block);

			if (return_text.endsWith("]") == true) {

				return_text = return_text.substring(0, return_text.indexOf("["));

			}

		}

		return return_text;

	}

	public static String biomeToBiomeID (Holder<Biome> biome) {

		String return_text = "";

		{

			return_text = biome.toString().replace("Reference{ResourceKey[minecraft:worldgen/biome / ", "");
			return_text = return_text.substring(0, return_text.indexOf("]"));

		}

		return return_text;

	}

	public static boolean isBiomeTaggedAs (Holder<Biome> biome, String tag) {

		boolean return_logic = false;

		{

			try {

				return_logic = biome.is(TagKey.create(Registries.BIOME, new ResourceLocation(tag)));

			} catch (Exception ignored) {}

		}

		return return_logic;

	}

}