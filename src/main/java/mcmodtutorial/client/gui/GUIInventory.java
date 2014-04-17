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
    private static final ResourceLocation texture = new ResourceLocation(References.MODID.toLowerCase() + ":" + "textures/gui/mygui.png");
    private static TileEntityTestContainer te;

    public GUIInventory(InventoryPlayer inventoryPlayer, TileEntityTestContainer tileEntityTestContainer)
    {
        super(new InventoryTest(inventoryPlayer, tileEntityTestContainer));
        xSize = 176;
        ySize = 214;
        te  = tileEntityTestContainer;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        /*
        Texture details. My arrow (filled) starts at 177, 0 and is 23,23 big
         */
        int arrowU = 177;
        int arrowUDelta = 23;
        int arrowV = 0;
        int arrowVDelta = 23;

        /*
        Draw GUI Background
         */

            //Bind Texture
            this.mc.getTextureManager().bindTexture(texture);
            // set the x for the texture, Total width - textureSize / 2
            par2 = (this.width - xSize) / 2;
            // set the y for the texture, Total height - textureSize - 30 (up) / 2,
            int j = (this.height - ySize) / 2;
            // draw the texture
            drawTexturedModalRect(par2, j, 0, 0, xSize,  ySize);

        /*
        Draw Black arrow
         */
            par2 = (this.width - arrowUDelta) /2 + 1; //x
            j = (this.height - arrowVDelta) /2 - 34; //y

            /*
            DrawTexturedModalRect takes 6 params.
            xCoord to display
            yCoord to display
            U, where the part starts it has to draw in your texture (x)
            V, where the part starts it has to draw in your texture (y)
            dU, size of texture (x)
            dV, size of texture (y)
             */
            drawTexturedModalRect(par2, j, arrowU, arrowV, arrowUDelta, arrowVDelta);

        /*
        Draw image to (partially) cover the black arrow)
         */

            par2 = (this.width - arrowUDelta) /2 + 1;
            j = (this.height - arrowVDelta) /2 - 34;
            // This time, my V is lower, and my dV depends on how far the smashing progress is.
            drawTexturedModalRect(par2, j, arrowU, (arrowV + arrowVDelta + 1), arrowUDelta, Math.round(arrowVDelta  * (((float)te.getSmashTime() - te.getSmashTimeRemaining()) / te.getSmashTime())));
    }
}
