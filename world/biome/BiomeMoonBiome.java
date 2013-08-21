package Spazzysmod.world.biome;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import Spazzysmod.entity.passive.EntityGopher;

public class BiomeMoonBiome extends BiomeGenBase {

    @SuppressWarnings("unchecked")
    public BiomeMoonBiome(int par1) {
        super(par1);
        this.setBiomeName("Moon Biome");
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGopher.class,
                5, 2, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class,
                10, 0, 2));
        this.theBiomeDecorator.generateLakes = false;

        // TODO Auto-generated constructor stub
    }

}
