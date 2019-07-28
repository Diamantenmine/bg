package com.Diamantenmine.bg.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Utils {
	public static EntityPlayer getPlayer(String str) {
		return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(str);
	}
}