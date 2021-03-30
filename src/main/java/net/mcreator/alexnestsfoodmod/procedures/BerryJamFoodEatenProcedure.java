package net.mcreator.alexnestsfoodmod.procedures;

@FoodModModElements.ModElement.Tag
public class BerryJamFoodEatenProcedure extends FoodModModElements.ModElement {

	public BerryJamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 14);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure BerryJamFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 100, (int) 1));

	}

}
