package com.invizzble.SC.config;

import java.io.File;

import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.lib.ItemInfo;

import net.minecraftforge.common.Configuration;


public class ConfigHandler {
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		
		final String ITEM_CATEGORY="Items";
		final String BLOCK_CATEGORY="Blocks";
		
		config.load();
		
		//blocks
		BlockInfo.ATOMIZER_ID = config.getBlock(BLOCK_CATEGORY, BlockInfo.ATOMIZER_NAME, BlockInfo.ATOMIZER_DEFAULT).getInt();
		
		//items
		ItemInfo.SCI_PAD_ID = config.getItem(ITEM_CATEGORY, ItemInfo.SCI_PAD_NAME, ItemInfo.SCI_PAD_DEFAULT).getInt() - 256;
		
		config.save();
	}

}
