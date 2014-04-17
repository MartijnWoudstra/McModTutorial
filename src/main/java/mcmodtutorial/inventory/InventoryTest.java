package mcmodtutorial.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * InventoryTest
 * Created by: Martijn Woudstra
 * Date: 31-mrt-2014
 */

public class InventoryTest extends Container
{
    //Create an Object of our TE.
    private TileEntityTestContainer tile;
    private int smashTimeRemaining;
    private int smashTime;

    public InventoryTest(InventoryPlayer inventory, TileEntityTestContainer tileEntityTestContainer)
    {
        tile = tileEntityTestContainer;
        bindPlayerInventory(inventory);

    }

    /*
    To update our progress bar, we need to send a packet.
    In MC, there is an easy way to send an update for a progress bar
    We need to 'register' what values we want to send
     */
    @Override
    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.getSmashTime());
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tile.getSmashTimeRemaining());
    }

    /*
    If a change is detected, this method is called.
    If the value stored in this class, is not the same as in the Container class, we update
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if(this.smashTime != this.tile.getSmashTime())
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tile.getSmashTime());
            }
            if(this.smashTimeRemaining != this.tile.getSmashTimeRemaining())
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tile.getSmashTimeRemaining());
            }
        }
    }

    /*
    And update
     */
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tile.smashTime = par2;
        }

        if (par1 == 1)
        {
            this.tile.smashTimeRemaining = par2;
        }
    }


    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotIndex)
    {
        return null;
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
                addSlotToContainer(new SlotTest(tile, id2, i * 18 + 62, j * 18 + 19)); //Adds custon slots
                id2++;
            }
        }
        System.out.println("slotid = " + id2);
        addSlotToContainer(new SlotTest(tile, id2, 81, 95)); //Adds custon output
    }

    @Override
    public boolean canInteractWith(EntityPlayer var1)
    {
        return true;
    }
}
