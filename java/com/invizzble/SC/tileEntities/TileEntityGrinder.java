package com.invizzble.SC.tileEntities;

public class TileEntityGrinder extends BaseTileEntityConsumer{

	public TileEntityGrinder(){
	}

	@Override
	public int getMaxProcessing() {
		return 0;
	}

	@Override
	public void updateEntity() {
		
	}

	@Override
	public int getMaxTransfer() {
		return 0;
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
		return 0;
	}

}
