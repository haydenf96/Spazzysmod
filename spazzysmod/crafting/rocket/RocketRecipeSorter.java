package spazzysmod.crafting.rocket;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class RocketRecipeSorter implements Comparator {
	final RocketCraftingManager betterCraftingManager;

	public RocketRecipeSorter(RocketCraftingManager par1BetterCraftingManager) {
		this.betterCraftingManager = par1BetterCraftingManager;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
		return par1IRecipe instanceof RocketShapelessRecipes
				&& par2IRecipe instanceof RocketShapedRecipes ? 1
				: (par2IRecipe instanceof RocketShapelessRecipes
						&& par1IRecipe instanceof RocketShapedRecipes ? -1
						: (par2IRecipe.getRecipeSize() < par1IRecipe
								.getRecipeSize() ? -1
								: (par2IRecipe.getRecipeSize() > par1IRecipe
										.getRecipeSize() ? 1 : 0)));
	}

	public int compare(Object par1Obj, Object par2Obj) {
		return this.compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
	}
}