/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.block.entity.VillageLocationBlockEntity;
import tannyjung.skywiza.block.entity.VillageInfoBlockEntity;
import tannyjung.skywiza.block.entity.VillageCenterBlockEntity;
import tannyjung.skywiza.block.entity.SpawnerRemoverBlockEntity;
import tannyjung.skywiza.block.entity.SpawnerBlockEntity;
import tannyjung.skywiza.block.entity.QuestBoardBlockEntity;
import tannyjung.skywiza.block.entity.NpcBlockBlockEntity;
import tannyjung.skywiza.block.entity.LootChestBlockEntity;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

public class SkywizaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SkywizaMod.MODID);
	public static final RegistryObject<BlockEntityType<LootChestBlockEntity>> LOOT_CHEST = register("loot_chest", SkywizaModBlocks.LOOT_CHEST, LootChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<SpawnerBlockEntity>> SPAWNER = register("spawner", SkywizaModBlocks.SPAWNER, SpawnerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<QuestBoardBlockEntity>> QUEST_BOARD = register("quest_board", SkywizaModBlocks.QUEST_BOARD, QuestBoardBlockEntity::new);
	public static final RegistryObject<BlockEntityType<NpcBlockBlockEntity>> NPC_BLOCK = register("npc_block", SkywizaModBlocks.NPC_BLOCK, NpcBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<SpawnerRemoverBlockEntity>> SPAWNER_REMOVER = register("spawner_remover", SkywizaModBlocks.SPAWNER_REMOVER, SpawnerRemoverBlockEntity::new);
	public static final RegistryObject<BlockEntityType<VillageInfoBlockEntity>> VILLAGE_INFO = register("village_info", SkywizaModBlocks.VILLAGE_INFO, VillageInfoBlockEntity::new);
	public static final RegistryObject<BlockEntityType<VillageCenterBlockEntity>> VILLAGE_CENTER = register("village_center", SkywizaModBlocks.VILLAGE_CENTER, VillageCenterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<VillageLocationBlockEntity>> VILLAGE_LOCATION = register("village_location", SkywizaModBlocks.VILLAGE_LOCATION, VillageLocationBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}