package spazzysmod.client.gui.api;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;

import spazzysmod.client.gui.RenderHelper;

public class GuiNewList<T> extends GuiButton 
{  
	private boolean dragging;
	private float slider;
	private ArrayList<T> itemList;
	private boolean focused;
	private float buttonHeight = height * 5 / 40f;
	private float buttonWidth = width * 160f / 216f;
	private float buttonWS = width * 5 / 54f;
	private int selected;

	public GuiNewList(int id, int x, int y, int width, int height) {
		super(x, x, y, width, height, "");
		dragging = false;
		slider = 0;
		itemList = new ArrayList<T>();
		focused = false;
		selected = -1;
	}

	@Override
	public void drawButton(Minecraft mc, int x, int y) {
		if (focused) {
			pollWheel();
		}
		boolean inside = isInside(x, y);
		if (dragging) {
			this.mouseDragged(mc, x, y);
		}

	//	mc.renderEngine.func_110577_a(ForgeRevCommonProxy.blankTexture);
		RenderHelper.drawTexturedQuadFit(xPosition + 3, yPosition + 3,
				width - 6, height - 6, zLevel, 139, 139, 139, 255);

	//	mc.renderEngine.func_110577_a(ForgeRevCommonProxy.listItemNotSelected);

		int startingItem = (int) (slider * (itemList.size() - 6));
		int numItemToRender = 6;
		if (itemList.size() < 6) {
			startingItem = 0;
			numItemToRender = itemList.size();
		}
		for (int i = startingItem; i < numItemToRender + startingItem; i++) {
			if(i != selected){
	//		mc.renderEngine.func_110577_a(ForgeRevCommonProxy.listItemNotSelected);
			}else{
		//		mc.renderEngine.func_110577_a(ForgeRevCommonProxy.listItemSelected);
			}
			RenderHelper.drawTexturedQuadFit(xPosition + buttonWS, yPosition
					+ buttonHeight * (1 + i - slider * (itemList.size() - 6)),
					buttonWidth, buttonHeight, zLevel);

			if (i+1 < itemList.size()
					&& yPosition + buttonHeight
							* (7 - slider * (itemList.size() - 6))
							+ buttonHeight < yPosition + width * 136 / 156f) {
				if(i+1 != selected){
		//			mc.renderEngine
			//				.func_110577_a(ForgeRevCommonProxy.listItemNotSelected);
					}else{
			//			mc.renderEngine.func_110577_a(ForgeRevCommonProxy.listItemSelected);
					}
				RenderHelper.drawTexturedQuadFit(
						xPosition + buttonWS,
						yPosition + buttonHeight
								* (2 + i - slider * (itemList.size() - 6)),
						buttonWidth, buttonHeight, zLevel);
				mc.fontRenderer.drawStringWithShadow(itemList.get(i + 1)
						.toString(), (int) (xPosition + width * 20 / 216f
						+ buttonWidth / 2 - mc.fontRenderer
						.getStringWidth(itemList.get(i + 1).toString()) / 2),
						(int) (yPosition + buttonHeight / 2 - 4 + buttonHeight
								* (2 + i - slider * (itemList.size() - 6))),
						0xffffff);
			}
			mc.fontRenderer
					.drawStringWithShadow(
							itemList.get(i).toString(),
							(int) (this.xPosition + width * 20 / 216f
									+ buttonWidth / 2 - mc.fontRenderer
									.getStringWidth(itemList.get(i).toString()) / 2),
							(int) (yPosition + buttonHeight / 2 - 4 + buttonHeight
									* (1 + i - slider * (itemList.size() - 6))),
							0xffffff);

		}

	//	mc.renderEngine.func_110577_a(ForgeRevCommonProxy.guiListForeground);
		RenderHelper.drawTexturedQuadFit(xPosition, yPosition,
				width, height, zLevel);

	//	mc.renderEngine.func_110577_a(ForgeRevCommonProxy.slider);
		RenderHelper.drawTexturedQuadFit(this.xPosition + width * 31 / 36f,
				yPosition + height * 5 / 39f + slider * height * 101f
						/ 156f, width / 18f, height * 5 / 52f, zLevel);
	}

	private void pollWheel() {
		int wdx = Mouse.getDWheel();
		if (wdx != 0) {
			if (wdx < 0) {
				slider = slider + 1 / (float) (itemList.size());
				if (slider > 1) {
					slider = 0.999f;
				}
			} else {
				slider = slider - 1 / (float) (itemList.size());
				if (slider < 0) {
					slider = 0;
				}
			}
		}
	}

	@Override
	public void mouseDragged(Minecraft mc, int x, int y) {
		slider = (y - (yPosition + height / 6f))
				/ (height * 109 / 216f + height / 6);
		if (slider > 1) {
			slider = 0.999f;
		} else if (slider < 0) {
			slider = 0;
		}
	}

	@Override
	public boolean mousePressed(Minecraft mc, int x, int y) {
		if (isInside(x, y)) {
			boolean insideBar = x > this.xPosition + width * 186f / 216f
					&& x < xPosition + width * 197 / 216f && y > yPosition
					&& y < yPosition + height;
			if (insideBar) {
				dragging = true;
			}else{
				dragging = false;
			}
			if (x > this.xPosition + width * 20 / 216f
					&& x < xPosition + width * 179 / 216f
					&& y < yPosition + height * 136 / 156f
					&& y > yPosition + height * 20 / 156f) {
				
				
				int startingItem = (int) (slider * (itemList.size() - 6));
				
				for (int i = startingItem; i < 6 + startingItem; i++) {
					RenderHelper.drawTexturedQuadFit(xPosition + buttonWS, yPosition
							+ buttonHeight * (1 + i - slider * (itemList.size() - 6)),
							buttonWidth, buttonHeight, this.zLevel);
					
					if(x > xPosition + buttonWS && x < xPosition + buttonWS+buttonWidth && y > yPosition
							+ buttonHeight * (1 + i - slider * (itemList.size() - 6)) && y < yPosition
							+ buttonHeight * (1 + i - slider * (itemList.size() - 6))+buttonHeight){
						selected = i;
					}
				}
			}
			focused = true;

			if(selected+1 > itemList.size()){
				selected = -1;
			}
			return true;
		} else {
			focused = false;
			dragging = false;
			return false;
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		dragging = false;
	}

	private boolean isInside(int x, int y) {
		return x >= this.xPosition && y >= yPosition
				&& x < xPosition + width
				&& y < yPosition + height;
	}

	public void add(T t) {
		itemList.add(t);
	}
	
	public int getSelected(){
		return selected;
	}
	
	public T getSelectedItem(){
		try{
		return itemList.get(selected);
		}catch(Exception e){
			return null;
		}
	}
	
	public void remove(int item){
		itemList.remove(item);
	}
	
	public void remove(T item){
		for(int i = 0; i < itemList.size(); i++){
			if(itemList.get(i).equals(item)){
				itemList.remove(i);
				break;
			}
		}
	}
	
	public void setList(ArrayList<T> list){
		itemList = list;
	}
}
