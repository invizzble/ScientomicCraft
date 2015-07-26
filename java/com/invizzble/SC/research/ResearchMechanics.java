package com.invizzble.SC.research;

public class ResearchMechanics extends Research{
	
	public ResearchMechanics() {
		super("Mechanics");
		setResearchPage(ModResearch.physics);
		setRequiredResearch(ModResearch.basicPhysics);
	}

}
