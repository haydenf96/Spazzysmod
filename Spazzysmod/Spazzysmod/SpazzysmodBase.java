package spazzysmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.Configuration;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

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

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.initProxy ();
	}
	
	public static void displayGUI ( int guiID ) {
		Minecraft.getMinecraft ().thePlayer.openGui ( SpazzysmodBase.instance, guiID, Minecraft.getMinecraft ().theWorld, 0, 0, 0);
	}
}