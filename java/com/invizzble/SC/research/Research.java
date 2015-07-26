package com.invizzble.SC.research;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import com.invizzble.SC.handler.ConfigurationHandler;

public class Research {
	
	String name;
	String desciption;
	
	boolean discovered;
	
	//the x- and y-coordinate of the center of the achievement from the center of the page
	int pageX;
	int pageY;
	
	IIcon icon;
	
	Research[] required = {};
	
	PageResearch page;
	
	public Research(String name){
		this.name = name;
		discovered = isDiscoveredFromConfig();
	}

	public Research(String name, boolean defaultDiscovered){
		this.name = name;
		if(defaultDiscovered){
			discovered = true;
		}else{
			discovered = isDiscoveredFromConfig();
		}
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
	
	public boolean isDiscoveredFromConfig(){
		return ConfigurationHandler.getResearchState(name);
	}

	public void discover(){
		onDiscover();
		discovered = true;
		ConfigurationHandler.setResearchState(name, discovered);
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
	
	public void setIcon(Block block){
		setIcon(Item.getItemFromBlock(block));
	}
	
	public void setRequiredResearch(Research... required){
		this.required = required;
	}
	
	public Research[] getRequiredResearch(){
		return required;
	}
	
	public void setResearchPage(PageResearch page){
		page.addResearchToList(this);
		this.page = page;
	}
	
	public PageResearch getResearchPage(){
		return page;
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
