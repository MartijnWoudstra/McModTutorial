package mcmodtutorial.items;

import cpw.mods.fml.common.registry.GameRegistry;
import mcmodtutorial.McModTutorial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

/**
 * TestFood
 * Created by: Martijn Woudstra
 * Date: 08-apr-2014
 */

public class TestFood extends ItemFood
{
    public TestFood()
    {
        super(7, 1F, false);
        this.setUnlocalizedName("MyFood");
        this.setCreativeTab(McModTutorial.getCreativeTab());
        this.setPotionEffect(4, 10, 1, 1F);
        this.setAlwaysEdible();
        GameRegistry.registerItem(this, this.getUnlocalizedName());
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack)
    {
        return 10;
    }
}
