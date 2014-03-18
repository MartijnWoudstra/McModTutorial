package mcmodtutorial.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * mcmodtutorial
 * <p/>
 * ModItems
 *
 * @Author Martijn Woudstra
 */

public class ModItems
{
    public static Item testItem;

    public static void init()
    {
        testItem = new TestItem();
    }

    /**
     * Registeres the items.
     * Any item calling this NEEDS to extend ItemMcModTutorial.
     * For registering an item, you need to call registerBlock and use
     * Format: [block], [unlocalizedname]
     * @param item
     */
    public static void register(ItemMcModTutorial item)
    {
        GameRegistry.registerItem(item, item.getUnwrappedUnlocalizedName(item.getUnlocalizedName()));
    }
}