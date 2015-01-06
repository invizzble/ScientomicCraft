package com.invizzble.SC.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.model.ModelCable;
import com.invizzble.SC.tileEntities.BaseTileEntityCable;

public class TileEntityRenderCable extends TileEntitySpecialRenderer{
	
	private ModelCable modelCable;
	private static final ResourceLocation texture = new ResourceLocation(Info.MOD_ID, "textures/models/cable.png");
	
	
	public TileEntityRenderCable(float red, float green, float blue){
		modelCable = new ModelCable(red, green, blue);
		
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double translationX, double translationY, double translationZ, float f) {
		GL11.glDisable(GL11.GL_LIGHTING);
		renderPipe((BaseTileEntityCable)tileEntity, translationX, translationY, translationZ, f);
		GL11.glEnable(GL11.GL_LIGHTING);

	}
	
	private void renderPipe(BaseTileEntityCable cable, double translationX, double translationY, double translationZ, float f){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)translationX, (float)translationY, (float)translationZ);
		GL11.glScalef(-1F, -1F, 1F);		
		bindTexture(texture);
		modelCable.render(cable, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glPopMatrix();
	}
	
	

}
