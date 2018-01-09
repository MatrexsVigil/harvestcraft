package com.pam.harvestcraft.blocks.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BeehiveBlock extends Block implements IShearable {

	public static String registryName = "beehive";

	public BeehiveBlock() {
		super(Material.WOOD);
		setCreativeTab(HarvestCraft.modTab);
		setSoundType(SoundType.WOOD);
		this.setTickRandomly(true);
		setHardness(1.0f);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemRegistry.queenbeeItem;
	}
	
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!this.canBlockStay(worldIn, pos))
        {
        	this.dropBlock(worldIn, pos, state);
        }
        
    }
	
	private void dropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
   // public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
   // {
   //     super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
   // }

    //@Override
   // public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
   // {
   ///     super.getDrops(drops, world, pos, state, fortune);
   //     
   //         drops.add(new ItemStack(ItemRegistry.queenbeeItem));
   //     
   // }

    //public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    //{
    //    return new ItemStack(ItemRegistry.queenbeeItem);
    //}

    private boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.up()).getMaterial().isSolid();
    }

	@Override public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos){ return true; }

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		// TODO Auto-generated method stub
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
	}
}
