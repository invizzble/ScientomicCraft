package com.invizzble.SC.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.tileEntities.TileEntityGrinder;

public class BlockGrinder extends SCBlockMachine{
	
	public BlockGrinder(){
		setBlockName("Grinder");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGrinder();
	}

}
