package com.pam.harvestcraft.addons;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterables;
import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.growables.BlockPamFruit;
import com.pam.harvestcraft.blocks.growables.BlockPamFruitLog;
import com.pam.harvestcraft.blocks.growables.PamCropGrowable;

import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.BlockPotato;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RightClickHarvesting {

	public static final RightClickHarvesting instance = new RightClickHarvesting();

	private RightClickHarvesting() {}

	public void register() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		if(!HarvestCraft.config.enableEasyHarvest)
			return;

		if(event.getEntityPlayer() == null)
			return;

		final IBlockState blockState = event.getWorld().getBlockState(event.getPos());

		if(blockState.getBlock() instanceof BlockCrops) {
			// we harvest with mainhand only
			// but we cancel both hands
			if(event.getHand() == EnumHand.MAIN_HAND) {
				if(!event.getWorld().isRemote)
					// must be run by server only
					harvestCrops(blockState, event.getEntityPlayer(), event.getWorld(), event.getPos());
				event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
			}
			// this actually denies block placement only
			// targeted block and held item can still be activated
			event.setUseItem(Event.Result.DENY);
		}

		// now do this again for other block types
		else if(blockState.getBlock() instanceof BlockNetherWart) {
			if(event.getHand() == EnumHand.MAIN_HAND) {
				if(!event.getWorld().isRemote)
					harvestNetherWart(blockState, event.getEntityPlayer(), event.getWorld(), event.getPos());
				event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
			}
			event.setUseItem(Event.Result.DENY);
		}

		else if(blockState.getBlock() instanceof BlockPamFruit || blockState.getBlock() instanceof BlockPamFruitLog) {
			if(event.getHand() == EnumHand.MAIN_HAND) {
				if(!event.getWorld().isRemote)
					harvestFruit(blockState, event.getEntityPlayer(), event.getWorld(), event.getPos());
				event.getEntityPlayer().swingArm(EnumHand.MAIN_HAND);
			}
			event.setUseItem(Event.Result.DENY);
		}
	}

	private static void harvestCrops(IBlockState blockState, EntityPlayer player, World world, BlockPos blockPos) {
		final BlockCrops crops = (BlockCrops) blockState.getBlock();
		if(crops.isMaxAge(blockState)) {
			final ItemStack stack = player.getHeldItemMainhand();
			final int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);

			final List<ItemStack> drops = crops.getDrops(world, blockPos, blockState, fortune);

			// This removes exactly one seed from drops in order to make this more fair compared to vanilla
			// as one seed stays planted.
			final Item seedItem = crops.getItemDropped(blockState, world.rand, fortune);
			if(seedItem != null)
				for(Iterator<ItemStack> iterator = drops.iterator(); iterator.hasNext();) {
					final ItemStack drop = iterator.next();

					// Remove a seed, then break.
					if(!(drop.getItem() == seedItem) || crops instanceof BlockCarrot || crops instanceof BlockPotato) {
						iterator.remove();
						break;
					}
				}

			ForgeEventFactory.fireBlockHarvesting(drops, world, blockPos, blockState, fortune, 1f, false, player);

			// Reset growth level
			world.setBlockState(blockPos, crops.withAge(0));

			for(ItemStack drop : drops) {
				dropItem(drop, world, blockPos);
			}
		}
	}

	private static void harvestFruit(IBlockState blockState, EntityPlayer player, World world, BlockPos blockPos) {
		final PamCropGrowable blockPamFruit = (PamCropGrowable) blockState.getBlock();

		if(blockPamFruit.isMature(blockState)) {
			final ItemStack stack = player.getHeldItemMainhand();
			final int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
			final List<ItemStack> drops = blockPamFruit.getDrops(world, blockPos, blockState, fortune);

			// This removes exactly one fruit from drops in order to make this more fair compared to "vanilla"
			// as one fruit stays planted.
			if(drops.size() > 0)
				drops.remove(drops.size() - 1);

			ForgeEventFactory.fireBlockHarvesting(drops, world, blockPos, blockState, fortune, 1f, false, player);

			world.setBlockState(blockPos, blockState.withProperty(blockPamFruit.getAgeProperty(), 0), 3);

			for(ItemStack drop : drops) {
				dropItem(drop, world, blockPos);
			}
		}
	}

	private static void harvestNetherWart(IBlockState blockState, EntityPlayer player, World world, BlockPos blockPos) {
		final BlockNetherWart netherWart = (BlockNetherWart) blockState.getBlock();
		if (blockState.getValue(BlockNetherWart.AGE) >= Iterables.getLast(BlockNetherWart.AGE.getAllowedValues())) {
			final ItemStack stack = player.getHeldItemMainhand();
			final int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);

			final List<ItemStack> drops = netherWart.getDrops(world, blockPos, blockState, fortune);

			// This removes exactly one seed from drops in order to make this more fair compared to vanilla
			// as one seed stays planted.
			final Item seedItem = netherWart.getItemDropped(blockState, world.rand, fortune);
			if (seedItem != null) {
				for (Iterator<ItemStack> iterator = drops.iterator(); iterator.hasNext(); ) {
					final ItemStack drop = iterator.next();

					// Remove a seed, then break.
					if (!(drop.getItem() == seedItem)) {
						iterator.remove();
						break;
					}
				}
			}
			ForgeEventFactory.fireBlockHarvesting(drops, world, blockPos, blockState, fortune, 1f, false, player);

			world.setBlockState(blockPos, blockState.withProperty(BlockNetherWart.AGE, 0));

			for (ItemStack drop : drops) {
				dropItem(drop, world, blockPos);
			}
		}
	}

	private static void dropItem(ItemStack itemStack, World world, BlockPos pos) {
		if(world.restoringBlockSnapshots || world.isRemote)
			return;

		float f = 0.5F;
		double d0 = (world.rand.nextFloat() * f) + 0.25D;
		double d1 = (world.rand.nextFloat() * f) + 0.25D;
		double d2 = (world.rand.nextFloat() * f) + 0.25D;

		final EntityItem entityItem =
				new EntityItem(world, pos.getX() + d0, pos.getY() + d1, pos.getZ() + d2, itemStack);
		entityItem.setDefaultPickupDelay();
		world.spawnEntity(entityItem);
	}

}
