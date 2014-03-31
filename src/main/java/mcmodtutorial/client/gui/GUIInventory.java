package mcmodtutorial.client.gui;

import mcmodtutorial.inventory.InventoryTest;
import mcmodtutorial.lib.References;
import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * GUIInventory
 * Created by: Martijn Woudstra
 * Date: 31-mrt-2014
 */

public class GUIInventory extends GuiContainer
{
    /**
     * See TestGUI
     */
    private static final ResourceLocation backgroundimage = new ResourceLocation(References.MODID.toLowerCase() + ":" + "textures/gui/mygui.png");

    public GUIInventory(InventoryPlayer inventoryPlayer, TileEntityTestContainer tileEntityTestContainer)
    {
        super(new InventoryTest(inventoryPlayer, tileEntityTestContainer));
        xSize = 176;
        ySize = 214;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        //Bind Texture
        this.mc.getTextureManager().bindTexture(backgroundimage);
        // set the x for the texture, Total width - textureSize / 2
        par2 = (this.width - xSize) / 2;
        // set the y for the texture, Total height - textureSize - 30 (up) / 2,
        int j = (this.height - ySize) / 2;
        // draw the texture
        drawTexturedModalRect(par2, j, 0, 0, xSize,  ySize);
    }
}
