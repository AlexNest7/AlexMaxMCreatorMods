
package net.mcreator.alexnestsfoodandstuff.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alexnestsfoodandstuff.procedures.BrokenBerryJamJarEatenProcedure;
import net.mcreator.alexnestsfoodandstuff.itemgroup.AMFoodModItemGroup;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@FoodandstuffModModElements.ModElement.Tag
public class BrokenBerryJamJarItem extends FoodandstuffModModElements.ModElement {
	@ObjectHolder("foodandstuff_mod:broken_berry_jam_jar")
	public static final Item block = null;
	public BrokenBerryJamJarItem(FoodandstuffModModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(AMFoodModItemGroup.tab).maxStackSize(16).rarity(Rarity.UNCOMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.5f).build()));
			setRegistryName("broken_berry_jam_jar");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 30;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Why did you do this?"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				BrokenBerryJamJarEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
