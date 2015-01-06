package com.invizzble.SC.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.tileEntities.BaseTileEntityMachine;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class SCBlockMachine extends SCBlock{
	IIcon front;
	IIcon defaultIcon;
	String frontName;
	String defaultName;
		
	public SCBlockMachine(){
		super(Material.iron);
		setHardness(3F);
	}
	
	public void setIcons(String _frontName, String _defaultName){
		frontName = _frontName;
		defaultName = _defaultName;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		front= p_149651_1_.registerIcon(Info.MOD_ID+":"+frontName);
		defaultIcon = p_149651_1_.registerIcon(Info.MOD_ID+":"+defaultName);
	}
	
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
		return (side != 1 && side != 0)?front:defaultIcon;
    }
		
	
}
