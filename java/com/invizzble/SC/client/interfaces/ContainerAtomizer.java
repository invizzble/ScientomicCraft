package com.invizzble.SC.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import com.invizzble.SC.tileEntities.BaseTileEntityMachine;

public class ContainerAtomizer extends Container{

public ContainerAtomizer(BaseTileEntityMachine machine, InventoryPlayer invPlayer){
		
		addSlotToContainer(new SlotMachine(machine,0,38,18));
		
		addSlotToContainer(new SlotMachine(machine, 1, 38, 54));
		
		for(int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 18*x+8, 142));
		}
		
		for (int y = 0; y < 3; y++){
			for(int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, 9+x+(y*9), 18*x+8, 84+y*18));
			}
		}
	}

@Override
public boolean canInteractWith(EntityPlayer p_75145_1_) {
	return true;
}

}
