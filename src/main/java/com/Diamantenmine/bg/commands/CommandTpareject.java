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

public class CommandTpareject implements ICommand {

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "tpareject";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "Rejects the last tpa request.";
	}

	@Override
	public List<String> getAliases() {
		List<String> res = new ArrayList<String>();
		res.add("tpan");
		return res;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			
			if(player != null) {
				player.getCapability(PlayerDataTpProvider.PLAYER_DATA_TP, null).removePlayerTpaFirst();
				player.sendMessage(new TextComponentString("The request of the first player was denied."));
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
