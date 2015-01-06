package com.invizzble.SC.client.interfaces;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.invizzble.SC.lib.Info;
import com.invizzble.SC.tileEntities.BaseTileEntityMachine;
import com.invizzble.SC.tileEntities.TileEntityGeneratorMK1;

public class GuiGeneratorMK1 extends BaseGuiMachine {

	//TileEntityGeneratorMK1 gen;

	public GuiGeneratorMK1(BaseTileEntityMachine te,
			InventoryPlayer player) {
		super(new ContainerGeneratorMK1(te, player), te);

		xSize = 176;
		ySize = 166;
		leftPowerIndicator = 176;
		topPowerIndicator = 0;
		widthPowerIndicator = 21;
		heightPowerIndicator = 60;
		texture = new ResourceLocation(
				Info.MOD_ID, "textures/gui/Generator.png");;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		drawEnergyBox();
	}

}
