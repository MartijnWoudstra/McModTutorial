package mcmodtutorial.core.handler;

import mcmodtutorial.blocks.ModBlocks;
import mcmodtutorial.items.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * mcmodtutorial
 * <p/>
 * CraftingHandler
 *
 * @Author Martijn Woudstra
 */

public class CraftingHandler
{
    public static void init()
    {
        registerRecipes();
    }

    public static void registerRecipes()
    {
        /*  ### Recipe where #      = dirt
        *  #S#              s      = testBlock
        *  ###              output = testItem, 2x
        */
        CraftingManager.getInstance().addRecipe(new ItemStack(ModItems.testItem, 2), "###","#s#","###", '#', Blocks.dirt, 's', ModBlocks.testBlock);

        /*       Recipe where the following items are needed, but can be placed in any combination in the grid:
        *        2x dirt
        *        1x grass
        *        1x testBlock
        *output: testItem, 4x
        */
        CraftingManager.getInstance().addShapelessRecipe(new ItemStack(ModItems.testItem, 4), Blocks.dirt, Blocks.dirt, Blocks.grass, ModBlocks.testBlock);

        /* In this example, we will create a new ItemStack, of a diamond sword
        * On that itemstack, we put the Enchantment Efficiency.
        * We create a new recipe, and instead of giving it a new ItemStack, we give it our itemstack.
        * Required to make this item is a block of dirt, anywhere in the grid.
        */
        ItemStack itemStack = new ItemStack(Items.diamond_sword);
        itemStack.addEnchantment(Enchantment.efficiency, 2);
        CraftingManager.getInstance().addShapelessRecipe(itemStack, Blocks.dirt);

        /*
        * Smelting Recipe, where the input it a testItem, the output is a testBlock, and you get 1f experience.
        */
        FurnaceRecipes.smelting().func_151396_a(ModItems.testItem, new ItemStack(ModBlocks.testBlock), 1f);
    }
}