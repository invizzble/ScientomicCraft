package com.invizzble.SC.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;


public class SCPacket implements IMessageHandler<SCMessage, IMessage>{

	@Override
	public IMessage onMessage(SCMessage message, MessageContext ctx) {
		if(ctx.side == Side.CLIENT){
			
		}
		
		return message;
	}
	
}
