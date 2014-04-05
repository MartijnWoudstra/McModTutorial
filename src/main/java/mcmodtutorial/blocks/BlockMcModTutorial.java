package mcmodtutorial.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.lib.References;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * mcmodtutorial
 * <p/>
 * BlockMcModTutorial
 *
 * @Author Martijn Woudstra
 */

public class BlockMcModTutorial extends Block
{
    /**
     * Constructor for when no material is passed on.
     * Default material: rock
     */
    public BlockMcModTutorial()
    {
        super(Material.rock);
    }

    /**
     * Constructor for defined material.
     * @param material
     */
    public BlockMcModTutorial(Material material)
    {
        super(material);
    }

    /**
     * Gets the unwrapped name of a block
     * UnlocalizedName is usually something like tile.[modid].[blockname]
     * This method only returns the blockname
     * @param unlocalizedName
     * @return blockname
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
        return String.format("%s%s", References.RESOURCESPREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * Overrides the registerBlockIcon method.
     * This method handles all the textures.
     * Call registerIcon() and pass it a
     * Format: [modid]:[blockname]
     * @param iconRegister
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(References.RESOURCESPREFIX + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
}