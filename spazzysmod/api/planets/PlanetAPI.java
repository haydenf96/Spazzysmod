package spazzysmod.api.planets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import spazzysmod.planets.Planet;
import spazzysmod.planets.PlanetMars;
import spazzysmod.planets.PlanetMoon;
import spazzysmod.planets.SpazzysPlanets;
import spazzysmod.world.TeleporterSpazzys;

public class PlanetAPI {

	private static List<Planet> planetList = new ArrayList<Planet>();

	public static void populateUniverse() 
	{
		System.out.println( "[Spazzy Planets API] Populating the Universe..." );

		PlanetAPI.registerPlanet ( SpazzysPlanets.MOON );
		PlanetAPI.registerPlanet ( SpazzysPlanets.MARS );

		System.out.println( "[Spazzy Planets API] Populated!" );
	}


	public static void registerPlanet ( Planet planet )
	{
		planetList.add (planet.getPlanetID(), planet );
	}

	public static Planet getPlanet ( int planetID ) {
		return planetList.get( planetID );
	}

	public static String getPlanetName ( int planetID ) {
		return planetList.get( planetID ).getPlanetName();
	}

	public static int getPlanetXCoord ( int planetID ) {
		return planetList.get( planetID ).getXCoord();
	}

	public static int getPlanetYCoord ( int planetID ) {
		return planetList.get( planetID ).getYCoord();
	}

	public static List<Planet> getPlanetsList () {
		return planetList;
	}
	

	public static void travelToDimension ( Planet planet, EntityPlayerMP player) {
		player.mcServer.getConfigurationManager ().transferPlayerToDimension ( player, planet.getPlanetDimensionID(),
				new TeleporterSpazzys ( player.mcServer.worldServerForDimension ( planet.getPlanetDimensionID() ) ) );
	}
	
	public static void travelToOverworld ( EntityPlayerMP player ) {
		player.mcServer.getConfigurationManager ().transferPlayerToDimension ( player, 0, new TeleporterSpazzys ( player.mcServer.worldServerForDimension ( 0 ) ) );
	}
}