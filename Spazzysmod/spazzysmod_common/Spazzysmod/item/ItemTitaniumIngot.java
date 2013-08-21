package Spazzysmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import Spazzysmod.SpazzysmodBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTitaniumIngot extends Item {

    public ItemTitaniumIngot(int par1) {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(SpazzysmodBase.modid + ":"
                + (this.getUnlocalizedName().substring(5)));
    }
}
