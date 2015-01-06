package com.invizzble.SC.block;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.tileEntities.BaseTileEntityCable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class SCBlockCable extends SCBlock {

	public SCBlockCable() {
		setBlockBounds(BlockInfo.CABLE_MIN_CONSTANT,
				BlockInfo.CABLE_MIN_CONSTANT, BlockInfo.CABLE_MIN_CONSTANT,
				BlockInfo.CABLE_MAX_CONSTANT, BlockInfo.CABLE_MAX_CONSTANT,
				BlockInfo.CABLE_MAX_CONSTANT);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		BaseTileEntityCable cable = (BaseTileEntityCable) world.getTileEntity(
				x, y, z);
		if (cable != null) {

			float minX = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.WEST) ? (6 / 16F): 0);
			float maxX = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.EAST) ? (6 / 16F): 0);
			float minY = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.DOWN) ? (6 / 16F): 0);
			float maxY = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.UP) ? (6 / 16F): 0);
			float minZ = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.NORTH) ? (6 / 16F): 0);
			float maxZ = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.SOUTH) ? (6 / 16F): 0);

			setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		return AxisAlignedBB.getBoundingBox(x + this.minX, y + this.minY, z
				+ this.minZ, x + this.maxX, y + this.maxY, z + this.maxZ);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity) { 
		BaseTileEntityCable cable = (BaseTileEntityCable) world.getTileEntity(x, y, z);
		if (cable != null) {
			float minX = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.WEST) ? (6 / 16F): 0);
			float maxX = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.EAST) ? (6 / 16F): 0);
			float minY = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.DOWN) ? (6 / 16F): 0);
			float maxY = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.UP) ? (6 / 16F): 0);
			float minZ = BlockInfo.CABLE_MIN_CONSTANT - (cable.isCableConnected(ForgeDirection.NORTH) ? (6 / 16F): 0);
			float maxZ = BlockInfo.CABLE_MAX_CONSTANT + (cable.isCableConnected(ForgeDirection.SOUTH) ? (6 / 16F): 0);

			setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		}
		super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		
	}
	
	@Override
	public String getItemIconName() {
		return Info.MOD_ID+":cable";
	}
}
