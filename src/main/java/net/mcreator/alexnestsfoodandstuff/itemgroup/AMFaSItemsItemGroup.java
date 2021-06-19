
package net.mcreator.alexnestsfoodandstuff.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alexnestsfoodandstuff.item.DarkessenceingotItem;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

@FoodandstuffModModElements.ModElement.Tag
public class AMFaSItemsItemGroup extends FoodandstuffModModElements.ModElement {
	public AMFaSItemsItemGroup(FoodandstuffModModElements instance) {
		super(instance, 75);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_fa_s_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DarkessenceingotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
