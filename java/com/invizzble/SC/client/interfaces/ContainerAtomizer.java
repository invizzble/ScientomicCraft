package com.invizzble.SC.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

import com.invizzble.SC.tileEntities.TileAtomizer;

public class ContainerAtomizer extends Container{
	
	private TileAtomizer atomizer;
	
	public ContainerAtomizer(InventoryPlayer invPlayer, TileAtomizer atomizer){
		this.atomizer = atomizer;
	}



	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return atomizer.isUseableByPlayer(entityplayer);
	}}
