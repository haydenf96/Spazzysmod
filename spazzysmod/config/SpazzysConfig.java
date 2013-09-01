package spazzysmod.config;

import net.minecraftforge.common.Configuration;

public class SpazzysConfig {

	public static int cheeseBlockID;
	public static int moonDirtID;
	public static int moonStoneID;
	public static int titaniumBlockID;
	public static int launchPadID;
	public static int marsRockID;
	public static int redRockID;
	public static int rocketID;

	public static int titaniumIngotID;
	public static int titaniumSwordID;
	public static int explosiveArrowID;
	public static int explosiveBowID;

	public static int spaceshipID;

	public static int titaniumHelmetID;
	public static int titaniumChestplateID;
	public static int titaniumLeggingsID;
	public static int titaniumBootsID;

	public static int spaceHelmetID;
	public static int spaceJacketID;
	public static int spacePantsID;
	public static int spaceShoesID;


	private static Configuration config;

	public static void initConfig(Configuration configuration) {
		config = configuration;
		config.load();

		// blocks
		cheeseBlockID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"Cheese Block ID", 2500, "CheeseBlockID").getInt();
		moonDirtID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"Moon Dirt ID", 255, "MoonDirtID").getInt();
		moonStoneID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"Moon Stone ID", 254, "MoonStoneID").getInt();
		titaniumBlockID = config.get(Configuration.CATEGORY_BLOCK,
				"Titanium Block ID", 501).getInt();
		redRockID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"red Rock ID", 2490, "redRockID").getInt();
		marsRockID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"mars Rock ID", 251, "marsRockID").getInt();

		rocketID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"Rocket Block ID", 2900, "CheeseBlockID").getInt();

		launchPadID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK,
				"Launch Pad ID", 2501, "LaunchPadID").getInt();

		// items
		titaniumIngotID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Ingot ID", 5000).getInt();
		titaniumSwordID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Sword ID", 5001).getInt();
		explosiveArrowID = config.get(Configuration.CATEGORY_ITEM,
				"Explosive Arrow ID", 5006).getInt();
		explosiveBowID = config.get(Configuration.CATEGORY_ITEM,
				"Explosive Bow ID", 5007).getInt();

		spaceshipID = config.get(Configuration.CATEGORY_ITEM,
				"Spaceship ID", 5008).getInt();

		
		// armor
		titaniumHelmetID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Helmet ID", 5002).getInt();
		titaniumChestplateID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Chestplate ID", 5003).getInt();
		titaniumLeggingsID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Leggings ID", 5004).getInt();
		titaniumBootsID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Boots ID", 5005).getInt();

		spaceHelmetID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Helmet ID", 5012).getInt();
		spaceJacketID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Chestplate ID", 5013).getInt();
		spacePantsID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Leggings ID", 5014).getInt();
		spaceShoesID = config.get(Configuration.CATEGORY_ITEM,
				"Titanium Boots ID", 5015).getInt();

		config.save();
	}
}