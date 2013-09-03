package spazzysmod.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderHelper {
	
	@SideOnly(Side.CLIENT)
	public static void drawTexturedQuadFit ( double x, double y, double width, double height, double zLevel ) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
        tessellator.startDrawingQuads();
		tessellator.setColorOpaque(255, 255, 255);
        tessellator.addVertexWithUV(x + 0, y + height, zLevel, 0,1);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, 1, 1);
        tessellator.addVertexWithUV(x + width, y + 0, zLevel, 1,0);
        tessellator.addVertexWithUV(x + 0, y + 0, zLevel, 0, 0);
		tessellator.setColorOpaque(255, 255, 255);
        tessellator.draw();
	}
	
	public static void drawTexturedQuadFit ( double x, double y, double width, double height, double zLevel, int R, int G, int B, int A ) {
		Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(R, G, B, A);
        tessellator.addVertexWithUV(x, y + height, zLevel, 0,1);
        tessellator.addVertexWithUV(x + width, y + height, zLevel, 1, 1);
        tessellator.addVertexWithUV(x + width, y, zLevel, 1,0);
        tessellator.addVertexWithUV(x, y, zLevel, 0, 0);
		tessellator.setColorOpaque(255, 255, 255);
        tessellator.draw();
	}
}
