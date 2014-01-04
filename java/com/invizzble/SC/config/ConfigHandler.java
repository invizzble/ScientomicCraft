package com.invizzble.SC.config;

import java.io.File;

import net.minecraftforge.common.Configuration;


public class ConfigHandler {
	
	public static void init(File file){
		Configuration config = new Configuration(file);
	}

}
