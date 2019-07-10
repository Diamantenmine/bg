package com.Diamantenmine.bg.tileentity;

import com.Diamantenmine.bg.init.ModBlocks;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityCobblestoneGenerator extends TileEntity implements ITickable{
	private int tick;

	public TileEntityCobblestoneGenerator() {
		super();
		this.tick = 0;
	}

	@Override
	public void update() {	//System.out.println(this.tick);
		this.tick++;
		if(this.tick >= 50) {
			this.tick = 0;
			if((!world.isRemote)) {
				ItemStack cobble_bg = new ItemStack(Blocks.COBBLESTONE,1);
				if(this.getWorld().getBlockState(pos)==ModBlocks.COBBLESTONE_GENERATOR_LVL0_BLOCK.getDefaultState())
					cobble_bg.setCount(16);

				EntityItem eItem = new EntityItem(this.getWorld(), this.getPos().getX()+0.5F, this.getPos().getY()+1, this.getPos().getZ()+0.5F, cobble_bg);

				eItem.motionX = 0;
				eItem.motionY = 0;
				eItem.motionZ = 0;
				
				world.spawnEntity(eItem);
			}
		}
	}
}
	
