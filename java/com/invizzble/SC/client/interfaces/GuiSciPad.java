package com.invizzble.SC.client.interfaces;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.research.ModResearch;
import com.invizzble.SC.research.PageResearch;
import com.invizzble.SC.research.Research;

import cpw.mods.fml.client.config.HoverChecker;

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
	public void drawScreen(int mouseX, int mouseY, float p_73863_3_) {
		super.drawScreen(mouseX, mouseY, p_73863_3_);
		drawDefaultBackground();
		drawPageBackground();
		drawResearches(mouseX, mouseY);
		drawSciPadOverlay();
	}
	
	public void drawPageBackground(){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Info.MOD_ID+":"+"textures/gui/pageBackground/"+curPage.getName()+".png"));
		GL11.glScalef(pageScaleWidth, pageScaleHeight, 1.0F);
		x = (width - sciPadWidth)/ 2 + 50/4;
		y = (height - sciPadHeight)/ 2 + 50/4 + (int)(pageScaleHeight);
		scWidth = sciPadWidth - 2 * 50/4 - 14;
		scHeight = (sciPadHeight - 2*50/4) - (int)(pageScaleWidth);
		drawTexturedModalRect((int)(x/pageScaleWidth), (int)(y/pageScaleHeight) , focusX, focusY, (int)(scWidth/pageScaleWidth), (int)(scHeight/pageScaleHeight));
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
			if(focusX + (tempMouseX - x) <= -5){
				focusX = -4;
			}else if (focusX + (tempMouseX - x) > 139){
				focusX = 139;
			}else{
				focusX += (tempMouseX - x);
			}
			tempMouseX = x;
			if(focusY + (tempMouseY - y) <  -2){
				focusY = -2;
			}else if(focusY + (tempMouseY - y) > 75){
				focusY = 75;
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
	
	public void drawResearches(int mouseX, int mouseY){
		int left ;
		int right;
		int sWidth;
		int sHeight;
		for(Research research: curPage.getResearchesList()){
			GL11.glPushMatrix();
			int x = this.x + scWidth/2 - (int)((focusX - 64 + research.getPageX() - 4) * pageScaleWidth);
			int y = this.y + scHeight/2 - (int)((focusY - 32 + research.getPageY() - 4)* pageScaleHeight);
			IIcon icon = research.getIcon();
			if(research.isDiscovered()){
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}else{
				GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			if((x > this.x && x < this.x + scWidth) && (y > this.y && y < this.y+scHeight)){
				drawTexturedModalRect(x-(researchSide/2), y-(researchSide/2), 0, 256-researchSide, researchSide, researchSide);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
				drawTexturedModelRectFromIcon(x-(researchIconSide/2), y-(researchIconSide/2), icon, researchIconSide, researchIconSide);
			}
			
			if((mouseX > (x-researchSide/2) && mouseX < (x-researchSide/2)+researchSide) && (mouseY > (y-researchSide/2) && mouseY < (y-researchSide/2)+researchSide)){
				ArrayList<String> list = new ArrayList<String>();
				if(research.canDiscover() || research.isDiscovered()){
					list.add(research.getName());
					list.add(research.getDesciption());
				}else{
					list.add("??");
					list.add("????");
				}
				drawHoveringText(list, mouseX, mouseY, fontRendererObj);
			}
			
			GL11.glPopMatrix();
		}
	}
	
	public void drawSciPadOverlay(){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GL11.glScalef(scale, scale, 1.0F);
		drawTexturedModalRect((int)((width - sciPadWidth)/(scale * 2)), (int)((height - sciPadHeight)/(scale * 2)), 0, 0, 256, 128);
		GL11.glPopMatrix();
	}
	

}
