package com.pam.harvestcraft.blocks.growables;

import java.util.Random;

import javax.annotation.Nonnull;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.worldgen.FruitTreeGen;
import com.pam.harvestcraft.worldgen.LogFruitTreeGen;
import com.pam.harvestcraft.worldgen.WorldGenHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.FMLLog;

public class BlockPamSapling extends BlockBush implements IGrowable {

    public final String name;
    private static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    private Block fruit;
    private Item fruitItem;
    private final SaplingType saplingType;

    // Caching information for sapling.
    private final BlockPlanks.EnumType planks;
    private final IBlockState logState;
    private final IBlockState leavesState;

    public BlockPamSapling(String name, SaplingType saplingType) {
        super();
        this.setSoundType(SoundType.PLANT);
        this.setHardness(0.0F);
        this.setCreativeTab(HarvestCraft.modTab);
        this.saplingType = saplingType;
        this.name = name;

        // Generating information for saplings
        switch (saplingType) {
            case WARM:
                planks = BlockPlanks.EnumType.JUNGLE;
                break;

            case COLD:
                planks = BlockPlanks.EnumType.SPRUCE;
                break;
            case TEMPERATE:
            default:
                planks = BlockPlanks.EnumType.OAK;
        }

        logState = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, planks);
        leavesState = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, planks)
                .withProperty(BlockLeaves.CHECK_DECAY, false);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        Block soilBlock = world.getBlockState(pos.down()).getBlock();

        return this.isSuitableSoilBlock(soilBlock);
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        validatePosition(worldIn, pos, state);
    }

    private void validatePosition(World world, BlockPos pos, IBlockState state) {
        if (!this.canPlaceBlockAt(world, pos)) {
            this.dropBlockAsItem(world, pos, state, 0);

            world.setBlockToAir(pos);
        }
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    private boolean isSuitableSoilBlock(Block soilBlock) {
        return soilBlock == Blocks.GRASS || soilBlock == Blocks.DIRT || soilBlock == Blocks.FARMLAND;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    private void grow(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        generateTree(worldIn, pos, state, rand);
    }

    private void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
            return;
        }
        worldIn.setBlockToAir(pos);

        final IBlockState fruitState = getFruit().getDefaultState();

        if (getFruit() instanceof BlockPamFruit) {
            if (!new FruitTreeGen(5, logState, leavesState, false, fruitState).generate(worldIn, rand, pos)) {
                worldIn.setBlockState(pos, state); //Re-add the sapling if the tree failed to grow
            }
        } else if (getFruit() instanceof BlockPamFruitLog) {
            if (!new LogFruitTreeGen(5, logState, leavesState, fruitState).generate(worldIn, rand, pos)) {
                worldIn.setBlockState(pos, state);
            }
        }
    }

    public void worldGenTree(World world, Random random, int x, int z) {

        final BlockPos pos = WorldGenHelper.getGroundPos(world, x, z);
        if (pos == null) return;

        final IBlockState fruitState = getFruit().getDefaultState();

        if (getFruit() instanceof BlockPamFruit) {
            new FruitTreeGen(5, logState, leavesState, false, fruitState).generate(world, random, pos);
        } else if (getFruit() instanceof BlockPamFruitLog) {
            new LogFruitTreeGen(5, logState, leavesState, fruitState).generate(world, random, pos);
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.grow(worldIn, pos, state, rand);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        final IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }

    public Item getFruitItem() {
        return this.fruitItem;
    }


    public void setFruit(@Nonnull Block fruit) {
        this.fruit = fruit;

        if (fruit instanceof BlockPamFruit) {
            this.fruitItem = ((BlockPamFruit) fruit).getFruitItem();
            return;
        }

        if (fruit instanceof BlockPamFruitLog) {
            this.fruitItem = ((BlockPamFruitLog) fruit).getFruitItem();
            return;
        }

        FMLLog.severe("Given fruit block %s is invalid.", fruit.getUnlocalizedName());
    }

    public Block getFruit() {
        if (fruit == null) {
            FMLLog.bigWarning("Fruit for sapling %s not found.", getUnlocalizedName());
            return null;
        }

        return fruit;
    }

    public enum SaplingType {
        TEMPERATE, WARM, COLD
    }
}