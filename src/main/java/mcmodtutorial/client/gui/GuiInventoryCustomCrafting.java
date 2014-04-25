package mcmodtutorial.client.gui;

import mcmodtutorial.inventory.ContainerCustomCrafting;
import mcmodtutorial.tileentities.TileEntityCustomCrafting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * GuiInventoryCustomCrafting
 * Created by: Martijn Woudstra
 * Date: 23-apr-2014
 */

public class GuiInventoryCustomCrafting extends GuiContainer
{
    public GuiInventoryCustomCrafting(InventoryPlayer inventory, TileEntityCustomCrafting tileEntityCustomCrafting)
    {
        super(new ContainerCustomCrafting(inventory,tileEntityCustomCrafting, tileEntityCustomCrafting.getWorldObj()));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {

    }
}
