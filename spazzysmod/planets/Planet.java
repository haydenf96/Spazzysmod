package spazzysmod.planets;

import net.minecraft.world.WorldProvider;

public class Planet {

	/**
	 * The name of the planet
	 */
	private String planetName;

	/**
	 * The ID for this planet
	 */
	private int planetID;

	/**
	 * The path to the planets texture
	 */
	private String planetTexture;

	/**
	 * The x and y coordinates for the MAP, not actual locations
	 */
	private int xCoord, yCoord;

	/**
	 * The dimension ID that corresponds with the planet
	 */
	private int planetDimensionID;

	private int galaxyAttatchedTo;

	/**
	 * Has this planet got breathable oxygen?
	 */
	private boolean hasBreathableOxygen;

	/**
	 * 
	 * @param par1Str
	 *            - The name of the planet
	 * @param par2
	 *            - xCoord on map
	 * @param par3
	 *            - yCoord on map
	 */
	// TODO - Need to make an achievement system to unlock planets, then add the
	// achievement needed to unlock the planet...
	public Planet(String pName, int pID, String par3Str, int x, int y,
			int pDimensionID, int par7, boolean hasPlanetGotBreathableOxegyn) {
		this.planetName = pName;
		this.planetID = pID;
		this.planetTexture = par3Str;
		this.xCoord = x;
		this.yCoord = y;
		this.planetDimensionID = pDimensionID;
		this.galaxyAttatchedTo = par7;
		this.hasBreathableOxygen = hasPlanetGotBreathableOxegyn;
	}

	public String getPlanetName() {
		return this.planetName;
	}

	public int getPlanetID() {
		return this.planetID;
	}

	public int getXCoord() {
		return this.xCoord;
	}

	public int getYCoord() {
		return this.yCoord;
	}

	public int getPlanetDimensionID() {
		return this.planetDimensionID;
	}

	public boolean getHasPlanetBreathableOxygen() {
		return this.hasBreathableOxygen;
	}
}