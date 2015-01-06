package com.invizzble.SC.tileEntities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.energy.Energy;
import com.invizzble.SC.energy.EnergyGrid;
import com.invizzble.SC.energy.ITransport;
import com.invizzble.SC.lib.NBTKeys;

import cpw.mods.fml.common.registry.GameRegistry;


public abstract class BaseTileEntityProducer extends BaseTileEntityMachine implements ITransport{

	private ForgeDirection lastDirection = ForgeDirection.UNKNOWN;
	private int changingPower;
	int processTime = 0;
	
	public BaseTileEntityProducer(){
		items = new ItemStack[2];
	}
	
	@Override
	void save(NBTTagCompound tag) {
		tag.setInteger(NBTKeys.PRODUCER_PROCESSTIME, processTime);
	}
	
	@Override
	void load(NBTTagCompound tag) {
		processTime = tag.getInteger(NBTKeys.PRODUCER_PROCESSTIME);
	}
	
	@Override
	public void updateEntity() {
		onUpdate();
		EnergyGrid.transportToSurrounding(worldObj, xCoord, yCoord, zCoord, energy);
	}
	
	abstract void onUpdate();
	
	
/**				METHODS FOR THE MACHINES THAT BURN STUFF TO GET POWER */
		protected void burn(){
			if(canBurn(getStackInSlot(0)) && !isProcessing()){
				process(0);
			}else if(isProcessing()){
				processTime-= 1;
				energy.addPower(getMaxProcessing());
			}
		}
	
	public boolean canBurn(ItemStack stack){
		if(stack != null){
			if(isFuel(stack)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isProcessing(){
		return processTime > 0;
	}
	
	protected void process(int input){
		processTime = GameRegistry.getFuelValue(getStackInSlot(input))/getMaxProcessing();
		decrStackSize(input, 1);
	}
	
	public boolean isFuel(ItemStack stack){
		return GameRegistry.getFuelValue(stack) > 0;
	}
	
	@Override
	public void setLastReceivedDirection(ForgeDirection direction) {
		lastDirection = direction;
	}
	
	@Override
	public boolean canSendTo(ForgeDirection direction) {
		if(worldObj.getTileEntity(xCoord+direction.offsetX, yCoord+direction.offsetY, zCoord+direction.offsetZ) instanceof BaseTileEntityProducer){
			return false;
		}
		return true;
	}
}
