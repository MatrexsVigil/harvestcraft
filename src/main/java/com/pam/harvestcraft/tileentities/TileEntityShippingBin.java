package com.pam.harvestcraft.tileentities;

import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TileEntityShippingBin extends TileEntity implements ITileCheckInteract {

	public TileEntityShippingBin() {
		super();
	}

	private int stockNum = 0;

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("Shipping Bin");
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.stockNum = par1NBTTagCompound.getInteger("StockNum");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("StockNum", stockNum);

		return tagCompound;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	public int getBrowsingInfo() {
		return stockNum;
	}

	public void setBrowsingInfo(int stockNum) {
		this.stockNum = stockNum;
	}

	@Override
	public void invalidate() {
		updateContainingBlockInfo();
		super.invalidate();
	}

	@Override
	  public boolean shouldRefresh(World world, BlockPos pos,@Nonnull IBlockState oldState,@Nonnull IBlockState newState) {
	    return oldState.getBlock() != newState.getBlock();
	  }
	

	public String getGuiID() {
		return "harvestcraft:shippingbin";
	}
}
