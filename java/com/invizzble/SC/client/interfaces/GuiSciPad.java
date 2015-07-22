package com.invizzble.SC.client.interfaces;

import java.math.BigDecimal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.research.ModResearch;
import com.invizzble.SC.research.PageResearch;
import com.invizzble.SC.research.Research;

public class GuiSciPad extends GuiScreen{
    /**
     * This class is really a mess... It just won't work the way I want it so i'll brute force it a bit.
     */
	private static final ResourceLocation texture = new ResourceLocation(Info.MOD_ID+":"+"textures/gui/SciPad.png");
	
	PageResearch curPage;
	
	int sciPadWidth = 410;
	int sciPadHeight = 205;
	
	int pageWidth = 2*(sciPadWidth- (int)(14*(sciPadWidth/256)));
	int pageHeight = 2*sciPadHeight;
	
	int pageX;
	int pagY;
	
	int researchSide = 20;
	int researchIconSide = 16;
	
	float scale = sciPadWidth / 256.0F;
	float pageScaleWidth = pageWidth/256.0F;
	float pageScaleHeight = 2*scale;
	
	int x;
	int y;
	int focusX = 64;
	int focusY = 32;
	int scWidth;
	int scHeight;
	
	int tempMouseX;
	int tempMouseY;
	
	boolean isClicked = false;
	
	
	
	//THe Width and height of the 'screen' with 20px (int 256 file)
	
	
	public GuiSciPad() {
		curPage = ModResearch.basic;
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
		drawDefaultBackground();
		drawPageBackground();
		drawResearches();
		drawSciPadOverlay();
	}
	
	public void drawPageBackground(){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Info.MOD_ID+":"+"textures/gui/pageBackground/"+curPage.getName()+".png"));
		GL11.glScalef(pageScaleWidth, pageScaleHeight, 1.0F);
		x = (width-sciPadWidth)/2;
		y = (height-sciPadHeight)/2;
		scWidth = (int)((sciPadWidth -3 )/pageScaleWidth)- 14 * (sciPadWidth / 256) + 4;
		scHeight = (int)((sciPadHeight)/pageScaleHeight) -2;
		drawTexturedModalRect((int)(x/pageScaleWidth + 2), (int)(y/pageScaleHeight + 1), focusX, focusY, scWidth, scHeight);
		
		//drawTexturedModalRect(((width-256)/2 + 12), ((height-128)/2 + 12), 12, 12, 256 - 24  - 14, 128-24);
		//drawTexturedModalRect((int)((width - sciPadWidth)/(2* scale * 2)), (int)((height - sciPadHeight)/(2*scale * 2)), 0, 0, 256, 128);
		//drawTexturedModalRect((int)(((width-pageShownWidth)/2  - (int)(14*(sciPadWidth/256)))/scale) , (int)(((height-pageShownHeight)/2)/scale), 0, 0, (int)(pageShownWidth/scale), (int)(pageShownHeight/scale));
		//drawTexturedModalRect((int)(((width - pageShownWidth)/2 - 12.5*(pageShownWidth/256))/scale), (int)((height -pageShownHeight)/(scale * 2)) + (int)(4/scale), xToCenter, yToCenter, (int)((pageShownWidth - 12.5*(pageShownWidth/256))/scale), (int)(pageShownHeight/scale));
		GL11.glPopMatrix();
	}
	
	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY,
			int wich) {
		super.mouseMovedOrUp(mouseX, mouseY, wich);
		//mouseUp
		if(wich == 0 || wich == 1){
			isClicked = false;
		}
		
	}
	
	@Override
	protected void mouseClickMove(int x, int y,
			int p_146273_3_, long p_146273_4_) {
		super.mouseClickMove(x, y, p_146273_3_, p_146273_4_);
		if(isClicked){
		if(focusX + (tempMouseX - x) < 0){
			focusX = 0;
		}else if (focusX + (tempMouseX - x) > 128){
			focusX = 128;
		}else{
			focusX += (tempMouseX - x);
		}
		tempMouseX = x;
		if(focusY + (tempMouseY - y) < 0){
			focusY = 0;
		}else if(focusY + (tempMouseY - y) > 64){
			focusY = 64;
		}else{
			focusY += (tempMouseY - y);
		}
		tempMouseY = y;
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int p_73864_3_) {
		super.mouseClicked(mouseX, mouseY, p_73864_3_);
		tempMouseX = mouseX;
		tempMouseY = mouseY;
		if((mouseX > this.x && mouseX < this.x + scWidth * pageScaleWidth) && (mouseY > this.y && mouseY < this.y+ scHeight * pageScaleHeight)){
			isClicked = true;
		}
	}
	
	public void drawResearches(){
		for(Research research: curPage.getResearchesList()){
			GL11.glPushMatrix();
			int x = (this.x+2) - 3*(focusX - 64 + research.getPageX()) + ((sciPadWidth-3)-14*(sciPadWidth/256)+15)/2;
			int y = this.y - 3*(focusY - 32 + research.getPageY())+ sciPadHeight/2;
			IIcon icon = research.getIcon();
			if(research.isDiscovered()){
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}else{
				GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			drawTexturedModalRect(x-(researchSide/2), y-(researchSide/2), 0, 256-researchSide, researchSide, researchSide);
			Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
			drawTexturedModelRectFromIcon(x-(researchIconSide/2), y-(researchIconSide/2), icon, researchIconSide, researchIconSide);
			GL11.glPopMatrix();
		}
	}
	
	public void drawSciPadOverlay(){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GL11.glScalef(scale, scale, 1.0F);
		//drawTexturedModalRect((width-256)/2, (height-128)/2, 0, 0, 256, 128);
		drawTexturedModalRect((int)((width - sciPadWidth)/(scale * 2)), (int)((height - sciPadHeight)/(scale * 2)), 0, 0, 256, 128);
		GL11.glPopMatrix();
	}

}
