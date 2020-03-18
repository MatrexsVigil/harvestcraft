package com.pam.harvestcraft.tileentities;

import com.pam.harvestcraft.gui.ContainerShippingBin;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageShippingBinBuy implements IMessage, IMessageHandler<MessageShippingBinBuy, IMessage> {
	private int itemNum;

	public MessageShippingBinBuy() {}

	public MessageShippingBinBuy(int itemNum) {
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
	public IMessage onMessage(MessageShippingBinBuy message, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		player.getServerWorld().addScheduledTask(() -> {
			if (player.openContainer instanceof ContainerShippingBin && player.openContainer.canInteractWith(player)) {
				ContainerShippingBin containerBin = (ContainerShippingBin) player.openContainer;
				ItemStack result = containerBin.buy(message.itemNum);
				if (!result.isEmpty()) {
					player.world.spawnEntity(new EntityItem(player.world, player.posX, player.posY + 1D, player.posZ, result));
				}
			}
		});
		return null;
	}
}