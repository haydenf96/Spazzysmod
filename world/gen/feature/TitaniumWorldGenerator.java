package Spazzysmod.world.gen.feature;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import Spazzysmod.Spazzysmod;
import cpw.mods.fml.common.IWorldGenerator;

public class TitaniumWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {

		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);


		}

	}


	private void generateSurface(World world, Random random, int i, int j) {
		for (int k = 0; k < 6; k++) {
			int Xcoord = i + random.nextInt(16);
			int Ycoord = random.nextInt(16);
			int Zcoord = j + random.nextInt(16);

			(new WorldGenMinable(Spazzysmod.titaniumBlock.blockID, 4))
			.generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	}



}
