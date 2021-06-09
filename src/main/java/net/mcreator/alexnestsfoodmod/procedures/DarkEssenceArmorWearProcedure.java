package net.mcreator.alexnestsfoodmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodmod.FoodModModElements;
import net.mcreator.alexnestsfoodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class DarkEssenceArmorWearProcedure extends FoodModModElements.ModElement {
	public DarkEssenceArmorWearProcedure(FoodModModElements instance) {
		super(instance, 56);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure DarkEssenceArmorWear!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 1) && (entity instanceof PlayerEntity))) {
			entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
		}
	}
}
