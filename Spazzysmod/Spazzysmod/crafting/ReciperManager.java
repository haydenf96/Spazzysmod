package Spazzysmod.crafting;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Spazzysmod.blocks.MarsBlocks;
import Spazzysmod.blocks.MoonBlocks;
import Spazzysmod.blocks.SpazzysBlocks;
import Spazzysmod.item.SpazzysItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ReciperManager {

    public static void initRecipes() {
        GameRegistry.addRecipe(new ItemStack(MoonBlocks.cheeseBlock),
                new Object[] { "   ", " X ", "   ", 'X', Item.bucketMilk });

        GameRegistry.addRecipe(new ItemStack(MoonBlocks.moonPortal),
                new Object[] { "XXX", "XYX", "XXX", 'X',
                        MoonBlocks.cheeseBlock, 'Y', Item.flintAndSteel });

        GameRegistry.addRecipe(new ItemStack(MarsBlocks.marsPortal),
                new Object[] { "XXX", "XYX", "XXX", 'X', MarsBlocks.redRock,
                        'Y', Item.flintAndSteel });

        GameRegistry.addRecipe(new ItemStack(SpazzysItems.titaniumHelmet),
                new Object[] { "   ", "XXX", "X X", 'X',
                        SpazzysItems.titaniumIngot, 'Y', Item.diamond });

        GameRegistry.addRecipe(new ItemStack(SpazzysItems.titaniumChestplate),
                new Object[] { "X X", "XXX", "XXX", 'X',
                        SpazzysItems.titaniumIngot, 'Y', Item.diamond });

        GameRegistry.addRecipe(new ItemStack(SpazzysItems.titaniumLeggings),
                new Object[] { "XXX", "X X", "X X", 'X',
                        SpazzysItems.titaniumIngot, 'Y', Item.diamond });

        GameRegistry.addRecipe(new ItemStack(SpazzysItems.titaniumBoots),
                new Object[] { "   ", "X X", "X X", 'X',
                        SpazzysItems.titaniumIngot, 'Y', Item.diamond });

        GameRegistry.addRecipe(new ItemStack(SpazzysItems.titaniumSword),
                new Object[] { " X ", " X ", " Y ", 'X',
                        SpazzysItems.titaniumIngot, 'Y', Item.diamond });

        GameRegistry.addSmelting(SpazzysBlocks.titaniumBlock.blockID,
                new ItemStack(SpazzysItems.titaniumIngot, 1), 1F);
    }
}
