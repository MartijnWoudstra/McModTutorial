package mcmodtutorial.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.lib.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * mcmodtutorial
 * <p/>
 * ItemMcModTutorial
 *
 * @Author Martijn Woudstra
 */

public class ItemMcModTutorial extends Item
{
    /**
     * Gets the unwrapped name of a item
     * UnlocalizedName is usually something like tile.[modid].[itemname]
     * This method only returns the itemname
     * @param unlocalizedName
     * @return itemname
     */
    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    /**
     * Overrides the block method for returning unlocalizedName.
     * This way, when you extend this class, everything is handled properly.
     * @return unlocalizedName
     */
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", References.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", References.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * Overrides the registerIcon method.
     * This method handles all the textures.
     * Call registerIcon() and pass it a
     * Format: [modid]:[itemname]
     * @param iconRegister
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(References.RESOURCESPREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
}