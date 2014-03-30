package mcmodtutorial.core.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import mcmodtutorial.client.gui.TestGUI;
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
        return null;
    }
}
