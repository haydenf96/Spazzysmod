package Spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Spazzysmod.config.SpazzysConfig;
import Spazzysmod.world.gen.feature.TitaniumWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysBlocks {

    public static Block titaniumBlock;

    @SuppressWarnings("deprecation")
    public static void initBlocks() {
        titaniumBlock = new BlockTitaniumBlock(SpazzysConfig.titaniumBlockID,
                Material.rock).setUnlocalizedName("titaniumBlock");
        GameRegistry.registerBlock(titaniumBlock);
        LanguageRegistry.addName(titaniumBlock, "Titanium Ore");
        GameRegistry.registerWorldGenerator(new TitaniumWorldGenerator());

        MoonBlocks.initBlocks();
        MarsBlocks.initBlocks();
    }
}
