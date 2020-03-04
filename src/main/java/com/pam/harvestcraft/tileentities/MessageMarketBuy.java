package com.pam.harvestcraft.tileentities;

import com.pam.harvestcraft.gui.ContainerMarket;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageMarketBuy implements IMessage, IMessageHandler<MessageMarketBuy, IMessage> {
	private int itemNum;

	public MessageMarketBuy() {}

	public MessageMarketBuy(int itemNum) {
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
	public IMessage onMessage(MessageMarketBuy message, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		player.getServerWorld().addScheduledTask(() -> {
			if (player.openContainer instanceof ContainerMarket && player.openContainer.canInteractWith(player)) {
				ContainerMarket market = (ContainerMarket) player.openContainer;
				ItemStack result = market.buy(message.itemNum);
				if (!result.isEmpty()) {
					player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY + 1D, player.posZ, result));
				}
			}
		});
		return null;
	}
}