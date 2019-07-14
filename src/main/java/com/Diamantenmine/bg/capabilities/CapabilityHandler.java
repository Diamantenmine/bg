package com.Diamantenmine.bg.capabilities;

import com.Diamantenmine.bg.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	public static final ResourceLocation PLAYER_DATA_TP = new ResourceLocation(Reference.MOD_ID, "playerDataTp");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if((event.getObject() instanceof EntityPlayer)) {
			event.addCapability(PLAYER_DATA_TP, new PlayerDataTpProvider());
		}
	}
}