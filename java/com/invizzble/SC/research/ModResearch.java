package com.invizzble.SC.research;

public class ModResearch {
	
	public static PageResearchBasic basic;
	
	public static ResearchStart start;
	
	public static void init(){
		registerPages();
		registerResearches();
	}
	
	public static void registerPages(){
		basic = new PageResearchBasic();

	}
	
	public static void registerResearches(){
		start = new ResearchStart();
	}

}
