package com.Diamantenmine.bg.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerDataTpProvider implements ICapabilitySerializable<NBTBase>{
	@CapabilityInject(IPlayerDataTp.class)
	public static Capability<IPlayerDataTp> PLAYER_DATA_TP = null;
	private IPlayerDataTp instance = PLAYER_DATA_TP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_DATA_TP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_DATA_TP ? PLAYER_DATA_TP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_DATA_TP.getStorage().writeNBT(PLAYER_DATA_TP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_DATA_TP.getStorage().readNBT(PLAYER_DATA_TP, this.instance, null, nbt);
	}

}
