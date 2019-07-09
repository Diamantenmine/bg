package com.Diamantenmine.bg.proxy;

import net.minecraft.item.Item;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id){}
	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(TileEntityCobblestoneGenerator.class,  Reference.MOD_ID + ":cobblestone_generator");
	}
	
}
