
package spazzysmod.item.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import spazzysmod.item.SpazzysItems;

public class ItemSpacesuit extends ItemArmor
{
	public String armorNamePrefix;
	public EnumArmorMaterial material;

	public ItemSpacesuit(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		par2EnumArmorMaterial.getDamageReductionAmount(par4);
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabCombat);

	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{	
		if(this.itemID == SpazzysItems.spaceHelmet.itemID)
		{
			itemIcon = iconRegister.registerIcon("spazzysmod:spacesuitHelm");
		}
		else if(this.itemID == SpazzysItems.spaceJacket.itemID)
		{
			itemIcon = iconRegister.registerIcon("spazzysmod:spacesuitJacket" );
		}
		else if(this.itemID == SpazzysItems.spacePants.itemID)
		{
			itemIcon = iconRegister.registerIcon("spazzysmod:spacesuitPants" );
		}
		else
		{
			itemIcon = iconRegister.registerIcon("spazzysmod:spacesuitFeet" );
		}

	}


	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(this.itemID == SpazzysItems.spaceHelmet.itemID)
		{
			return "spazzysmod:/textures/armor/SPACESUIT_1.png";
		}
		else if(this.itemID == SpazzysItems.spaceJacket.itemID)
		{
			return "spazzysmod:/textures/armor/SPACESUIT_1.png";
		}
		else if(this.itemID == SpazzysItems.spacePants.itemID)
		{
			return "spazzysmod:/textures/armor/SPACESUIT_2.png";
		}
		else
		{
			return "spazzysmod:/textures/armor/SPACESUIT_1.png";
		}
	}
}
