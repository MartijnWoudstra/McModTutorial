package mcmodtutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * mcmodtutorial
 * <p/>
 * ModBlocks
 *
 * @Author Martijn Woudstra
 */

public class ModBlocks
{
    public static Block testBlock;

    public static void init()
    {
        testBlock = new TestBlock();
    }

    /**
     * Registeres the blocks.
     * Any block calling this NEEDS to extend BlockMcModTutorial.
     * For registering a block, you need to call registerBlock and use
     * Format: [block], [unlocalizedname]
     * @param block
     */
    public static void register(BlockMcModTutorial block)
    {
        GameRegistry.registerBlock(block, block.getUnwrappedUnlocalizedName(block.getUnlocalizedName()));
    }
}
