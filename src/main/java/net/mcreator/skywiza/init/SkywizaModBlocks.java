
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skywiza.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.skywiza.block.VillageLocationBlock;
import net.mcreator.skywiza.block.VillageInfoBlock;
import net.mcreator.skywiza.block.VillageCenterBlock;
import net.mcreator.skywiza.block.SpawnerRemoverBlock;
import net.mcreator.skywiza.block.SpawnerBlock;
import net.mcreator.skywiza.block.QuestBoardRemoverBlock;
import net.mcreator.skywiza.block.QuestBoardBlock;
import net.mcreator.skywiza.block.NpcBlockBlock;
import net.mcreator.skywiza.block.LootChestRemoverBlock;
import net.mcreator.skywiza.block.LootChestBlock;
import net.mcreator.skywiza.SkywizaMod;

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
