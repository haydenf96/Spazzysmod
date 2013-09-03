package spazzysmod.galaxies;

import net.minecraft.world.WorldProvider;

public class Galaxy
{
	/**
	 * The name of the galaxy
	 */
	private String galaxyName;

	/**
	 * The ID for this planet
	 */
	private int galaxyID;


	/**
	 * 
	 * @param par1Str - The name of the galaxy
	 */
	public Galaxy ( String par1Str, int par2) 
	{
		this.galaxyName = par1Str;
		this.galaxyID = par2;
	}

	public String getGalaxyName () {
		return this.galaxyName;
	}

	public int getGalaxyID () {
		return this.galaxyID;
	}

}