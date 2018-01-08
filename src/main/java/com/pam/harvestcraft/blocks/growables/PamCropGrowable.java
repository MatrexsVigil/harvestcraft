package com.pam.harvestcraft.blocks.growables;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public interface PamCropGrowable {
    int getMatureAge();
    boolean isMature(IBlockState state);
    List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune);
    PropertyInteger getAgeProperty();
    
    

}
