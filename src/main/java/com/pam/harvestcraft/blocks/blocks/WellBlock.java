package com.pam.harvestcraft.blocks.blocks;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WellBlock extends Block {

	public static final String registryName = "well";

	public WellBlock() {
		super(Material.ROCK);
		setCreativeTab(HarvestCraft.modTab);
		setSoundType(SoundType.STONE);

		setHardness(1.0f);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		ItemStack heldItem = playerIn.getHeldItem(hand);

		if(heldItem.isEmpty()) {
			return true;
		}
		else {

			Item item = heldItem.getItem();

			if(item == Items.BUCKET) {

				heldItem.shrink(1);

				if(heldItem.isEmpty()) {
					playerIn.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
				}
				else if(!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false);
				}

				return true;
			}
			else if(item == Items.GLASS_BOTTLE) {

                        ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
                        heldItem.shrink(1);

                        if (itemstack3.isEmpty())
                        {
                            playerIn.setHeldItem(hand, itemstack3);
                        }
                        else if (!playerIn.inventory.addItemStackToInventory(itemstack3))
                        {
                            playerIn.dropItem(itemstack3, false);
                        }
                        else if (playerIn instanceof EntityPlayerMP)
                        {
                            ((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
                        }


                return true;
            }
			else if(item == ItemRegistry.freshwaterItem) {
				{
					playerIn.inventory.addItemStackToInventory(new ItemStack(ItemRegistry.freshwaterItem));
				}
				return true;
			}

			return false;
		}
	}

}
