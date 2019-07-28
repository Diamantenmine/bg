package com.Diamantenmine.bg.capabilities;

import java.util.ArrayList;

public class PlayerDataTp implements IPlayerDataTp{
	ArrayList<String> tpaRequests = new ArrayList<String>();
	
	@Override
	public void addPlayerTpa(String str) {
		tpaRequests.add(str);
	}

	@Override
	public String getFirstPlayerTpa() {
		if(tpaRequests.size() == 0) return null;
		return tpaRequests.get(0);
	}

	@Override
	public void removePlayerTpaFirst() {
		if(tpaRequests.size() == 0) return;
		tpaRequests.remove(0);
	}

	@Override
	public ArrayList<String> getPlayerTpa() {
		return tpaRequests;
	}

	@Override
	public void setPlayerTpa(ArrayList<String> str) {
		tpaRequests = str;
	}
}
