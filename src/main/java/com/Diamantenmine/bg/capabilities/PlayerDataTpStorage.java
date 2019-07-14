package com.Diamantenmine.bg.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerDataTpStorage implements IStorage<IPlayerDataTp>{

	@Override
	public NBTBase writeNBT(Capability<IPlayerDataTp> capability, IPlayerDataTp instance, EnumFacing side) {
		return new NBTTagFloat(0.1F);
	}

	@Override
	public void readNBT(Capability<IPlayerDataTp> capability, IPlayerDataTp instance, EnumFacing side, NBTBase nbt) {
		
	}

}
