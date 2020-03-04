package com.pam.harvestcraft.tileentities;

import com.pam.harvestcraft.gui.ContainerShippingBin;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageShippingBinBrowse implements IMessage, IMessageHandler<MessageShippingBinBrowse, IMessage> {
	private int itemNum;

	public MessageShippingBinBrowse() {}

	public MessageShippingBinBrowse(int itemNum) {
		this.itemNum = itemNum;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.itemNum = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.itemNum);
	}

	@Override
	public IMessage onMessage(MessageShippingBinBrowse message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().player;
		player.getServerWorld().addScheduledTask(() -> {
			if (player.openContainer instanceof ContainerShippingBin && player.openContainer.canInteractWith(player)) {
				ContainerShippingBin containerBin = (ContainerShippingBin) player.openContainer;
				TileEntityShippingBin bin = containerBin.getBin();

				bin.setBrowsingInfo(itemNum);

				final IBlockState state = bin.getWorld().getBlockState(bin.getPos());
				bin.getWorld().notifyBlockUpdate(bin.getPos(), state, state, 3);
			}
		});
		return null;
	}

}
