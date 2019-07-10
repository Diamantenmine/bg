package com.Diamantenmine.bg.init;

import java.util.ArrayList;
import java.util.List;

import com.Diamantenmine.bg.blocks.CobblestoneGeneratorLvl0Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block COBBLESTONE_GENERATOR_LVL0_BLOCK = new CobblestoneGeneratorLvl0Block("cobblestone_generator_lvl0_block", Material.IRON);
}