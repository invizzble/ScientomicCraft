package com.invizzble.SC.client.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachine extends Slot{

	public SlotMachine(IInventory inventory, int id, int x,
			int y) {
		super(inventory,id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack p_75214_1_) {
		return getSlotIndex()==2?false:true;
	}

}
