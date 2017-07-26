package com.pam.harvestcraft.item.items;

import com.pam.harvestcraft.HarvestCraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPamCakeFood extends ItemBlock {
	public ItemPamCakeFood(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_, Block cake) {
		super(cake);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public CreativeTabs getCreativeTab() {
		return HarvestCraft.modTab;
	}
}
