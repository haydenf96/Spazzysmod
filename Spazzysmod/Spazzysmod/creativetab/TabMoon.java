package spazzysmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import spazzysmod.blocks.MoonBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMoon extends CreativeTabs {

	public TabMoon(String s) {
		super(s);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * the itemID for the item to be displayed on the tab
	 */
	public int getTabIconItemIndex() {
		return MoonBlocks.moonStone.blockID;
	}

}
