package mcmodtutorial.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * CraftingManagerTut
 * Created by: Martijn Woudstra
 * Date: 23-apr-2014
 */

public class CraftingManagerTut
{
    private static final CraftingManagerTut instance = new CraftingManagerTut();
    public               List               recipes;

    public static CraftingManagerTut getInstance()
    {
        return instance;
    }

    public CraftingManagerTut(){
        recipes = new ArrayList();
        System.out.println(recipes.size());
        addRecipe(new ItemStack(Blocks.diamond_block, 2), "xxxxx", "x   x", "x   x", "x   x", "xxxxx", 'x', Blocks.dirt);
        System.out.println(recipes.size());
        Collections.sort(this.recipes, new MyRecipeSorter(this));
        System.out.println(recipes.size());
    }


    public ShapedRecipeCustom addRecipe(ItemStack itemStack, Object... objects)
    {
        String stringHolder = ""; //Long string of the recipe
        int indexer = 0;
        int recipeWidth = 0;
        int recipeHeight = 0;
        if(objects[indexer] instanceof String[]){
            String[] strings = (String[]) objects[indexer++];
            for(int i = 0; i < strings.length; ++i){
                String string = strings[i];
                recipeHeight++;
                recipeWidth = string.length();
                stringHolder = stringHolder + string;
            }
        }
        else while(objects[indexer] instanceof String){ //Looping thru an horizonal line
            String string = (String)objects[indexer++]; //Stroring the line
            recipeHeight++; //Since we found a line, add height
            recipeWidth = string.length(); //Lenght of the line = width
            stringHolder = stringHolder + string;
        }

        HashMap hashmap;
        for(hashmap = new HashMap(); indexer < objects.length; indexer += 2){
            Character character = (Character) objects[indexer];
            ItemStack itemStackHolder = null;
            if(objects[indexer+1] instanceof Item)
                itemStackHolder = new ItemStack((Item)objects[indexer+1]);
            else if(objects[indexer + 1] instanceof Block)
                itemStackHolder = new ItemStack((Block)objects[indexer +1]);
            else if(objects[indexer +1] instanceof ItemStack)
                itemStackHolder = (ItemStack)objects[indexer+1];

            hashmap.put(character, itemStackHolder);
        }

        ItemStack[] itemStacks = new ItemStack[recipeHeight * recipeWidth];

        for(int i = 0; i < recipeHeight * recipeWidth; ++i){
            char charr = stringHolder.charAt(i);
            if(hashmap.containsKey(charr)){
                itemStacks[i] = ((ItemStack)hashmap.get(Character.valueOf(charr))).copy();
            } else
                itemStacks[i] = null;
        }
        ShapedRecipeCustom shapedRecipeCustom = new ShapedRecipeCustom(recipeWidth, recipeHeight, itemStacks, itemStack);
        getRecipes().add(shapedRecipeCustom);
        return shapedRecipeCustom;
    }

    public void addShapeless(ItemStack itemStack, Object ... objects){
        ArrayList arrayList = new ArrayList();
        Object[] list = objects;

        for(int i = 0; i < objects.length; ++i){
            Object object = list[i];
            if( object instanceof ItemStack){
                arrayList.add(((ItemStack)object).copy());
            }else if (object instanceof  Item)
                arrayList.add(new ItemStack((Item)object));
            else {
                if(!(object instanceof Block)){
                    throw new RuntimeException("Invalid Shapless recipy!");
                }
                arrayList.add(new ItemStack((Block)object));
            }
        }
        getRecipes().add(new ShapelessRecipeCustom(itemStack, arrayList));
    }


    public ItemStack findMatchingRecipe(InventoryCrafting inventoryCrafting, World world) {
        int var3 = 0;
        ItemStack ItemStack1 = null;
        ItemStack ItemStack2 = null;

        for(int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStackHolder = inventoryCrafting.getStackInSlot(i);
            if(itemStackHolder != null) {
                if(var3 == 0) {
                    ItemStack1 = itemStackHolder;
                }

                if(var3 == 1) {
                    ItemStack2 = itemStackHolder;
                }
                ++var3;
            }
        }

        if(var3 == 2 && ItemStack1.getItem() == ItemStack2.getItem() && ItemStack1.stackSize == 1 && ItemStack2.stackSize == 1 && ItemStack1.getItem().isDamageable()) {
            Item item = ItemStack1.getItem();
            int damageLeftItemStack1 = item.getMaxDamage() - ItemStack1.getItemDamage();
            int damageLeftItemStack2 = item.getMaxDamage() - ItemStack2.getItemDamage();
            int damageGone = damageLeftItemStack1 + damageLeftItemStack2 + item.getMaxDamage() * 5 / 100;
            int damageValue = item.getMaxDamage() - damageGone;
            if(damageValue < 0) {
                damageValue = 0;
            }
            return new ItemStack(ItemStack1.getItem(), 1, damageValue);
        } else {
            for(Object recipe : this.recipes)
            {
                IRecipe irecipe = (IRecipe) recipe;
                if(irecipe.matches(inventoryCrafting, world))
                {
                    return irecipe.getCraftingResult(inventoryCrafting);
                }
            }

            return null;
        }
    }

    public List getRecipes() {
        return this.recipes;
    }
}
