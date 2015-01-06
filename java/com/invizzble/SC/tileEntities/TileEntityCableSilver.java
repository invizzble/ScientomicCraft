package com.invizzble.SC.tileEntities;


public class TileEntityCableSilver extends BaseTileEntityCable {

	public TileEntityCableSilver() {
		super(CableType.SILVER);
	}

	@Override
	public int getMaxTransfer() {
		return 100;
	}

}
