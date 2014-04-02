package mcmodtutorial.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import mcmodtutorial.tileentities.TestTileEntity;
import mcmodtutorial.tileentities.TileEntityTestContainer;

/**
 * mcmodtutorial
 * <p/>
 * CommonProxy
 *
 * @Author Martijn Woudstra
 */

public class CommonProxy
{
    /**
     * Register the TE's.
     * registerTileEntity takes 2 params.
     * 1) A Tile Entity class. (Class <? extends TileEntity> clazz)
     * 2) A name.
     */
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TestTileEntity.class, "TestBlockTileEntity");
        GameRegistry.registerTileEntity(TileEntityTestContainer.class, "TileEntityTestContainer");
    }

    /**
     * Making a method for our ClientProxy. Rendering = Client!
     */
    public void registerRendering(){}
}
