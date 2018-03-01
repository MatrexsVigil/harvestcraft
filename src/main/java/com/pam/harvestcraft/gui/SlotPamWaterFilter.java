package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.WaterFilterRecipes;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamWaterFilter extends SlotItemHandler {
	public SlotPamWaterFilter(IItemHandler inventory, int index, int xPos, int yPos) {
		super(inventory, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if(WaterFilterRecipes.getFilterResult(stack) != null)
			return true;
		return false;
	}
}
