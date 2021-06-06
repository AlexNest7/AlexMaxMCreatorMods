package net.mcreator.alexnestsfoodmod.procedures;

public class ChocoMilkFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure ChocoMilkFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 600, (int) 1));
	}

}
