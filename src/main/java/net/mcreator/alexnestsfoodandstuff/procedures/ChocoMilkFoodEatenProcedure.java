package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class ChocoMilkFoodEatenProcedure extends FoodandstuffModModElements.ModElement {
	public ChocoMilkFoodEatenProcedure(FoodandstuffModModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure ChocoMilkFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).clearActivePotions();
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 600, (int) 1));
	}
}
