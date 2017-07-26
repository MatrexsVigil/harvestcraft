package com.pam.harvestcraft.loottables;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableLoadEventHandler {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void onLootTableLoad(LootTableLoadEvent event) {
        LootHandler.handleLootTableMod(event);
    }
}
