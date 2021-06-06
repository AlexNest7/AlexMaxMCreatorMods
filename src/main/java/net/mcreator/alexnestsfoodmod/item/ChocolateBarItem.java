
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class ChocolateBarItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:chocolate_bar")
	public static final Item block = null;

	public ChocolateBarItem(FoodModModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(32).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.6f)

							.build()));
			setRegistryName("chocolate_bar");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 33;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A delicious self-made chocolate bar."));
		}

	}

}
