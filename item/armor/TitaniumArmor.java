package Spazzysmod.item.armor;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import Spazzysmod.Spazzysmod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SuppressWarnings("deprecation")
public class TitaniumArmor extends ItemArmor implements IArmorTextureProvider {

    public TitaniumArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
            int par3, int par4) {
        super(par1, par2EnumArmorMaterial, par3, par4);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getArmorTextureFile(ItemStack itemstack) {
        if (itemstack.itemID == Spazzysmod.titaniumHelmet.itemID
                || itemstack.itemID == Spazzysmod.titaniumChestplate.itemID
                || itemstack.itemID == Spazzysmod.titaniumBoots.itemID)
            return "/mods/Spazzy_Spazzysmod/textures/armor/TITANIUMARMOR_1.png";

        if (itemstack.itemID == Spazzysmod.titaniumLeggings.itemID)
            return "/mods/Spazzy_Spazzysmod/textures/armor/TITANIUMARMOR_2.png";
        else
            return null;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Spazzysmod.modid + ":"
                + (this.getUnlocalizedName().substring(5)));
    }
}
