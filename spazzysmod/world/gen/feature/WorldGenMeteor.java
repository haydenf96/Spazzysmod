package spazzysmod.world.gen.feature;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.item.SpazzysItems;

public class WorldGenMeteor extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		// Bottom
		world.setBlock(x, y - 5, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 5, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 5, z, SpazzysBlocks.meteorite.blockID);

		world.setBlock(x, y - 5, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 5, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 5, z - 1, SpazzysBlocks.meteorite.blockID);

		world.setBlock(x, y - 5, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 5, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 5, z + 1, SpazzysBlocks.meteorite.blockID);

		// Top
		world.setBlock(x, y - 1, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 1, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 1, z, SpazzysBlocks.meteorite.blockID);

		world.setBlock(x, y - 1, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 1, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 1, z - 1, SpazzysBlocks.meteorite.blockID);

		world.setBlock(x, y - 1, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 1, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 1, z + 1, SpazzysBlocks.meteorite.blockID);

		// Front
		world.setBlock(x, y - 2, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 2, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 2, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x, y - 3, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 3, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 3, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x, y - 4, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 4, z + 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 4, z + 2, SpazzysBlocks.meteorite.blockID);

		// Back
		world.setBlock(x, y - 2, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 2, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 2, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x, y - 3, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 3, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 3, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x, y - 4, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 1, y - 4, z - 2, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 1, y - 4, z - 2, SpazzysBlocks.meteorite.blockID);

		// Left
		world.setBlock(x - 2, y - 2, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 2, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 2, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 3, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 3, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 3, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 4, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 4, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x - 2, y - 4, z - 1, SpazzysBlocks.meteorite.blockID);

		// Right
		world.setBlock(x + 2, y - 2, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 2, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 2, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 3, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 3, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 3, z - 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 4, z, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 4, z + 1, SpazzysBlocks.meteorite.blockID);
		world.setBlock(x + 2, y - 4, z - 1, SpazzysBlocks.meteorite.blockID);

		// Crater
		world.createExplosion((EntityLivingBase) null, x, y - 3, z, 9, true);
		world.createExplosion((EntityLivingBase) null, x, y - 3, z, 9, true);

		world.createExplosion((EntityLivingBase) null, x, y, z, 9, true);
		world.createExplosion((EntityLivingBase) null, x, y, z, 9, true);

		// Chest
		world.setBlock(x, y - 4, z, Block.chest.blockID, 0, 2);

		TileEntityChest tileentitychest = (TileEntityChest) world
				.getBlockTileEntity(x, y - 4, z);

		if (tileentitychest != null && tileentitychest != null) {
			Random rand = new Random();

			tileentitychest
					.setInventorySlotContents(rand.nextInt(27), new ItemStack(
							SpazzysItems.titaniumIngot, rand.nextInt(20)));
			tileentitychest.setInventorySlotContents(rand.nextInt(27),
					new ItemStack(Item.redstone, rand.nextInt(30)));

			if (rand.nextInt(4) == 1) {
				tileentitychest.setInventorySlotContents(
						rand.nextInt(27),
						new ItemStack(SpazzysItems.explosiveBow, rand
								.nextInt(1)));
			}

			tileentitychest
					.setInventorySlotContents(rand.nextInt(27), new ItemStack(
							SpazzysItems.explosiveArrow, rand.nextInt(15)));

			if (rand.nextInt(5) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.diamond, rand.nextInt(5)));
			}
			if (rand.nextInt(5) == 1) {
				tileentitychest
						.setInventorySlotContents(
								rand.nextInt(27),
								new ItemStack(SpazzysBlocks.meteorite, rand
										.nextInt(5)));
			}

			if (rand.nextInt(12) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.helmetDiamond, rand.nextInt(1)));
			}

			if (rand.nextInt(14) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.plateDiamond, rand.nextInt(1)));
			}

			if (rand.nextInt(13) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.legsDiamond, rand.nextInt(1)));
			}

			if (rand.nextInt(10) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.bootsDiamond, rand.nextInt(1)));
			}

			if (rand.nextInt(30) == 1) {
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.emerald, rand.nextInt(2)));
			}

			if (rand.nextInt(25) == 1) {
				world.setBlock(x + 1, y - 4, z + 1, Block.mobSpawner.blockID,
						0, 2);
				TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world
						.getBlockTileEntity(x + 1, y - 4, z + 1);

				if (tileentitymobspawner != null) {
					tileentitymobspawner.getSpawnerLogic().setMobID("Creeper");
				} else {
					System.err
							.println("Failed to fetch mob spawner entity at ("
									+ x + ", " + y + ", " + z + ")");
				}
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.diamond, rand.nextInt(6)));
				tileentitychest.setInventorySlotContents(rand.nextInt(27),
						new ItemStack(Item.emerald, rand.nextInt(4)));
			}
		}

		return true;
	}

}
