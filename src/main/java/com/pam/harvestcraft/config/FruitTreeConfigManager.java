package com.pam.harvestcraft.config;

import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FruitTreeConfigManager {
    private final String WHITELIST = "whitelist";
    private static final String CATEGORY_FRUIT_TREES_COMMON = "_common_fruit_trees";

    private static String[] defaultWarm = new String[]{
            "minecraft:savanna",
            "minecraft:jungle",
            "minecraft:jungle_hills",
            "minecraft:jungle_edge",
            "minecraft:mutated_jungle",
            "minecraft:mutated_jungle_edge",
            "biomesoplenty:chaparral",
            "biomesoplenty:sacred_springs",
            "biomesoplenty:bamboo_forest",
            "biomesoplenty:eucalyptus_forest",
            "biomesoplenty:prairie",
            "biomesoplenty:rainforest",
            "biomesoplenty:tropical_rainforest",
            "biomesoplenty:oasis",
            "biomesoplenty:tropical_island",
    };

    private static String[] defaultTemperate = new String[]{
            // TEMPERATURE CATEGORY MEDIUM: 0.6 ... 0.85
            "minecraft:forest",
            "minecraft:river",
            "minecraft:forest_hills",
            "minecraft:birch_forest",
            "minecraft:birch_forest_hills",
            "minecraft:roofed_forest",
            "minecraft:mutated_forest",
            "minecraft:mutated_birch_forest",
            "minecraft:mutated_birch_forest_hills",
            "minecraft:mutated_roofed_forest",
            "biomesoplenty:boreal_forest",
            "biomesoplenty:brushland",
            "biomesoplenty:grove",
            "biomesoplenty:land_of_lakes",
            "biomesoplenty:lush_swamp",
            "biomesoplenty:mountain",
            "biomesoplenty:orchard",
            "biomesoplenty:overgrown_cliffs",
            "biomesoplenty:seasonal_forest",
            "biomesoplenty:temperate_rainforest",
            "biomesoplenty:wetland",
            "biomesoplenty:woodland",
            "biomesoplenty:mountain_foothills"
    };

    private static String[] defaultCold = new String[]{
            // TEMPERATURE CATEGORY COLD
            "minecraft:taiga_cold",
            "minecraft:taiga_cold_hills",
            "minecraft:mutated_taiga_cold",
            "biomesoplenty:snowy_coniferous_forest",
            "biomesoplenty:snowy_forest",
            "biomesoplenty:alps_foothills",
            // TEMPERATURE CATEGORY MEDIUM: 0.2 ... 0.45
            "minecraft:taiga",
            "minecraft:taiga_hills",
            "biomesoplenty:boreal_forest",
            "biomesoplenty:coniferous_forest",
            "biomesoplenty:maple_woods",
            "biomesoplenty:seasonal_forest",
    };

    public List<Biome> availableBiomes;
    public List<TreeGenerationConfiguration> treeConfigurations = new ArrayList<>();
    public boolean enableFruitTreeGeneration;
    private Configuration config;

    private int fruitGrowthSpeed;

    public int getFruitGrowthSpeed() {
        return fruitGrowthSpeed;
    }

    public FruitTreeConfigManager(Configuration config) {
        this.config = config;
    }

    /**
     * call Configure during init
     * this allows to dynamically detect biomes and use the FruitRegistry
     */
    public void Configure() {
        config.load();

        ConfigureCommon();
        ConfigureFruits();

        if (config.hasChanged()) {
            config.save();
        }
    }

    private void ConfigureCommon() {
        availableBiomes = ForgeRegistries.BIOMES.getValues();
        StringBuilder biomeNames = new StringBuilder();
        biomeNames.append("Available/Detected biomes: ");
        for (Biome x : this.availableBiomes) {
            biomeNames.append("[" + x.getRegistryName().toString() + "], ");
            FMLLog.log.info(
                    x.getRegistryName().toString() + ";" +
                            x.getBiomeName() + ";" +
                            x.getTempCategory() + ";" +
                            x.getTemperature() + ";" +
                            x.isHighHumidity() + ";" +
                            x.isMutation() + ";" +
                            x.isSnowyBiome() + ";" +
                            BiomeDictionary.getTypes(x).toString()
            );

        }

        this.config.setCategoryComment(CATEGORY_FRUIT_TREES_COMMON, biomeNames.toString());

        this.enableFruitTreeGeneration = config.get(CATEGORY_FRUIT_TREES_COMMON, "enableFruitTreeGeneration", true, "Default: true").getBoolean();
        this.fruitGrowthSpeed = config.get(CATEGORY_FRUIT_TREES_COMMON, "fruitGrowthSpeed", 25, "Default: 25, Lower is faster").getInt();
    }

    private void configureForFruit(String fruit, BlockPamSapling.SaplingType saplingType) {
        boolean enable = this.config.getBoolean("enableGeneration", fruit, true, "");
        int rarity = this.config.getInt("rarity", fruit, 20, 0, 100, "rarity range 0 ... 100, where 0 is common and 100 is rare");

        String[] biomesAllowed = new String[]{};
        if (saplingType == BlockPamSapling.SaplingType.TEMPERATE) {
            biomesAllowed = config.getStringList(WHITELIST, fruit, defaultTemperate, "temperate");
        } else if (saplingType == BlockPamSapling.SaplingType.COLD) {
            biomesAllowed = config.getStringList(WHITELIST, fruit, defaultCold, "cold");
        } else if (saplingType == BlockPamSapling.SaplingType.WARM) {
            biomesAllowed = config.getStringList(WHITELIST, fruit, defaultWarm, "warm");
        }

        TreeGenerationConfiguration treeGenerationConfiguration = new TreeGenerationConfiguration(fruit, enable, rarity, availableBiomes, biomesAllowed);
        treeConfigurations.add(treeGenerationConfiguration);
    }

    private void ConfigureFruits() {
        HashMap<String, BlockPamSapling.SaplingType> availableFruits = FruitRegistry.registeringFruits;
        availableFruits.putAll(FruitRegistry.registeringLogFruits);

        availableFruits.forEach(this::configureForFruit);
    }

    public List<TreeGenerationConfiguration> getFruitTreesInBiome(Biome biome) {
        List<TreeGenerationConfiguration> list = new ArrayList<>();
        for (TreeGenerationConfiguration tc : treeConfigurations) {
            if (tc.getEnableGeneration() && tc.getBiomesAllowed().contains(biome)) {
                list.add(tc);
            }
        }
        return list;
    }

    public List<TreeGenerationConfiguration> getFruitTreesInBiomeWithLowerRarity(int rarity, Biome biome) {
        List<TreeGenerationConfiguration> list = new ArrayList<>();
        for (TreeGenerationConfiguration tc : treeConfigurations) {
            if (tc.getEnableGeneration()
                    && tc.getRarity() < rarity
                    && tc.getBiomesAllowed().contains(biome)) {
                list.add(tc);
            }
        }
        return list;
    }
}
