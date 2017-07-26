package com.pam.harvestcraft.worldgen;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class LogFruitTreeGen extends WorldGenAbstractTree {
    private final int minTreeHeight;
    private final IBlockState metaWood;
    private final IBlockState metaLeaves;
    private final IBlockState fruitType;

    public LogFruitTreeGen(int minTreeHeight, IBlockState metaWood, IBlockState metaLeaves, IBlockState fruitType) {
        super(true);
        this.minTreeHeight = minTreeHeight;
        this.metaWood = metaWood;
        this.metaLeaves = metaLeaves;
        this.fruitType = fruitType;
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean generate(World worldIn, Random rand, BlockPos blockPos) {
        int treeHeight = rand.nextInt(3) + this.minTreeHeight;
        int treeTopPos = blockPos.getY() + treeHeight;

        boolean canGenerate = true;

        final BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        if (blockPos.getY() >= 1 && treeTopPos <= 255) {
            for (int iPosY = blockPos.getY(); iPosY <= treeTopPos + 1; ++iPosY) {
                int k = 1;

                if (iPosY == blockPos.getY()) {
                    k = 0;
                }

                if (iPosY >= treeTopPos - 1) {
                    k = 2;
                }

                for (int xStart = blockPos.getX() - k, xEnd = blockPos.getX() + k; xStart <= xEnd && canGenerate; ++xStart) {
                    for (int zStart = blockPos.getZ() - k, zEnd = blockPos.getZ() + k; zStart <= zEnd && canGenerate; ++zStart) {
                        if (iPosY >= 0 && iPosY < 256) {
                            if (!this.isReplaceable(worldIn, mutableBlockPos.setPos(xStart, iPosY, zStart))) {
                                canGenerate = false;
                            }
                        } else {
                            canGenerate = false;
                        }
                    }
                }
            }

            if (!canGenerate) {
                return false;
            } else {
                BlockPos blockPosDown = blockPos.down();
                IBlockState blockStateDown = worldIn.getBlockState(blockPosDown);
                Block blockDown = blockStateDown.getBlock();
                boolean isSoil = blockDown.canSustainPlant(blockStateDown, worldIn, blockPosDown, EnumFacing.UP, (BlockSapling) Blocks.SAPLING);

                if (isSoil && treeTopPos < 255) {
                    blockDown.onPlantGrow(blockStateDown, worldIn, blockPosDown, blockPos);

                    for (int iPosY = blockPos.getY() - 3 + treeHeight; iPosY <= treeTopPos; ++iPosY) {
                        int distanceToTop = iPosY - treeTopPos;
                        int margin = 1 - distanceToTop / 2;

                        for (int xStart = blockPos.getX() - margin, xEnd = blockPos.getX() + margin; xStart <= xEnd; ++xStart) {
                            int currentMarginX = Math.abs(xStart - blockPos.getX());

                            for (int zStart = blockPos.getZ() - margin, zEnd = blockPos.getZ() + margin; zStart <= zEnd; ++zStart) {
                                int currentMarginZ = Math.abs(zStart - blockPos.getZ());

                                if (currentMarginX != margin || currentMarginZ != margin || rand.nextInt(2) != 0 && distanceToTop != 0) {
                                    BlockPos blockpos = new BlockPos(xStart, iPosY, zStart);

                                    IBlockState leavesBlockState = worldIn.getBlockState(blockpos);
                                    Block leavesBlock = leavesBlockState.getBlock();

                                    if (leavesBlock.isAir(leavesBlockState, worldIn, blockpos) || leavesBlock.isLeaves(leavesBlockState, worldIn, blockpos)
                                            || leavesBlock.getMaterial(leavesBlockState) == Material.VINE) {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.metaLeaves);

                                    }
                                }
                            }
                        }
                    }

                    for (int i = 0; i < treeHeight; ++i) {
                        BlockPos upN = blockPos.up(i);
                        IBlockState blockStateUp = worldIn.getBlockState(upN);
                        Block blockUp = blockStateUp.getBlock();

                        if (blockUp.isAir(blockStateUp, worldIn, upN)) {
                            this.setBlockAndNotifyAdequately(worldIn, blockPos.up(i), this.fruitType);
                        }
                        if (blockUp.isLeaves(blockStateUp, worldIn, upN)) {
                            this.setBlockAndNotifyAdequately(worldIn, blockPos.up(i), this.metaWood);
                        }

                    }


                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }


}

