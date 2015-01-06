package com.invizzble.SC.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.lib.GuiInfo;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.lib.ItemInfo;
import com.invizzble.SC.util.LogHelper;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSciPad extends SCItem {

	public ItemSciPad() {
		setMaxStackSize(1);
		setUnlocalizedName("Scipad");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List info, boolean useExtraInformation) {
		info.add("No This is not based on a product");
		info.add("of a big company that ");
		info.add("doesn't call pear...");
	}

	@Override
	protected void onRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		if(world.isRemote){
			FMLNetworkHandler.openGui(player, SC.instance, GuiInfo.SCIPAD_ID, world,
					player.getPlayerCoordinates().posX,
					player.getPlayerCoordinates().posY,
					player.getPlayerCoordinates().posZ);
		}
	}

	@Override
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_,
			Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {

	}

	@Override
	protected void onRightRelease(ItemStack itemstack, World world,
			EntityPlayer player, int itemCount) {
		
	}
}
