package net.mcreator.alexnestsfoodmod.entity.renderer;

@OnlyIn(Dist.CLIENT)
public class FireBallRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FireBallItem.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}

}
