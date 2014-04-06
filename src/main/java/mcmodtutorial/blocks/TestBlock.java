package mcmodtutorial.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

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
        if(meta == 0)
        {
            if(side <= 5)
                return icons[side];
            else
                return icons[0];
        }
        else
        {
            if(side<= 5)
                return icons[5-side];
            else
                return icons[0];
        }
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List par3list)
    {
        for (int i = 0; i < 2; i++)
        {
            par3list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote)
        {
            if (world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) == 0)
            {
                world.setBlock(x, y, z, ModBlocks.testBlock, 1, 2);
            }
            if(!world.isBlockIndirectlyGettingPowered(x, y, z) && world.getBlockMetadata(x, y, z) == 1)
            {
                world.setBlock(x, y, z, ModBlocks.testBlock, 0, 2);
            }
        }
    }
}
