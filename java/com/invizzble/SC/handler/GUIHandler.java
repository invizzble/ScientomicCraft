package com.invizzble.SC.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.invizzble.SC.SC;
import com.invizzble.SC.client.interfaces.ContainerAtomizer;
import com.invizzble.SC.client.interfaces.ContainerGeneratorMK1;
import com.invizzble.SC.client.interfaces.GuiAtomizer;
import com.invizzble.SC.client.interfaces.GuiGeneratorMK1;
import com.invizzble.SC.client.interfaces.GuiSciPad;
import com.invizzble.SC.lib.GuiInfo;
import com.invizzble.SC.tileEntities.TileEntityAtomizer;
import com.invizzble.SC.tileEntities.TileEntityGeneratorMK1;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler{

	public GUIHandler(){
		NetworkRegistry.INSTANCE.registerGuiHandler(SC.instance, this);
	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		switch(ID){
			case GuiInfo.GENERATOR_MK1_ID:
				te = world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityGeneratorMK1){
					return new ContainerGeneratorMK1((TileEntityGeneratorMK1)te, player.inventory);
				}
				break;
			case GuiInfo.ATOMIZER_ID:
				te = world.getTileEntity(x, y, z);
				if(te != null && te instanceof TileEntityAtomizer){
					return new ContainerAtomizer((TileEntityAtomizer) te, player.inventory);
				}
				break;
			}
			return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		switch(ID){
		case  GuiInfo.GENERATOR_MK1_ID:
			te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityGeneratorMK1){
				return new GuiGeneratorMK1((TileEntityGeneratorMK1)te, player.inventory);
			}
			break;
		case GuiInfo.ATOMIZER_ID:
			te = world.getTileEntity(x, y, z);
			if(te != null && te instanceof TileEntityAtomizer){
				return new GuiAtomizer((TileEntityAtomizer) te, player.inventory);
			}
			break;
			
		case GuiInfo.SCIPAD_ID:
			return new GuiSciPad();
		}
		return null;
	}

}
