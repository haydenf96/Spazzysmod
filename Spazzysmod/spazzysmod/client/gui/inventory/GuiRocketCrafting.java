package spazzysmod.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiRocketCrafting extends GuiContainer {
	public static final int GUI_ID = 21;

	private static final ResourceLocation field_110422_t = new ResourceLocation("textures/gui/container/crafting_table.png");

	public GuiRocketCrafting ( InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5 ) {
		super( new ContainerRocketWorkbench ( par1InventoryPlayer, par2World, par3, par4, par5 ) );
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer ( int par1, int par2 ) {
		this.fontRenderer.drawString ( "Rocket Workbench", 28, 6, 4210752 );
		this.fontRenderer.drawString ( I18n.func_135053_a("container.inventory"), 8, this.ySize - 96 + 2, 4210752 );
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the items)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer ( float par1, int par2, int par3 ) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.func_110434_K().func_110577_a(field_110422_t);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}