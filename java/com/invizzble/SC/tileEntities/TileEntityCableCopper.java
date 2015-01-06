package com.invizzble.SC.tileEntities;

import com.invizzble.SC.energy.Energy;


public class TileEntityCableCopper extends BaseTileEntityCable {

	public TileEntityCableCopper(){
		super(CableType.COPPER);
	}

	@Override
	public int getMaxTransfer() {
		return 5;
	}

	
}
