package com.invizzble.SC.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;

public class GuiSciPad extends GuiScreen{

	private static final ResourceLocation texture = new ResourceLocation(Info.MOD_ID+":"+"textures/gui/SciPad.png");
	
	public GuiSciPad() {
		
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		drawDefaultBackground();
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect((width - 256)/2, (height - 128)/2, 0, 0, 256, 128);
	}

}
