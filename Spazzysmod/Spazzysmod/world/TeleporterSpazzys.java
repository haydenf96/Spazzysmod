package spazzysmod.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import spazzysmod.blocks.SpazzysBlocks;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.PortalPosition;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterSpazzys extends Teleporter {

	private final WorldServer world;
	private final Random random;
	private final LongHashMap field_85191_c = new LongHashMap();
	private final List<Long> field_85190_d = new ArrayList<Long>();

	public TeleporterSpazzys(WorldServer par1WorldServer) {
		super(par1WorldServer);
		this.world = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
	}

	@Override
	public boolean makePortal(Entity entity) {

		if (world.isAirBlock((int) entity.posX, (int) entity.posY - 2,
				(int) entity.posZ)) {
			if (entity.dimension == 25) {
				world.setBlock((int) entity.posX, (int) entity.posY - 1,
						(int) entity.posZ, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX + 1, (int) entity.posY - 1,
						(int) entity.posZ, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX - 1, (int) entity.posY - 1,
						(int) entity.posZ, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX + 1, (int) entity.posY - 1,
						(int) entity.posZ + 1, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX - 1, (int) entity.posY - 1,
						(int) entity.posZ - 1, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX, (int) entity.posY - 1,
						(int) entity.posZ + 1, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX, (int) entity.posY - 1,
						(int) entity.posZ - 1, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX + 1, (int) entity.posY - 1,
						(int) entity.posZ - 1, SpazzysBlocks.launchPad.blockID);
				world.setBlock((int) entity.posX - 1, (int) entity.posY - 1,
						(int) entity.posZ - 1, SpazzysBlocks.launchPad.blockID);

			}

		}
		return true;
	}

	/**
	 * Place an entity in a nearby portal which already exists.
	 */
	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2,
			double par4, double par6, float par8) {
		short short1 = 128;
		double d3 = -1.0D;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = MathHelper.floor_double(par1Entity.posX);
		int i1 = MathHelper.floor_double(par1Entity.posZ);
		long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
		boolean flag = true;
		double d4;
		int k1;

		if (this.field_85191_c.containsItem(j1)) {
			PortalPosition portalposition = (PortalPosition) this.field_85191_c
					.getValueByKey(j1);
			d3 = 0.0D;
			i = portalposition.posX;
			j = portalposition.posY;
			k = portalposition.posZ;
			portalposition.lastUpdateTime = this.world.getTotalWorldTime();
			flag = false;
		} else {
			for (k1 = l - short1; k1 <= l + short1; ++k1) {
				double d5 = k1 + 0.5D - par1Entity.posX;

				for (int l1 = i1 - short1; l1 <= i1 + short1; ++l1) {
					double d6 = l1 + 0.5D - par1Entity.posZ;

					for (int i2 = this.world.getActualHeight() - 1; i2 >= 0; --i2) {
						if (par1Entity.dimension == 25) {
							if (this.world.getBlockId(k1, i2, l1) == SpazzysBlocks.launchPad.blockID) {
								while (this.world.getBlockId(k1, i2 - 1, l1) == SpazzysBlocks.launchPad.blockID) {
									--i2;
								}

								d4 = i2 + 0.5D - par1Entity.posY;
								double d7 = d5 * d5 + d4 * d4 + d6 * d6;

								if (d3 < 0.0D || d7 < d3) {
									d3 = d7;
									i = k1;
									j = i2;
									k = l1;
								}
							}
						} else {
							if (this.world.getBlockId(k1, i2, l1) == SpazzysBlocks.launchPad.blockID) {
								while (this.world.getBlockId(k1, i2 - 1, l1) == SpazzysBlocks.launchPad.blockID) {
									--i2;
								}

								d4 = i2 + 0.5D - par1Entity.posY;
								double d7 = d5 * d5 + d4 * d4 + d6 * d6;

								if (d3 < 0.0D || d7 < d3) {
									d3 = d7;
									i = k1;
									j = i2;
									k = l1;
								}
							}
						}

					}
				}
			}
		}

		if (d3 >= 0.0D) {
			if (flag) {
				this.field_85191_c.add(j1, new PortalPosition(this, i, j, k,
						this.world.getTotalWorldTime()));
				this.field_85190_d.add(Long.valueOf(j1));
			}

			double d8 = i + 0.5D;
			double d9 = j + 0.5D;
			d4 = k + 0.5D;
			int j2 = -1;

			if (par1Entity.dimension == 25) {
				if (this.world.getBlockId(i - 1, j, k) == SpazzysBlocks.launchPad.blockID) {
					j2 = 2;
				}

				if (this.world.getBlockId(i + 1, j, k) == SpazzysBlocks.launchPad.blockID) {
					j2 = 0;
				}

				if (this.world.getBlockId(i, j, k - 1) == SpazzysBlocks.launchPad.blockID) {
					j2 = 3;
				}

				if (this.world.getBlockId(i, j, k + 1) == SpazzysBlocks.launchPad.blockID) {
					j2 = 1;
				}
			} else {
				if (this.world.getBlockId(i - 1, j, k) == SpazzysBlocks.launchPad.blockID) {
					j2 = 2;
				}

				if (this.world.getBlockId(i + 1, j, k) == SpazzysBlocks.launchPad.blockID) {
					j2 = 0;
				}

				if (this.world.getBlockId(i, j, k - 1) == SpazzysBlocks.launchPad.blockID) {
					j2 = 3;
				}

				if (this.world.getBlockId(i, j, k + 1) == SpazzysBlocks.launchPad.blockID) {
					j2 = 1;
				}
			}

			int k2 = par1Entity.getTeleportDirection();

			if (j2 > -1) {
				int l2 = Direction.rotateLeft[j2];
				int i3 = Direction.offsetX[j2];
				int j3 = Direction.offsetZ[j2];
				int k3 = Direction.offsetX[l2];
				int l3 = Direction.offsetZ[l2];
				boolean flag1 = !this.world.isAirBlock(i + i3 + k3, j, k + j3
						+ l3)
						|| !this.world.isAirBlock(i + i3 + k3, j + 1, k + j3
								+ l3);
				boolean flag2 = !this.world.isAirBlock(i + i3, j, k + j3)
						|| !this.world.isAirBlock(i + i3, j + 1, k + j3);

				if (flag1 && flag2) {
					j2 = Direction.rotateOpposite[j2];
					l2 = Direction.rotateOpposite[l2];
					i3 = Direction.offsetX[j2];
					j3 = Direction.offsetZ[j2];
					k3 = Direction.offsetX[l2];
					l3 = Direction.offsetZ[l2];
					k1 = i - k3;
					d8 -= k3;
					int i4 = k - l3;
					d4 -= l3;
					flag1 = !this.world.isAirBlock(k1 + i3 + k3, j, i4 + j3
							+ l3)
							|| !this.world.isAirBlock(k1 + i3 + k3, j + 1, i4
									+ j3 + l3);
					flag2 = !this.world.isAirBlock(k1 + i3, j, i4 + j3)
							|| !this.world.isAirBlock(k1 + i3, j + 1, i4 + j3);
				}

				float f1 = 0.5F;
				float f2 = 0.5F;

				if (!flag1 && flag2) {
					f1 = 1.0F;
				} else if (flag1 && !flag2) {
					f1 = 0.0F;
				} else if (flag1 && flag2) {
					f2 = 0.0F;
				}

				d8 += k3 * f1 + f2 * i3;
				d4 += l3 * f1 + f2 * j3;
				float f3 = 0.0F;
				float f4 = 0.0F;
				float f5 = 0.0F;
				float f6 = 0.0F;

				if (j2 == k2) {
					f3 = 1.0F;
					f4 = 1.0F;
				} else if (j2 == Direction.rotateOpposite[k2]) {
					f3 = -1.0F;
					f4 = -1.0F;
				} else if (j2 == Direction.rotateRight[k2]) {
					f5 = 1.0F;
					f6 = -1.0F;
				} else {
					f5 = -1.0F;
					f6 = 1.0F;
				}

				double d10 = par1Entity.motionX;
				double d11 = par1Entity.motionZ;
				par1Entity.motionX = d10 * f3 + d11 * f6;
				par1Entity.motionZ = d10 * f5 + d11 * f4;
				par1Entity.rotationYaw = par8 - k2 * 90
						+ j2 * 90;
			} else {
				par1Entity.motionX = par1Entity.motionY = par1Entity.motionZ = 0.0D;
			}
			if (par1Entity.dimension == 25) {
				par1Entity.setLocationAndAngles(d8, d9, d4,
						par1Entity.rotationYaw, par1Entity.rotationPitch);
			} else {
				par1Entity.setLocationAndAngles(d8, d9 + 1, d4,
						par1Entity.rotationYaw, par1Entity.rotationPitch);
			}

			// Structures.createRocketWithPos(par1Entity, world, (int)d8 - 8,
			// (int)d9, (int)d4);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Place an entity in a nearby portal, creating one if necessary.
	 */
	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4,
			double par6, float par8) {
		if (!this.placeInExistingPortal(par1Entity, par2, par4, par6, par8)) {
			this.makePortal(par1Entity);
			this.placeInExistingPortal(par1Entity, par2, par4, par6, par8);
		} else {

			// Structures.createRocketWithPos(par1Entity, world, (int)par2 - 8,
			// (int)par4, (int)par6);
		}
	}

	@Override
	public void removeStalePortalLocations(long par1) {
		if (par1 % 100L == 0L) {
			Iterator<Long> var3 = this.field_85190_d.iterator();
			long var4 = par1 - 600L;

			while (var3.hasNext()) {
				Long var6 = var3.next();
				PortalPosition var7 = (PortalPosition) this.field_85191_c
						.getValueByKey(var6.longValue());

				if (var7 == null || var7.lastUpdateTime < var4) {
					var3.remove();
					this.field_85191_c.remove(var6.longValue());
				}
			}
		}
	}
}