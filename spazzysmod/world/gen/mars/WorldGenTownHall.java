package spazzysmod.world.gen.mars;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenTownHall {

	private World world;
	private int x, y, z;

	public WorldGenTownHall(World par1World, int par2, int par3, int par4) {
		this.world = par1World;
		this.x = par2;
		this.y = par3;
		this.z = par4;
	}

	public void generate() {
		final int BLOCK_SIZE = 21;

		for (int i = 0; i < BLOCK_SIZE; ++i)
			for (int j = 0; j < BLOCK_SIZE; ++j)
				for (int k = 0; k < BLOCK_SIZE; ++k)
					world.setBlock(x + i, y + j, z + k,
							Block.cobblestone.blockID);

		for (int i = 0; i < BLOCK_SIZE; ++i)
			for (int j = 0; j < BLOCK_SIZE; ++j)
				for (int k = 0; k < BLOCK_SIZE; ++k)
					if (j == 5 || j == 10 || j == 15 || j == 20)
						for (int a = 0; a < 3; ++a)
							world.setBlockToAir(x + i + a, y + j, z + k + a);

		// for another loop: if ( ( i > 1 && j > 1 ) && ( i < 19 && j < 19 ) )
	}
}