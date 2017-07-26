package com.pam.harvestcraft.worldgen;

import static com.pam.harvestcraft.HarvestCraft.config;

import java.util.Random;

import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class FruitTreeWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (random.nextFloat() > 0.12f) {
            return;
        }

        final int x = chunkX * 16 + 8 + random.nextInt(16);
        final int z = chunkZ * 16 + 8 + random.nextInt(16);

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 64, z));

        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD)) {
            return;
        }

        if ((BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST))
                && (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.COLD))
                && (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.SPOOKY))
                && (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))) {
            {
                switch (random.nextInt(9)) {
                    case 0:
                        if (config.appletreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.APPLE, x, z);
                            return;
                        }
                    case 1:
                        if (config.avocadotreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.AVOCADO, x, z);
                            return;
                        }
                    case 2:
                        if (config.cherrytreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.CHERRY, x, z);
                            return;
                        }
                    case 3:
                        if (config.chestnuttreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.CHESTNUT, x, z);
                            return;
                        }
                    case 4:
                        if (config.nutmegtreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.NUTMEG, x, z);
                            return;
                        }
                    case 5:
                        if (config.peartreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.PEAR, x, z);
                            return;
                        }
                    case 6:
                        if (config.plumtreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.PLUM, x, z);
                            return;
                        }
                    case 7:
                        if (config.walnuttreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.WALNUT, x, z);
                            return;
                        }
                    case 8:
                        if (config.gooseberrytreeGeneration) {
                            generateFruitTree(world, random, FruitRegistry.GOOSEBERRY, x, z);
                            return;
                        }
                }
            }
        }

        if ( (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) && (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.DRY))
        && ( BiomeDictionary.hasType(biome, BiomeDictionary.Type.HOT) || (BiomeDictionary.hasType(biome, BiomeDictionary.Type.WET)) ) ) {
            switch (random.nextInt(25)) {
                case 0:
                    if (config.bananatreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.BANANA, x, z);
                        return;
                    }
                case 1:
                    if (config.cinnamontreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.CINNAMON, x, z);
                        return;
                    }
                case 2:
                    if (config.coconuttreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.COCONUT, x, z);
                        return;
                    }
                case 3:
                    if (config.datetreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.DATE, x, z);
                        return;
                    }
                case 4:
                    if (config.dragonfruittreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.DRAGONFRUIT, x, z);
                        return;
                    }
                case 5:
                    if (config.papayatreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PAPAYA, x, z);
                        return;
                    }
                case 6:
                    if (config.almondtreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.ALMOND, x, z);
                        return;
                    }
                case 7:
                    if (config.apricottreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.APRICOT, x, z);
                        return;
                    }
                case 8:
                    if (config.cashewtreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.CASHEW, x, z);
                        return;
                    }
                case 9:
                    if (config.duriantreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.DURIAN, x, z);
                        return;
                    }
                case 10:
                    if (config.figtreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.FIG, x, z);
                        return;
                    }
                case 11:
                    if (config.grapefruittreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.GRAPEFRUIT, x, z);
                        return;
                    }
                case 12:
                    if (config.lemontreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.LEMON, x, z);
                        return;
                    }
                case 13:
                    if (config.limetreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.LIME, x, z);
                        return;
                    }
                case 14:
                    if (config.mangotreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.MANGO, x, z);
                        return;
                    }
                case 15:
                    if (config.orangetreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.ORANGE, x, z);
                        return;
                    }
                case 16:
                    if (config.paperbarktreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PAPERBARK, x, z);
                        return;
                    }
                case 17:
                    if (config.peachtreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PEACH, x, z);
                        return;
                    }
                case 18:
                    if (config.pecantreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PECAN, x, z);
                        return;
                    }
                case 19:
                    if (config.peppercorntreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PEPPERCORN, x, z);
                        return;
                    }
                case 20:
                    if (config.persimmontreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PERSIMMON, x, z);
                        return;
                    }
                case 21:
                    if (config.pistachiotreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.PISTACHIO, x, z);
                        return;
                    }
                case 22:
                    if (config.pomegranatetreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.POMEGRANATE, x, z);
                        return;
                    }
                case 23:
                    if (config.starfruittreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.STARFRUIT, x, z);
                        return;
                    }
                case 24:
                    if (config.vanillabeantreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.VANILLABEAN, x, z);
                        return;
                    }
                case 25:
                    if (config.olivetreeGeneration) {
                        generateFruitTree(world, random, FruitRegistry.OLIVE, x, z);
                        return;
                    }
            }
        }

        if ((BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY))
                || (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))
                || (BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS))) {
            if (config.mapletreeGeneration) {
                generateFruitTree(world, random, FruitRegistry.MAPLE, x, z);
                return;
            }
        }

    }

    private void generateFruitTree(World world, Random random, String fruitName, int x, int z) {
        final BlockPamSapling sapling = FruitRegistry.getSapling(fruitName);
        if (sapling != null) {
            sapling.worldGenTree(world, random, x, z);
        }
    }
}
