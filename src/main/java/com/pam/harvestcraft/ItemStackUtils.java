package com.pam.harvestcraft;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

public class ItemStackUtils {
	public static void dropInventoryItems(World world, BlockPos pos, IItemHandler itemHandler) {
		Random random = new Random();
		for(int i = 0; i < itemHandler.getSlots(); i++) {
			ItemStack itemStack = itemHandler.getStackInSlot(i);
			if(!itemStack.isEmpty()) {
				float offsetX = random.nextFloat() * 0.8f + 0.1f;
				float offsetY = random.nextFloat() * 0.8f + 0.1f;
				float offsetZ = random.nextFloat() * 0.8f + 0.1f;
				EntityItem entityitem = new EntityItem(world, pos.getX() + (double) offsetX,
						pos.getY() + (double) offsetY, pos.getZ() + (double) offsetZ,
						new ItemStack(itemStack.getItem(), itemStack.getCount(), itemStack.getMetadata()));
				if(itemStack.hasTagCompound()) {
					entityitem.getItem().setTagCompound(itemStack.getTagCompound().copy());
				}

				float motionScale = 0.05f;
				entityitem.motionX = random.nextGaussian() * (double) motionScale;
				entityitem.motionY = random.nextGaussian() * (double) motionScale + 0.20000000298023224D;
				entityitem.motionZ = random.nextGaussian() * (double) motionScale;
				world.spawnEntity(entityitem);
			}
		}
	}
}
