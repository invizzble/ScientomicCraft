package com.invizzble.SC.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.energy.IEnergy;
import com.invizzble.SC.tileEntities.BaseTileEntityCable;

public class ModelCable extends ModelBase{
	
	private ModelRenderer cableTop;
	private ModelRenderer cableBottom;
	private ModelRenderer cableNorth;
	private ModelRenderer cableEast;
	private ModelRenderer cableSouth;
	private ModelRenderer cableWest;
	private ModelRenderer core;
	
	private ArrayList parts;
	
	private float red,green,blue;
	
	public ModelCable(float red, float green, float blue){
		core = new ModelRenderer(this);
		cableTop = new ModelRenderer(this, 0, 8);
		cableBottom = new ModelRenderer(this, 0, 8);
		cableNorth = new ModelRenderer(this, 16, 0);
		cableSouth= new ModelRenderer(this, 16, 0);
		cableEast = new ModelRenderer(this, 16, 10);
		cableWest = new ModelRenderer(this, 16, 10);
		//(positionx, positiony, positionz, sizex, sizey,sizez)
		this.red = red;
		this.blue = blue;
		this.green = green;
		
		addBoxes();
	}
	
	public void render(BaseTileEntityCable cable, float value1, float value2,float value3, float value4, float value5,float size) {
		GL11.glColor4d(red/255,  green/255, blue/255, 1);
		core.render(size);

		for(ForgeDirection direction: ForgeDirection.VALID_DIRECTIONS){
			if(drawConnector(cable, direction)){
				drawConnectors(direction, size);
			}
		}


	}
	
	public boolean drawConnector(BaseTileEntityCable cable, ForgeDirection direction){
		TileEntity tile = cable.getWorldObj().getTileEntity(cable.xCoord+direction.offsetX, cable.yCoord+direction.offsetY, cable.zCoord+direction.offsetZ);
		if(tile != null){
			if(tile instanceof IEnergy){
				if(tile instanceof BaseTileEntityCable){
					return cable.getCableType() == ((BaseTileEntityCable)tile).getCableType();
				}
				return true;
			}
		}
		return false;
	}
	
	 
	
	public void drawConnectors(ForgeDirection direction, float size){
		if(direction.equals(ForgeDirection.UP)){
			cableTop.render(size);
		}
		
		if(direction.equals(ForgeDirection.DOWN)){
			cableBottom.render(size);
		}
		
		if (direction.equals(ForgeDirection.NORTH)) {
			cableNorth.render(size);
		}

		if (direction.equals(ForgeDirection.SOUTH)) {
			cableSouth.render(size);
		}

		if (direction.equals(ForgeDirection.WEST)) {
			cableWest.render(size);
		}

		if (direction.equals(ForgeDirection.EAST)) {
			cableEast.render(size);
		}
	}
		
	private void addBoxes(){
		core.addBox(-10, -10, 6, 4, 4, 4);
		
		cableTop.addBox(-10, -16, 6, 4, 6, 4);
		cableBottom.addBox(-10, -6, 6, 4, 6, 4);
		
		cableNorth.addBox(-10, -10, 0, 4, 4, 6);
		cableSouth.addBox(-10, -10, 10, 4, 4, 6);

		cableWest.addBox(-6, -10, 6, 6, 4, 4);
		cableEast.addBox(-16, -10, 6, 6, 4, 4);
	}
}
