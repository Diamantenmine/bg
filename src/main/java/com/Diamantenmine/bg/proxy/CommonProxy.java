package com.Diamantenmine.bg.proxy;

import com.Diamantenmine.bg.capabilities.CapabilityHandler;
import com.Diamantenmine.bg.capabilities.IPlayerDataTp;
import com.Diamantenmine.bg.capabilities.PlayerDataTp;
import com.Diamantenmine.bg.capabilities.PlayerDataTpStorage;
import com.Diamantenmine.bg.eventHandler.EventHandler;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CommonProxy {
	public void init() {
		//CapabilityManager.INSTANCE.register(IPlayerDataTp.class, new PlayerDataTpStorage(), PlayerDataTp.class);
		CapabilityManager.INSTANCE.register(IPlayerDataTp.class, new PlayerDataTpStorage(), new PlayerDataTp());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public void registerItemRenderer(Item item, int meta, String id){}
	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(TileEntityCobblestoneGenerator.class,  Reference.MOD_ID + ":cobblestone_generator");
	}
	
}