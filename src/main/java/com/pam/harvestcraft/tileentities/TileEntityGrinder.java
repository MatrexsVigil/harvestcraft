package com.pam.harvestcraft.tileentities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.pam.harvestcraft.item.GrinderRecipes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public class TileEntityGrinder extends TileEntity implements ITickable, ITileCheckInteract {

	//private ItemStackHandler itemstackhandler = new ItemStackHandler(3);
	public short cookTime;

	@CapabilityInject(IItemHandler.class)
    public static Capability<IItemHandler> ITEMS_CAP;

    private final ItemStackHandler itemstackhandler = new ItemStackHandler(3);
    private final RangedWrapper top = new RangedWrapper(itemstackhandler, 0, 1);
    
    private final RangedWrapper bottom = new RangedWrapper(itemstackhandler, 1, 3)
    {
        @Nonnull
        @Override
        public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
        {
            return stack;
        }
    };
    
    public ItemStackHandler getInventory()
    {
        return itemstackhandler;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        if (capability == ITEMS_CAP)
            return true;

        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        if (capability == ITEMS_CAP)
        {
            if (facing == EnumFacing.UP) return (T)top;
            if (facing == EnumFacing.DOWN) return (T)bottom;
            if (facing != null) return (T)top;
            return (T)itemstackhandler;
        }

        return super.getCapability(capability, facing);
    }

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		
		ITEMS_CAP.readNBT(itemstackhandler, null, compound.getTag("Items"));
		cookTime = compound.getShort("CookTime");
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setShort("CookTime", cookTime);
		compound.setTag("Items", ITEMS_CAP.writeNBT(itemstackhandler, null));

		return super.writeToNBT(compound);
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@SideOnly(value = Side.CLIENT)
	public int getCookProgressScaled(int scale) {
		return cookTime * scale / 125;
	}

	@Override
	public void update() {
		boolean needsUpdate = false;

		if(world.isRemote)
			return;

		if(canRun()) {
			++cookTime;

			if(cookTime >= 125) {
				cookTime = 0;
				pressComb();
				needsUpdate = true;
			}
		}
		else {
			cookTime = 0;
		}

		if(needsUpdate != cookTime > 0) {
			needsUpdate = true;
		}

		if(needsUpdate) {
			markDirty();
			world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
		}
	}

	private boolean canRun() {
		if(itemstackhandler.getStackInSlot(0).isEmpty())
			return false;

		final ItemStack[] results = GrinderRecipes.getGrindingResult(itemstackhandler.getStackInSlot(0));
		if(results == null)
			return false;

		if(!itemstackhandler.getStackInSlot(1).isEmpty()) {
			if(!itemstackhandler.getStackInSlot(1).isItemEqual(results[0]))
				return false;
			if(itemstackhandler.getStackInSlot(1).getCount() + results[0].getCount() > itemstackhandler
					.getStackInSlot(1).getMaxStackSize())
				return false;
		}

		if(results[1] != null && !results[1].isEmpty() && !itemstackhandler.getStackInSlot(2).isEmpty()) {
			if(!itemstackhandler.getStackInSlot(2).isItemEqual(results[1]))
				return false;
			if(itemstackhandler.getStackInSlot(2).getCount() + results[1].getCount() > itemstackhandler
					.getStackInSlot(2).getMaxStackSize())
				return false;
		}

		return true;
	}

	private void pressComb() {

		if(!canRun())
			return;

		final ItemStack[] results = GrinderRecipes.getGrindingResult(itemstackhandler.getStackInSlot(0));
		if(results == null)
			return;

		if(itemstackhandler.getStackInSlot(1).isEmpty()) {

			itemstackhandler.setStackInSlot(1, results[0].copy());
		}
		else if(itemstackhandler.getStackInSlot(1).getCount() + results[0].getCount() <= results[0].getMaxStackSize()) {
			itemstackhandler.getStackInSlot(1)
					.setCount(itemstackhandler.getStackInSlot(1).getCount() + results[0].getCount());
		}

		if(!results[1].isEmpty()) {
			if(itemstackhandler.getStackInSlot(2).isEmpty()) {
				itemstackhandler.setStackInSlot(2, results[1].copy());
			}
			else if(itemstackhandler.getStackInSlot(2).isItemEqual(results[1])) {
				itemstackhandler.getStackInSlot(2)
						.setCount(itemstackhandler.getStackInSlot(2).getCount() + results[1].getCount());
			}
		}

		itemstackhandler.getStackInSlot(0).setCount(itemstackhandler.getStackInSlot(0).getCount() - 1);
		if(itemstackhandler.getStackInSlot(0).getCount() <= 0) {
			itemstackhandler.getStackInSlot(0).isEmpty();
		}
	}

	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		final NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);

		return new SPacketUpdateTileEntity(getPos(), 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}

	@Override
	  public boolean shouldRefresh(World world, BlockPos pos,@Nonnull IBlockState oldState,@Nonnull IBlockState newState) {
	    return oldState.getBlock() != newState.getBlock();
	  }

	public String getGuiID() {
		return "harvestcraft:grinder";
	}
}
