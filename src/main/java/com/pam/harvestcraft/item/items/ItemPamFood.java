package com.pam.harvestcraft.item.items;

import java.util.List;

import com.pam.harvestcraft.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemPamFood extends ItemFood {

    public final float saturation;

    public ItemPamFood(int healAmount, float saturation) {
        super(healAmount, saturation, false);

        this.saturation = saturation;
    }

}
