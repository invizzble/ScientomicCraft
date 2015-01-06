package com.invizzble.SC.block;

import com.invizzble.SC.tileEntities.TileEntityCableSilver;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCableSilver extends SCBlockCable{

	public BlockCableSilver(){
		setBlockName("SilverCable");
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metaData) {
		return new TileEntityCableSilver();
	}

}
