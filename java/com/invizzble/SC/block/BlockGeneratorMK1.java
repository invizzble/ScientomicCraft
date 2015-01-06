package com.invizzble.SC.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.lib.GuiInfo;
import com.invizzble.SC.lib.TileInfo;
import com.invizzble.SC.tileEntities.TileEntityAtomizer;
import com.invizzble.SC.tileEntities.TileEntityGeneratorMK1;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockGeneratorMK1 extends SCBlockMachine{
	
	public BlockGeneratorMK1(){
		setBlockName("GeneratorMK1");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGeneratorMK1();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		FMLNetworkHandler.openGui(player, SC.instance,  GuiInfo.GENERATOR_MK1_ID, world, x, y, z);
		return true;
	}

	
}
