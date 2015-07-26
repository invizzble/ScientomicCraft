package com.invizzble.SC;

import net.minecraftforge.common.config.Configuration;

import com.invizzble.SC.block.ModBlocks;
import com.invizzble.SC.handler.ConfigurationHandler;
import com.invizzble.SC.handler.FuelHandler;
import com.invizzble.SC.handler.GUIHandler;
import com.invizzble.SC.item.ModItems;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.network.PacketHandler;
import com.invizzble.SC.proxies.CommonProxy;
import com.invizzble.SC.recipes.ModRecipes;
import com.invizzble.SC.recipes.ShapedRecipes;
import com.invizzble.SC.research.ModResearch;
import com.invizzble.SC.tileEntities.ModTileEntities;
import com.invizzble.SC.util.LogHelper;
import com.invizzble.SC.world.WorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Info.MOD_ID , name=Info.MOD_NAME,version = Info.MOD_VERSION)


public class SC {
	
	/*
	 * IDEAS:
	 * -some kind of research?, no idea how => Check out how achievements work
	 * 
	 * -atomizer, electronizer, moleculizer, .. (need also better names)
	 * 
	 * -minecraft periodic table?
	 * 
	 * -Device that creates wormholes to teleport you through space and time (time is just changing the minecraft time)
	 * 
	 * TODO: 
	 * -Balance the power system
	 * 
	 * -Draw out the mod structure (what machines first, next tier, ..., tools, blocks, ores, items, recipes, ...)
	 */
	
	@SidedProxy(clientSide = Info.PROXY_CLIENT, serverSide = Info.PROXY_SERVER)
	public static CommonProxy proxy;
	
	@Instance(Info.MOD_ID)
	public static SC instance;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
		//adds the Blocks
		LogHelper.info("Registering Blocks");
		ModBlocks.init();
		
		//adds the Items
		LogHelper.info("Registering Items");
		ModItems.init();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//registers the tile entities
		LogHelper.info("Registering TileEntities");
		ModTileEntities.registerTileEntities();
		
		//registers the recipes for my mod's Items
		ShapedRecipes.init();
		ModRecipes.init();
		
		//Registers the packethandler
		PacketHandler.initPackets();
		
		//register the gui handler
		new GUIHandler();
		
		//register fuelhandler
		GameRegistry.registerFuelHandler(new FuelHandler());
		
		//regiser the oregenerator
		GameRegistry.registerWorldGenerator((new WorldGen()), 1);
		
		//do ProxyStuff
		proxy.registerProxies();
		
		//initialize the research stuff
		ModResearch.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
