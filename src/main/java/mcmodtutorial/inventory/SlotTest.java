package mcmodtutorial.inventory;

import mcmodtutorial.items.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * SlotTest
 * Created by: Martijn Woudstra
 * Date: 31-mrt-2014
 */

public class SlotTest extends Slot
{
    public SlotTest(IInventory inventory, int slotIndex, int x, int y)
    {
        super(inventory, slotIndex, x ,y);
    }

    /*
    In this case, you can only place this item
     */
    @Override
    public boolean isItemValid(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() == ModItems.testItem;
    }
}
