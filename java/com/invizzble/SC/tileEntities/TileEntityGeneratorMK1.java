package com.invizzble.SC.tileEntities;

import com.invizzble.SC.recipes.ModRecipes;

public class TileEntityGeneratorMK1 extends BaseTileEntityProducer{
	public TileEntityGeneratorMK1(){
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
	public int getMaxProcessing() {
		return 10;
	}

	@Override
	void onUpdate() {
		burn();
	}

	@Override
	public int getMaxTransfer() {
		return 10;
	}

	@Override
	public int getMaxCapacity() {
		return 10000;
	}
	
	

}
