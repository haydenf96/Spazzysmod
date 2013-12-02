package spazzysmod;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import spazzysmod.api.SpazzysAPI;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.client.gui.GuiPlanets;
import spazzysmod.client.gui.GuiUniverse;
import spazzysmod.client.gui.inventory.ContainerRocketWorkbench;
import spazzysmod.client.gui.inventory.GuiRocketCrafting;
import spazzysmod.crafting.ReciperManager;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.entity.SpazzysEntitys;
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
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (ID == GuiRocketCrafting.GUI_ID)
			return ID == GuiRocketCrafting.GUI_ID
					&& world.getBlockId(x, y, z) == SpazzysBlocks.rocketWorkbench.blockID ? new ContainerRocketWorkbench(
					player.inventory, world, x, y, z) : null;
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if (ID == GuiPlanets.GUI_ID)
			return new GuiPlanets(player);
		else if (ID == GuiUniverse.GUI_ID)
			return new GuiUniverse(player);
		else if (ID == GuiRocketCrafting.GUI_ID)
			return ID == GuiRocketCrafting.GUI_ID
					&& world.getBlockId(x, y, z) == SpazzysBlocks.rocketWorkbench.blockID ? new GuiRocketCrafting(
					player.inventory, world, x, y, z) : null;

		return null;
	}

	public void initProxy() {
		NetworkRegistry.instance().registerGuiHandler(SpazzysmodBase.instance,
				this);

		SpazzysBlocks.initBlocks();

		SpazzysItems.initItems();

		ReciperManager.craftItems();

		SpazzysTabs.nameTabs();

		SpazzysEntitys.registerEntities();

		SpazzysEntitys.registerEntitySpawns();

		SpazzysDimensions.registerDimensions();

		SpazzysAPI.populateUniverse();

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