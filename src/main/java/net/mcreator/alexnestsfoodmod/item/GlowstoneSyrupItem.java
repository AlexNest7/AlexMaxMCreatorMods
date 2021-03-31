
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class GlowstoneSyrupItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:glowstone_syrup")
	public static final Item block = null;

	public GlowstoneSyrupItem(FoodModModElements instance) {
		super(instance, 36);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(16).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(3).saturation(0.4f).setAlwaysEdible()

							.build()));
			setRegistryName("glowstone_syrup");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 35;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
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
			list.add(new StringTextComponent("It's so bright! But i hope it's drinkable."));
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

				GlowstoneSyrupFoodEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
