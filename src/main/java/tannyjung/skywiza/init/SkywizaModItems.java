
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.skywiza.init;

import tannyjung.skywiza.item.WoodenCoinItem;
import tannyjung.skywiza.item.VillageManagerItem;
import tannyjung.skywiza.item.TxtStructureManagerItem;
import tannyjung.skywiza.item.TestingStickItem;
import tannyjung.skywiza.item.StoneCoinItem;
import tannyjung.skywiza.item.SilverCoinItem;
import tannyjung.skywiza.item.QuestPaper72Item;
import tannyjung.skywiza.item.QuestPaper71Item;
import tannyjung.skywiza.item.QuestPaper63Item;
import tannyjung.skywiza.item.QuestPaper62Item;
import tannyjung.skywiza.item.QuestPaper61Item;
import tannyjung.skywiza.item.QuestPaper52Item;
import tannyjung.skywiza.item.QuestPaper51Item;
import tannyjung.skywiza.item.QuestPaper42Item;
import tannyjung.skywiza.item.QuestPaper41Item;
import tannyjung.skywiza.item.QuestPaper32Item;
import tannyjung.skywiza.item.QuestPaper31Item;
import tannyjung.skywiza.item.QuestPaper23Item;
import tannyjung.skywiza.item.QuestPaper22Item;
import tannyjung.skywiza.item.QuestPaper21Item;
import tannyjung.skywiza.item.QuestPaper18Item;
import tannyjung.skywiza.item.QuestPaper17Item;
import tannyjung.skywiza.item.QuestPaper16Item;
import tannyjung.skywiza.item.QuestPaper15Item;
import tannyjung.skywiza.item.QuestPaper14Item;
import tannyjung.skywiza.item.QuestPaper13Item;
import tannyjung.skywiza.item.QuestPaper12Item;
import tannyjung.skywiza.item.QuestPaper11Item;
import tannyjung.skywiza.item.PathManagerItem;
import tannyjung.skywiza.item.GoldenCoinItem;
import tannyjung.skywiza.item.DiamondCoinItem;
import tannyjung.skywiza.item.CoinPouchItem;
import tannyjung.skywiza.item.CityGeneratorManagerItem;
import tannyjung.skywiza.SkywizaMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class SkywizaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SkywizaMod.MODID);
	public static final RegistryObject<Item> GOLDEN_COIN = REGISTRY.register("golden_coin", () -> new GoldenCoinItem());
	public static final RegistryObject<Item> SILVER_COIN = REGISTRY.register("silver_coin", () -> new SilverCoinItem());
	public static final RegistryObject<Item> WOODEN_COIN = REGISTRY.register("wooden_coin", () -> new WoodenCoinItem());
	public static final RegistryObject<Item> DIAMOND_COIN = REGISTRY.register("diamond_coin", () -> new DiamondCoinItem());
	public static final RegistryObject<Item> STONE_COIN = REGISTRY.register("stone_coin", () -> new StoneCoinItem());
	public static final RegistryObject<Item> QUEST_PAPER_11 = REGISTRY.register("quest_paper_11", () -> new QuestPaper11Item());
	public static final RegistryObject<Item> QUEST_PAPER_12 = REGISTRY.register("quest_paper_12", () -> new QuestPaper12Item());
	public static final RegistryObject<Item> QUEST_PAPER_13 = REGISTRY.register("quest_paper_13", () -> new QuestPaper13Item());
	public static final RegistryObject<Item> QUEST_PAPER_14 = REGISTRY.register("quest_paper_14", () -> new QuestPaper14Item());
	public static final RegistryObject<Item> QUEST_PAPER_15 = REGISTRY.register("quest_paper_15", () -> new QuestPaper15Item());
	public static final RegistryObject<Item> QUEST_PAPER_16 = REGISTRY.register("quest_paper_16", () -> new QuestPaper16Item());
	public static final RegistryObject<Item> QUEST_PAPER_21 = REGISTRY.register("quest_paper_21", () -> new QuestPaper21Item());
	public static final RegistryObject<Item> QUEST_PAPER_22 = REGISTRY.register("quest_paper_22", () -> new QuestPaper22Item());
	public static final RegistryObject<Item> QUEST_PAPER_31 = REGISTRY.register("quest_paper_31", () -> new QuestPaper31Item());
	public static final RegistryObject<Item> QUEST_PAPER_41 = REGISTRY.register("quest_paper_41", () -> new QuestPaper41Item());
	public static final RegistryObject<Item> QUEST_PAPER_51 = REGISTRY.register("quest_paper_51", () -> new QuestPaper51Item());
	public static final RegistryObject<Item> QUEST_PAPER_32 = REGISTRY.register("quest_paper_32", () -> new QuestPaper32Item());
	public static final RegistryObject<Item> QUEST_PAPER_61 = REGISTRY.register("quest_paper_61", () -> new QuestPaper61Item());
	public static final RegistryObject<Item> QUEST_PAPER_62 = REGISTRY.register("quest_paper_62", () -> new QuestPaper62Item());
	public static final RegistryObject<Item> QUEST_PAPER_71 = REGISTRY.register("quest_paper_71", () -> new QuestPaper71Item());
	public static final RegistryObject<Item> QUEST_PAPER_42 = REGISTRY.register("quest_paper_42", () -> new QuestPaper42Item());
	public static final RegistryObject<Item> LOOT_CHEST_REMOVER = block(SkywizaModBlocks.LOOT_CHEST_REMOVER);
	public static final RegistryObject<Item> LOOT_CHEST = block(SkywizaModBlocks.LOOT_CHEST);
	public static final RegistryObject<Item> QUEST_BOARD_REMOVER = block(SkywizaModBlocks.QUEST_BOARD_REMOVER);
	public static final RegistryObject<Item> SPAWNER = block(SkywizaModBlocks.SPAWNER);
	public static final RegistryObject<Item> QUEST_BOARD = block(SkywizaModBlocks.QUEST_BOARD);
	public static final RegistryObject<Item> QUEST_PAPER_72 = REGISTRY.register("quest_paper_72", () -> new QuestPaper72Item());
	public static final RegistryObject<Item> QUEST_PAPER_23 = REGISTRY.register("quest_paper_23", () -> new QuestPaper23Item());
	public static final RegistryObject<Item> QUEST_PAPER_17 = REGISTRY.register("quest_paper_17", () -> new QuestPaper17Item());
	public static final RegistryObject<Item> QUEST_PAPER_18 = REGISTRY.register("quest_paper_18", () -> new QuestPaper18Item());
	public static final RegistryObject<Item> QUEST_PAPER_63 = REGISTRY.register("quest_paper_63", () -> new QuestPaper63Item());
	public static final RegistryObject<Item> QUEST_PAPER_52 = REGISTRY.register("quest_paper_52", () -> new QuestPaper52Item());
	public static final RegistryObject<Item> NPC_SPAWN_EGG = REGISTRY.register("npc_spawn_egg", () -> new ForgeSpawnEggItem(SkywizaModEntities.NPC, -6122911, -2041420, new Item.Properties()));
	public static final RegistryObject<Item> NPC_BLOCK = block(SkywizaModBlocks.NPC_BLOCK);
	public static final RegistryObject<Item> VILLAGE_MANAGER = REGISTRY.register("village_manager", () -> new VillageManagerItem());
	public static final RegistryObject<Item> COIN_POUCH = REGISTRY.register("coin_pouch", () -> new CoinPouchItem());
	public static final RegistryObject<Item> SPAWNER_REMOVER = block(SkywizaModBlocks.SPAWNER_REMOVER);
	public static final RegistryObject<Item> VILLAGE_INFO = block(SkywizaModBlocks.VILLAGE_INFO);
	public static final RegistryObject<Item> VILLAGE_CENTER = block(SkywizaModBlocks.VILLAGE_CENTER);
	public static final RegistryObject<Item> VILLAGE_LOCATION = block(SkywizaModBlocks.VILLAGE_LOCATION);
	public static final RegistryObject<Item> PATH_MANAGER = REGISTRY.register("path_manager", () -> new PathManagerItem());
	public static final RegistryObject<Item> TXT_STRUCTURE_MANAGER = REGISTRY.register("txt_structure_manager", () -> new TxtStructureManagerItem());
	public static final RegistryObject<Item> TESTING_STICK = REGISTRY.register("testing_stick", () -> new TestingStickItem());
	public static final RegistryObject<Item> CITY_GENERATOR_MANAGER = REGISTRY.register("city_generator_manager", () -> new CityGeneratorManagerItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
