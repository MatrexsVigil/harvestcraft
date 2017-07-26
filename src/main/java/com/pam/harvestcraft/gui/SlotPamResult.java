package com.pam.harvestcraft.gui;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamResult extends SlotItemHandler {

	public SlotPamResult(IItemHandler tileEntityApiary, int index, int x, int y) {
		super(tileEntityApiary, index, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
