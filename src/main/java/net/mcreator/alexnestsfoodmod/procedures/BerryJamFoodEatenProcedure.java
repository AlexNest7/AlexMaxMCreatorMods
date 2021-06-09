package net.mcreator.alexnestsfoodmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodmod.FoodModModElements;
import net.mcreator.alexnestsfoodmod.FoodModMod;

import java.util.Map;

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
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 1, (false), (false)));
	}
}
