package com.pam.harvestcraft.tileentities;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.items.CapabilityItemHandler;

public class MessageMarketClosed implements IMessage, IMessageHandler<MessageMarketClosed, IMessage> {
	private int x;
	private int y;
	private int z;

	public MessageMarketClosed() {}

	public MessageMarketClosed(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}

	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.x);
		buf.writeInt(this.y);
		buf.writeInt(this.z);
	}

	public IMessage onMessage(MessageMarketClosed message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().player;

		TileEntity tile_entity = player.world.getTileEntity(new BlockPos(message.x, message.y, message.z));
		if((tile_entity instanceof TileEntityMarket)) {
			TileEntityMarket tileEntityMarket = (TileEntityMarket) tile_entity;

			if(!tileEntityMarket.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0)
					.isEmpty()) {
				player.entityDropItem(tileEntityMarket
						.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0), 1.0F);
				tileEntityMarket.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).getStackInSlot(0)
						.setCount(0);
			}
		}

		final IBlockState state = player.world.getBlockState(new BlockPos(message.x, message.y, message.z));
		player.world.notifyBlockUpdate(new BlockPos(message.x, message.y, message.z), state, state, 3);
		return null;
	}
}
