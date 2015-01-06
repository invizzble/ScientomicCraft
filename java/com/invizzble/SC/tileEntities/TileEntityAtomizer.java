package com.invizzble.SC.tileEntities;

import net.minecraft.inventory.InventoryBasic;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityAtomizer extends BaseTileEntityConsumer{
	
	public TileEntityAtomizer() {
	}

	@Override
	public
	int getMaxProcessing() {
		return 100;
	}

	@Override
	public void updateEntity() {
	}

	@Override
	public int getMaxTransfer() {
		return 5;
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getMaxCapacity() {
		return 1000;
	}

}
