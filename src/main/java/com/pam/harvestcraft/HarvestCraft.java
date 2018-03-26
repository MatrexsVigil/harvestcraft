package com.pam.harvestcraft;

import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.config.FruitTreeConfigManager;
import com.pam.harvestcraft.gui.GuiHandler;
import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class HarvestCraft {

	@Instance(value = Reference.MODID)
	public static HarvestCraft instance = new HarvestCraft();
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static final CreativeTabs modTab = new CreativeTabs(Reference.MODID) {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemRegistry.toastsandwichItem);
		}
	};

	public static ConfigHandler config;
	public static FruitTreeConfigManager fruitTreeConfigManager;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new ConfigHandler(new Configuration(event.getSuggestedConfigurationFile()));

        fruitTreeConfigManager = new FruitTreeConfigManager(
        		new Configuration(
        				new File(event.getModConfigurationDirectory(), Reference.MODID + "_fruittree" + ".cfg")));
		proxy.preInit(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		//final SimpleNetworkWrapper NETWORKINSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		fruitTreeConfigManager.Configure();
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}