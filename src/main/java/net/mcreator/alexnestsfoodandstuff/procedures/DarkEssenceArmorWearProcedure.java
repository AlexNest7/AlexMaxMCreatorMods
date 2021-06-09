package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class DarkEssenceArmorWearProcedure extends FoodandstuffModModElements.ModElement {
	public DarkEssenceArmorWearProcedure(FoodandstuffModModElements instance) {
		super(instance, 56);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure DarkEssenceArmorWear!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) > 1) && (entity instanceof PlayerEntity))) {
			entity.attackEntityFrom(DamageSource.WITHER, (float) 1);
		}
	}
}
