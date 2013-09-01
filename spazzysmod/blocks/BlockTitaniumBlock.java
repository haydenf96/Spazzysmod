package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import spazzysmod.creativetab.SpazzysTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTitaniumBlock extends Block {

    public BlockTitaniumBlock(int id, Material par2Material) {
        super(id, par2Material);
        this.setCreativeTab(SpazzysTabs.tabSolarSystem).setHardness(50.0F)
                .setResistance(2000.0F);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("spazzysmod:"
                + this.getUnlocalizedName().substring(5));
    }

}
