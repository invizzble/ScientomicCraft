package com.invizzble.SC.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.lib.Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SCBlock extends BlockContainer{

	TileEntity tileEntity = null;
	
	public SCBlock(Material material){
		super(material);
		setCreativeTab(ModCreativeTabs.tabSC);
	}
	
	public SCBlock(){
		super(Material.iron);
		setCreativeTab(ModCreativeTabs.tabSC);
	}
	
	@Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Info.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

	public TileEntity createNewTileEntity(World wrold, int var2) {
		return null;
	}
}
