package com.pam.harvestcraft.blocks.growables;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBlockCropFruit extends ItemBlock {
    public ItemBlockCropFruit(Block block) {
        super(block);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return (I18n.translateToLocal("harvestcraft." + this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}
