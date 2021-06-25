package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

public class EraserOnEntityHitProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure EraserOnEntityHit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.isNonBoss())) {
			if (!entity.world.isRemote())
				entity.remove();
		} else {
			entity.attackEntityFrom(DamageSource.MAGIC, (float) 10000);
		}
	}
}
