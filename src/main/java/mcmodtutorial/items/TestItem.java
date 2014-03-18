package mcmodtutorial.items;

import mcmodtutorial.lib.Strings;
import net.minecraft.creativetab.CreativeTabs;

/**
 * mcmodtutorial
 * <p/>
 * TestItem
 *
 * @Author Martijn Woudstra
 */

public class TestItem extends ItemMcModTutorial
{
    public TestItem()
    {
        this.setUnlocalizedName(Strings.TestItemName);
        this.setCreativeTab(CreativeTabs.tabCombat);
        ModItems.register(this);
    }
}