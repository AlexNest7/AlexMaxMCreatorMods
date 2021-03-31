package net.mcreator.alexnestsfoodmod.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodmod.FoodModModElements;
import net.mcreator.alexnestsfoodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class SunflowerOilCraftedProcedure extends FoodModModElements.ModElement {
	public SunflowerOilCraftedProcedure(FoodModModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure SunflowerOilCrafted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("seed_salad")});
		}
	}
}
