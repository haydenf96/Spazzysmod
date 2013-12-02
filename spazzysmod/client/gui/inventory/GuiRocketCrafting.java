package spazzysmod.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import spazzysmod.SpazzysmodBase;

public class GuiRocketCrafting extends GuiContainer {
	public static final int GUI_ID = 21;

	private ResourceLocation better = new ResourceLocation(
			SpazzysmodBase.MODID, "textures/gui/rocketWorkbench.png");

	public GuiRocketCrafting(InventoryPlayer inventoryplayer, World world,
			int i, int j, int k) {
		super(new ContainerRocketWorkbench(inventoryplayer, world, i, j, k));
	}

	public void onGuiClosed() {
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(
				StatCollector.translateToLocal("\u00a76Rocket"), 120, 5,
				0x404040);
		this.fontRenderer.drawString(
				StatCollector.translateToLocal("\u00a76Crafting"), 116, 20,
				0x404040);
		// this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"),
		// 8, this.ySize - 96 - 14, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.func_110577_a(better);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
	}
}