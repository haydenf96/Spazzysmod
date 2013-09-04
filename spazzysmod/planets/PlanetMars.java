package spazzysmod.planets;

import spazzysmod.galaxies.SpazzysGalaxies;
import spazzysmod.world.SpazzysDimensions;

public class PlanetMars extends Planet {

	public PlanetMars() {
		super( "Mars", 1, "PATH TO PANET TEXTURE", -20, -50, SpazzysDimensions.marsDimensionID, SpazzysGalaxies.milkyWay.getGalaxyID(), false );
	}
}