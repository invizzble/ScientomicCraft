package com.invizzble.SC.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.lib.GuiInfo;
import com.invizzble.SC.tileEntities.TileEntityAtomizer;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class BlockAtomizer extends SCBlockMachine {
	EntityPlayer player;
	
	public BlockAtomizer() {
		setBlockName("Atomizer");
		//setIcons(BlockInfo.ATOMIZER_TEXTURES[0], BlockInfo.ATOMIZER_TEXTURES[1]);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,int p_149727_6_, float hitX, float hitY, float hitZ) {
		FMLNetworkHandler.openGui(player, SC.instance, GuiInfo.ATOMIZER_ID, world, x , y, z);
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityAtomizer();
	}

}
