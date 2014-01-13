package com.invizzble.SC.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.tileEntities.TileAtomizer;

public class GUIAtomizer extends GuiContainer{
	
	public GUIAtomizer(InventoryPlayer invplayer, TileAtomizer atomizer){
		super(new ContainerAtomizer(invplayer, atomizer));
		
		xSize = 176;
		ySize = 154;
	}
	
	private static final ResourceLocation texture = new ResourceLocation(BlockInfo.TEXTURE_LOCATION, "textures/gui/machine.png");

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
