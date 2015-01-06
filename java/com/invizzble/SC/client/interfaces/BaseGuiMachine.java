package com.invizzble.SC.client.interfaces;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import com.invizzble.SC.tileEntities.BaseTileEntityMachine;

public abstract class BaseGuiMachine extends GuiContainer{
	
	int mouseX;
	int mouseY;
	
	int leftPowerIndicator;
	int topPowerIndicator;
	int widthPowerIndicator;
	int heightPowerIndicator;
	
	boolean hasEnergyBox;
	
	BaseTileEntityMachine machine;
	
	protected ResourceLocation texture;
	
	public BaseGuiMachine(Container container, BaseTileEntityMachine machine) {
		super(container);
		this.machine = machine;
		hasEnergyBox =false;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.mouseX =  par1;
		this.mouseY =  par2;
		super.drawScreen(par1, par2, par3);
	}
	
	protected void drawEnergyBox(){
		hasEnergyBox = true;
		int scaledPower = machine.getEnergy().getPowerScaled(100);
		this.drawTexturedModalRect(guiLeft + 109, guiTop + 14
				+ (heightPowerIndicator-(scaledPower*heightPowerIndicator)/100), leftPowerIndicator, topPowerIndicator+(heightPowerIndicator-(scaledPower*heightPowerIndicator)/100)
				, widthPowerIndicator,heightPowerIndicator - (heightPowerIndicator-(scaledPower*heightPowerIndicator)/100));
	}
	
	protected void drawForegroundTextures(int par1, int par2){}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_,
			int p_146979_2_) {
		if(hasEnergyBox){
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			
			if(mouseX > guiLeft+109 && mouseX < guiLeft+109+widthPowerIndicator){
				 if(mouseY > guiTop+14 && mouseY < guiTop+14+heightPowerIndicator){
					List list = new ArrayList();
					list.add("Power:");
					list.add(machine.getEnergy().getCurrentPower()+"/"+machine.getEnergy().getMaxPower() + " EM");
					this.drawHoveringText(list, (int)mouseX-k, (int)mouseY - l, fontRendererObj);
				 }
			}
		}
	}
	
}
