
package net.mcreator.skywiza.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class WoodenCoinItem extends Item {
	public WoodenCoinItem() {
		super(new Item.Properties().stacksTo(50).rarity(Rarity.COMMON));
	}
}
