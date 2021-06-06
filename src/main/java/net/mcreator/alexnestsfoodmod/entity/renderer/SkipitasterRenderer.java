package net.mcreator.alexnestsfoodmod.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class SkipitasterRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SkipitasterItem.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}

}
