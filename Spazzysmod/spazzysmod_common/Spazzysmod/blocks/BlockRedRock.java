package Spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import Spazzysmod.SpazzysmodBase;
import Spazzysmod.creativetab.SpazzysTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRedRock extends Block {

    public BlockRedRock(int id, Material par2Material) {
        super(id, par2Material);
        this.setCreativeTab(SpazzysTabs.tabMars);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(SpazzysmodBase.modid + ":"
                + this.getUnlocalizedName2());
    }

}
