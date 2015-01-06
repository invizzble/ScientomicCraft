package com.invizzble.SC.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.item.ItemSciPad;
import com.invizzble.SC.item.ModItems;
import com.invizzble.SC.lib.Info;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModCreativeTabs {
	
	public static final CreativeTabs tabSC = new CreativeTabs(Info.MOD_ID.toLowerCase()) {

		@Override
		public Item getTabIconItem() {
			return ModItems.SciPad;
		}
};

}
