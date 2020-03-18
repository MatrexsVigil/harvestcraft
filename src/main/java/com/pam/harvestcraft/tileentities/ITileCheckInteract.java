package com.pam.harvestcraft.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * Implement this class only for TileEntities.
 *
 * I could add getWorld() getPos() and isInvalid() methods and use them instead of casting to TileEntity
 * but TileEntity's methods gets obfuscated and this interface's not therefore we have AbstractMethodError at production.
 */
public interface ITileCheckInteract {
    default boolean canInteractWithMe(EntityPlayer player) {
        TileEntity tile = (TileEntity) this;
        return !tile.isInvalid() && player.getDistanceSq(tile.getPos().add(0.5D, 0.5D, 0.5D)) <= 64D && player.world.getTileEntity(tile.getPos()) == this;
    }
}
