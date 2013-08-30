package spazzysmod.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeMarsBiome extends BiomeGenBase {

    public BiomeMarsBiome(int par1) {
        super(par1);
        this.setBiomeName("Mars Biome");

        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

        this.theBiomeDecorator.generateLakes = false;
    }
}