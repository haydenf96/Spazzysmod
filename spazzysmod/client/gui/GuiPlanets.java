package spazzysmod.client.gui;

import intergalacticTravelMod.item.IntergalacticTravelModItems;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import spazzysmod.SpazzysmodBase;
import spazzysmod.item.SpazzysItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class GuiPlanets extends GuiScreen
{
	private final EntityPlayerMP player;
	protected String screenTitle = "Select a planet";
	byte b0 = -16;

	public GuiPlanets(EntityPlayer par1EntityPlayer)
	{
		player = (EntityPlayerMP) par1EntityPlayer;
	}


	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	public void initGui()
	{
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 24 + b0, "Overworld"));
		this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 44 + b0, "Moon"));
		this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 64 + b0, "Mars"));
		this.screenTitle = "Select a planet";
	}

	/**
	 * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
	 */
	protected void actionPerformed(GuiButton par1GuiButton)
	{   

		EntityPlayerMP thePlayer = player;

		if (par1GuiButton.id == 0)
		{
			if(thePlayer.dimension != 0)
			{
				
				SpazzysmodBase.travelToDimension(0, thePlayer);
				ItemStack itemstack = new ItemStack(SpazzysItems.spaceship, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
				this.mc.displayGuiScreen((GuiScreen)null);
			}
			else
			{
				ItemStack itemstack = new ItemStack(IntergalacticTravelModItems.rocket, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
				this.mc.displayGuiScreen((GuiScreen)null);
			}
		}

		if (par1GuiButton.id == 1)
		{
			if(thePlayer.dimension != 10)
			{
				SpazzysmodBase.travelToDimension(10, thePlayer);
				ItemStack itemstack = new ItemStack(IntergalacticTravelModItems.rocket, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
				this.mc.displayGuiScreen((GuiScreen)null);
			}
			else
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				ItemStack itemstack = new ItemStack(IntergalacticTravelModItems.rocket, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
			}
			
		}

		if (par1GuiButton.id == 2)
		{
			if(thePlayer.dimension != 12)
			{
				SpazzysmodBase.travelToDimension(12, thePlayer);
				ItemStack itemstack = new ItemStack(IntergalacticTravelModItems.rocket, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
				this.mc.displayGuiScreen((GuiScreen)null);
			}
			else
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				ItemStack itemstack = new ItemStack(IntergalacticTravelModItems.rocket, 1, 0);
				EntityItem entityitem = thePlayer.dropPlayerItem(itemstack);
				entityitem.delayBeforeCanPickup = 0;
			}
		}

	}


	/**
	 * Called when the mouse is clicked.
	 */
	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, "Select A Planet", this.width / 2, 40, 16777215);
		super.drawScreen(par1, par2, par3);
	}
}
