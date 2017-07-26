package com.pam.harvestcraft.item;

import com.pam.harvestcraft.HarvestCraft;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemPamHardenedLeatherArmor extends ItemArmor
{
  public ItemPamHardenedLeatherArmor(EntityEquipmentSlot armorType) {
    super(ItemRegistry.armorHardenedLeather, 0, armorType);
    setCreativeTab(HarvestCraft.modTab);
  }
  
  @Override
  public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
   return stack.getItem() == ItemRegistry.hardenedleatherItem; 
  }
}
