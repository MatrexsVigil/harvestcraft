package com.pam.harvestcraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityMarket extends TileEntity {

	public TileEntityMarket() {
		super();
	}

	private int stockNum = 0;
	private ItemStackHandler itemstackhandler = new ItemStackHandler();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemstackhandler);
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString("Market");
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		this.stockNum = tagCompound.getInteger("StockNum");
		itemstackhandler.deserializeNBT((NBTTagCompound) tagCompound.getTag("Items"));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setInteger("StockNum", stockNum);
		tagCompound.setTag("Items", itemstackhandler.serializeNBT());
		return tagCompound;
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

	public boolean canInteractWith(EntityPlayer playerIn) {
		// If we are too far away from this tile entity you cannot use it
		return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}

	public String getGuiID() {
		return "harvestcraft:market";
	}
}