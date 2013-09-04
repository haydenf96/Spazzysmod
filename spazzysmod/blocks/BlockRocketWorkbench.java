package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import spazzysmod.SpazzysmodBase;
import spazzysmod.client.gui.inventory.GuiRocketCrafting;
import spazzysmod.creativetab.SpazzysTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRocketWorkbench extends Block
{
    @SideOnly ( Side.CLIENT )
    private Icon workbenchIconTop;
    @SideOnly ( Side.CLIENT )
    private Icon workbenchIconFront;

    protected BlockRocketWorkbench ( int par1 )
    {
        super ( par1, Material.iron );
        this.setCreativeTab ( SpazzysTabs.tabSolarSystem );
        this.setHardness ( 1F );
        this.setResistance ( 1F );
        this.func_111022_d ( SpazzysmodBase.MODID + ":" + this.getUnlocalizedName ().substring ( 5 ) );
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
    public Icon getIcon ( int par1, int par2 ) {
        return par1 == 1 ? this.workbenchIconTop : ( par1 == 0 ? Block.blockIron.getBlockTextureFromSide ( par1) : ( par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.isRemote) return true;
        else {
            SpazzysmodBase.displayGUI ( new GuiRocketCrafting ( par5EntityPlayer.inventory, par1World, par2, par3, par4 ) );
            return true;
        }
    }
}