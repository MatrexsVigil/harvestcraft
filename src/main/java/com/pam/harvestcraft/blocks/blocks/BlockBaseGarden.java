package com.pam.harvestcraft.blocks.blocks;

import static com.pam.harvestcraft.HarvestCraft.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.worldgen.WorldGenHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.event.ForgeEventFactory;

public class BlockBaseGarden extends BlockBush {
    public static final Map<String, List<ItemStack>> drops = new HashMap<String, List<ItemStack>>();

    public enum Region {
        PLAINS(EnumPlantType.Plains, Blocks.GRASS, Blocks.DIRT),
        DESERT(EnumPlantType.Desert, Blocks.SAND);

        private final EnumPlantType plantType;

        private final Block[] soilBlocks;

        Region(EnumPlantType plantType, Block... soilBlocks) {
            this.plantType = plantType;
            this.soilBlocks = soilBlocks;
        }

        public EnumPlantType getPlantType() {
            return plantType;
        }

        public Block[] getSoilBlocks() {
            return soilBlocks;
        }
    }

    private final String type;
    private final String name;
    private final Region region;

    public BlockBaseGarden(String type, Region region) {
        super(Material.GRASS);
        this.type = type;
        this.name = type.toLowerCase();
        this.region = region;

        this.setCreativeTab(HarvestCraft.modTab);
        this.setSoundType(SoundType.PLANT);
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        BlockRegistry.registerBlock(name, this);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);

        if (config.enablegardenSpread && rand.nextInt(100) < config.gardenspreadRate) {
            int amount = config.gardenSpreadMax;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (!worldIn.isBlockLoaded(blockpos) || worldIn.getBlockState(blockpos).getBlock() == this) {
                    --amount;

                    if (amount <= 0) return;
                }
            }

            BlockPos newGardenPos = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k) {
                if (worldIn.isBlockLoaded(newGardenPos) && canPlaceBlockAt(worldIn, newGardenPos) && canBlockStay(worldIn, newGardenPos, getDefaultState())) {
                    pos = newGardenPos;
                }

                newGardenPos = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (worldIn.isBlockLoaded(newGardenPos) &&
                    canPlaceBlockAt(worldIn, newGardenPos) &&
                    canBlockStay(worldIn, newGardenPos, getDefaultState())) {
                worldIn.setBlockState(newGardenPos, getDefaultState(), 2);
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        IBlockState blockState = worldIn.getBlockState(pos);
        return WorldGenHelper.canReplace(blockState, worldIn, pos) && checkSoilBlock(worldIn, pos);
    }

    private boolean checkSoilBlock(World world, BlockPos pos) {
        final Block soilBlock = world.getBlockState(pos.down()).getBlock();

        for (Block acceptableBlock : region.getSoilBlocks()) {
            if (acceptableBlock == soilBlock) return true;
        }
        return false;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return region.getPlantType();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    public String getName() {
        return name;
    }

    /**
     * Overriding this in order to allow dropping the garden when sneaking.
     */
    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) {
        player.addStat(StatList.getBlockStats(this));
        player.addExhaustion(0.025F);

        if (player.isSneaking() || canSilkHarvest(worldIn, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
            List<ItemStack> items = new ArrayList<ItemStack>();
            ItemStack itemstack = this.getSilkTouchDrop(state);

            if (itemstack != null) {
                items.add(itemstack);
            }

            ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, 0, 1.0f, true, player);
            for (ItemStack item : items) {
                spawnAsEntity(worldIn, pos, item);
            }
        } else {
            harvesters.set(player);
            final int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
            dropBlockAsItem(worldIn, pos, state, i);
            harvesters.set(null);
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> list, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> ourDrops = drops.get(type);
        Collections.shuffle(ourDrops);

        int len = Math.min(config.gardendropAmount, ourDrops.size());

        for (int i = 0; i < len; i++) {
            ItemStack drop = ourDrops.get(i);

            // This should never happen, but check it anyway...
            if (drop == null) {
                System.err.println("Tried to get a null item for garden '" + type + "'.");
                continue;
            }

            // Add it to our drops...
            list.add(drop.copy());
        }
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
}
