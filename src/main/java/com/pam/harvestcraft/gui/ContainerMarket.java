package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.tileentities.MarketData;
import com.pam.harvestcraft.tileentities.MarketItems;
import com.pam.harvestcraft.tileentities.TileEntityMarket;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMarket extends Container {
	private final TileEntityMarket market;

	public ContainerMarket(IInventory par1IInventory, TileEntityMarket tileEntity) {
		market = tileEntity;
		// can't implement isItemValid cause there is no way to check...
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

	public boolean canInteractWith(EntityPlayer player) {
		return market.canInteractWithMe(player);
	}

	public ItemStack buy(int item) {
		if (item > -1 && item < MarketItems.getSize()) {
			MarketData marketData = MarketItems.getData(item);
			ItemStack emeralds = getSlot(0).getStack();
			if (marketData.getCurrency().isItemEqual(emeralds) && marketData.getPrice() <= emeralds.getCount()) {
				emeralds.shrink(marketData.getPrice());
				return marketData.getItem().copy();
			}
		}
		return ItemStack.EMPTY;
	}

	public TileEntityMarket getMarket() {
		return market;
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

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
		ItemStack itemStack = ItemStack.EMPTY;
		final Slot slot = inventorySlots.get(slotIndex);
		if(slot != null && slot.getStack() != ItemStack.EMPTY) {
			ItemStack slotStack = slot.getStack();
			itemStack = slotStack.copy();

			if(slotIndex >= 1) {
				if(slotStack.getItem() == Items.EMERALD) {
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
