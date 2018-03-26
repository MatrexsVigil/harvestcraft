package com.pam.harvestcraft.config;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TreeGenerationConfiguration {
    private String fruit;
    private boolean enableGeneration = true;
    private int rarity = 20;
    private List<Biome> biomesAllowed = new ArrayList<>();

    public TreeGenerationConfiguration(String fruit, boolean enableGeneration, int rarity, List<Biome> availableBiomes, String[] biomesAllowed) {
        this.fruit = fruit;
        this.enableGeneration = enableGeneration;
        if (!this.enableGeneration) {
            FMLLog.log.trace("generation is disabled for " + fruit);
            return;
        }
        this.rarity = rarity;

        Arrays.stream(biomesAllowed).forEach((item) -> {
            Optional<Biome> found = availableBiomes.stream().filter(b -> b.getRegistryName().toString().equalsIgnoreCase(item)).findFirst();
            if (found != null
                    && found.isPresent()
                    && !this.getBiomesAllowed().contains(found.get())) {
                FMLLog.log.trace("biome added:" + found.get().getRegistryName().toString());
                this.biomesAllowed.add(found.get());
            }
        });
    }

    public boolean getEnableGeneration() {
        return this.enableGeneration;
    }

    public String getFruit() {
        return fruit;
    }

    public int getRarity() {
        return rarity;
    }

    public List<Biome> getBiomesAllowed() {
        return biomesAllowed;
    }
}
