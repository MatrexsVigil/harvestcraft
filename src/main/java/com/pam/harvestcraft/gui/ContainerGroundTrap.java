package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.tileentities.TileEntityGroundTrap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;

public class ContainerGroundTrap extends Container {

	private final TileEntityGroundTrap groundtrap;
	private int lastProduceTime = 0;
	private int lastRunTime = 0;
	private int lastBeeRunTime = 0;

	public ContainerGroundTrap(InventoryPlayer inv, TileEntityGroundTrap tileEntityGroundTrap) {
		this.groundtrap = tileEntityGroundTrap;

		for(int x = 0; x < 6; ++x) {
			for(int y = 0; y < 3; ++y) {
				addSlotToContainer(new SlotPamResult(
						tileEntityGroundTrap.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null),
						y + x * 3, 62 + 18 * x, 17 + 18 * y));
			}
		}

		addSlotToContainer(new SlotPamGroundTrap(
				tileEntityGroundTrap.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 18, 26, 35));

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
			if(lastProduceTime != groundtrap.produceTime) {
				listener.sendWindowProperty(this, 1, groundtrap.produceTime);
			}

			if(lastRunTime != groundtrap.runTime) {
				listener.sendWindowProperty(this, 2, groundtrap.runTime);
			}

			if(lastBeeRunTime != groundtrap.currentBeeRunTime) {
				listener.sendWindowProperty(this, 3, groundtrap.currentBeeRunTime);
			}
		}

		lastProduceTime = groundtrap.produceTime;
		lastRunTime = groundtrap.runTime;
		lastBeeRunTime = groundtrap.currentBeeRunTime;
	}

	@Override
	public void updateProgressBar(int id, int data) {
		switch(id) {
			case 1:
				groundtrap.produceTime = data;
			break;
			case 2:
				groundtrap.runTime = data;
			break;
			case 3:
				groundtrap.currentBeeRunTime = data;
			break;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return groundtrap.canInteractWithMe(playerIn);
	}

	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
	/*     */ {
		/* 82 */ ItemStack itemStack = ItemStack.EMPTY;
		/* 83 */ Slot slot = (Slot) this.inventorySlots.get(slotIndex);
		/* 84 */ if((slot != null) && (slot.getHasStack())) {
			/* 85 */ ItemStack slotStack = slot.getStack();
			/* 86 */ itemStack = slotStack.copy();
			/*     */
			/* 88 */ if(slotIndex >= 19) {
				/* 89 */ if((slotStack.getItem() == ItemRegistry.fruitbaitItem)
						|| (slotStack.getItem() == ItemRegistry.grainbaitItem)
						|| (slotStack.getItem() == ItemRegistry.veggiebaitItem)) {
					/* 90 */ if(!mergeItemStack(slotStack, 18, 19, false))
					/*     */ {
						/* 92 */ return ItemStack.EMPTY;
						/*     */ }
					/* 94 */ }
				else if((slotIndex >= 19) && (slotIndex < 46))
				/*     */ {
					/* 96 */ if(!mergeItemStack(slotStack, 46, 55, false)) {
						/* 97 */ return ItemStack.EMPTY;
						/*     */ }
					/* 99 */ }
				else if((slotIndex >= 46) && (slotIndex < 55) && (!mergeItemStack(slotStack, 19, 46, false)))
				/*     */ {
					/* 101 */ return ItemStack.EMPTY;
					/*     */ }
				/* 103 */ }
			else if(!mergeItemStack(slotStack, 19, 55, false))
			/*     */ {
				/* 105 */ return ItemStack.EMPTY;
				/*     */ }
			/*     */
			/* 108 */ if(slotStack.getCount() == 0) {
				/* 109 */ slot.putStack(ItemStack.EMPTY);
				/*     */ }
			else {
				/* 111 */ slot.onSlotChanged();
				/*     */ }
			/*     */
			/* 114 */ if(slotStack.getCount() == itemStack.getCount()) {
				/* 115 */ return ItemStack.EMPTY;
				/*     */ }
			/*     */
			/* 118 */ slot.onTake(entityPlayer, slotStack);
			/*     */ }
		/*     */
		/* 121 */ return itemStack;
		/*     */ }
}
