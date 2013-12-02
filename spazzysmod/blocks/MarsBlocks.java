package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import spazzysmod.config.SpazzysConfig;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MarsBlocks {

	public static Block marsRock;
	public static Block redRock;

	public static void initBlocks() {
		marsRock = new BlockMarsRock(SpazzysConfig.marsRockID, Material.rock)
				.setUnlocalizedName("marsRock");
		GameRegistry.registerBlock(marsRock,
				"spazzysmod" + marsRock.getUnlocalizedName());
		LanguageRegistry.addName(marsRock, "Mars Rock");

		redRock = new BlockRedRock(SpazzysConfig.redRockID, Material.rock)
				.setUnlocalizedName("redRock");
		GameRegistry.registerBlock(redRock,
				"spazzysmod" + redRock.getUnlocalizedName());
		LanguageRegistry.addName(redRock, "Red Rock");

	}
}
