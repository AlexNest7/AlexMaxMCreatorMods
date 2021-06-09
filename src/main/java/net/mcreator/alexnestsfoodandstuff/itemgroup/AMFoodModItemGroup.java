
package net.mcreator.alexnestsfoodandstuff.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alexnestsfoodandstuff.item.ChocoCookieItem;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

@FoodandstuffModModElements.ModElement.Tag
public class AMFoodModItemGroup extends FoodandstuffModModElements.ModElement {
	public AMFoodModItemGroup(FoodandstuffModModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_food_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChocoCookieItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
