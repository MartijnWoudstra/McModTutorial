package mcmodtutorial.inventory;

import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * InventoryTest
 * Created by: Martijn Woudstra
 * Date: 31-mrt-2014
 */

public class InventoryTest extends Container
{
    //Create an Object of our TE.
    private TileEntityTestContainer tile;

    public InventoryTest(InventoryPlayer inventory, TileEntityTestContainer tileEntityTestContainer)
    {
        tile = tileEntityTestContainer;
        bindPlayerInventory(inventory);
    }

    /*
    Add slots to our GUI.
    The id's are for the slotnumbers.
    For the rest, the i * 18 and j * 18 is always the same.
    The other numbers can change, depending on your gui.
     */
    private void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        int id = 0;
        int id2 = 0;

        for(int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, id, i * 18 + 8, 189)); //Adds player hotbar
            id++;
        }
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, id ,j * 18 + 8, i * 18 + 131 )); //Adds player inventory
                id++;
            }
        }

        for(int i = 0; i < 3; i ++)
        {
            for(int j = 0; j < 2; j++)
            {
                addSlotToContainer(new SlotTest(tile, id2, i * 18 + 62, j * 18 + 21)); //Adds custon slots
                id2++;
            }
        }
        addSlotToContainer(new SlotTest(tile, id2, 81, 95)); //Adds custon output
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;
    }
}
