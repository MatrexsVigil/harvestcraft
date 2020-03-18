package com.pam.harvestcraft.proxy;

import com.pam.harvestcraft.Reference;
import com.pam.harvestcraft.tileentities.MessageMarketBrowse;
import com.pam.harvestcraft.tileentities.MessageMarketBuy;
import com.pam.harvestcraft.tileentities.MessageShippingBinBrowse;
import com.pam.harvestcraft.tileentities.MessageShippingBinBuy;
import com.pam.harvestcraft.tileentities.MessageTEUpdate;
import com.pam.harvestcraft.tileentities.MessageTEUpdateRequest;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;



public class PacketHandler  {
    public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

    public static void init() {
    	
    	
        network.registerMessage(MessageMarketBrowse.class, MessageMarketBrowse.class, 0, Side.SERVER);
        network.registerMessage(MessageMarketBuy.class, MessageMarketBuy.class, 1, Side.SERVER);
//        network.registerMessage(MessageMarketClosed.class, MessageMarketClosed.class, 2, Side.SERVER);
        
        network.registerMessage(MessageShippingBinBrowse.class, MessageShippingBinBrowse.class, 3, Side.SERVER);
        network.registerMessage(MessageShippingBinBuy.class, MessageShippingBinBuy.class, 4, Side.SERVER);
//        network.registerMessage(MessageShippingBinClosed.class, MessageShippingBinClosed.class, 5, Side.SERVER);
        
        network.registerMessage(MessageTEUpdate.MessageHolder.class,MessageTEUpdate.class,6,Side.CLIENT);
    	network.registerMessage(MessageTEUpdateRequest.MessageHolder.class,MessageTEUpdateRequest.class,7,Side.SERVER);
    	
    	//network.registerMessage(BagDescMessage.MyMessageHandler.class, BagDescMessage.class, 8, Side.CLIENT);
    	//network.registerMessage(OpenBagMessage.MyMessageHandler.class, OpenBagMessage.class, 9, Side.SERVER);
    }
}
