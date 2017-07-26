package com.pam.harvestcraft.blocks.blocks;

import com.pam.harvestcraft.HarvestCraft;

import net.minecraft.block.BlockTorch;

public class BlockPamCandle extends BlockTorch {
	public BlockPamCandle() {
		setCreativeTab(HarvestCraft.modTab);
		setLightLevel(7F);
	}
}
