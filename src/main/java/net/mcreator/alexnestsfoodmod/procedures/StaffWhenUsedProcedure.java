package net.mcreator.alexnestsfoodmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodmod.FoodModModElements;
import net.mcreator.alexnestsfoodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class StaffWhenUsedProcedure extends FoodModModElements.ModElement {
	public StaffWhenUsedProcedure(FoodModModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure StaffWhenUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
	}
}
