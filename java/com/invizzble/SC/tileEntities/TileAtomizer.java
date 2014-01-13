package com.invizzble.SC.tileEntities;

import com.invizzble.SC.lib.BlockInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileAtomizer extends TileEntity implements IInventory {

	private ItemStack[] items;

	public TileAtomizer() {
		items = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);
		
		if(itemstack != null){
			if(itemstack.stackSize <= count){
				setInventorySlotContents(i, null);
			}else{
				itemstack.splitStack(count);
				onInventoryChanged();
			}
		}
		
		// TODO Auto-generated method stub
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		
		if(itemstack!= null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
		
		onInventoryChanged();

	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return BlockInfo.ATOMIZER_NAME;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
				zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub

	}

	int[] allowedItems = new int[] { Item.redstone.itemID, Item.coal.itemID,
			Item.diamond.itemID, Item.ingotGold.itemID, Item.ingotIron.itemID };

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return itemstack.itemID == Item.coal.itemID;

	}
}
