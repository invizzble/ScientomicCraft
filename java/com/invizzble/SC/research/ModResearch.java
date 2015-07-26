package com.invizzble.SC.research;

public class ModResearch {
	
	public static PageResearch basic;
	
	//The science tabs
	public static PageResearch physics;
	
	//other tabs
	public static PageResearch industrialization;
	
	public static Research start;
	public static Research calculus;
	
	public static Research basicPhysics;
	public static Research mechanics;
	
	public static Research mechanicalLabor;
	
	public static void init(){
		registerPages();
		registerResearches();
	}
	
	public static void registerPages(){
		basic = new PageResearchBasic();
		
		physics = new PageResearchPhyisics();
		
		industrialization = new PageResearchIndustrialization();

	}
	
	public static void registerResearches(){
		start = new ResearchStart();
		calculus = new ResearchCalculus();
		
		basicPhysics = new ResearchPhysics();
		mechanics = new ResearchMechanics();
		
		mechanicalLabor = new ResearchMechanicalLabor();
	}

}
