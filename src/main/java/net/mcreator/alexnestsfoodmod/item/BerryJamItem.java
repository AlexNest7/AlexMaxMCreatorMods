
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class BerryJamItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:berry_jam")
	public static final Item block = null;

	public BerryJamItem(FoodModModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(8).saturation(0.7000000000000001f)

							.build()));
			setRegistryName("berry_jam");
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
			list.add(new StringTextComponent("A jar of sweet berry jam. Better not eat too much!"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				BerryJamFoodEatenProcedure.executeProcedure($_dependencies);
			}

			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			boolean retval = super.hitEntity(itemstack, entity, sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				BerryJamLivingSmthIsHitWithProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

	}

}
