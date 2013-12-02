package spazzysmod.world;

import net.minecraftforge.common.DimensionManager;
import spazzysmod.world.biome.SpazzysBiomes;
import cpw.mods.fml.common.registry.GameRegistry;

public class SpazzysDimensions {

	public static int moonDimensionID = 10;
	public static int marsDimensionID = 12;

	public static void registerDimensions() {
		DimensionManager.registerProviderType(moonDimensionID,
				WorldProviderMoon.class, false);
		DimensionManager.registerDimension(moonDimensionID, moonDimensionID);
		GameRegistry.addBiome(SpazzysBiomes.moonBiome);

		DimensionManager.registerProviderType(marsDimensionID,
				WorldProviderMars.class, false);
		DimensionManager.registerDimension(marsDimensionID, marsDimensionID);
		GameRegistry.addBiome(SpazzysBiomes.marsBiome);
	}
}
