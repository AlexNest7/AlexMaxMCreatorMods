
package net.mcreator.alexnestsfoodandstuff.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.alexnestsfoodandstuff.itemgroup.AMFaSArmorItemGroup;
import net.mcreator.alexnestsfoodandstuff.FoodandstuffModModElements;

import java.util.List;

@FoodandstuffModModElements.ModElement.Tag
public class EnhancedDarkMetalArmorItem extends FoodandstuffModModElements.ModElement {
	@ObjectHolder("foodandstuff_mod:enhanced_dark_metal_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("foodandstuff_mod:enhanced_dark_metal_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("foodandstuff_mod:enhanced_dark_metal_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("foodandstuff_mod:enhanced_dark_metal_armor_boots")
	public static final Item boots = null;
	public EnhancedDarkMetalArmorItem(FoodandstuffModModElements instance) {
		super(instance, 66);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 28;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{4, 5, 5, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 7;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DarkessenceingotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "enhanced_dark_metal_armor";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.05f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(AMFaSArmorItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Wow, it looks much better now."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "foodandstuff_mod:textures/models/armor/enhanced_darksteel_armor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
						+ ".png";
			}
		}.setRegistryName("enhanced_dark_metal_armor_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(AMFaSArmorItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("This one is heavy!"));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "foodandstuff_mod:textures/models/armor/enhanced_darksteel_armor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
						+ ".png";
			}
		}.setRegistryName("enhanced_dark_metal_armor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(AMFaSArmorItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("They're quiet heavy."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "foodandstuff_mod:textures/models/armor/enhanced_darksteel_armor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
						+ ".png";
			}
		}.setRegistryName("enhanced_dark_metal_armor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(AMFaSArmorItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("It's harder to walk wearing these."));
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "foodandstuff_mod:textures/models/armor/enhanced_darksteel_armor__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1")
						+ ".png";
			}
		}.setRegistryName("enhanced_dark_metal_armor_boots"));
	}
}
