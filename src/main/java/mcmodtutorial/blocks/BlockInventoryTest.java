package mcmodtutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.References;
import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * BlockInventoryTest
 * Created by: Martijn Woudstra
 * Date: 31-mrt-2014
 */

public class BlockInventoryTest extends BlockContainer
{
    /**
     * See TestTileBlock
     */
    protected BlockInventoryTest()
    {
        super(Material.rock);
        this.setCreativeTab(McModTutorial.getCreativeTab());
        /*
        Since we cant extend BlockMcModTutorial, we have to do this manually for once
         */
        this.setBlockName(References.MODID + ":" + "BlockInventoryTest");
        GameRegistry.registerBlock(this, this.getUnlocalizedName());
        //Set the collision box of a block. Params xMin, yMin, zMin, xMax, yMax, zMax.
        setBlockBounds(0.05f, 0.5f, 0.05f, 0.95f, 1f ,0.95f);
    }

    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityTestContainer();
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par1, float par2, float par3, float par4)
    {
        entityPlayer.openGui(McModTutorial.instance, 1, world, x, y, z);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName());
    }

    /**
     * Because we render our block ourselves, we need to set this to -1.
     */
    @Override
    public int getRenderType()
    {
        return -1;
    }

    /**
     * Do not render as a normal block
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     *  If a block is solid, and 1x1x1, MC doesnt render the sides of the block next to this block.
     *  Ingame, this looks like the old see-through piston or sand effect.
     *  To prevent this, set this to false.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Return true to have no particles spawn when you break something.
     */
    @SideOnly(Side.CLIENT)
    public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer)
    {
        return true;
    }
}
