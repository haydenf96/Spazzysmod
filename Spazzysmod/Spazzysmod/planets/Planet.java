package spazzysmod.planets;

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
	 * The x and y coordinates for the MAP, not actual locations
	 */
	private int xCoord, yCoord;

	/**
	 * The dimension ID that corresponds with the planet
	 */
	private int planetDimensionID;

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
	public Planet(String par1Str, int par2, int par3, int par4, int par5) {
		this.planetName = par1Str;
		this.planetID = par2;
		this.xCoord = par3;
		this.yCoord = par4;
		this.planetDimensionID = par5;
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
}