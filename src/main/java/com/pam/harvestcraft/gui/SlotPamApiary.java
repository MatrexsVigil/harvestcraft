package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamApiary extends SlotItemHandler {

	public SlotPamApiary(IItemHandler handler, int index, int xPos, int yPos) {
		super(handler, index, xPos, yPos);
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() == ItemRegistry.queenbeeItem;
	}
}
