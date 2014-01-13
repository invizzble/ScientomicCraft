package com.invizzble.SC.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.item.ModItems;
import com.invizzble.SC.lib.Info;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModCreativeTabs {
	
	public static void nameCreativeTabs(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSC", "en_US", Info.MOD_NAME);
	}
	
	public static CreativeTabs tabSC = new CreativeTabs("tabSC") {
        public ItemStack getIconItemStack() {
                return new ItemStack(ModItems.SciPad, 1, 0);
        }
        
        
};

}
