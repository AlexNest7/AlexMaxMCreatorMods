
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class ChocoCookieItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:choco_cookie")
	public static final Item block = null;

	public ChocoCookieItem(FoodModModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.5f)

							.build()));
			setRegistryName("choco_cookie");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 30;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A chocolate chip cookie. Looks tasty."));
		}

	}

}
