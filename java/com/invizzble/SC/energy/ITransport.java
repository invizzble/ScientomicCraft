package com.invizzble.SC.energy;

import net.minecraftforge.common.util.ForgeDirection;

public interface ITransport extends IEnergy{
	
	void setLastReceivedDirection(ForgeDirection direction);
	
}
