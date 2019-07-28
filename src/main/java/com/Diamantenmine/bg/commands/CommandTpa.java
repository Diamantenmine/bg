package com.Diamantenmine.bg.commands;

import java.util.ArrayList;
import java.util.List;

import com.Diamantenmine.bg.capabilities.PlayerDataTpProvider;
import com.Diamantenmine.bg.util.Utils;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class CommandTpa implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		return "tpa";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Send a request to teleport to an other player.";
	}

	@Override
	public List<String> getAliases() {
		List<String> res = new ArrayList<String>();
		res.add("darfIchZuDirKommen");
		return res;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			
			if(args.length != 1) {
				player.sendMessage(new TextComponentString("Only one argument is allowed. /tpa <PlayerName>"));
				return;
			}
			
			if(player != null) {
				final EntityPlayer target = Utils.getPlayer(args[0]);
				if(target == null) {
					player.sendMessage(new TextComponentString("Player was not found."));
					return;
				}
				
				target.sendMessage(new TextComponentString("Please use \"\\tpaaccept\" to accept the teleportation request or \"\\tpareject\" to reject the teleportation request."));
				target.getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null).addPlayerTpa(args[0]);
			}
		}
	}

	@Override	
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {		
		if (args.length == 1)
		{
			List<EntityPlayerMP> playerList = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers();
			List<String> namesList = new ArrayList<String>();
			
			for(EntityPlayerMP p : playerList) {
				namesList.add(p.getName());
			}
			
			return namesList;
		}
		
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return index == 1;
	}

}
