
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class HotChocolateItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:hot_chocolate")
	public static final Item block = null;

	public HotChocolateItem(FoodModModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.7f).setAlwaysEdible()

							.build()));
			setRegistryName("hot_chocolate");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 36;
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
			list.add(new StringTextComponent("Ouch , it's still hot!"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				HotChocoFoodEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
