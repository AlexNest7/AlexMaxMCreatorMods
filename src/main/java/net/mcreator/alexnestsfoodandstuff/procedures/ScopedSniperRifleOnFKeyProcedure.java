package net.mcreator.alexnestsfoodandstuff.procedures;

import org.lwjgl.glfw.GLFW;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.Minecraft;

import net.mcreator.alexnestsfoodandstuff.item.ScopedSniperRifleItem;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Map;

public class ScopedSniperRifleOnFKeyProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure ScopedSniperRifleOnFKey!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(ScopedSniperRifleItem.block, (int) (1)).getItem())) {
			if ((InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_F))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 999999, (int) 2, (false), (false)));
			}
		}
	}
}
