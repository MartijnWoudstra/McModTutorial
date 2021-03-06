package mcmodtutorial.blocks;

import mcmodtutorial.McModTutorial;
import mcmodtutorial.tileentities.TestTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * TestTileBlock
 * Created by: Martijn Woudstra
 * Date: 28-mrt-2014
 */

public class TestTileBlock extends BlockMcModTutorial
{
    public TestTileBlock()
    {
        super(Material.rock);
        this.setBlockName("TestTileBlock");
        this.setCreativeTab(McModTutorial.getCreativeTab());
        ModBlocks.register(this);
    }

    /**
     * Tells forge that we have a tile entity.
     *
     * @param meta
     * @return true
     */
    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }

    /**
     * Create a tile entity. This should return your TE class
     *
     * @return your TE class
     */
    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return new TestTileEntity();
    }

    /**
     * On right click, open the GUI.
     * Return true if something happens, otherwise return false
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par1, float par2, float par3, float par4)
    {
        entityPlayer.openGui(McModTutorial.instance, 0, world, x ,y, z);
        return true;
    }
}
