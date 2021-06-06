package net.mcreator.alexnestsfoodmod.procedures;

@FoodModModElements.ModElement.Tag
public class FlareGunOnHitProcedure extends FoodModModElements.ModElement {

	public FlareGunOnHitProcedure(FoodModModElements instance) {
		super(instance, 60);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				FoodModMod.LOGGER.warn("Failed to load dependency cmdparams for procedure FlareGunOnHit!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FoodModMod.LOGGER.warn("Failed to load dependency world for procedure FlareGunOnHit!");
			return;
		}

		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");

		world.setBlockState(new BlockPos((int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())), (int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())), (int) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("2");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()))), Blocks.FIRE.getDefaultState(), 3);
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())), new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())), new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("2");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())), new ItemStack(UsedflareItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 10);
			world.addEntity(entityToSpawn);
		}

	}

}
