
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.skywiza.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.skywiza.SkywizaMod;

public class SkywizaModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkywizaMod.MODID);
	public static final RegistryObject<CreativeModeTab> SKYWIZA_TAB = REGISTRY.register("skywiza_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.skywiza.skywiza_tab")).icon(() -> new ItemStack(SkywizaModItems.QUEST_PAPER_21.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SkywizaModItems.COIN_POUCH.get());
				tabData.accept(SkywizaModItems.GOLDEN_COIN.get());
				tabData.accept(SkywizaModItems.SILVER_COIN.get());
				tabData.accept(SkywizaModItems.WOODEN_COIN.get());
				tabData.accept(SkywizaModItems.DIAMOND_COIN.get());
				tabData.accept(SkywizaModItems.STONE_COIN.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_11.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_12.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_13.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_14.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_15.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_16.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_17.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_18.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_21.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_22.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_23.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_31.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_32.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_41.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_42.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_51.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_52.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_61.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_62.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_63.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_71.get());
				tabData.accept(SkywizaModItems.QUEST_PAPER_72.get());
				tabData.accept(SkywizaModBlocks.LOOT_CHEST_REMOVER.get().asItem());
				tabData.accept(SkywizaModBlocks.LOOT_CHEST.get().asItem());
				tabData.accept(SkywizaModBlocks.QUEST_BOARD_REMOVER.get().asItem());
				tabData.accept(SkywizaModBlocks.QUEST_BOARD.get().asItem());
				tabData.accept(SkywizaModBlocks.SPAWNER_REMOVER.get().asItem());
				tabData.accept(SkywizaModBlocks.SPAWNER.get().asItem());
				tabData.accept(SkywizaModBlocks.NPC_BLOCK.get().asItem());
				tabData.accept(SkywizaModBlocks.VILLAGE_INFO.get().asItem());
				tabData.accept(SkywizaModBlocks.VILLAGE_CENTER.get().asItem());
				tabData.accept(SkywizaModBlocks.VILLAGE_LOCATION.get().asItem());
				tabData.accept(SkywizaModItems.VILLAGE_MANAGER.get());
				tabData.accept(SkywizaModItems.PATH_MANAGER.get());
				tabData.accept(SkywizaModItems.TXT_STRUCTURE_MANAGER.get());
				tabData.accept(SkywizaModItems.TESTING_STICK.get());
				tabData.accept(SkywizaModItems.CITY_GENERATOR_MANAGER.get());
			})

					.build());
}
