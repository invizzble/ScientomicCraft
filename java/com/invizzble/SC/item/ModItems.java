package com.invizzble.SC.item;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.lib.ItemInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Info.MOD_ID)
public class ModItems {

	public static SCItem SciPad;
	
	public static void init() {
		SciPad = new ItemSciPad();
		
		GameRegistry.registerItem(SciPad, ItemInfo.SCI_PAD_NAME);

	}
}
