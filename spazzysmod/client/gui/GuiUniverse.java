package spazzysmod.client.gui;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import spazzysmod.SpazzysResources;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.client.gui.api.GuiNewList;
import spazzysmod.planets.Planet;

public class GuiUniverse extends GuiScreen {

	public static final int GUI_ID = 20;
	
	private List<Planet> planetList = PlanetAPI.getPlanetsList ();
	private GuiNewList<String> newList;
	
	public GuiUniverse ( EntityPlayer par1EntityPlayer ) {}
	
	@Override
	public void drawScreen ( int x, int y, float idk )
	{
		this.drawDefaultBackground();
		
		// TODO - all the rendering etc. for the map
		this.mc.renderEngine.func_110577_a ( SpazzysResources.GUI_UNIVERSE );
		RenderHelper.drawTexturedQuadFit ( 0, 0, width, height, this.zLevel );
	}
	
	@Override
	public void initGui () {
		newList = new GuiNewList<String>(0, 0, 0, 200, 200 /* ( width / 4 * 3 ), 0, ( width / 4 ), height */);
		
		for ( int i = 0; i < planetList.size(); ++i )
			newList.add ( planetList.get ( i ).getPlanetName() );
		
		buttonList.add ( newList );
	}
}