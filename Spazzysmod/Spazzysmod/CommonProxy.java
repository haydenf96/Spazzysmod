package spazzysmod;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.client.gui.GuiPlanets;
import spazzysmod.client.gui.GuiUniverse;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.item.SpazzysItems;
import spazzysmod.tick.PlayerTickHandler;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if (ID == GuiPlanets.GUI_ID)
			return new GuiPlanets(player);
		else if (ID == GuiUniverse.GUI_ID)
			return new GuiUniverse(player);

		return null;
	}

	public void initProxy() {
		NetworkRegistry.instance().registerGuiHandler(SpazzysmodBase.instance,
				this);

		SpazzysBlocks.initBlocks();

		SpazzysItems.initItems();

		SpazzysTabs.nameTabs();

		SpazzysDimensions.registerDimensions();

		PlanetAPI.populateUniverse();

		TickRegistry
				.registerTickHandler(
						new PlayerTickHandler(EnumSet.of(TickType.PLAYER)),
						Side.SERVER);

		this.registerEntities();
		this.registerTickHandlers();
	}

	public void registerEntities() {
	}

	public void registerTickHandlers() {
	}
}