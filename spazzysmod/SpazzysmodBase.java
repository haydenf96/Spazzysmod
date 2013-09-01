package spazzysmod;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.Configuration;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.tick.PlayerTickHandler;
import spazzysmod.world.SpazzysDimensions;
import spazzysmod.world.TeleporterSpazzys;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = SpazzysmodBase.modid, name = "Spazzy's Mod", version = "V 0.4")
@NetworkMod ( clientSideRequired = true, serverSideRequired = false )
public class SpazzysmodBase {

	public static final String modid = "Spazzy_Spazzysmod";
	
	@Instance ( SpazzysmodBase.modid )
	public static SpazzysmodBase instance;

	@SidedProxy ( clientSide = "spazzysmod.CommonProxy", serverSide = "spazzysmod.client.ClientProxy" )
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SpazzysConfig.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
	}
	
	public static void travelToDimension(int dimensionID, EntityPlayerMP player)
	{
		EntityPlayerMP thePlayer =  player;
		
		thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,dimensionID,new TeleporterSpazzys(thePlayer.mcServer.worldServerForDimension(dimensionID)));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initProxy();
	}
	
	public static void displayGUI ( int guiID ) {
		Minecraft.getMinecraft ().thePlayer.openGui ( SpazzysmodBase.instance, guiID, Minecraft.getMinecraft ().theWorld, 0, 0, 0);
	}
}