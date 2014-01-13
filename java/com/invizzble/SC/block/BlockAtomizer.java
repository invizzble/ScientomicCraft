package com.invizzble.SC.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.tileEntities.TileAtomizer;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAtomizer extends BlockContainer {

	private Icon front;
	private Icon defaultIcon;

	EntityPlayer player;

	public BlockAtomizer(int id) {
		super(id, Material.iron);
		setUnlocalizedName(BlockInfo.ATOMIZER_UNLOCALIZED);
		setCreativeTab(ModCreativeTabs.tabSC);
		setHardness(3F);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(!world.isRemote){
			FMLNetworkHandler.openGui(player, SC.instance, 1, world, x, y, z);
		}
		return true;	
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		front = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.ATOMIZER_TEXTURES[0]);
		defaultIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":"
				+ BlockInfo.ATOMIZER_TEXTURES[1]);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileAtomizer();
	}

	/**
	 * Side: -1: UP 0: NORTH 1: EAST 2: SOUTH 3: WEST
	 **/
	

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
		return par1 != par2 ? defaultIcon : front;
    }

	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
    }

}
