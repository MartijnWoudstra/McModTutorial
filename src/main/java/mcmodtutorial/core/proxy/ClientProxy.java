package mcmodtutorial.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import mcmodtutorial.client.render.RenderTestContainer;
import mcmodtutorial.tileentities.TileEntityTestContainer;

/**
 * mcmodtutorial
 * <p/>
 * ClientProxy
 *
 * @Author Martijn Woudstra
 */

public class ClientProxy extends CommonProxy
{

    /**
     * Override CommonProxy.registerRendering
     * Register all your renderers here.
     */
    @Override
    public void registerRendering()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestContainer.class, new RenderTestContainer());
    }
}
