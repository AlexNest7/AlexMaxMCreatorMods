
package net.mcreator.alexnestsfoodmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.alexnestsfoodmod.item.FlareGunItem;
import net.mcreator.alexnestsfoodmod.FoodModModElements;

@FoodModModElements.ModElement.Tag
public class AMFaSRangedWeaponsItemGroup extends FoodModModElements.ModElement {
	public AMFaSRangedWeaponsItemGroup(FoodModModElements instance) {
		super(instance, 65);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabam_fa_s_ranged_weapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FlareGunItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
