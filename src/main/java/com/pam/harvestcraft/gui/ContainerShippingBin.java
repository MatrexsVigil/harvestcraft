package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.tileentities.ShippingBinData;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import com.pam.harvestcraft.tileentities.TileEntityShippingBin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerShippingBin extends Container {
	private final TileEntityShippingBin bin;

	public ContainerShippingBin(IInventory par1IInventory, TileEntityShippingBin tileEntity) {
		bin = tileEntity;

		addSlotToContainer(new SlotItemHandler(new ItemStackHandler(), 0, 113, 38));

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(par1IInventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 95));
			}
		}

		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(par1IInventory, i, i * 18 + 8, 153));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return bin.canInteractWithMe(player);
	}

	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		if (!playerIn.world.isRemote) {
			ItemStack stack = getSlot(0).getStack();

			if (!playerIn.isEntityAlive() || playerIn instanceof EntityPlayerMP && ((EntityPlayerMP)playerIn).hasDisconnected()) {
				playerIn.dropItem(stack.copy(), false);
			}
			else {
				playerIn.inventory.placeItemBackInInventory(playerIn.world, stack.copy());
			}

			stack.setCount(0);
		}
		super.onContainerClosed(playerIn);
	}

	public TileEntityShippingBin getBin() {
		return bin;
	}

	public ItemStack buy(int item) {
		if (item > -1 && item < ShippingBinItems.getSize()) {
			ShippingBinData marketData = ShippingBinItems.getData(item);
			ItemStack emeralds = getSlot(0).getStack();
			if (marketData.getCurrency().isItemEqual(emeralds) && marketData.getPrice() <= emeralds.getCount()) {
				emeralds.shrink(marketData.getPrice());
				return marketData.getItem().copy();
			}
		}
		return ItemStack.EMPTY;

	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
		ItemStack itemStack = ItemStack.EMPTY;
		final Slot slot = inventorySlots.get(slotIndex);
		if(slot != null && slot.getStack() != ItemStack.EMPTY) {
			ItemStack slotStack = slot.getStack();
			itemStack = slotStack.copy();

			if(slotIndex >= 1) {
				if(slotStack.getItem() == CropRegistry.getFoods().values()) {
					if(!mergeItemStack(slotStack, 0, 1, false)) {
						return ItemStack.EMPTY;
					}
				}
				else if((slotIndex >= 1) && (slotIndex < 28)) {
					if(!mergeItemStack(slotStack, 28, 37, false)) {
						return ItemStack.EMPTY;
					}
				}
				else if((slotIndex >= 1) && (slotIndex < 37) && (!mergeItemStack(slotStack, 1, 28, false))) {
					return ItemStack.EMPTY;
				}
			}
			else if(!mergeItemStack(slotStack, 1, 37, false)) {
				return ItemStack.EMPTY;
			}

			if(slotStack.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
				slot.onSlotChanged();
			}

			if(slotStack.getCount() == itemStack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(entityPlayer, slotStack);
		}

		return itemStack;
	}
}
