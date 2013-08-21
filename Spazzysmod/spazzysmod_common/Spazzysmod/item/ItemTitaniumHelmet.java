package Spazzysmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import Spazzysmod.SpazzysmodBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTitaniumHelmet extends ItemArmor {

    public ItemTitaniumHelmet(int par1,
            EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(SpazzysmodBase.modid + ":"
                + (this.getUnlocalizedName().substring(5)));
    }

}
