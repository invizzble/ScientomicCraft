package com.invizzble.SC.client.interfaces;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

import javax.vecmath.Vector2f;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.shader.TesselatorVertexState;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.research.ModResearch;
import com.invizzble.SC.research.PageResearch;
import com.invizzble.SC.research.Research;
import com.invizzble.SC.research.ResearchTest;

import cpw.mods.fml.client.config.HoverChecker;

public class GuiSciPad extends GuiScreen{
    /**
     * This class is really a mess... It just won't work the way I want it so i'll brute force it a bit.
     * 			-> can be lots better, will be when i redo the mod, but it won't be directly :p (there first has to be a mod to be redone
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
	
	double animateLine = 0;
	
	boolean isClicked = false;		
	
	public GuiSciPad() {
		curPage = ModResearch.basic;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float p_73863_3_) {
		super.drawScreen(mouseX, mouseY, p_73863_3_);
		drawDefaultBackground();
		drawPageBackground();
		drawLines();
		drawResearches(mouseX, mouseY);
		drawSciPadOverlay();
		drawHovering(mouseX, mouseY);
		
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
			if(focusX + (tempMouseX - x) < -3){
				focusX = -3;
			}else if (focusX + (tempMouseX - x) > 139){
				focusX = 139;
			}else{
				focusX += (tempMouseX - x);
			}
			tempMouseX = x;
			if(focusY + (tempMouseY - y) <  -2){
				focusY = -2;
			}else if(focusY + (tempMouseY - y) > 74){
				focusY = 74;
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
		for(Research research: curPage.getResearchesList()){
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);

			int x = this.x + scWidth/2 - (int)((focusX - 64 -research.getPageX() - 4) * pageScaleWidth);
			int y = this.y + scHeight/2 - (int)((focusY - 32 - research.getPageY() - 4)* pageScaleHeight);
			IIcon icon = research.getIcon();
			if(research.isDiscovered()){
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}else{
				GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
			}
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			if(((x+researchSide/2) >= this.x + 5 && (x-researchSide/2) <= this.x + scWidth) && ((y+researchSide/2) >= this.y + 5 && (y-researchSide/2) <= this.y+scHeight - 10)){
				drawTexturedModalRect(x-(researchSide/2), y-(researchSide/2), 0, 256-researchSide, researchSide, researchSide);
				Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
				drawTexturedModelRectFromIcon(x-(researchIconSide/2), y-(researchIconSide/2), icon, researchIconSide, researchIconSide);
			}
			
			//Find way to draw the lines behind the
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
	
	public void drawHovering(int mouseX, int mouseY){
		ArrayList<String> list = new ArrayList<String>();
		for(Research research:curPage.getResearchesList()){
			int x = this.x + scWidth/2 - (int)((focusX - 64 -research.getPageX() - 4) * pageScaleWidth);
			int y = this.y + scHeight/2 - (int)((focusY - 32 - research.getPageY() - 4)* pageScaleHeight);
			if((mouseX > (x-researchSide/2) && mouseX < (x-researchSide/2)+researchSide) && (mouseY > (y-researchSide/2) && mouseY < (y-researchSide/2)+researchSide)){
				list.clear();
				if(research.canDiscover() || research.isDiscovered()){
					list.add(research.getName());
					list.add(research.getDesciption());
				}else{
					list.add("??");
					list.add("????");
				}
				drawHoveringText(list, mouseX, mouseY, fontRendererObj);
			}
		}
	}
	
	public void drawLines(){
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//FIX THIS!
		for(Research research:curPage.getResearchesList()){
			int x = this.x + scWidth/2 - (int)((focusX - 64 -research.getPageX() - 4) * pageScaleWidth);
			int y = this.y + scHeight/2 - (int)((focusY - 32 - research.getPageY() - 4)* pageScaleHeight);
			for(Research required:research.getRequiredResearch()){
				int otherX = this.x + scWidth/2 - (int)((focusX - 64 -required.getPageX() - 4) * pageScaleWidth);
				int otherY = this.y + scHeight/2 - (int)((focusY - 32 - required.getPageY() - 4)* pageScaleHeight);
				int width;
				int height;
				
				if(x > otherX){
					width = research.getPageX() - required.getPageX();
				}else{
					width = required.getPageX() - research.getPageX();
				}
				if(y > otherY){
					height = research.getPageY() - required.getPageY();
				}else{
					height = required.getPageY() - research.getPageY();
				}
				
				//Using thales to keep the line straight if it's past the borders! adjustement = (overflow/(width or height)*(width or height)
				if(x < this.x){
					try{
						y  += (int)((float)(Math.abs(x - this.x ))/width * height);
					}catch(ArithmeticException e){
						
					}
					x = this.x;
				}
				
				if(x > this.x + scWidth){
					try{
						y  -= (int)((float)(Math.abs(x -(this.x + scWidth)))/width * height);
					}catch(ArithmeticException e){
						
					}
					x = this.x+scWidth;
				}
				
				if(otherX > this.x + scWidth){
					try{
						otherY  -= (int)(float)(Math.abs(otherX-(this.x + scWidth))/width * height);
					}catch(ArithmeticException e){
						
					}
					otherX = this.x+scWidth;
				}
				
				if(otherX < this.x){
					try{
					otherY  += (int)((float)(Math.abs(otherX - this.x))/width * height);				
					}catch(ArithmeticException e){
						
					}
					otherX = this.x;
				}
				
				if(otherY < this.y){
					try{
						otherX  += (int)((float)(Math.abs(otherY - this.y))/ height * width);
					}catch(ArithmeticException e){
						
					}
					otherY = this.y;
				}
				
				if(y < this.y){
					try{
						x  += (int)((float)(Math.abs(y - this.y))/ height * width);
					}catch(ArithmeticException e){
						
					}
					y = this.y;
				}
				
				if(otherY > this.y + scHeight){
					
					otherY = this.y+scHeight;
				}
				
				if(y > this.y+scHeight){
					x  -= (int)((float)(Math.abs(y - (this.y + scHeight)))/ height * width);
					y = this.y+scHeight;
				}
				
				//color = (alpha)(red)(green)(blue)
				int color = 0xFFD9D9D9;
				
				drawLine(x, y, otherX, otherY, color);
			}
		}
		GL11.glPopMatrix();
	}
	
	
	//problem with coloring
	public void drawLine(int xStart, int yStart, int xEnd, int yEnd, int color){
		double width ;
		double height;
		if(xStart > xEnd){
			width = -(xStart - xEnd);
		}else{
			width = xEnd - xStart;
		}
		if(yStart > yEnd){
			height = -(yStart - yEnd);
		}else{
			height = yEnd - yStart;
		}
		double length = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		if(xEnd <= xStart){
			length = -length;
		}
		GL11.glTranslatef((float)xStart, (float)yStart, 0);
		if(width != 0){
			GL11.glRotated(Math.toDegrees(Math.atan2(height, width)), 0.0F, 0.0F, 1.0F);
		}else{
			if(yStart < yEnd){
				GL11.glRotated(90, 0.0F, 0.0F, 1.0F);
			}else{
				GL11.glRotated(-90 , 0.0F, 0.0F, 1.0F);
			}
		}
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glLineWidth(2.0F);
		Tessellator tes = Tessellator.instance;
		tes.startDrawing(GL11.GL_LINES);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		tes.setColorOpaque_I(color);
		for(int i = 0; i < Math.abs(length); i+=1){
			tes.addVertex(i, 5*Math.sin(0.1*i + animateLine) , 0);
			tes.addVertex(i + 1, 5*Math.sin(0.1*(i - 1) + animateLine), 0);

		}
		if(animateLine < 31.5){
			animateLine+=0.1;
		}else{
			animateLine = 0;
		}
		tes.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}
	

}
