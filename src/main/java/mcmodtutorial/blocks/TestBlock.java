package mcmodtutorial.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * mcmodtutorial
 * <p/>
 * TestBlock
 *
 * @Author Martijn Woudstra
 */

public class TestBlock extends BlockMcModTutorial
{
    /**
     * Array of IIcons, where we store our textures.
     */
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public TestBlock()
    {
        this.setBlockName(Strings.TestBlockName);
        this.setHardness(1f);
        this.setResistance(3f);
        this.setCreativeTab(McModTutorial.getCreativeTab());
        this.setStepSound(Block.soundTypeAnvil);
        ModBlocks.register(this);
        icons = new IIcon[6];
    }

    /**
     * Returns the desired texture for the side.
     * 0: bottom
     * 1: top
     * 2-5: sides.
     *
     * @param side side of the block
     * @param meta metadata of the block.
     * @return IIcon
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if(side <= 5)
            return icons[side];
        else
            return icons[0];
    }

    /**
     * Registers all icons in your IIcon array.
     * The names in the if statement are the suffix for the texture name. (the 1 in the example below)
     *
     * ..\mcmodtutorial\src\main\resources\assets\mcmodtutorial\textures\blocks\testBlock1.png
     *
     * @param iconRegister iconRegister
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for(int i = 0; i < icons.length; i++)
        {
            String name;
            switch(i)
            {
                case 0: name = "0"; break;
                case 1: name = "1"; break;
                case 2: name = "2"; break;
                case 3: name = "3"; break;
                case 4: name = "4"; break;
                case 5: name = "5"; break;
                default: name = "0";
            }
            icons[i] = iconRegister.registerIcon(getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + name);
        }
    }
}
