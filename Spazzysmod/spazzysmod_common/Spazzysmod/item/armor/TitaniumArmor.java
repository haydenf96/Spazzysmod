package Spazzysmod.item.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import Spazzysmod.SpazzysmodBase;
import Spazzysmod.item.SpazzysItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class TitaniumArmor extends ItemArmor implements IArmorTextureProvider {

    public TitaniumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
            int par3, int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
    }

    @Override
    public String getArmorTextureFile(ItemStack itemstack) {
        if (itemstack.itemID == SpazzysItems.titaniumHelmet.itemID
                || itemstack.itemID == SpazzysItems.titaniumChestplate.itemID
                || itemstack.itemID == SpazzysItems.titaniumBoots.itemID)
            return "/mods/Spazzy_Spazzysmod/textures/armor/TITANIUMARMOR_1.png";

        if (itemstack.itemID == SpazzysItems.titaniumLeggings.itemID)
            return "/mods/Spazzy_Spazzysmod/textures/armor/TITANIUMARMOR_2.png";
        else
            return null;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(SpazzysmodBase.modid + ":"
                + (this.getUnlocalizedName().substring(5)));
    }
}
