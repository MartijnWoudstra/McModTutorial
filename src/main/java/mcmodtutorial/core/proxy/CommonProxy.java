package mcmodtutorial.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import mcmodtutorial.tileentities.TestTileEntity;

/**
 * mcmodtutorial
 * <p/>
 * CommonProxy
 *
 * @Author Martijn Woudstra
 */

public class CommonProxy
{
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TestTileEntity.class, "TestBlockTileEntity");
    }
}
