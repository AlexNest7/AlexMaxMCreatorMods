package net.mcreator.alexnestsfoodmod.procedures;

public class DarkEssenceArmorWearProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure DarkEssenceArmorWear!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 1) && (entity instanceof PlayerEntity))) {
			entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
		}
	}

}
