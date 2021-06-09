
package net.mcreator.alexnestsfoodmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alexnestsfoodmod.itemgroup.AMFoodModItemGroup;
import net.mcreator.alexnestsfoodmod.FoodModModElements;

import java.util.List;

@FoodModModElements.ModElement.Tag
public class RawChoppedPorkItem extends FoodModModElements.ModElement {
	@ObjectHolder("food_mod:raw_chopped_pork")
	public static final Item block = null;
	public RawChoppedPorkItem(FoodModModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.5f).meat().build()));
			setRegistryName("raw_chopped_pork");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A piece of raw chopped meat. I should cook it."));
		}
	}
}
