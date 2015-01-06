package com.invizzble.SC.tileEntities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.energy.Energy;
import com.invizzble.SC.energy.EnergyGrid;
import com.invizzble.SC.energy.IEnergy;
import com.invizzble.SC.energy.ITransport;

public abstract class BaseTileEntityCable extends TileEntity implements ITransport{
	
	int transportCapacity;
	float boundNorth;
	float boundSouth;
	float boundUp;
	float boundDown;
	float boundEast;
	float boundWest;	
	private CableType type;
	private ForgeDirection lastReceived = ForgeDirection.UNKNOWN;
	private Energy energy;
	
	public BaseTileEntityCable(CableType type){
		this.type = type;
		energy = new Energy(getMaxTransfer(), getMaxTransfer());
	}
	
	public enum CableType{
		COPPER, SILVER
	}
	
	@Override
	public void updateEntity() {
		EnergyGrid.transportToSurrounding(worldObj, xCoord, yCoord, zCoord, lastReceived, energy);		
	}
	
	public CableType getCableType(){
		return type;
	}
	
	public boolean isCableConnected(ForgeDirection direction){
		return canSendTo(direction);
	}
	
	public void setLastReceivedDirection(ForgeDirection direction){
		lastReceived = direction;
	}

	//Have to make a difference between the different types
	@Override
	public boolean canSendTo(ForgeDirection direction) {
		IEnergy tile = (IEnergy)worldObj.getTileEntity(xCoord+direction.offsetX, yCoord+direction.offsetY, zCoord+direction.offsetZ);
		
		if(tile != null){
			if(tile instanceof BaseTileEntityCable){
				BaseTileEntityCable cable = (BaseTileEntityCable)tile;
				if(getCableType() == cable.getCableType())
					return true;
				else
					return false;
			}else if(tile instanceof BaseTileEntityConsumer)
				return true;
		}
		return false;
	}

	@Override
	public Energy getEnergy() {
		return energy;
	}
	
	@Override
	public int getMaxCapacity() {
		return getMaxTransfer();
	}
}
