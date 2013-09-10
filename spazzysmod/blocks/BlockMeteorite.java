package spazzysmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMeteorite extends Block
{

	public BlockMeteorite(int par1)
	{
		super(par1, Material.rock);
		this.setHardness(5F);
		this.setResistance(1000F);
		this.setUnlocalizedName("meteorite");
	}
	@SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("spazzysmod:meteorite");
    }


}
