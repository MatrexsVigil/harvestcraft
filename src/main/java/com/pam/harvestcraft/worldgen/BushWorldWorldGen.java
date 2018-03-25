package com.pam.harvestcraft.worldgen;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static com.pam.harvestcraft.HarvestCraft.config;

public class BushWorldWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        final int xChunk = chunkX * 16 + 8, zChunk = chunkZ * 16 + 8;
        int xCh = chunkX * 16 + random.nextInt(16);
        int yCh = random.nextInt(128);
        int zCh = chunkZ * 16 + random.nextInt(16);

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(xChunk + 16, 0, zChunk + 16));
        final BlockPos blockPos = new BlockPos(xCh, yCh + 64, zCh);
        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DEAD)) {
            return;
        }


        if (config.enablearidgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.MESA))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.aridGarden), world, blockPos);
        }

        if (config.enablefrostgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SNOWY) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.frostGarden), world, blockPos);
        }

        if (config.enableshadedgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SPOOKY))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.shadedGarden), world, blockPos);
        }

        if (config.enablesoggygardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.RIVER))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.soggyGarden), world, blockPos);
        }

        if (config.enabletropicalgardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.tropicalGarden), world, blockPos);
        }

        if (config.enablewindygardenGeneration && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) || (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
            generateGarden(BlockRegistry.getGarden(BlockRegistry.windyGarden), world, blockPos);
        }
    }

    private void generateGarden(BlockBaseGarden gardenBlock, World world, BlockPos pos) {

        final int tries = 32 * HarvestCraft.config.gardenRarity;

        for (int tryNum = 0; tryNum < tries; tryNum++) {
            int posX = (pos.getX() + world.rand.nextInt(8)) - world.rand.nextInt(8);
            int posY = (pos.getY() + world.rand.nextInt(4)) - world.rand.nextInt(4);
            int posZ = (pos.getZ() + world.rand.nextInt(8)) - world.rand.nextInt(8);

            final BlockPos newPos = new BlockPos(posX, posY, posZ);

            if (gardenBlock.canPlaceBlockAt(world, newPos)) {
                world.setBlockState(newPos, gardenBlock.getDefaultState(), 2);
            }
        }
    }

}
