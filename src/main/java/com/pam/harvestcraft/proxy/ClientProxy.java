package com.pam.harvestcraft.proxy;

import com.pam.harvestcraft.addons.Waila;
import com.pam.harvestcraft.blocks.ItemModels;
import com.pam.harvestcraft.item.ItemRenderRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ItemModels.preInit();
        //ModItems.registerModels();
        Waila.init();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ItemModels.init();
        ItemRenderRegister.registerItemRenderer();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}

