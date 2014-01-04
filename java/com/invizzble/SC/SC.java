package com.invizzble.SC;

import com.invizzble.SC.config.ConfigHandler;
import com.invizzble.SC.lib.Info;
import com.invizzble.SC.network.PacketHandler;
import com.invizzble.SC.proxies.CommonProxy;

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

	@SidedProxy(clientSide = "com.invizzble.SC.proxies.ClientProxy", serverSide = "com.invizzble.SC.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Info.MOD_ID)
	public static SC instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
