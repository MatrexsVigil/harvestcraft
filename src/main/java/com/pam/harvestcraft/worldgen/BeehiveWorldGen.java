package com.pam.harvestcraft.worldgen;

import java.util.Random;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BeehiveWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!HarvestCraft.config.enableBeehiveGeneration) return;

        final Biome biome = world.getBiomeForCoordsBody(new BlockPos(chunkX, 0, chunkZ));

        if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.END) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.NETHER)) {
            return;
        }

        tryGenerateBeehives(world, random, chunkX * 16 + 8, chunkZ * 16 + 8);
    }

    private static void tryGenerateBeehives(World world, Random random, int chunkX, int chunkZ) {
        final BlockPos.MutableBlockPos variableBlockPos = new BlockPos.MutableBlockPos();

        if (random.nextFloat() < HarvestCraft.config.beehiveRarity / 33.0f) {
            int x = chunkX + random.nextInt(16);
            int z = chunkZ + random.nextInt(16);
            int y = world.getHeight(x, z) - 1; // if there is a tree, world height will be just above the top leaves of the tree.
            variableBlockPos.setPos(x, y, z);

            if (!isBlockLeaves(world, variableBlockPos)) return;

            int newY = getHeightBelowLeaves(world, x, y, z);

            if (newY < 0) return;

            variableBlockPos.setY(newY);
            world.setBlockState(variableBlockPos, BlockRegistry.beehive.getDefaultState());
        }
    }

    private static boolean isBlockLeaves(World world, BlockPos blockPos) {
        IBlockState blockState = world.getBlockState(blockPos);
        final Block block = blockState.getBlock();
        return block.isLeaves(blockState, world, blockPos);
    }

    private static int getHeightBelowLeaves(World world, int posX, int posY, int posZ) {
        final BlockPos.MutableBlockPos variableBlockPos = new BlockPos.MutableBlockPos();
        variableBlockPos.setPos(posX, posY, posZ);

        // Starting from a known leaves block, descend until air block is reached.
        // If another block is reached (non-leaves, non-air), abort and return -1.
        for (int y = posY, sealevel = world.getSeaLevel(); y >= sealevel; --y) {
            variableBlockPos.setY(y);
            final IBlockState blockState = world.getBlockState(variableBlockPos);
            final Block block = blockState.getBlock();

            if (block.isLeaves(blockState, world, variableBlockPos)) continue;

            if (world.isAirBlock(variableBlockPos)) return y;

            return -1;
        }
        return -1;
    }

}