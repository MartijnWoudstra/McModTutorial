package mcmodtutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.References;
import mcmodtutorial.tileentities.TileEntityTestContainer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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
        entityPlayer.openGui(McModTutorial.instance, 1, world, x ,y, z);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName());
    }
}
