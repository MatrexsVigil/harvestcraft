package com.pam.harvestcraft.gui;

import javax.annotation.Nullable;

import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.tileentities.TileEntityApiary;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;

public class ContainerApiary extends Container {

	private final TileEntityApiary apiary;
	private int lastProduceTime = 0;
	private int lastRunTime = 0;
	private int lastBeeRunTime = 0;

	public ContainerApiary(InventoryPlayer inv, TileEntityApiary tileEntityApiary) {
		this.apiary = tileEntityApiary;

		for(int x = 0; x < 6; ++x) {
			for(int y = 0; y < 3; ++y) {
				addSlotToContainer(new SlotPamResult(
						tileEntityApiary.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), y + x * 3,
						62 + 18 * x, 17 + 18 * y));
			}
		}

		addSlotToContainer(new SlotPamApiary(
				tileEntityApiary.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 18, 26, 35));

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(inv, i, 8 + i * 18, 142));
		}
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for(IContainerListener listener : listeners) {
			if(lastProduceTime != apiary.produceTime) {
				listener.sendWindowProperty(this, 1, apiary.produceTime);
			}

			if(lastRunTime != apiary.runTime) {
				listener.sendWindowProperty(this, 2, apiary.runTime);
			}

			if(lastBeeRunTime != apiary.currentBeeRunTime) {
				listener.sendWindowProperty(this, 3, apiary.currentBeeRunTime);
			}
		}

		lastProduceTime = apiary.produceTime;
		lastRunTime = apiary.runTime;
		lastBeeRunTime = apiary.currentBeeRunTime;
	}

	@Override
	public void updateProgressBar(int id, int data) {
		switch(id) {
			case 1:
				apiary.produceTime = data;
			break;
			case 2:
				apiary.runTime = data;
			break;
			case 3:
				apiary.currentBeeRunTime = data;
			break;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return apiary.canInteractWithMe(playerIn);
	}

	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		final Slot slot = inventorySlots.get(index);

		if(slot != null && slot.getStack() != ItemStack.EMPTY) {
			final ItemStack slotStack = slot.getStack();
			itemStack = slotStack.copy();

			if(index >= 19
					? (slotStack.getItem() == ItemRegistry.queenbeeItem ? !mergeItemStack(slotStack, 18, 19, false)
							: (index >= 19 && index < 46 ? !mergeItemStack(slotStack, 46, 55, false)
									: index >= 46 && index < 55 && !mergeItemStack(slotStack, 19, 46, false)))
					: !mergeItemStack(slotStack, 19, 55, false)) {
				return ItemStack.EMPTY;
			}

			if(slotStack.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
				return ItemStack.EMPTY;
			}
			else {
				slot.onSlotChanged();
			}

			if(slotStack.getCount() == itemStack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, slotStack);
		}

		return itemStack;
	}
}
