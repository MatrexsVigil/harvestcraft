package com.pam.harvestcraft.tileentities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageTEUpdate implements IMessage {
	public NBTTagCompound tag = new NBTTagCompound();
	
	public MessageTEUpdate(){
		//
	}
	
	public MessageTEUpdate(NBTTagCompound tag){
		this.tag = tag;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		tag = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, tag);
	}

    public static class MessageHolder implements IMessageHandler<MessageTEUpdate,IMessage>
    {
    	@SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(final MessageTEUpdate message, final MessageContext ctx) {
    		Minecraft.getMinecraft().addScheduledTask(()-> {
    			NBTTagList list = message.tag.getTagList("data", Constants.NBT.TAG_COMPOUND);
    			for (int i = 0; i < list.tagCount(); i ++){
    				NBTTagCompound tag = list.getCompoundTagAt(i);
    				TileEntity t = Minecraft.getMinecraft().player.getEntityWorld().getTileEntity(new BlockPos(tag.getInteger("x"),tag.getInteger("y"),tag.getInteger("z")));
		    		if (t != null){
		    			t.readFromNBT(tag);
		    			t.markDirty();
		    		}
    			}
	    	});
    		return null;
	    }
    }
}
