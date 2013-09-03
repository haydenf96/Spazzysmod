package spazzysmod.api.galaxies;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import spazzysmod.galaxies.Galaxy;
import spazzysmod.galaxies.SpazzysGalaxies;
import spazzysmod.planets.Planet;
import spazzysmod.world.TeleporterSpazzys;

public class GalaxyAPI {

	private static List<Galaxy> galaxyList = new ArrayList<Galaxy>();

	public static void addSpazzyGalaxies ()
	{
		System.out.println( "[Spazzys Galaxy API] Populating the Universe..." );

		GalaxyAPI.registerGalaxy(SpazzysGalaxies.milkyWay);

		System.out.println( "[Spazzys Galaxy API] Populated!" );
	}


	public static void registerGalaxy ( Galaxy galaxy ) 
	{
		galaxyList.add(galaxy.getGalaxyID(), galaxy );
	}

	public static Galaxy getGalaxy ( int galaxyID ) {
		return galaxyList.get( galaxyID );
	}

	public static String getGalaxyName ( int galaxyID ) {
		return galaxyList.get( galaxyID ).getGalaxyName();
	}


	public static List<Galaxy> getGalaxiesList () {
		return galaxyList;
	}
	
}