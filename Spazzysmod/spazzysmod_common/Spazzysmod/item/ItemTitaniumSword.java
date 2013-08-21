package Spazzysmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import Spazzysmod.SpazzysmodBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTitaniumSword extends ItemSword {

    public ItemTitaniumSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(SpazzysmodBase.modid + ":"
                + (this.getUnlocalizedName().substring(5)));
    }
}
