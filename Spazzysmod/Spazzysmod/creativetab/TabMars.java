package Spazzysmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import Spazzysmod.blocks.MarsBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMars extends CreativeTabs {

    public TabMars(String s) {
        super(s);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {
        return MarsBlocks.marsRock.blockID;
    }

}
