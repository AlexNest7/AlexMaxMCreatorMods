package net.mcreator.alexnestsfoodandstuff.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.alexnestsfoodandstuff.item.FlaregunAmmoItem;
import net.mcreator.alexnestsfoodandstuff.item.FlareGunItem;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModMod;

import java.util.Random;
import java.util.Map;

@FoodandstuffModModElements.ModElement.Tag
public class FlareGunWhenUsedProcedure extends FoodandstuffModModElements.ModElement {
	public FlareGunWhenUsedProcedure(FoodandstuffModModElements instance) {
		super(instance, 72);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency entity for procedure FlareGunWhenUsed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency x for procedure FlareGunWhenUsed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency y for procedure FlareGunWhenUsed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency z for procedure FlareGunWhenUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodandstuffModMod.LOGGER.warn("Failed to load dependency world for procedure FlareGunWhenUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FlaregunAmmoItem.block, (int) (1)))
				: false)) {
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("foodandstuff_mod:flare_gun_shot")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("foodandstuff_mod:flare_gun_shot")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					FlareGunItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 5, (int) 5);
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FlaregunAmmoItem.block, (int) (1));
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown((new ItemStack(FlareGunItem.block, (int) (1))).getItem(), (int) 60);
		} else {
			if (world instanceof World && !world.isRemote()) {
				((World) world)
						.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("foodandstuff_mod:flare_gun_dry_shot")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
								.getValue(new ResourceLocation("foodandstuff_mod:flare_gun_dry_shot")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
