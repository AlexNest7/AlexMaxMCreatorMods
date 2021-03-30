
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class CookedChoppedPorkItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:cooked_chopped_pork")
	public static final Item block = null;

	public CookedChoppedPorkItem(FoodModModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(13).saturation(1.1f)

							.meat().build()));
			setRegistryName("cooked_chopped_pork");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 35;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A cooked piece of chopped pork."));
			list.add(new StringTextComponent("Can't Wait to try it out!"));
		}

	}

}
