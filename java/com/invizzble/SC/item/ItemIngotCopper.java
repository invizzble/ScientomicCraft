package com.invizzble.SC.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ItemIngotCopper extends SCItem{
	
	public ItemIngotCopper() {
		setMaxStackSize(64);
		setUnlocalizedName("ingotCopper");
		OreDictionary.registerOre("ingotCopper", this);
	}

	@Override
	protected void onRightRelease(ItemStack itemstack, World world,
			EntityPlayer player, int itemCount) {
		
	}

	@Override
	protected void onRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player,
			List list, boolean p_77624_4_) {
	}

}
