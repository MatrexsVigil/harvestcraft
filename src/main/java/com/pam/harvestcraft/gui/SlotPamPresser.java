package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.PresserRecipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPamPresser extends SlotItemHandler {
	public SlotPamPresser(IItemHandler inventory, int index, int xPos, int yPos) {
		super(inventory, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if(PresserRecipes.getPressingResult(stack) != null)
			return true;
		return false;
	}
}
