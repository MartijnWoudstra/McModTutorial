package mcmodtutorial.blocks;

import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.Strings;
import net.minecraft.block.Block;

/**
 * mcmodtutorial
 * <p/>
 * TestBlock
 *
 * @Author Martijn Woudstra
 */

public class TestBlock extends BlockMcModTutorial
{
    public TestBlock()
    {
        this.setBlockName(Strings.TestBlockName);
        this.setHardness(1f);
        this.setResistance(3f);
        this.setCreativeTab(McModTutorial.getCreativeTab());
        this.setStepSound(Block.soundTypeAnvil);
        ModBlocks.register(this);
    }
}
