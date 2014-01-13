package com.invizzble.SC.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.tileEntities.TileAtomizer;

public class ContainerAtomizer extends Container{
	
	private TileAtomizer atomizer;
	
	public ContainerAtomizer(InventoryPlayer invPlayer, TileAtomizer atomizer){
		this.atomizer = atomizer;
		
		for(int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 8+18*x, 130));
		}
		
		for (int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + y *9 + 9,8 + 18 * x, 72 + y * 18));
			}
		}
		
		for(int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(atomizer, x, 8+18*x, 17));
		}
	}



	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return atomizer.isUseableByPlayer(entityplayer);
	}

	@Override 
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		return null;
	}
}
