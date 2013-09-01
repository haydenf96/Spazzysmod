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
	public static Block launchPad;

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
		
		launchPad= new BlockLaunchPad(SpazzysConfig.launchPadID,
				Material.iron).setUnlocalizedName("launchPad");
		GameRegistry.registerBlock(launchPad);
		LanguageRegistry.addName(launchPad, "Launch Pad");

		MoonBlocks.initBlocks();
		MarsBlocks.initBlocks();
	}
}