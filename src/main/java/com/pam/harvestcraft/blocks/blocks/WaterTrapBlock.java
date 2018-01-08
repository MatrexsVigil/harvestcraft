package com.pam.harvestcraft.blocks.blocks;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.ItemStackUtils;
import com.pam.harvestcraft.gui.GuiHandler;
import com.pam.harvestcraft.tileentities.TileEntityWaterTrap;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class WaterTrapBlock extends BlockContainerRotating {

	public static final String registryName = "watertrap";

	public WaterTrapBlock() {
		super(Material.WOOD);
		setSoundType(SoundType.WOOD);
		setCreativeTab(HarvestCraft.modTab);
		this.setHardness(1.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityWaterTrap();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		// keepInventory = true;
		// if(!keepInventory) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if(tileentity instanceof TileEntityWaterTrap) {
			ItemStackUtils.dropInventoryItems(worldIn, pos,
					tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null));
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		// }

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if(world.isRemote) {
			return true;
		}
		TileEntity te = world.getTileEntity(pos);
		if(!(te instanceof TileEntityWaterTrap)) {
			return false;
		}
		player.openGui(HarvestCraft.instance, GuiHandler.GUIID_WATER_TRAP, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
