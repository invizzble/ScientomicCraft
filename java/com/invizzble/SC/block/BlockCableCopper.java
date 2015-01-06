package com.invizzble.SC.block;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.tileEntities.BaseTileEntityCable;
import com.invizzble.SC.tileEntities.TileEntityCableCopper;
import com.invizzble.SC.util.LogHelper;

public class BlockCableCopper extends SCBlockCable{
	
	public BlockCableCopper(){
		setBlockName("CopperCable");
		
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityCableCopper();
	}
}
