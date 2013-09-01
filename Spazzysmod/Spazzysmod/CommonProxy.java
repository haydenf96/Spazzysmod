package spazzysmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.client.gui.GuiPlanets;
import spazzysmod.client.gui.GuiUniverse;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
		return null;
	}

	@Override
	public Object getClientGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
		if ( ID == GuiPlanets.GUI_ID )
			return new GuiPlanets ( player );
		else if ( ID == GuiUniverse.GUI_ID )
			return new GuiUniverse ( player );
		
		return null;
	}
	
	public void initProxy () {
		NetworkRegistry.instance ().registerGuiHandler ( SpazzysmodBase.instance, this );
		
		SpazzysBlocks.initBlocks ();

		SpazzysItems.initItems ();

		SpazzysTabs.nameTabs ();

		SpazzysDimensions.registerDimensions ();

		PlanetAPI.populateUniverse ();
		
		this.registerEntities ();
	}
	
	public void registerEntities () {}
}