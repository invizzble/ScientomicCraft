package com.invizzble.SC.tileEntities;

public class TileEntityElectricFurnace extends BaseTileEntityConsumer {

	public TileEntityElectricFurnace(){
		
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getMaxCapacity() {
		return 10000;
	}
	
	@Override
	public int getMaxProcessing() {
		return 20;
	}

	@Override
	public int getMaxTransfer() {
		return 5;
	}

}
