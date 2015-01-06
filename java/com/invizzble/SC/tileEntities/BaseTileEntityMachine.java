package com.invizzble.SC.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.energy.Energy;
import com.invizzble.SC.energy.IMachine;
import com.invizzble.SC.lib.NBTKeys;
import com.invizzble.SC.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BaseTileEntityMachine extends TileEntity
		implements IInventory, IMachine {

	protected ItemStack[] items;
	protected Energy energy = new Energy(getMaxCapacity(), getMaxProcessing(), getMaxTransfer());
	
	public BaseTileEntityMachine(){
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		writeSyncableToNBT(compound);
		
		for (int i = 0; i < getSizeInventory(); i++) {		
			
			if (getStackInSlot(i) != null) {
				ItemStack stack = getStackInSlot(i);
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);
		save(compound);
	}
	
	abstract void save(NBTTagCompound tag);
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList items = (NBTTagList)compound.getTag("Items");
		readSyncableFromNBT(compound);
		
		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			int slot = item.getByte("Slot");
			
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		load(compound);
	}
	
	abstract void load(NBTTagCompound tag);
	
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (items[slot] != null) {
			ItemStack itemstack;

			if (items[slot].stackSize <= amount) {
				itemstack = items[slot];
				items[slot] = null;
				return itemstack;
			} else {
				itemstack = items[slot].splitStack(amount);

				if (items[slot].stackSize == 0) {
					items[slot] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		items[slot] = stack;
	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) {
		return items[slot];
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}
	
	@Override
	public Energy getEnergy() {
		return energy;
	}	
	@Override
	public boolean canSendTo(ForgeDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readSyncableFromNBT(pkt.func_148857_g());
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound data = new NBTTagCompound();
		writeSyncableToNBT(data);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, data);
	}
	
	public void writeSyncableToNBT(NBTTagCompound tag){
		tag.setInteger(NBTKeys.MACHINE_CURRENT_POWER, energy.getCurrentPower());
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
	}
	
	public void readSyncableFromNBT(NBTTagCompound tag){
		energy.setCurrentPower(tag.getInteger(NBTKeys.MACHINE_CURRENT_POWER));
	}
	
}
