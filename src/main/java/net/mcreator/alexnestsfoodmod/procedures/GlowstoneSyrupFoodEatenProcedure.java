package net.mcreator.alexnestsfoodmod.procedures;

@FoodModModElements.ModElement.Tag
public class GlowstoneSyrupFoodEatenProcedure extends FoodModModElements.ModElement {

	public GlowstoneSyrupFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 38);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure GlowstoneSyrupFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1200, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 1200, (int) 2));
		entity.attackEntityFrom(DamageSource.HOT_FLOOR, (float) 2);

	}

}
