package net.mcreator.alexnestsfoodmod.procedures;

public class DarkEssenceFoodEatenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure DarkEssenceFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 1, (false), (true)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 200, (int) 1, (false), (false)));
	}

}
