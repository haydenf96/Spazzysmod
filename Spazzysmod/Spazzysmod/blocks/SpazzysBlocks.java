package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.world.gen.feature.TitaniumWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysBlocks {

	public static Block titaniumBlock;
	public static Block rocketBlock;

	@SuppressWarnings("deprecation")
	public static void initBlocks()
	{
		titaniumBlock = new BlockTitaniumBlock(SpazzysConfig.titaniumBlockID,
				Material.rock).setUnlocalizedName("titaniumBlock");
		GameRegistry.registerBlock(titaniumBlock);
		LanguageRegistry.addName(titaniumBlock, "Titanium Ore");
		GameRegistry.registerWorldGenerator(new TitaniumWorldGenerator());

		rocketBlock= new BlockRocketEngine(SpazzysConfig.rocketID,
				Material.iron).setUnlocalizedName("moonRocket");
		GameRegistry.registerBlock(rocketBlock);
		LanguageRegistry.addName(rocketBlock, "Rocket Engine");

		MoonBlocks.initBlocks();
		MarsBlocks.initBlocks();
	}
}