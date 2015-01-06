package com.invizzble.SC.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.invizzble.SC.item.ItemSciPad;
import com.invizzble.SC.item.ModItems;
import com.invizzble.SC.util.LogHelper;

public class GrinderRecipes extends CustomRecipes{

	public static void setRecipes(){
		addRecipe(ModItems.SciPad, new ItemStack(Items.blaze_powder));
	}

}
