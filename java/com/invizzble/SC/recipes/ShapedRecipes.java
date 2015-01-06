package com.invizzble.SC.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ShapedRecipes {
	
	public static void init(){
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.SciPad), "X  ","   ","   ", 'X', Items.stick);
	}

}
