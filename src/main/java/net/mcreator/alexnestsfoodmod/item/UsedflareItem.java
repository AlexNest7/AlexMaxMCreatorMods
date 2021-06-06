
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class UsedflareItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:usedflare")
	public static final Item block = null;

	public UsedflareItem(FoodModModElements instance) {
		super(instance, 59);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("usedflare");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("I can refill this shell with blaze powder."));
		}

	}

}
