package spazzysmod.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import spazzysmod.SpazzysmodBase;
import spazzysmod.config.SpazzysConfig;
import spazzysmod.creativetab.SpazzysTabs;
import spazzysmod.item.armor.TitaniumArmor;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysItems {

    public static Item titaniumIngot;
    public static Item titaniumSword;
    public static Item explosiveArrow;
    public static Item explosiveBow;

    public static Item titaniumHelmet;
    public static Item titaniumChestplate;
    public static Item titaniumLeggings;
    public static Item titaniumBoots;

    static EnumArmorMaterial TITANIUMARMOR = EnumHelper.addArmorMaterial(
            "TITANIUMARMOR", 33, new int[] { 3, 8, 6, 3 }, 25);
    public static final EnumToolMaterial TITANIUM = EnumHelper.addToolMaterial(
            "TITANIUM", 2, 20000, 10.0F, 7, 10);

    public static void initItems() {
        titaniumIngot = new ItemTitaniumIngot(SpazzysConfig.titaniumIngotID)
                .setUnlocalizedName("titaniumIngot").setCreativeTab(
                        SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumIngot, "Titanium Ingot");
        GameRegistry.registerItem(titaniumIngot, "Titanium Ingot");

        titaniumHelmet = new TitaniumArmor(SpazzysConfig.titaniumHelmetID,
                TITANIUMARMOR, ModLoader.addArmor("TitaniumArmor"), 0)
                .setUnlocalizedName("titaniumHelmet").setCreativeTab(
                        SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumHelmet, "Titanium Helmet");
        GameRegistry.registerItem(titaniumHelmet, "Titanium Helmet");

        titaniumChestplate = new TitaniumArmor(
                SpazzysConfig.titaniumChestplateID, TITANIUMARMOR,
                ModLoader.addArmor("TitaniumArmor"), 1).setUnlocalizedName(
                "titaniumChestPlate")
                .setCreativeTab(SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumChestplate, "Titanium Chestplate");
        GameRegistry.registerItem(titaniumChestplate, "Titanium Chestplate");

        titaniumLeggings = new TitaniumArmor(SpazzysConfig.titaniumLeggingsID,
                TITANIUMARMOR, ModLoader.addArmor("TitaniumArmor"), 2)
                .setUnlocalizedName("titaniumLeggings").setCreativeTab(
                        SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumLeggings, "Titanium Leggings");
        GameRegistry.registerItem(titaniumLeggings, "Titanium Leggings");

        titaniumBoots = new TitaniumArmor(SpazzysConfig.titaniumBootsID,
                TITANIUMARMOR, ModLoader.addArmor("TitaniumArmor"), 3)
                .setUnlocalizedName("titaniumBoots").setCreativeTab(
                        SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumBoots, "Titanium Boots");
        GameRegistry.registerItem(titaniumBoots, "Titanium Boots");

        titaniumSword = new ItemTitaniumSword(SpazzysConfig.titaniumSwordID,
                TITANIUM).setUnlocalizedName("titaniumSword").setCreativeTab(
                SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(titaniumSword, "Titanium Sword");
        GameRegistry.registerItem(titaniumSword, "Titanium Sword");

        explosiveArrow = new Item(SpazzysConfig.explosiveArrowID)
                .setUnlocalizedName("explosiveArrow").setCreativeTab(
                        SpazzysTabs.tabSolarSystem).func_111206_d(SpazzysmodBase.modid + ":explosiveArrow");
        LanguageRegistry.addName(explosiveArrow, "Explosive Arrow");
        GameRegistry.registerItem(explosiveArrow, "Explosive Arrow");
        
        explosiveBow = new ItemExplosiveBow(SpazzysConfig.explosiveBowID).setUnlocalizedName("explosiveBow").setCreativeTab(SpazzysTabs.tabSolarSystem);
        LanguageRegistry.addName(explosiveBow, "Explosive Bow");
        GameRegistry.registerItem(explosiveBow, "Explosive Bow");

    }
}
