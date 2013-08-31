package spazzysmod.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spazzysmod.blocks.SpazzysBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpaceship extends Item
{
	public ItemSpaceship(int par1)
	{
		super(par1);
		this.maxStackSize = 1;
		this.setMaxDamage(1);
		this.setUnlocalizedName("rocket");
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (par7 == 0)
		{
			--par5;
		}

		if (par7 == 1)
		{
			++par5;
		}

		if (par7 == 2)
		{
			--par6;
		}

		if (par7 == 3)
		{
			++par6;
		}

		if (par7 == 4)
		{
			--par4;
		}

		if (par7 == 5)
		{
			++par4;
		}

		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			if(world.getBlockId(par4, par5 -1, par6) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 -1, par5 -1, par6) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 + 1, par5 -1, par6) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 - 1, par5 -1, par6 - 1) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 + 1, par5 -1, par6 - 1) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4, par5 -1, par6 - 1) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 - 1, par5 -1, par6 + 1) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4 + 1, par5 -1, par6 + 1) == SpazzysBlocks.launchPad.blockID &&
					world.getBlockId(par4, par5 -1, par6 + 1) == SpazzysBlocks.launchPad.blockID)
			{

				world.setBlock(par4, par5 + 1, par6, SpazzysBlocks.rocketBlock.blockID);
				world.setBlock(par4, par5 + 2, par6, Block.blockIron.blockID);
				world.setBlock(par4, par5 + 3, par6, Block.glass.blockID);
				world.setBlock(par4, par5 + 4, par6, Block.blockIron.blockID);

				world.setBlock(par4 + 1, par5 + 1, par6, Block.fence.blockID);
				world.setBlock(par4 - 1, par5 + 1, par6, Block.fence.blockID);
				world.setBlock(par4, par5 + 1, par6 - 1, Block.fence.blockID);
				world.setBlock(par4, par5 + 1, par6 + 1, Block.fence.blockID);

				world.setBlock(par4 + 1, par5, par6, Block.fence.blockID);
				world.setBlock(par4 - 1, par5, par6, Block.fence.blockID);
				world.setBlock(par4, par5, par6 - 1, Block.fence.blockID);
				world.setBlock(par4, par5, par6 + 1, Block.fence.blockID);

				--par1ItemStack.stackSize;

			}
			else
			{
				par2EntityPlayer.addChatMessage("You need a launch pad!");
			}

			
			return true;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) 
	{
		this.itemIcon = par1IconRegister.registerIcon("spazzysmod:spaceship");
	}

}
