package com.invizzble.SC.research;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class PageResearch {
	
	String name;
	
	IIcon icon;
	
	ArrayList<Research> researches;
	
	public PageResearch(){
		researches = new ArrayList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IIcon getIcon() {
		return icon;
	}

	public void setIcon(IIcon icon) {
		this.icon = icon;
	}
	
	public void setIcon(Item item){
		setIcon(new ItemStack(item).getIconIndex());
	}

	public void addResearchToList(Research research){
		researches.add(research);
	}
	
	public ArrayList<Research> getResearchesList(){
		return researches;
	}
}
