package mcmodtutorial.blocks;

import mcmodtutorial.McModTutorial;
import mcmodtutorial.tileentities.TestTileEntity;
import net.minecraft.block.material.Material;
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

    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        return new TestTileEntity();
    }
}
