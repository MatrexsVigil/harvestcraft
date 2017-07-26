package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamGroundTrap extends SlotItemHandler {

	public SlotPamGroundTrap(IItemHandler iItemHandler, int index, int xPos, int yPos) {
		super(iItemHandler, index, xPos, yPos);
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		return (par1ItemStack.getItem() == ItemRegistry.grainbaitItem)
				|| (par1ItemStack.getItem() == ItemRegistry.veggiebaitItem)
				|| (par1ItemStack.getItem() == ItemRegistry.fruitbaitItem);
	}
}
