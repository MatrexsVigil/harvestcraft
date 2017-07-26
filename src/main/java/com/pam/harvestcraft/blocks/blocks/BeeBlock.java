package com.pam.harvestcraft.blocks.blocks;

import com.pam.harvestcraft.HarvestCraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BeeBlock extends Block {
	public BeeBlock() {
		super(Material.GROUND);
		setSoundType(SoundType.WOOD);
		setCreativeTab(HarvestCraft.modTab);
	}
}