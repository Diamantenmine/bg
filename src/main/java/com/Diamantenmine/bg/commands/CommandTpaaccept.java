package com.Diamantenmine.bg.commands;

import java.util.ArrayList;
import java.util.List;

import com.Diamantenmine.bg.capabilities.PlayerDataTpProvider;
import com.Diamantenmine.bg.util.Utils;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class CommandTpaaccept implements ICommand {

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

	@Override
	public String getName() {
		return "tpaaccept";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Accepts the first tpa request.";
	}

	@Override
	public List<String> getAliases() {
		List<String> res = new ArrayList<String>();
		res.add("tpay");
		return res;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			
			if(player != null) {
				String name = player.getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null).getFirstPlayerTpa();
				if(name == null) {
					player.sendMessage(new TextComponentString("The are no requests."));
					return;
				}
				EntityPlayer theChosenOne = Utils.getPlayer(name);
				
				if(theChosenOne != null) {
					theChosenOne.setPositionAndUpdate(player.getPosition().getX(), player.getPosition().getY() + 1, player.getPosition().getZ());
					player.getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null).removePlayerTpaFirst();
					player.sendMessage(new TextComponentString("You got teleported."));
				}
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
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
