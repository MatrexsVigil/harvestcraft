package com.pam.harvestcraft.tileentities;

import net.minecraft.tileentity.TileEntity;

public interface ITileEntitySpecialRendererLater {
	public void renderLater(TileEntity tile, double x, double y, double z, float partialTicks);
}	
