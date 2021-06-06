
package net.mcreator.alexnestsfoodmod.item;

@FoodModModElements.ModElement.Tag
public class RedstoneSyrupItem extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:redstone_syrup")
	public static final Item block = null;

	public RedstoneSyrupItem(FoodModModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.5f).setAlwaysEdible()

							.build()));
			setRegistryName("redstone_syrup");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 30;
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
			list.add(new StringTextComponent("Should I even drink this?"));
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

				$_dependencies.put("entity", entity);

				RedstoneSyrupFoodEatenProcedure.executeProcedure($_dependencies);
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
		public boolean onDroppedByPlayer(ItemStack itemstack, PlayerEntity entity) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				RedstoneSyrupOnDropProcedure.executeProcedure($_dependencies);
			}
			return true;
		}
	}

}
