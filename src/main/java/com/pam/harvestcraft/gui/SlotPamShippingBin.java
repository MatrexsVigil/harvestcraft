package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.tileentities.ShippingBinItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamShippingBin extends SlotItemHandler {
	
	public SlotPamShippingBin(IItemHandler handler, int index, int xPos, int yPos) {
		super(handler, index, xPos, yPos);
		
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		for(int i = 0; i < ShippingBinItems.getSize(); i++) {
			if(ShippingBinItems.getData(i).getCurrency().isItemEqual(stack)) {
				return true;
			}
		}
		return false;
	}
}
