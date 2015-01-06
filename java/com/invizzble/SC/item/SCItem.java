package com.invizzble.SC.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.lib.Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class SCItem extends Item{
	
	boolean isActive= false;
	
	public SCItem(){
		setCreativeTab(ModCreativeTabs.tabSC);
	}
	
	@Override
    public String getUnlocalizedName(){
        return String.format("item.%s%s", Info.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
	
    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
    	//if(!isActive){
	    	onRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	    //	isActive = true;
    	//}
    	return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }
    
    @Override
    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
    		onRightRelease(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
    		//isActive = false;
    	super.onPlayerStoppedUsing(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
    }
    
    protected abstract void onRightRelease(ItemStack itemstack, World world, EntityPlayer player, int itemCount);

    protected abstract void onRightClick(ItemStack itemstack, World world, EntityPlayer player);
}
