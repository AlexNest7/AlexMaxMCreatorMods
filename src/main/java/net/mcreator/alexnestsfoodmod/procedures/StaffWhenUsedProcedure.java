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
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				FoodModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StaffWhenUsed!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		sourceentity.attackEntityFrom(DamageSource.DRYOUT, (float) 1);
	}
}
