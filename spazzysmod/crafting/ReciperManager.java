package spazzysmod.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spazzysmod.blocks.MoonBlocks;
import spazzysmod.blocks.SpazzysBlocks;
import spazzysmod.crafting.rocket.RocketCraftingManager;
import spazzysmod.item.SpazzysItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ReciperManager {

    public static void craftItems () {
        GameRegistry.addRecipe(new ItemStack(MoonBlocks.cheeseBlock),
                new Object[] { "   ", " X ", "   ", 'X', Item.bucketMilk });
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
        
        RocketCraftingManager.func_92051_a(new ItemStack(SpazzysItems.spaceship),  new Object[] 
        		{ 
        	"  x  ",
        	" xgx ",
        	" xxx ",
        	"  x  ",
        	" x x ",
        	'x',
            SpazzysItems.titaniumIngot, 'Y', Item.diamond, 'g', Block.glass 
            });
    }
}
