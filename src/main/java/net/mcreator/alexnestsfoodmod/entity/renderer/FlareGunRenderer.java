package net.mcreator.alexnestsfoodmod.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class FlareGunRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FlareGunItem.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}

}
