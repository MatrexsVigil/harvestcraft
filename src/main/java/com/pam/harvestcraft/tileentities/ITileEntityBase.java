package com.pam.harvestcraft.tileentities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ITileEntityBase {
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ);

	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player);
	
	public void markForUpdate();
	
	public boolean needsUpdate();
	
	public void clean();
}
