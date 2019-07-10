package com.Diamantenmine.bg.blocks;

import com.Diamantenmine.bg.tileentity.TileEntityCobblestoneGenerator;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CobblestoneGeneratorLvl0Block extends BlockBase implements ITileEntityProvider {
	public CobblestoneGeneratorLvl0Block(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(3.0F);
		setResistance(12.0F);
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCobblestoneGenerator();
	}
}