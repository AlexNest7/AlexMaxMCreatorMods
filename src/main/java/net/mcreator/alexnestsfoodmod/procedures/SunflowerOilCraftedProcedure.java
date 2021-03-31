package net.mcreator.alexnestsfoodmod.procedures;

@FoodModModElements.ModElement.Tag
public class SunflowerOilCraftedProcedure extends FoodModModElements.ModElement {

	public SunflowerOilCraftedProcedure(FoodModModElements instance) {
		super(instance, 40);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure SunflowerOilCrafted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("seed_salad")});
		}

	}

}
