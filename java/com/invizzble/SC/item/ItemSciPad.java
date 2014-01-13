package com.invizzble.SC.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.lib.ItemInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSciPad extends Item {

	public ItemSciPad(int id) {
		super(id);
		setCreativeTab(ModCreativeTabs.tabSC);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.SCI_PAD_UNLOCALIZED);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION +":"+ ItemInfo.SCI_PAD_TEXTURE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation){
		info.add("No This is not based on a product");
		info.add("of a big company that ");
		info.add("doesn't call pear...");
	}
}
