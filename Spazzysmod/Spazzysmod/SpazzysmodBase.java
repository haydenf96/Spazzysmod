package spazzysmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.Configuration;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.SpazzysDimensions;
import spazzysmod.world.TeleporterSpazzys;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SpazzysmodBase.modid, name = "Spazzy's Mod", version = "V 0.4")
public class SpazzysmodBase {

	@Instance ( SpazzysmodBase.modid )
	public static SpazzysmodBase instance;
	
	public static final String modid = "Spazzy_Spazzysmod";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SpazzysConfig.initConfig(new Configuration(event
				.getSuggestedConfigurationFile()));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		SpazzysBlocks.initBlocks();

		SpazzysItems.initItems();

		SpazzysTabs.nameTabs();

		SpazzysDimensions.registerDimensions();

		PlanetAPI.populateUniverse();

		SpazzysEntitys.registerEntitySpawns();
		SpazzysEntitys.registerEntities();
	}
	
	public static void displayGUISpazzys(GuiScreen guiScreen) {
		Minecraft.getMinecraft().displayGuiScreen(guiScreen);
	}
}