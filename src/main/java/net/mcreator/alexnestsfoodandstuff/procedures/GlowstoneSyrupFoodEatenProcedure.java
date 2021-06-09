package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class GlowstoneSyrupFoodEatenProcedure extends FoodandstuffModModElements.ModElement {
	public GlowstoneSyrupFoodEatenProcedure(FoodandstuffModModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure GlowstoneSyrupFoodEaten!");
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
