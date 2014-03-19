package mcmodtutorial.creativetab;

import mcmodtutorial.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * mcmodtutorial
 * <p/>
 * McModTutorialTab
 *
 * @Author Martijn Woudstra
 */

public class McModTutorialTab extends CreativeTabs
{
    public McModTutorialTab(int id, String modid)
    {
        super(id, modid);
    }

    @Override
    public Item getTabIconItem()
    {
        return ModItems.testItem;
    }
}