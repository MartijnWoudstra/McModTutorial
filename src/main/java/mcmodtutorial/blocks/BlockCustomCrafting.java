package mcmodtutorial.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcmodtutorial.McModTutorial;
import mcmodtutorial.lib.References;
import mcmodtutorial.tileentities.TileEntityCustomCrafting;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * BlockCustomCrafting
 * Created by: Martijn Woudstra
 * Date: 23-apr-2014
 */

public class BlockCustomCrafting extends BlockContainer
{
    protected BlockCustomCrafting()
    {
        super(Material.rock);
        this.setCreativeTab(McModTutorial.getCreativeTab());
        this.setBlockName(References.MODID + ":" + "BlockCustomContainer");
        GameRegistry.registerBlock(this, this.getUnlocalizedName());
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileEntityCustomCrafting();
    }

    @Override
    public boolean hasTileEntity(int meta)
    {
        return true;
    }
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par1, float par2, float par3, float par4)
    {
        entityPlayer.openGui(McModTutorial.instance, 2, world, x, y, z);
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName());
    }
}
