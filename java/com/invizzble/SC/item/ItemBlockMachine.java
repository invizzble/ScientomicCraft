package com.invizzble.SC.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockMachine extends ItemBlock{

	public ItemBlockMachine(Block block) {
		super(block);
		
	}

	
	@Override
	public int getDamage(ItemStack stack) {
		return 5;
	}
}
