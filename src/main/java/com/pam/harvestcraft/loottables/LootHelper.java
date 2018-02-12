package com.pam.harvestcraft.loottables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;

public class LootHelper {
    public static final Set<CustomLootPool> additionalLootPools = new HashSet<CustomLootPool>();

    static {
        // LootTable for GAMEPLAY_FISHING_JUNK
        final ArrayList<LootEntryItem> gameplayFishingJunkEntries = new ArrayList<LootEntryItem>();
        gameplayFishingJunkEntries.add(createLootEntryItem(CropRegistry.getFood(CropRegistry.SEAWEED), 10, 0));

        additionalLootPools.add(new CustomLootPool(
                LootTableList.GAMEPLAY_FISHING_JUNK,
                gameplayFishingJunkEntries, false));

        // LootTable for GAMEPLAY_FISHING_FISH
        final ArrayList<LootEntryItem> gameplayFishingFishEntries = new ArrayList<LootEntryItem>();
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.anchovyrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.bassrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.carprawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.catfishrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.charrrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.eelrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.greenheartfishItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.grouperrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.herringrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.jellyfishrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.mudfishrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.octopusrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.perchrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.snapperrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.tilapiarawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.troutrawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.tunarawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.walleyerawItem, 25, 0));
        gameplayFishingFishEntries.add(createLootEntryItem(ItemRegistry.sardinerawItem, 25, 0));

        additionalLootPools.add(new CustomLootPool(
                LootTableList.GAMEPLAY_FISHING_FISH,
                gameplayFishingFishEntries, false));

        // LootTable for SQUIDS
        if (HarvestCraft.config.squiddropCalamari) {
            final ArrayList<LootEntryItem> squidEntries = new ArrayList<LootEntryItem>();
            squidEntries.add(createLootEntryItem(ItemRegistry.calamarirawItem, 50, 0,
                    new LootFunction[]{new SetCount(new LootCondition[]{}, new RandomValueRange(1, 2))},
                    new KilledByPlayer(false)));

            additionalLootPools.add(new CustomLootPool(
                    LootTableList.ENTITIES_SQUID,
                    squidEntries, true));
        }
        
        if (HarvestCraft.config.enablegigapickleCrop)
        {
        	final ArrayList<LootEntryItem> dungeonchestEntries = new ArrayList<LootEntryItem>();
        	dungeonchestEntries.add(createLootEntryItem(CropRegistry.getSeed(CropRegistry.GIGAPICKLE), 10, 0));
        	additionalLootPools.add(new CustomLootPool(
        			LootTableList.CHESTS_SIMPLE_DUNGEON,
        			dungeonchestEntries, false));
        			
        }

    }


    private static LootEntryItem createLootEntryItem(Item item, int weight, int quality) {
        return createLootEntryItem(item, weight, quality, new LootFunction[]{});
    }

    private static LootEntryItem createLootEntryItem(Item item, int weight, int quality, LootFunction[] lootFunctions, LootCondition... lootConditions) {
        return new LootEntryItem(item, weight, quality, lootFunctions, lootConditions, "harvestcraft." + item.getUnlocalizedName());
    }
}
