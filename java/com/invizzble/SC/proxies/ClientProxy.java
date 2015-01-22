package com.invizzble.SC.proxies;

import net.minecraft.block.Block;

import com.invizzble.SC.block.ModBlocks;
import com.invizzble.SC.client.renderer.InventoryMachineRenderer;
import com.invizzble.SC.client.renderer.TileEntityRenderCable;
import com.invizzble.SC.lib.BlockInfo;
import com.invizzble.SC.tileEntities.TileEntityCableCopper;
import com.invizzble.SC.tileEntities.TileEntityCableSilver;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	
	
	@Override
	public void registerProxies() {
		registerSpecialRenders();
	}
	
	private void registerSpecialRenders(){
		registerMachineInventoryRendering(ModBlocks.atomizer);
		registerMachineInventoryRendering(ModBlocks.furnace);
		registerMachineInventoryRendering(ModBlocks.generatorMK1);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCableCopper.class, new TileEntityRenderCable(BlockInfo.CABLE_COPPER_COLORS[0], BlockInfo.CABLE_COPPER_COLORS[1], BlockInfo.CABLE_COPPER_COLORS[2]));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCableSilver.class, new TileEntityRenderCable(BlockInfo.CABLE_SILVER_COLORS[0], BlockInfo.CABLE_SILVER_COLORS[1], BlockInfo.CABLE_SILVER_COLORS[2]));
	}
	
	private void registerMachineInventoryRendering(Block block){
		ISimpleBlockRenderingHandler myISBRH = new InventoryMachineRenderer();
		RenderingRegistry.registerBlockHandler(block.getRenderType(), myISBRH);
		
	}
	
	
	
}
