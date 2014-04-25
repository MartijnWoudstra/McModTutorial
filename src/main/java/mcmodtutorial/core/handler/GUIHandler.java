package mcmodtutorial.core.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import mcmodtutorial.client.gui.GUIInventory;
import mcmodtutorial.client.gui.GuiInventoryCustomCrafting;
import mcmodtutorial.client.gui.TestGUI;
import mcmodtutorial.inventory.ContainerCustomCrafting;
import mcmodtutorial.inventory.InventoryTest;
import mcmodtutorial.tileentities.TileEntityCustomCrafting;
import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * GUIHandler
 * Created by: Martijn Woudstra
 * Date: 30-mrt-2014
 */

public class GUIHandler implements IGuiHandler
{
    public GUIHandler(){}

    /**
     * Gets the server element.
     * This means, do something server side, when this ID gets called.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == 1)
        {
            // Create an Object of our TE, so we can give that to our inventory.
            TileEntityTestContainer tileEntityTestContainer = (TileEntityTestContainer) world.getTileEntity(x, y, z);
            return new InventoryTest(player.inventory, tileEntityTestContainer);
        }
        if(ID == 2)
        {
            TileEntityCustomCrafting tileEntityCustomCrafting = (TileEntityCustomCrafting) world.getTileEntity(x, y, z);
            return new ContainerCustomCrafting(player.inventory, tileEntityCustomCrafting, tileEntityCustomCrafting.getWorldObj());
        }
        return null;
    }

    /**
     * Gets the client element.
     * This means, do something client side, when this ID gets called.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == 0)
            return new TestGUI();
        if(ID == 1)
        {
            // Create an Object of our TE, so we can give that to our GUI.
            TileEntityTestContainer tileEntityTestContainer = (TileEntityTestContainer) world.getTileEntity(x, y, z);
            return new GUIInventory(player.inventory, tileEntityTestContainer);
        }
        if(ID == 2)
        {
            TileEntityCustomCrafting tileEntityCustomCrafting = (TileEntityCustomCrafting) world.getTileEntity(x, y, z);
            return new GuiInventoryCustomCrafting(player.inventory, tileEntityCustomCrafting);
        }
        return null;
    }
}
