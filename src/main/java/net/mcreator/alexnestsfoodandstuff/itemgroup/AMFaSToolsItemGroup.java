
package net.mcreator.alexnestsfoodandstuff.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alexnestsfoodandstuff.item.KitchenKnifeItem;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

@FoodandstuffModModElements.ModElement.Tag
public class AMFaSToolsItemGroup extends FoodandstuffModModElements.ModElement {
	public AMFaSToolsItemGroup(FoodandstuffModModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_fa_s_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(KitchenKnifeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
