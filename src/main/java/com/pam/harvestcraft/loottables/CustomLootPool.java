package com.pam.harvestcraft.loottables;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;

public class CustomLootPool {

    private final ResourceLocation resourceLocation;
    private final LootEntryItem[] lootEntries;
    private final boolean seperateLootPool;

    public CustomLootPool(ResourceLocation resourceLocation, List<LootEntryItem> lootEntryItems, boolean separateLootPool) {
        this.resourceLocation = resourceLocation;
        this.lootEntries = lootEntryItems.toArray(new LootEntryItem[lootEntryItems.size()]);
        this.seperateLootPool = separateLootPool;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public LootEntryItem[] getLootEntries() {
        return lootEntries;
    }

    public boolean isSeperateLootPool() {
        return seperateLootPool;
    }

    public LootPool createDefaultLootPool() {
        return new LootPool(lootEntries, new LootCondition[] {}, new RandomValueRange(1), new RandomValueRange(0), LootHandler.VANILLA_LOOT_POOL_ID);
    }
}
