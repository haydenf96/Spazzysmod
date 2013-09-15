package spazzysmod;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.Configuration;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.world.TeleporterSpazzys;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = SpazzysmodBase.MODID, name = "Spazzy's Mod", version = "V 0.71")
@NetworkMod ( clientSideRequired = true, serverSideRequired = false )
public class SpazzysmodBase {

	public static final String MODID = "spazzysmod";
	
	@Instance ( SpazzysmodBase.MODID )
	public static SpazzysmodBase instance;

	@SidedProxy ( clientSide = "spazzysmod.CommonProxy", serverSide = "spazzysmod.client.ClientProxy" )
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		SpazzysConfig.initConfig(new Configuration(event.getSuggestedConfigurationFile()));
	}
	
	public static void travelToDimension(int dimensionID, EntityPlayerMP player)
	{
		EntityPlayerMP thePlayer =  player;
		
		thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer,dimensionID,new TeleporterSpazzys(thePlayer.mcServer.worldServerForDimension(dimensionID)));
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{		
		proxy.initProxy();
	}
}