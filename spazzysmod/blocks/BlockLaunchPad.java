package spazzysmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import spazzysmod.SpazzysmodBase;

public class BlockLaunchPad extends Block
{

    public BlockLaunchPad(int id, Material par2Material) 
    {
        super(id, par2Material);
        this.setHardness(1F);
        this.setResistance(1F);
        this.func_111022_d ( SpazzysmodBase.MODID + ":launchPad" );
    }
}