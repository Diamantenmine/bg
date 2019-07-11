package com.Diamantenmine.bg;

import com.Diamantenmine.bg.commands.CommandTpa;
import com.Diamantenmine.bg.proxy.CommonProxy;
import com.Diamantenmine.bg.tileentity.TileEntityCobblestoneGenerator;
import com.Diamantenmine.bg.util.Reference;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		 
	}
	
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTpa());
	}
}