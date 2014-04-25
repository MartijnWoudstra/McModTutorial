package mcmodtutorial.util;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ShapelessRecipeCustom implements IRecipe
{
    private final ItemStack recipeOutput;
    public final List recipeItems;

    public ShapelessRecipeCustom(ItemStack itemStack, List list)
    {
        this.recipeOutput = itemStack;
        this.recipeItems = list;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inventoryCrafting, World world)
    {
        ArrayList<Object> arraylist = new ArrayList<Object>(this.recipeItems);

        for (int i = 0; i < 5; ++i)
        {
            for (int j = 0; j < 5; ++j)
            {
                ItemStack itemstack = inventoryCrafting.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;

                    for(Object anArraylist : arraylist)
                    {
                        ItemStack itemstack1 = (ItemStack) anArraylist;

                        if(itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
                        {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        return this.recipeOutput.copy();
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}