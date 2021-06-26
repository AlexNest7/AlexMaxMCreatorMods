package net.mcreator.alexnestsfoodandstuff.procedures;

import org.lwjgl.glfw.GLFW;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.Minecraft;

import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;
import java.util.Collection;

public class ScopedSniperOnFKeyReleaseProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure ScopedSniperOnFKeyRelease!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_F)))) {
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.SLOWNESS)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
				}
			}
		}
	}
}
