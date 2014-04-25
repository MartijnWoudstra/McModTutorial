package mcmodtutorial.inventory;

import mcmodtutorial.tileentities.TileEntityCustomCrafting;
import mcmodtutorial.util.CraftingManagerTut;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * ContainerCustomCrafting
 * Created by: Martijn Woudstra
 * Date: 23-apr-2014
 */

public class ContainerCustomCrafting extends Container
{
    private IInventory craftingResult;
    private InventoryCrafting inventoryCrafting = new InventoryCrafting((Container)this, 5,5);
    private World world;

    public ContainerCustomCrafting(InventoryPlayer inventory, TileEntityCustomCrafting tileEntityCustomCrafting, World world)
    {
        craftingResult = new InventoryCraftResult();
        this.world = world;
        bindPlayerInventory(inventory);
    }

    private void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        int id = 0;
        addSlotToContainer(new SlotCrafting(inventoryPlayer.player, inventoryCrafting, new InventoryCraftResult(), 0, 131, 36));

        for (int l = 0; l < 5; ++l)
        {
            for (int j = 0; j < 5; ++j)
            {
                this.addSlotToContainer(new Slot(this.inventoryCrafting, j + l * 5, 30 + j * 18, 17 + l * 18));
            }
        }
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, id ,j * 18 + 8, i * 18 + 131 )); //Adds player inventory
                id++;
            }
        }
        for(int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, id, i * 18 + 8, 189)); //Adds player hotbar
            id++;
        }
        onCraftMatrixChanged(inventoryCrafting);
    }

    public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftingResult.setInventorySlotContents(0, CraftingManagerTut.getInstance().findMatchingRecipe(inventoryCrafting, world));
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotIndex)
    {
        return null;
    }
}
