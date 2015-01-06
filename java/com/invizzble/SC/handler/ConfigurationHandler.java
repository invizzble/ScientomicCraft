package com.invizzble.SC.handler;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	public static Configuration configuration;
	
	public static void init(File file){
		
		if(configuration == null){
			configuration = new Configuration(file);
			loadConfigValues();
		}
		
		//place to load the config values
		
		try{
			
			configuration.load();
			
		}catch(Exception e){
			
		}finally{
			
			if(configuration.hasChanged()){
				configuration.save();
			}
		}
	}
	
	private static void loadConfigValues(){
		
	}

}
