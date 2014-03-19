package mcmodtutorial.items;

import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.Strings;

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
        this.setCreativeTab(McModTutorial.getCreativeTab());
        ModItems.register(this);
    }
}