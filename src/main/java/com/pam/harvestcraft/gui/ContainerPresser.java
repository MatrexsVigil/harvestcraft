package com.pam.harvestcraft.gui;

import com.pam.harvestcraft.item.PresserRecipes;
import com.pam.harvestcraft.tileentities.TileEntityPresser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;


public class ContainerPresser extends Container {

    private final TileEntityPresser entityPresser;
    private int lastCookTime = 0;

    public ContainerPresser(InventoryPlayer inventory, TileEntityPresser entityPresser) {
        this.entityPresser = entityPresser;
        
        addSlotToContainer(new SlotPamPresser(entityPresser.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 0, 80, 23));
        addSlotToContainer(new SlotPamResult(entityPresser.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 1, 62, 54));
        addSlotToContainer(new SlotPamResult(entityPresser.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null), 2, 98, 54));

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            addSlotToContainer(new Slot(inventory, i, i * 18 + 8, 142));
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener crafting : listeners) {
            if (lastCookTime == entityPresser.cookTime) continue;
            crafting.sendWindowProperty(this, 0, entityPresser.cookTime);
        }
        lastCookTime = entityPresser.cookTime;
    }

    @Override
    public void updateProgressBar(int id, int data) {
        if (id == 0) {
            entityPresser.cookTime = (short) data;
        }
    }


    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        final Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getStack() != ItemStack.EMPTY) {
            final ItemStack slotStack = slot.getStack();
            itemStack = slotStack.copy();

            if (index == 1 || index == 2) {
                if (!this.mergeItemStack(slotStack, 3, 39, true)) return ItemStack.EMPTY;

                slot.onSlotChange(slotStack, itemStack);
            } else if (index >= 3) {
                if (PresserRecipes.getPressingResult(slotStack) != null) {
                    if (!mergeItemStack(slotStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 3 && index < 30) {
                    if (!mergeItemStack(slotStack, 30, 39, false)) return ItemStack.EMPTY;
                } else if (index >= 30 && index < 39){
                    if (!mergeItemStack(slotStack, 3, 30, false)) return ItemStack.EMPTY;
                }
            } else if (!mergeItemStack(slotStack, 3, 39, false)) return ItemStack.EMPTY;

            if (slotStack.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemStack.getCount() == slotStack.getCount()) return ItemStack.EMPTY;

            slot.onTake(playerIn, slotStack);
        }

        return itemStack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
        return entityPresser.canInteractWithMe(playerIn);
	}
}