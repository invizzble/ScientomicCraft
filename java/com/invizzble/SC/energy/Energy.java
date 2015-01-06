package com.invizzble.SC.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.invizzble.SC.lib.NBTKeys;
import com.invizzble.SC.util.LogHelper;

public class Energy {
	
	private int maxCapacity;
	
	private int maxTransfer;
	private int maxProcessing;
	private int currentPower;
	

	public Energy(int maxCapacity, int maxProcessing, int maxTransfer) {
		this.maxCapacity = maxCapacity;
		this.maxTransfer = maxTransfer;
		this.maxProcessing = maxProcessing;
		currentPower = 0;
	}
	
	public Energy(int maxCapacity, int transfer){
		this(maxCapacity, transfer, transfer);
	}
	
	public void addPower(int amount){
		currentPower += amount;
	}
	
	public void removePower(int amount){
		currentPower  -= amount;
	}
	
	public int getPowerScaled(int scale) {
		return Math.round(currentPower / (maxCapacity / scale));
	}

	public int getCurrentPower() {
		return currentPower;
	}
	
	public int getMaxPower(){
		return maxCapacity;
	}
	
	public int getMaxProcessing(){
		return maxProcessing;
	}
	
	public void setCurrentPower(int amount){
		currentPower = amount;
	}
	
	public int getMaxTransfer(){
		return maxTransfer;
	}
	//NEED A BETTER METHOD FOR THIS ONE, WHAT TIRED WHEN MAKING IT
	public boolean canAcceptPower(int amount){
		if(currentPower < maxCapacity){
			return (maxCapacity - currentPower) >= amount;
		}
		return false;
	}
	
	//returns the rest
	public int addWithRest(int amount){
		addPower(amount);
		if(currentPower > maxCapacity){
			int rest = currentPower - maxCapacity;
			currentPower = maxCapacity;
			return rest;
		}
		
		return 0;
	}
	
	//returns the rest
	public int removeCarefull(int amount){
		removePower(amount);
		if(currentPower < 0){
			int rest = 0 - currentPower;
			currentPower = 0;
			return rest;
		}
		return 0;
	}

}
