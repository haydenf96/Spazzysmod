package Spazzysmod.creativeTabs;

import Spazzysmod.Spazzysmod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class TabMoon extends CreativeTabs
{

	public TabMoon(String s)
	{
		super(s);		
	}
	
	@SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex()
    {
        return Spazzysmod.moonStone.blockID;
    }

}
