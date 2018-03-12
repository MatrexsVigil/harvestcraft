package com.pam.harvestcraft.item.items;


import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPamItemSeeds extends ItemSeeds {

    private final Block cropBlock;
    
    public ItemPamItemSeeds(Block cropBlock, Block blockType) {
        super(cropBlock, blockType);
        this.cropBlock=cropBlock;
    }
    
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Block soilBlock = worldIn.getBlockState(pos).getBlock();
        if(cropBlock.getRegistryName().toString().equalsIgnoreCase("harvestcraft:pamwhitemushroomcrop") && soilBlock == Blocks.MYCELIUM) {    
            ItemStack itemstack = player.getHeldItem(hand);
            if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) &&  worldIn.isAirBlock(pos.up())) {
                worldIn.setBlockState(pos.up(), this.cropBlock.getDefaultState());
                if (player instanceof EntityPlayerMP) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos.up(), itemstack);
                }
                itemstack.shrink(1);
                return EnumActionResult.SUCCESS;
            }
            else {
                return EnumActionResult.FAIL;
            }
        }    
            return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
        }
}
