package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.tileentities.TileEntityShippingBin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerShippingBin extends Container {
	public ContainerShippingBin(IInventory par1IInventory, TileEntityShippingBin tileEntity) {
		addSlotToContainer(new SlotItemHandler(
				tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 0, 113, 38));

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(par1IInventory, j + i * 9 + 9, j * 18 + 8, i * 18 + 95));
			}
		}

		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(par1IInventory, i, i * 18 + 8, 153));
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return true;
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
