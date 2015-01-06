package com.invizzble.SC.tileEntities;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	public static void registerTileEntities(){
		final String PACKAGENAME = "com.invizzble.tileEntities.";
		
		//basic generators
		GameRegistry.registerTileEntity(TileEntityGeneratorMK1.class, PACKAGENAME+"TileEntityGenerator");
		//basic machines
		GameRegistry.registerTileEntity(TileEntityElectricFurnace.class, PACKAGENAME+"TileEntityElectricFurnace");
		GameRegistry.registerTileEntity(TileEntityGrinder.class, PACKAGENAME+"TileEntityGrinder");
		//advanced machines
		GameRegistry.registerTileEntity(TileEntityAtomizer.class, PACKAGENAME+"TileEntityAtomizer");
		//cables
		GameRegistry.registerTileEntity(TileEntityCableCopper.class, PACKAGENAME+"TileEnityCopperCable");
		GameRegistry.registerTileEntity(TileEntityCableSilver.class, PACKAGENAME+"TileEntitySilverCable");
		
	}

}
