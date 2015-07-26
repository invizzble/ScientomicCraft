package com.invizzble.SC.research;

import com.invizzble.SC.item.ModItems;

public class ResearchStart extends Research{
	
	public ResearchStart(){
		super("start", true);
		setDesciption("test");
		setResearchPage(ModResearch.basic);
		setIcon(ModItems.SciPad);
		setCords(0, 0);
	}

}
