package com.pam.harvestcraft.tileentities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;
import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.item.ItemRegistry;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public class TileEntityApiary extends TileEntity implements ITickable {

	//private ItemStackHandler itemstackhandler = new ItemStackHandler(19);
	public int runTime = 0;
	public int currentBeeRunTime = 0;
	public int produceTime = 0;

	@CapabilityInject(IItemHandler.class)
    public static Capability<IItemHandler> ITEMS_CAP;

    private final ItemStackHandler itemstackhandler = new ItemStackHandler(19);
    private final RangedWrapper top = new RangedWrapper(itemstackhandler, 18, 19);
    
    private final RangedWrapper bottom = new RangedWrapper(itemstackhandler, 0, 18)
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
		super.readFromNBT(compound);
		ITEMS_CAP.readNBT(itemstackhandler, null, compound.getTag("Items"));
		runTime = compound.getShort("RunTime");
		produceTime = compound.getShort("ProduceTime");
		currentBeeRunTime = getRunTime(itemstackhandler.getStackInSlot(1));
	}

	@Override
	@MethodsReturnNonnullByDefault
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setShort("RunTime", (short) runTime);
		compound.setShort("ProduceTime", (short) produceTime);
		compound.setTag("Items", ITEMS_CAP.writeNBT(itemstackhandler, null));

		return compound;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}


	@Override
	public void update() {
		boolean isRunning = runTime > 0;
		boolean needsUpdate = false;

		if(isRunning) {
			--runTime;
		}

		ItemStack queenBee = itemstackhandler.getStackInSlot(18);
		if(!world.isRemote) {
			if(runTime == 0 && canRun()) {
				currentBeeRunTime = runTime = getRunTime(queenBee);

				if(runTime > 0) {
					needsUpdate = true;
					if(!queenBee.isEmpty()) {
						queenBee.attemptDamageItem(1, this.getWorld().rand, null);
					}
				}
			}

			if(canRun()) {
				++produceTime;

				if(produceTime >= Math.floor(getRunTime(queenBee))) {
					produceTime = 0;
					run();
					needsUpdate = true;
				}
			}
			else {
				produceTime = 0;
			}

			if(isRunning != runTime > 0) {
				needsUpdate = true;
			}
		}

		if(needsUpdate) {
			markDirty();
			world.notifyBlockUpdate(pos, world.getBlockState(getPos()), world.getBlockState(getPos()), 3);
		}
	}

	private boolean canRun() {
		if(!itemstackhandler.getStackInSlot(18).isEmpty()) {
			if(itemstackhandler.getStackInSlot(18).getItem() == ItemRegistry.queenbeeItem) {
				return true;
			}
		}
		return false;
	}

	private void run() {
		itemstackhandler.getStackInSlot(18).attemptDamageItem(1, world.rand, null);
		final ItemStack itemProduced = getComb();

		if(itemProduced.isEmpty())
			return;

		for(int i = 0; i < 18; ++i) {
			if(!itemstackhandler.getStackInSlot(i).isEmpty())
				continue;
			itemstackhandler.setStackInSlot(i, itemProduced.copy());
			break;
		}
	}

	private ItemStack getComb() {
		int randomNum = world.rand.nextInt(100);

		if (HarvestCraft.config.queenbeelastresultequalsQueen)
		{
			if(!itemstackhandler.getStackInSlot(18).isEmpty()) {
				if(itemstackhandler.getStackInSlot(18).getItem() == ItemRegistry.queenbeeItem
						&& itemstackhandler.getStackInSlot(18).getItemDamage() >= 36) {
					itemstackhandler.getStackInSlot(18).shrink(1);
						return new ItemStack(ItemRegistry.queenbeeItem);	
				}
				if(randomNum < 35) {
					return new ItemStack(ItemRegistry.waxcombItem);
				}
				if(randomNum >= 35 && randomNum < 70) {
					return new ItemStack(ItemRegistry.honeycombItem);
				}
				return new ItemStack(ItemRegistry.grubItem);
			}
		} else
		
		
		if(!itemstackhandler.getStackInSlot(18).isEmpty()) {
			if(itemstackhandler.getStackInSlot(18).getItem() == ItemRegistry.queenbeeItem
					&& itemstackhandler.getStackInSlot(18).getItemDamage() >= 36) {
				itemstackhandler.getStackInSlot(18).shrink(1);
				if(randomNum < 35) {
					return new ItemStack(ItemRegistry.waxcombItem);
				}
				if(randomNum >= 35 && randomNum < 70) {
					return new ItemStack(ItemRegistry.honeycombItem);
				}
				return new ItemStack(ItemRegistry.grubItem);	
			}
			if(randomNum < 35) {
				return new ItemStack(ItemRegistry.waxcombItem);
			}
			if(randomNum >= 35 && randomNum < 70) {
				return new ItemStack(ItemRegistry.honeycombItem);
			}
			return new ItemStack(ItemRegistry.grubItem);
		}

		return null;
	}

	private int getRunTime(ItemStack stack) {
		if(!stack.isEmpty() && stack.getItem() == ItemRegistry.queenbeeItem) {
			return getRunTime();
		}
		return 0;
	}

	private int getRunTime() {
		final int radius = 2;
		// final World world = world;
		final int varX = pos.getX();
		final int varY = pos.getY();
		final int varZ = pos.getZ();

		int speed = 3500;

		for(int offsetX = -radius; offsetX <= radius; ++offsetX) {
			for(int offsetZ = -radius; offsetZ <= radius; ++offsetZ) {
				if(offsetX * offsetX + offsetZ * offsetZ > radius * radius
						|| offsetX == -radius - 1 && offsetZ == -radius - 1
						|| offsetX == radius - 1 && offsetZ == radius - 1
						|| offsetX == radius - 1 && offsetZ == -radius - 1
						|| offsetX == -radius - 1 && offsetZ == radius - 1)
					continue;
				final BlockPos pos = new BlockPos(varX + offsetX, varY, varZ + offsetZ);
				if (!world.isBlockLoaded(pos)) continue;
				final Block blockAtCoords = world.getBlockState(pos).getBlock();
				if(blockAtCoords instanceof BlockFlower || blockAtCoords instanceof BlockCrops
						|| blockAtCoords instanceof BlockBaseGarden) {
					speed = (int) (speed * .85);
				}
				if(blockAtCoords != BlockRegistry.apiary)
					continue;
				speed = (int) (speed / 1.0);
			}
		}
		return speed;
	}

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

	public boolean canInteractWith(EntityPlayer playerIn) {
		// If we are too far away from this tile entity you cannot use it
		return !isInvalid() && playerIn.getDistanceSq(pos.add(0.5D, 0.5D, 0.5D)) <= 64D;
	}

	public String getGuiID() {
		return "harvestcraft:apiary";
	}

}
