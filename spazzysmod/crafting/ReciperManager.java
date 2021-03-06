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

	public static void craftItems() {
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

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.spaceHelmet),
				new Object[] { "XXX", "XGX", "XXX", 'X', Block.cloth, 'G',
						Block.glass });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.spaceJacket),
				new Object[] { "XRX", "XXX", "XXX", 'X', Block.cloth, 'R',
						Item.redstone });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.spacePants),
				new Object[] { "XXX", "X X", "X X", 'X', Block.cloth });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.spaceShoes),
				new Object[] { "X X", "X X", 'X', Block.cloth });

		GameRegistry.addRecipe(new ItemStack(SpazzysBlocks.rocketWorkbench),
				new Object[] { "XXX", "X*X", "XXX", '*', Block.workbench, 'X',
						Item.ingotIron });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.launchPad),
				new Object[] { "***", "XXX",

				'X', Item.ingotIron, '*', SpazzysItems.titaniumIngot });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.explosiveBow),
				new Object[] { " x*", "xt*", " x*",

				'x', Item.stick, '*', Item.silk, 't', Block.tnt });

		GameRegistry.addRecipe(new ItemStack(SpazzysItems.explosiveArrow, 4),
				new Object[] { "t", "x", "*",

				'x', Item.stick, '*', Item.feather, 't', Block.tnt });

		RocketCraftingManager.func_92051_a(
				new ItemStack(SpazzysItems.spaceship), new Object[] { "  x  ",
						" xxx ", " xgx ", " xxx ", "xxrxx", 'x',
						SpazzysItems.titaniumIngot, 'r',
						SpazzysBlocks.rocketBlock, 'g', Block.glass });

		RocketCraftingManager.func_92051_a(new ItemStack(
				SpazzysBlocks.rocketBlock, 1), new Object[] { "#####", "##B##",
				"#BAB#", "##B##", "#####", '#', SpazzysItems.titaniumIngot,
				'A', Item.bucketLava, 'B', Item.redstone });
	}
}
