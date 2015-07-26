package com.invizzble.SC.research;

public class ResearchPhysics extends Research {
	
	public ResearchPhysics(){
		super("Physics");
		setRequiredResearch(ModResearch.basicPhysics);
		setResearchPage(ModResearch.physics);
	}

}
