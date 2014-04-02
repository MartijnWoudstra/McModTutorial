package mcmodtutorial.client.render;

import cpw.mods.fml.client.FMLClientHandler;
import mcmodtutorial.lib.References;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * RenderTestContainer
 * Created by: Martijn Woudstra
 * Date: 01-apr-2014
 */

public class RenderTestContainer extends TileEntitySpecialRenderer
{
    /**
     * Making fields of our texture and model.
     */
    private static final ResourceLocation texture = new ResourceLocation(References.MODID, "textures/models/lamp.png");
    private IModelCustom model;

    public RenderTestContainer()
    {
        //Set the model fielt to our Model File.
        this.model = AdvancedModelLoader.loadModel(new ResourceLocation(References.MODID, "models/Lamp.obj"));
    }

    /**
     * Render our Model
     */
    @Override
    public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8)
    {
        //'Clear memory'
        GL11.glPushMatrix();
        //Translate, no actual changes
        GL11.glTranslated(x, y, z);
        //Scale. Size = 1
        GL11.glScalef(1, 1, 1);
        //Bind our texture
        FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texture);
        //Rotate 0 degrees
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
        //Render Model
        model.renderAll();
        //Pop the matrix
        GL11.glPopMatrix();
    }
}
