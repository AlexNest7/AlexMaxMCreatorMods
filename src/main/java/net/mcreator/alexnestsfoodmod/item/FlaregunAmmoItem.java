
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class FlaregunAmmoItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:flaregun_ammo")
	public static final Item block = null;

	public FlaregunAmmoItem(FoodModModElements instance) {
		super(instance, 59);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("flaregun_ammo");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(UsedflareItem.block, (int) (1));
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
			list.add(new StringTextComponent("This flare can set things on fire!"));
		}

	}

}
