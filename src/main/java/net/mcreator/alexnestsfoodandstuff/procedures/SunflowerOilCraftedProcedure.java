package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class SunflowerOilCraftedProcedure extends FoodandstuffModModElements.ModElement {
	public SunflowerOilCraftedProcedure(FoodandstuffModModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure SunflowerOilCrafted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof ServerPlayerEntity) {
			((ServerPlayerEntity) entity).unlockRecipes(new ResourceLocation[]{new ResourceLocation("seed_salad")});
		}
	}
}
