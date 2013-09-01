package spazzysmod.world.biome;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import spazzysmod.entity.passive.EntityGopher;
import cpw.mods.fml.common.registry.EntityRegistry;

public class BiomeMoonBiome extends BiomeGenBase {

    public BiomeMoonBiome(int par1) {
        super(par1);
        this.setBiomeName("Moon Biome");

        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();

        EntityRegistry.addSpawn(EntityGopher.class, 10, 1, 5,
                EnumCreatureType.creature, this);
    }
}