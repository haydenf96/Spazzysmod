package spazzysmod;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.Configuration;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.tick.PlayerTickHandler;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
<<<<<<< HEAD:Spazzysmod/Spazzysmod/SpazzysmodBase.java
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = SpazzysmodBase.modid, name = "Spazzy's Mod", version = "V 0.4")
@NetworkMod ( clientSideRequired = true, serverSideRequired = false )
public class SpazzysmodBase {
=======
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = SpazzysmodBase.modid, name = "Spazzy's Mod", version = "V 0.4")
public class SpazzysmodBase 
{
>>>>>>> f700c62ede898cb1527ed31d5e89d9dfba9a6caf:spazzysmod/SpazzysmodBase.java

	public static final String modid = "Spazzy_Spazzysmod";
	
	@Instance ( SpazzysmodBase.modid )
	public static SpazzysmodBase instance;

<<<<<<< HEAD:Spazzysmod/Spazzysmod/SpazzysmodBase.java
	@SidedProxy ( clientSide = "spazzysmod.CommonProxy", serverSide = "spazzysmod.client.ClientProxy" )
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SpazzysConfig.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initProxy ();
=======
	
	public static void travelToDimension(int dimensionID, EntityPlayerMP player)
	{
		EntityPlayerMP thePlayer =  player;
		
		thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,dimensionID,new TeleporterSpazzys(thePlayer.mcServer.worldServerForDimension(dimensionID)));
	}
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		SpazzysConfig.initConfig(new Configuration(event
				.getSuggestedConfigurationFile()));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);
		
		SpazzysBlocks.initBlocks();

		SpazzysItems.initItems();

		SpazzysTabs.nameTabs();

		SpazzysDimensions.registerDimensions();

		PlanetAPI.populateUniverse();

		SpazzysEntitys.registerEntitySpawns();
		SpazzysEntitys.registerEntities();
>>>>>>> f700c62ede898cb1527ed31d5e89d9dfba9a6caf:spazzysmod/SpazzysmodBase.java
	}
	
	public static void displayGUI ( int guiID ) {
		Minecraft.getMinecraft ().thePlayer.openGui ( SpazzysmodBase.instance, guiID, Minecraft.getMinecraft ().theWorld, 0, 0, 0);
	}
}