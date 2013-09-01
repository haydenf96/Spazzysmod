package spazzysmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysTabs {

    public static final CreativeTabs tabMoon = new TabMoon("MoonTab");
    public static final CreativeTabs tabMars = new TabMars("MarsTab");
    public static final CreativeTabs tabSolarSystem = new TabSolarSystem(
            "SolarSystemTab");

    public static void nameTabs() {
        LanguageRegistry.instance().addStringLocalization("itemGroup.MoonTab",
                "en_US", "Moon");
        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.SolarSystemTab", "en_US",
                "Spazzy's Solar System Mod");
        LanguageRegistry.instance().addStringLocalization("itemGroup.MarsTab",
                "en_US", "Mars");
    }
}
