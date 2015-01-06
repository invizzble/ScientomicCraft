package com.invizzble.SC.block;

import com.invizzble.SC.tileEntities.TileEntityElectricFurnace;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockElectricFurnace extends SCBlockMachine{
	
	public BlockElectricFurnace(){
		setBlockName("ElectricFurnace");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityElectricFurnace();
	}

}
