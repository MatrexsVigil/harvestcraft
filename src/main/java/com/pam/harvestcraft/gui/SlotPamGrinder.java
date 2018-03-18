package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.GrinderRecipes;
import com.pam.harvestcraft.item.PresserRecipes;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamGrinder  extends SlotItemHandler {
	public SlotPamGrinder(IItemHandler inventory, int index, int xPos, int yPos) {
		super(inventory, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if(GrinderRecipes.getGrindingResult(stack) != null)
			return true;
		return false;
	}
}