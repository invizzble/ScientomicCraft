package com.invizzble.SC.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.lib.ItemInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

	public static Item SciPad;
	
	public static void init() {
		SciPad = new ItemSciPad(ItemInfo.SCI_PAD_ID);
		
		GameRegistry.registerItem(SciPad, ItemInfo.SCI_PAD_NAME);

	}

	public static void addNames() {
		LanguageRegistry.addName(SciPad, ItemInfo.SCI_PAD_NAME);
	}

}
