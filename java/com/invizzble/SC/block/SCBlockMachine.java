package com.invizzble.SC.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.invizzble.SC.lib.Info;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class SCBlockMachine extends SCBlock{
	@SideOnly(Side.CLIENT)
	IIcon front;
	@SideOnly(Side.CLIENT)
	IIcon defaultIcon;
	
	private int renderType;
	
	private int frontPos = 2;
		
	public SCBlockMachine(){
		super(Material.iron);
		setHardness(3F);
		renderType = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public void onBlockAdded(World world, int x,
			int y, int z) {
		System.out.println("k");
		world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		front = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()))+"_front");
		defaultIcon = iconRegister.registerIcon(Info.MOD_ID+":machine_default");
	};
	
	/**
	 * Side: 
	 * 		0:Top
	 * 		1:Bottom
	 * 		2:North
	 * 		3:East
	 * 		4:South
	 * 		5:West
	 **/
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
    {
		if(side != 1 || side != 0){
			if(side == meta){
				return front;
			}
		}
		return defaultIcon;
    }
	
	public IIcon[] getIcons(){
		IIcon[] icons = {defaultIcon, front};
		return icons;
	}
	
	@Override
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_,
			int p_149689_3_, int p_149689_4_, EntityLivingBase entity,
			ItemStack p_149689_6_) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

	}
	
	@Override
	public int getRenderType() {
		return renderType;

	}
	
//	@Override
//	public int damageDropped(int meta) {
//		return 3;
//	}
}
