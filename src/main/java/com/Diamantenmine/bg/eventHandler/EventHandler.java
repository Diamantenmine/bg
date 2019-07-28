package com.Diamantenmine.bg.eventHandler;

import com.Diamantenmine.bg.capabilities.IPlayerDataTp;
import com.Diamantenmine.bg.capabilities.PlayerDataTpProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event){
		EntityPlayer player = event.getEntityPlayer();
        IPlayerDataTp playerDataTp = player.getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null);
        IPlayerDataTp oldPlayerDataTp = event.getOriginal().getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null);

        playerDataTp.setPlayerTpa(oldPlayerDataTp.getPlayerTpa());
	}
}
