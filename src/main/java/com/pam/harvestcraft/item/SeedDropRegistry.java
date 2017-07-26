package com.pam.harvestcraft.item;

import java.util.Map;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedDropRegistry {

    public static void getSeedDrops() {
        for (Map.Entry<String, Boolean> entry : HarvestCraft.config.seedDropFromGrass.entrySet()) {
            if (entry.getValue()) {
                final Item item = CropRegistry.getSeed(entry.getKey());

                if (item == null) continue;

                MinecraftForge.addGrassSeed(new ItemStack(item, 1, 0), HarvestCraft.config.seedrarity);
            }
        }
    }
}


