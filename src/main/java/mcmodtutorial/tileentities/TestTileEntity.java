package mcmodtutorial.tileentities;

import net.minecraft.tileentity.TileEntity;

/**
 * TestTileEntity
 * Created by: Martijn Woudstra
 * Date: 28-mrt-2014
 */

public class TestTileEntity extends TileEntity
{
    int tick;
    int worldTime = 1;

    @Override
    public void updateEntity()
    {
        tick++;
        if(tick == 100)
        {
            if(worldTime == 1)
            {
                this.worldObj.setWorldTime(1000);
                worldTime = 0;
            }
            else
            {
                this.worldObj.setWorldTime(0);
                worldTime = 1;
            }
            tick = 0;
        }
    }
}
