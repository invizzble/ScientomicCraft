package com.invizzble.SC.block;

import net.minecraft.block.Block;

import com.invizzble.SC.lib.BlockInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {
	
	public static Block atomizer;
	
	public static void init(){
		atomizer = new BlockAtomizer(BlockInfo.ATOMIZER_ID);

		GameRegistry.registerBlock(atomizer, BlockInfo.ATOMIZER_UNLOCALIZED);
	}
	
	public static void addNames(){
		
		LanguageRegistry.addName(atomizer, BlockInfo.ATOMIZER_NAME);
	}
	
	public static void registerTileEntities(){
		
	}

}
