
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class ChocoMilkItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:choco_milk")
	public static final Item block = null;

	public ChocoMilkItem(FoodModModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(8).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(7).saturation(1f)

							.build()));
			setRegistryName("choco_milk");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 37;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("It contains both chocolate and milk."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				ChocoMilkFoodEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
