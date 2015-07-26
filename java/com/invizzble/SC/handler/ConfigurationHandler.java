package com.invizzble.SC.handler;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
	public static Configuration configuration;
	
	public static final String CATEGORY_RESEARCH = "Research";
	
	public static void init(File file){
		if(configuration == null){
			configuration = new Configuration(file);
		}
		
		//place to load the config values
		
		try{
			
			configuration.load();
			configuration.setCategoryComment(CATEGORY_RESEARCH, "The state for all the researches in the mod. If true -> research = discovered");
		}catch(Exception e){
			
		}finally{
			
			if(configuration.hasChanged()){
				configuration.save();
			}
		}
	}
	
	public static boolean getResearchState(String name){
		configuration.load();
		return configuration.getBoolean("Research."+name, CATEGORY_RESEARCH, false, "If true, then the "+name+" research is already discovered.");
	}
	
	public static boolean getResearchState(String name, boolean defaultValue){
		configuration.load();
		return configuration.getBoolean("Research."+name, CATEGORY_RESEARCH, defaultValue, "If true, then the "+name+" research is already discovered.");
	}
	
	public static void setResearchState(String name, boolean discovered){
		configuration.load();
		configuration.get(CATEGORY_RESEARCH, "Research."+name, false).set(discovered);
		if(configuration.hasChanged()){
			configuration.save();
		}
	}
}
