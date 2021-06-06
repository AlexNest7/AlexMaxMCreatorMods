
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class BrokenBerryJamJarItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:broken_berry_jam_jar")
	public static final Item block = null;

	public BrokenBerryJamJarItem(FoodModModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.5f)

							.build()));
			setRegistryName("broken_berry_jam_jar");
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
			list.add(new StringTextComponent("Why did you do this?"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				BrokenBerryJamJarEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
