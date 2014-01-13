package com.invizzble.SC.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.tileEntities.TileAtomizer;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler{

	public GUIHandler(){
		NetworkRegistry.instance().registerGuiHandler(SC.instance, this);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(ID){
		case 1: 
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileAtomizer){
				return new ContainerAtomizer(player.inventory, (TileAtomizer)te);
			}
			break;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		// TODO Auto-generated method stub
		switch(ID){
		case 1:
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if(te != null && te instanceof TileAtomizer){
				return new GUIAtomizer(player.inventory, (TileAtomizer)te);
			}
		}
		return null;
	}

}
