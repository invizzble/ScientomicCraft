package com.invizzble.SC.energy;

import com.invizzble.SC.util.LogHelper;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyGrid {

	public static void transportToSurrounding(World world, int x, int y, int z, Energy energy){
		transportToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, energy);
	}
	
	public static void transportToSurrounding(World world, int x, int y, int z, ForgeDirection lastDirection, Energy energy){
		ITransport currentTile = (ITransport)world.getTileEntity(x, y, z);
		int sides = 0;
		boolean[] canTransferTo = new boolean[6];
		for(ForgeDirection direction: ForgeDirection.VALID_DIRECTIONS){
			if(direction != lastDirection && currentTile.canSendTo(direction) && world.getTileEntity(x+direction.offsetX, y+direction.offsetY, z+direction.offsetZ) instanceof IEnergy){
				sides++;
				canTransferTo[direction.ordinal()] = true;
			}
		}
		
		for(ForgeDirection direction: ForgeDirection.VALID_DIRECTIONS){
			if(canTransferTo[direction.ordinal()]){
				IEnergy tile = (IEnergy)world.getTileEntity(x+direction.offsetX, y+direction.offsetY, z+direction.offsetZ);
				if(tile != null){
					int maxTransfer = energy.getMaxTransfer();
					int rest = tile.getEnergy().addWithRest(maxTransfer - energy.removeCarefull(maxTransfer));
					energy.addPower(rest);
					if(tile instanceof ITransport){
						((ITransport)tile).setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
					}
				}
			}
		}
	}
	
	private static void transferToSide(IEnergy tile){
		
	}
	
}
