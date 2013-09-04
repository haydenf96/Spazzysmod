package spazzysmod.galaxies;

import java.util.List;

import spazzysmod.planets.Planet;

public class Galaxy
{
	/**
	 * The name of the galaxy
	 */
	private String galaxyName;

	/**
	 * The ID for this galaxy
	 */
	private int galaxyID;

	/**
	 * The x coord on the Galaxy map
	 */
	private int xCoord;

	/**
	 * The y coord on the Galaxy map
	 */
	private int yCoord;

	/**
	 * The path to the galaxy's icon
	 */
	private String texturePath;

	/**
	 * The list of planets that this galaxy contains
	 */
	private List<Planet> planetsInTheGalaxy;

	/**
	 * 
	 * @param par1Str - The name of the galaxy
	 */
	public Galaxy ( String par1Str, int par2, int par3, int par4, String par5Str, Planet [] par6Planets ) 
	{
		this.galaxyName = par1Str;
		this.galaxyID = par2;
		this.xCoord = par3;
		this.yCoord = par4;
		this.texturePath = par5Str;

//		for ( Planet planet : par6Planets )
//			planetsInTheGalaxy.add ( planet.getPlanetID(), planet );
	}

	public String getGalaxyName () {
		return this.galaxyName;
	}

	public int getGalaxyID () {
		return this.galaxyID;
	}

	public List<Planet> getPlanetsInGalaxy () {
		return planetsInTheGalaxy;
	}
}