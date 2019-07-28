package com.Diamantenmine.bg.capabilities;

import java.util.ArrayList;

public interface IPlayerDataTp {
	public void addPlayerTpa(String str);
	public String getFirstPlayerTpa();
	public void removePlayerTpaFirst();
	public ArrayList<String> getPlayerTpa();
	public void setPlayerTpa(ArrayList<String> str);
}