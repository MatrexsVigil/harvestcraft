package com.pam.harvestcraft.worldgen;

import static com.pam.harvestcraft.HarvestCraft.config;

import java.util.Random;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BushWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        final int x = chunkX * 16 + 8;
        final int z = chunkZ * 16 + 8;

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD)) {
            return;
        }

        if (config.enablearidgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.MESA))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.aridGarden), world, random, x, z);
        }

        if (config.enablefrostgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.frostGarden), world, random, x, z);
        }

        if (config.enableshadedgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SPOOKY))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.shadedGarden), world, random, x, z);
        }

        if (config.enablesoggygardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.soggyGarden), world, random, x, z);
        }

        if (config.enabletropicalgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.tropicalGarden), world, random, x, z);
        }

        if (config.enablewindygardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.windyGarden), world, random, x, z);
        }
    }

    private void generateGarden(BlockBaseGarden gardenBlock, World world, Random random, int x, int z) {
        if (random.nextFloat() < HarvestCraft.config.gardenRarity / 8.0f) {
            final int posX = x + world.rand.nextInt(16);
            final int posZ = z + world.rand.nextInt(16);
            final BlockPos newPos = WorldGenHelper.getGroundPos(world, posX, posZ);

            if (newPos != null && gardenBlock.canPlaceBlockAt(world, newPos)) {
                world.setBlockState(newPos, gardenBlock.getDefaultState(), 2);
            }
        }
    }

}