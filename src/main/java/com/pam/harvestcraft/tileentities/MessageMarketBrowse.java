package com.pam.harvestcraft.tileentities;

import com.pam.harvestcraft.gui.ContainerMarket;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageMarketBrowse implements IMessage, IMessageHandler<MessageMarketBrowse, IMessage> {
	private int itemNum;
	private int x;
	private int y;
	private int z;

	public MessageMarketBrowse() {}

	public MessageMarketBrowse(int itemNum) {
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
	public IMessage onMessage(MessageMarketBrowse message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().player;
		player.getServerWorld().addScheduledTask(() -> {
			if (player.openContainer instanceof ContainerMarket && player.openContainer.canInteractWith(player)) {
				ContainerMarket containerMarket = (ContainerMarket) player.openContainer;
				TileEntityMarket market = containerMarket.getMarket();

				market.setBrowsingInfo(message.itemNum);

				final IBlockState state = market.getWorld().getBlockState(market.getPos());
				market.getWorld().notifyBlockUpdate(market.getPos(), state, state, 3);
			}
        });
		return null;
	}

}
