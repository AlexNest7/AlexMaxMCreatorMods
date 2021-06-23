package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

public class FlareGunWhileBulletFlyingTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency x for procedure FlareGunWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency y for procedure FlareGunWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency z for procedure FlareGunWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency world for procedure FlareGunWhileBulletFlyingTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, (int) 4, 1, 1, 1, 2);
		}
	}
}
