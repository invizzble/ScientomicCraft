package com.invizzble.SC.handler;

import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() instanceof ItemCoal){
			return 800;
		}
		return 0;
	}

}
