package Spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import Spazzysmod.Spazzysmod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTitaniumBlock extends Block {

    public BlockTitaniumBlock(int id, Material par2Material) {
        super(id, par2Material);
        this.setCreativeTab(Spazzysmod.SolarSystemTab).setHardness(50.0F)
                .setResistance(2000.0F);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Spazzysmod.modid + ":"
                + this.getUnlocalizedName2());
    }

}
