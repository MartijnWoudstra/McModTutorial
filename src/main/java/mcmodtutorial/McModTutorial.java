package mcmodtutorial;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import mcmodtutorial.blocks.ModBlocks;
import mcmodtutorial.core.handler.CraftingHandler;
import mcmodtutorial.core.proxy.CommonProxy;
import mcmodtutorial.creativetab.McModTutorialTab;
import mcmodtutorial.items.ModItems;
import mcmodtutorial.lib.References;
import mcmodtutorial.world.TutorialWorldGenerator;
import net.minecraft.creativetab.CreativeTabs;

/**
 * mcmodtutorial
 *
 * McModTutorial
 *
 * @Author Martijn Woudstra
 */

@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)

public class McModTutorial
{
    /**
     * @SidedProxy
     *
     * This is where we tell forge, where our proxies are located.
     * Proxies are what seperates server and client.
     */
    @SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
    public static CommonProxy proxy;

    private static CreativeTabs mcModTutorialTab = new McModTutorialTab(CreativeTabs.getNextID(), References.MODID);

    public static CreativeTabs getCreativeTab()
    {
        return mcModTutorialTab;
    }

    /**
     * preInit
     *
     * This is where forge starts loading your mod.
     * In the preInit, you call stuff that needs to be loaded before the world gets loaded.
     * E.G. Blocks, Items, WorldHandlers etc.
     *
     * @param event
     */
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        ModBlocks.init();

        ModItems.init();

        CraftingHandler.init();

        //Adds our worldgenerator. The int is the weight. How higher the number, how later your generator will be called
        GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 1);

        proxy.registerTileEntities();
    }

    /**
     * init
     *
     * This is where forge loads things which can be loaded while the world is loading.
     * E.G. Renderers, Events etc.
     * @param event
     */
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {

    }

    /**
     * postInit
     *
     * This is where all addons get loaded
     * This will happen AFTER all mods have been loaded.
     * E.G. Addon for another mod.
     * @param event
     */
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {

    }
}