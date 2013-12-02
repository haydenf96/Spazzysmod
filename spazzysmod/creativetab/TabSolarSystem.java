package spazzysmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.item.SpazzysItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabSolarSystem extends CreativeTabs {

	public TabSolarSystem(String s) {
		super(s);
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * the itemID for the item to be displayed on the tab
	 */
	public int getTabIconItemIndex() {
		return SpazzysItems.spaceship.itemID;
	}
}