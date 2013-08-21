package Spazzysmod.world.biome;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import Spazzysmod.entity.passive.EntityGopher;

public class BiomeMarsBiome extends BiomeGenBase {

    @SuppressWarnings("unchecked")
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
