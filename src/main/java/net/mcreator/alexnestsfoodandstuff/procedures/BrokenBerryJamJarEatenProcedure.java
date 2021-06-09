package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class BrokenBerryJamJarEatenProcedure extends FoodandstuffModModElements.ModElement {
	public BrokenBerryJamJarEatenProcedure(FoodandstuffModModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure BrokenBerryJamJarEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
	}
}
