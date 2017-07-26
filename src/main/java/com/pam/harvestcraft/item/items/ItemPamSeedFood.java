package com.pam.harvestcraft.item.items;

import java.util.List;

import com.pam.harvestcraft.Reference;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;

public class ItemPamSeedFood extends ItemSeedFood {

    public final float saturation;

    public ItemPamSeedFood(int healAmount, float saturation, Block crops) {
        super(healAmount, saturation, crops, Blocks.FARMLAND);

        this.saturation = saturation;
    }

}
