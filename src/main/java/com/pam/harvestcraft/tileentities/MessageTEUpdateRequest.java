package com.pam.harvestcraft.tileentities;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageTEUpdateRequest implements IMessage {
	public long pos = 0;
	UUID id = null;
	
	public MessageTEUpdateRequest(){
		//
	}
	
	public MessageTEUpdateRequest(UUID id, BlockPos pos){
		this.pos = pos.toLong();
		this.id = id;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		id = new UUID(buf.readLong(),buf.readLong());
		pos = buf.readLong();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(id.getMostSignificantBits());
		buf.writeLong(id.getLeastSignificantBits());
		buf.writeLong(pos);
	}

    public static class MessageHolder implements IMessageHandler<MessageTEUpdateRequest,MessageTEUpdate>
    {
    	@SideOnly(Side.CLIENT)
        @Override
        public MessageTEUpdate onMessage(final MessageTEUpdateRequest message, final MessageContext ctx) {
    		Minecraft.getMinecraft().addScheduledTask(()-> {
	    		BlockPos pos = BlockPos.fromLong(message.pos);
    			EntityPlayer player = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(message.id);
    			if (player != null){
    				if (player.world != null){
    					if (player.world.getTileEntity(pos) != null){
    						player.world.getTileEntity(pos).markDirty();
    					}
    				}
    			}
				return null;
	    	});
    		return null;
	    }
    }
}
