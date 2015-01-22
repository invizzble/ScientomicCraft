package com.invizzble.SC.block;

import net.minecraftforge.oredict.OreDictionary;

import com.invizzble.SC.item.ItemBlockCable;
import com.invizzble.SC.item.ItemBlockMachine;
import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.lib.Info;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Info.MOD_ID)
public class ModBlocks {
	public static SCBlock oreCopper;
	
	public static SCBlock furnace;
	public static SCBlock atomizer;
	public static SCBlock generatorMK1;
	
	public static SCBlockCable copperCable;
	public static SCBlockCable silverCable;
	
	public static void init(){
		oreCopper = new BlockOreCopper();
		
		furnace = new BlockElectricFurnace();
		
		atomizer = new BlockAtomizer();
		
		generatorMK1 = new BlockGeneratorMK1();

		copperCable = new BlockCableCopper();
		silverCable = new BlockCableSilver();
		
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		
		registerMachine(furnace, "electricFurnace");
		
		registerMachine(atomizer,"atomizer");
		registerMachine(generatorMK1, "generatorMK1");
		
		GameRegistry.registerBlock(copperCable, ItemBlockCable.class, "copperCable", (long)BlockInfo.CABLE_COPPER_COLORS[0], (long)BlockInfo.CABLE_COPPER_COLORS[1], (long)BlockInfo.CABLE_COPPER_COLORS[2]);
		GameRegistry.registerBlock(silverCable, ItemBlockCable.class, "silverCable", (long)BlockInfo.CABLE_SILVER_COLORS[0], (long)BlockInfo.CABLE_SILVER_COLORS[1], (long)BlockInfo.CABLE_SILVER_COLORS[2]);
		
		registerOreDictionary();
	}
	
	private static void registerOreDictionary(){
		OreDictionary.registerOre("oreCopper", oreCopper);

	}
	
	private static void registerMachine(SCBlock block, String name){
		GameRegistry.registerBlock(block, ItemBlockMachine.class, name);
	}

}
