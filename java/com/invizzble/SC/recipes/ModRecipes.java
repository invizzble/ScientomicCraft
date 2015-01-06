package com.invizzble.SC.recipes;

public class ModRecipes {
	
	public static GrinderRecipes grinder;

	public static void init(){
		grinder = new GrinderRecipes();
		
		grinder.setRecipes();

	}

}
