package com.invizzble.SC.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.energy.Energy;
import com.invizzble.SC.recipes.CustomRecipes;
import com.invizzble.SC.recipes.ModRecipes;

public abstract class BaseTileEntityConsumer extends BaseTileEntityMachine{
		
	public BaseTileEntityConsumer(){
		items = new ItemStack[2];
	}
	
	@Override
	void save(NBTTagCompound tag) {
		
	}
	
	@Override
	void load(NBTTagCompound tag) {
		
	}
	
	public boolean canProcess(CustomRecipes recipes, ItemStack stack){
		if(stack != null){
			if(recipes.getProcessResult(stack) != null){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public void process(CustomRecipes recipes, int inputSlot, int outputSlot){
		setInventorySlotContents(outputSlot, recipes.getProcessResult(getStackInSlot(inputSlot)));
		setInventorySlotContents(inputSlot, null);
	}
	
	@Override
	public void updateEntity() {
//		if(canProcess(ModRecipes.grinder, getStackInSlot(0))){
//			process(ModRecipes.grinder, 0, 2);
//		}
	}
	
	@Override
	public boolean canSendTo(ForgeDirection direction) {
		return false;
	}

}
