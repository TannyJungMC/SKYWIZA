
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skywiza.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.skywiza.block.entity.VillageLocationBlockEntity;
import net.mcreator.skywiza.block.entity.VillageInfoBlockEntity;
import net.mcreator.skywiza.block.entity.VillageCenterBlockEntity;
import net.mcreator.skywiza.block.entity.SpawnerRemoverBlockEntity;
import net.mcreator.skywiza.block.entity.SpawnerBlockEntity;
import net.mcreator.skywiza.block.entity.QuestBoardBlockEntity;
import net.mcreator.skywiza.block.entity.NpcBlockBlockEntity;
import net.mcreator.skywiza.block.entity.LootChestBlockEntity;
import net.mcreator.skywiza.SkywizaMod;

public class SkywizaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SkywizaMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> LOOT_CHEST = register("loot_chest", SkywizaModBlocks.LOOT_CHEST, LootChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPAWNER = register("spawner", SkywizaModBlocks.SPAWNER, SpawnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> QUEST_BOARD = register("quest_board", SkywizaModBlocks.QUEST_BOARD, QuestBoardBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NPC_BLOCK = register("npc_block", SkywizaModBlocks.NPC_BLOCK, NpcBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPAWNER_REMOVER = register("spawner_remover", SkywizaModBlocks.SPAWNER_REMOVER, SpawnerRemoverBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VILLAGE_INFO = register("village_info", SkywizaModBlocks.VILLAGE_INFO, VillageInfoBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VILLAGE_CENTER = register("village_center", SkywizaModBlocks.VILLAGE_CENTER, VillageCenterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> VILLAGE_LOCATION = register("village_location", SkywizaModBlocks.VILLAGE_LOCATION, VillageLocationBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
