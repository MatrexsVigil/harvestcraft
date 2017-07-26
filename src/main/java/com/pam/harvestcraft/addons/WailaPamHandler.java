package com.pam.harvestcraft.addons;

import java.util.List;

import com.pam.harvestcraft.blocks.growables.BlockPamCrop;
import com.pam.harvestcraft.blocks.growables.BlockPamFruit;
import com.pam.harvestcraft.blocks.growables.BlockPamFruitLog;
import com.pam.harvestcraft.blocks.growables.PamCropGrowable;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.cbcore.LangUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WailaPamHandler implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if(accessor.getBlock() instanceof BlockPamCrop) {
			BlockPamCrop crop = (BlockPamCrop) accessor.getBlock();
			return new ItemStack(crop.getCrop());
		}
		else if(accessor.getBlock() instanceof BlockPamFruit) {
			BlockPamFruit fruit = (BlockPamFruit) accessor.getBlock();
			return new ItemStack(fruit.getFruitItem());
		}
		else
			return ItemStack.EMPTY;
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		if(!config.getConfig("general.showcrop") || accessor.getBlock() == null
				|| !(accessor.getBlock() instanceof PamCropGrowable)) {
			return currenttip;
		}

		currenttip.clear();

		float matureAge = ((PamCropGrowable) accessor.getBlock()).getMatureAge();
		final int growthStage = accessor.getMetadata();

		final float growthValue = (growthStage / matureAge) * 100.0F;

		if(growthValue < 100.0) {
			currenttip.add(String.format("%s : %.0f %%", LangUtil.translateG("hud.msg.growth"), growthValue));
		}
		else {
			currenttip.add(String.format("%s : %s", LangUtil.translateG("hud.msg.growth"),
					LangUtil.translateG("hud.msg.mature")));
		}

		return currenttip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world,
			BlockPos pos) {
		if(te != null) {
			te.deserializeNBT(tag);
		}

		return tag;
	}

	public static void callbackRegister(IWailaRegistrar registrar) {
		registrar.registerBodyProvider(new WailaPamHandler(), BlockPamCrop.class);
		registrar.registerBodyProvider(new WailaPamHandler(), BlockPamFruit.class);
		registrar.registerBodyProvider(new WailaPamHandler(), BlockPamFruitLog.class);
	}
}
