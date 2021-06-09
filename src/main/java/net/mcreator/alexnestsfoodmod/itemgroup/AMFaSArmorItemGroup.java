
package net.mcreator.alexnestsfoodmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alexnestsfoodmod.item.EnhancedDarkMetalArmorItem;
import net.mcreator.alexnestsfoodmod.FoodModModElements;

@FoodModModElements.ModElement.Tag
public class AMFaSArmorItemGroup extends FoodModModElements.ModElement {
	public AMFaSArmorItemGroup(FoodModModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_fa_s_armor") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(EnhancedDarkMetalArmorItem.helmet, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
