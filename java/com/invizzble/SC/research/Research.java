package com.invizzble.SC.research;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Research {
	
	String name;
	String desciption;
	
	boolean discovered;
	
	IIcon icon;
	
	Research[] required;
	
	public Research(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public boolean isDiscovered() {
		return discovered;
	}

	public void discover(){
		onDiscover();
		discovered = true;
	}
	
	public boolean canDiscover(){
		for(Research research:required){
			if(!research.isDiscovered()){
				return false;
			}
		}
		return true;
	}
	
	public void onDiscover(){};

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
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
	
	public void setRequiredResearch(Research... required){
		this.required = required;
	}
	
	public Research[] getRequiredResearch(){
		return required;
	}
	
	public void setResearchPage(PageResearch page){
		page.addResearchToList(this);
	}

}
