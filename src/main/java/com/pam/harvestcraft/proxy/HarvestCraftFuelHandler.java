package com.pam.harvestcraft.proxy;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class HarvestCraftFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		// TODO Auto-generated method stub
		if (fuel.getItem() == ItemRegistry.beeswaxItem)
		{
			return 800;
		}
		if (fuel.getItem() == Item.getItemFromBlock(BlockRegistry.pressedwax))
		{
			return 8000;
		}
		return 0;
	}

}
