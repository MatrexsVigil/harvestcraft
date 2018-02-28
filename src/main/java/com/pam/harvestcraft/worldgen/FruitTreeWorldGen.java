package com.pam.harvestcraft.worldgen;

import static com.pam.harvestcraft.HarvestCraft.fruitTreeConfigManager;

import java.util.List;
import java.util.Random;

import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;

import com.pam.harvestcraft.config.TreeGenerationConfiguration;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;

public class FruitTreeWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!fruitTreeConfigManager.enableFruitTreeGeneration) {
            FMLLog.log.debug("disabled fruit tree generation");
            return;
        }

        final int x = chunkX * 16 + 8 + random.nextInt(16);
        final int z = chunkZ * 16 + 8 + random.nextInt(16);

        Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 64, z));

        int rarity = random.nextInt(100);
        List<TreeGenerationConfiguration> fruitTreesRarity = fruitTreeConfigManager.getFruitTreesInBiomeWithLowerRarity(rarity, biome);

        if (fruitTreesRarity.isEmpty()) {
            FMLLog.log.debug("no fruit available for biome: " + biome.getRegistryName().toString() + " with rarity < " + rarity + ".");
            return;
        }
        int index = random.nextInt(fruitTreesRarity.size());
        if (index < 0) {
            FMLLog.log.debug("is < 0");
            return;
        }
        TreeGenerationConfiguration fruitTree = fruitTreesRarity.get(index);

        if (fruitTree == null) {
            FMLLog.log.debug("fruit tree is null");
            return;
        }

//        FMLLog.log.debug("generate tree:" + fruitTree.getFruit());
        generateFruitTree(world, random, fruitTree.getFruit(), x, z);
        return;
    }

    private void generateFruitTree(World world, Random random, String fruitName, int x, int z) {
        final BlockPamSapling sapling = FruitRegistry.getSapling(fruitName);
        if (sapling != null) {
            sapling.worldGenTree(world, random, x, z);
        }
    }
}
