package Spazzysmod.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Spazzysmod.Spazzysmod;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.LongHashMap;
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
	public boolean makePortal(Entity entity)
	{   
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 1, (int)entity.posZ, Spazzysmod.moonRocket.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 2, (int)entity.posZ, Block.blockIron.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 3, (int)entity.posZ, Block.glass.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 4, (int)entity.posZ, Block.blockIron.blockID);

		world.setBlock((int)entity.posX + 4, (int)entity.posY + 1, (int)entity.posZ, Block.fence.blockID);
		world.setBlock((int)entity.posX + 2, (int)entity.posY + 1, (int)entity.posZ, Block.fence.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 1, (int)entity.posZ - 1, Block.fence.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY + 1, (int)entity.posZ + 1, Block.fence.blockID);
		
		world.setBlock((int)entity.posX + 4, (int)entity.posY, (int)entity.posZ, Block.fence.blockID);
		world.setBlock((int)entity.posX + 2, (int)entity.posY, (int)entity.posZ, Block.fence.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY, (int)entity.posZ - 1, Block.fence.blockID);
		world.setBlock((int)entity.posX + 3, (int)entity.posY, (int)entity.posZ + 1, Block.fence.blockID);



		return true;
	}

	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) 
	{
		makePortal(par1Entity);
		return true;
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) 
	{
		makePortal(par1Entity);
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