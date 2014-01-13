package com.invizzble.SC;

import com.invizzble.SC.block.ModBlocks;
import com.invizzble.SC.client.interfaces.GUIHandler;
import com.invizzble.SC.config.ConfigHandler;
import com.invizzble.SC.creativeTabs.ModCreativeTabs;
import com.invizzble.SC.item.ModItems;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.network.PacketHandler;
import com.invizzble.SC.proxies.CommonProxy;
import com.invizzble.SC.recipes.ShapedRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Info.MOD_ID , name=Info.MOD_NAME,version = Info.MOD_VERSION)

@NetworkMod(channels = {Info.MOD_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class SC {
	
	/*
	 * 
	 * IDEAS:
	 * -some kind of research?, no idea how
	 * 
	 * -Power System => check with what kind of block the cable is connected
	 * 			if(isConnectedtoCable){
	 * 				check that cable his connections
	 * 			}else if(isConnectedToConsumer && isConnectedtoProducer){
	 * 				while(!MaxPower of consumer full){
	 * 				bool 
	 * 				subtract power out of producer (method in interface)
	 * 				add power to consumer(method in interface)
	 * 				}
	 * 			}if(
	 * 				
	 * 
	 * -atomizer, electronizer, moleculizer, .. (need also better names)
	 * 
	 * -minecraft period system?
	 * 
	 * TODO:
	 * 
	 * -LEARN FURTHER THE VSWE COURSES
	 * 
	 * -inspect the minecraft code some more
	 * 
	 * -(study meta-data items in, so i finally now how to make them :p )
	 * 
	 */

	@SidedProxy(clientSide = "com.invizzble.SC.proxies.ClientProxy", serverSide = "com.invizzble.SC.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Info.MOD_ID)
	public static SC instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//sets up the config file
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		//adds the Blocks
		ModBlocks.init();
		
		//adds the Items
		ModItems.init();
		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//registers the names of the Items
		ModItems.addNames();
		
		//registers the names of the blocks
		ModBlocks.addNames();
		
		//registers the tile entities
		ModBlocks.registerTileEntities();
		
		//registers the recipes for my mod's Items
		ShapedRecipes.init();
		
		//registers the creativeTab(s) <- at this point there's only one buth there's room for expansion if i implement the different sciences
		ModCreativeTabs.nameCreativeTabs();
		
		//register the gui handler
		new GUIHandler();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
