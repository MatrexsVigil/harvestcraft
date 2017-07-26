package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamWaterTrap extends SlotItemHandler {

	public SlotPamWaterTrap(IItemHandler iItemHandler, int index, int xPos, int yPos) {
		super(iItemHandler, index, xPos, yPos);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() == ItemRegistry.fishtrapbaitItem;
	}
}
