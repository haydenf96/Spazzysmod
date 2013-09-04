package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.world.gen.feature.TitaniumWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysBlocks {

	public static Block titaniumBlock;
	public static Block launchPad;

	public static Block rocketBlock;
	public static Block rocketWorkbench;

	@SuppressWarnings("deprecation")
	public static void initBlocks() {
		titaniumBlock = new BlockTitaniumBlock(SpazzysConfig.titaniumBlockID,
				Material.rock).setUnlocalizedName("titaniumBlock");
		GameRegistry.registerBlock(titaniumBlock, "TitaniumBlock" );
		LanguageRegistry.addName(titaniumBlock, "Titanium Ore");
		GameRegistry.registerWorldGenerator(new TitaniumWorldGenerator());

		launchPad = new BlockLaunchPad(SpazzysConfig.launchPadID, Material.iron).setUnlocalizedName("launchPad");
		GameRegistry.registerBlock(launchPad, "LunchPad");
		LanguageRegistry.addName(launchPad, "Launch Pad");

		rocketBlock = new BlockRocketEngine(SpazzysConfig.rocketEngineID,
				Material.iron).setUnlocalizedName("moonRocket");
		GameRegistry.registerBlock(rocketBlock, "RocketBlock" );
		LanguageRegistry.addName(rocketBlock, "Rocket Engine");

		rocketWorkbench = new BlockRocketWorkbench ( SpazzysConfig.rocketWorkbenchID ).setUnlocalizedName( "rocketWorkbench" ).func_111022_d( "spazzysmod:workbench" );
		GameRegistry.registerBlock ( rocketWorkbench, "RocketWorkbench" );
		LanguageRegistry.addName( rocketWorkbench, "Rocket Workbench Alpha" );
		

		MoonBlocks.initBlocks();
		MarsBlocks.initBlocks();
	}
}