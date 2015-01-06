package com.invizzble.SC.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.invizzble.SC.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class CustomRecipes {
	
	static Map recipes;
	
	public CustomRecipes(){
		recipes =new HashMap();
	}
	
	public ItemStack getProcessResult(ItemStack inStack){
		Iterator iterator = recipes.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.hasRecipe(inStack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
	}
	
	public Integer getPowerResult(ItemStack inStack){
		Iterator iterator = recipes.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.hasRecipe(inStack, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
	}
	
	private boolean hasRecipe(ItemStack inStack, ItemStack stack){
		return inStack.getItem() == stack.getItem() && (stack.getItemDamage() == 32767 || inStack.getItemDamage() == stack.getItemDamage())? true: false;
	}
	
	
	public static void addRecipe(Block block, ItemStack stack){
		addRecipe(Item.getItemFromBlock(block), stack);
	}
	
	public static void addRecipe(Item item, ItemStack stack){
		addRecipe(new ItemStack(item), stack);
	}
	
	public static void addRecipe(ItemStack stack, ItemStack stack2){
		recipes.put(stack, stack2);
	}
	
	public static void addPowerRecipe(Block block, int power){
		addPowerRecipe(Item.getItemFromBlock(block), power);
	}
	
	public static void addPowerRecipe(Item item, int power){
		addPowerRecipe(new ItemStack(item), power);
	}
	
	public static void addPowerRecipe(ItemStack stack, int power){
		recipes.put(stack, power);
	}

}
