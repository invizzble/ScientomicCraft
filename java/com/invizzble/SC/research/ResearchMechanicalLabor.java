package com.invizzble.SC.research;

public class ResearchMechanicalLabor extends Research {

	public ResearchMechanicalLabor() {
		super("Mechanical labor");
		setResearchPage(ModResearch.industrialization);
		setRequiredResearch(ModResearch.mechanics);
	}

}
