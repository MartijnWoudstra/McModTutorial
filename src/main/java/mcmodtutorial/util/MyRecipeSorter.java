package mcmodtutorial.util;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

/**
 * MyRecipeSorter
 * Created by: Martijn Woudstra
 * Date: 24-apr-2014
 */

public class MyRecipeSorter implements Comparator
{
    final CraftingManagerTut craftingManagerTut;

    public MyRecipeSorter(CraftingManagerTut craftingManagerTut){
        this.craftingManagerTut = craftingManagerTut;
    }
    public int compareRecipes(IRecipe iRecipe1, IRecipe iRecipe2)
    {
        return iRecipe1 instanceof ShapelessRecipeCustom && iRecipe2 instanceof ShapedRecipeCustom ? 1
                : (iRecipe2 instanceof ShapelessRecipeCustom && iRecipe1 instanceof ShapedRecipeCustom ? -1
                : (iRecipe2.getRecipeSize() < iRecipe1.getRecipeSize() ? -1
                : (iRecipe2.getRecipeSize() > iRecipe1.getRecipeSize() ? 1
                : 0)));
    }

    public int compare(Object object1, Object object2)
    {
        return this.compareRecipes((IRecipe)object1, (IRecipe)object2);
    }
}
