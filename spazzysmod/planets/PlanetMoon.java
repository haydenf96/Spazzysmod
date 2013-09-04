package spazzysmod.planets;

import spazzysmod.galaxies.SpazzysGalaxies;
import spazzysmod.world.SpazzysDimensions;

public class PlanetMoon extends Planet {

	public PlanetMoon () {
		super ( "Moon", 0, "PATH TO PLANET TEXTURE", 0, -30, SpazzysDimensions.moonDimensionID, SpazzysGalaxies.milkyWay.getGalaxyID() );
	}
}