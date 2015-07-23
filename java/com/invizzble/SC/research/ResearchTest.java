package com.invizzble.SC.research;

import net.minecraft.init.Items;

public class ResearchTest extends Research{
	
	public ResearchTest(){
		setName("test");
		setIcon(Items.apple);
		setCords(60, 20);
		setRequiredResearch(ModResearch.start);
		setResearchPage(ModResearch.basic);
	}

}
