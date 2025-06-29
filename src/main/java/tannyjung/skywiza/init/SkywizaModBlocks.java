
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.block.VillageLocationBlock;
import tannyjung.skywiza.block.VillageInfoBlock;
import tannyjung.skywiza.block.VillageCenterBlock;
import tannyjung.skywiza.block.SpawnerRemoverBlock;
import tannyjung.skywiza.block.SpawnerBlock;
import tannyjung.skywiza.block.QuestBoardRemoverBlock;
import tannyjung.skywiza.block.QuestBoardBlock;
import tannyjung.skywiza.block.NpcBlockBlock;
import tannyjung.skywiza.block.LootChestRemoverBlock;
import tannyjung.skywiza.block.LootChestBlock;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class SkywizaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SkywizaMod.MODID);
	public static final RegistryObject<Block> LOOT_CHEST_REMOVER = REGISTRY.register("loot_chest_remover", () -> new LootChestRemoverBlock());
	public static final RegistryObject<Block> LOOT_CHEST = REGISTRY.register("loot_chest", () -> new LootChestBlock());
	public static final RegistryObject<Block> QUEST_BOARD_REMOVER = REGISTRY.register("quest_board_remover", () -> new QuestBoardRemoverBlock());
	public static final RegistryObject<Block> SPAWNER = REGISTRY.register("spawner", () -> new SpawnerBlock());
	public static final RegistryObject<Block> QUEST_BOARD = REGISTRY.register("quest_board", () -> new QuestBoardBlock());
	public static final RegistryObject<Block> NPC_BLOCK = REGISTRY.register("npc_block", () -> new NpcBlockBlock());
	public static final RegistryObject<Block> SPAWNER_REMOVER = REGISTRY.register("spawner_remover", () -> new SpawnerRemoverBlock());
	public static final RegistryObject<Block> VILLAGE_INFO = REGISTRY.register("village_info", () -> new VillageInfoBlock());
	public static final RegistryObject<Block> VILLAGE_CENTER = REGISTRY.register("village_center", () -> new VillageCenterBlock());
	public static final RegistryObject<Block> VILLAGE_LOCATION = REGISTRY.register("village_location", () -> new VillageLocationBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
