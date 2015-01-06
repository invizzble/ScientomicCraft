package com.invizzble.SC.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.lib.Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockCable extends ItemBlock{

	long hexaString;
	
	public ItemBlockCable(Block block, Long red, Long green, Long blue) {
		super(block);
		hexaString = Long.valueOf(Long.toHexString(red)+Long.toHexString(green)+Long.toHexString(blue), 16);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public int getColorFromItemStack(ItemStack stack, int par1) {
		return (int)hexaString;
	}
	
}
