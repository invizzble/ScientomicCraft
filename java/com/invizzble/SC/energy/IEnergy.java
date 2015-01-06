package com.invizzble.SC.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergy {
	
	boolean canSendTo(ForgeDirection direction);
	
	Energy getEnergy();
	
	int getMaxTransfer();
	
	int getMaxCapacity();

}
