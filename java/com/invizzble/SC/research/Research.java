package com.invizzble.SC.research;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Research {
	
	String name;
	String desciption;
	
	boolean discovered;
	
	//the x- and y-coordinate of the center of the achievement from the center of the page
	int pageX;
	int pageY;
	
	IIcon icon;
	
	Research[] required = {};
	
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
	
	public void setDiscovered(boolean discovered){
		this.discovered = discovered;
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

	public int getPageX() {
		return pageX;
	}

	public void setPageX(int pageX) {
		this.pageX = pageX;
	}

	public int getPageY() {
		return pageY;
	}

	public void setPageY(int pageY) {
		this.pageY = pageY;
	}
	
	public void setCords(int x, int y){
		pageX = x;
		pageY = y;
	}

}
