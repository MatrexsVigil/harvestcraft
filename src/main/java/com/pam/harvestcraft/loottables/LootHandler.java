package com.pam.harvestcraft.loottables;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;

public class LootHandler {
    public static final String SEPARATE_LOOT_POOL_ID = "harvestcraft";
    public static final String VANILLA_LOOT_POOL_ID = "main";

    public static void handleLootTableMod(LootTableLoadEvent event) {
        final List<CustomLootPool> customLootPools = getCustomLootPools(event.getName());

        for (CustomLootPool customLootPool : customLootPools) {
            final String lootPoolId = customLootPool.isSeperateLootPool() ? SEPARATE_LOOT_POOL_ID : VANILLA_LOOT_POOL_ID;

            createPoolIfNotExists(event.getTable(), lootPoolId);
            final LootPool lootPool = event.getTable().getPool(lootPoolId);

            for (LootEntry entry : customLootPool.getLootEntries()) {
                lootPool.addEntry(entry);
            }
        }
    }

    private static void createPoolIfNotExists(LootTable lootTable, String poolId) {
        if (poolId.equals(VANILLA_LOOT_POOL_ID) || lootTable.getPool(poolId) != null) return;

        lootTable.addPool(new LootPool(new LootEntry[] {}, new LootCondition[] {}, new RandomValueRange(1), new RandomValueRange(0), poolId));

    }

    private static List<CustomLootPool> getCustomLootPools(ResourceLocation resourceLocation) {
        final List<CustomLootPool> results = new ArrayList<CustomLootPool>();

        if (resourceLocation == null) return results;


        for (CustomLootPool customLootPool : LootHelper.additionalLootPools) {
            if (customLootPool.getResourceLocation().equals(resourceLocation)) {
                results.add(customLootPool);
            }
        }

        return results;
    }

}
