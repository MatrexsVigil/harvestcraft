package com.pam.harvestcraft.proxy;

import static com.pam.harvestcraft.HarvestCraft.config;

import java.util.Set;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.addons.RightClickHarvesting;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.events.AnimalBreedingEvent;
import com.pam.harvestcraft.item.GeneralOreRegistry;
import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.item.RecipeRegistry;
import com.pam.harvestcraft.item.SeedDropRegistry;
import com.pam.harvestcraft.loottables.LootTableLoadEventHandler;
import com.pam.harvestcraft.tileentities.MarketItems;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import com.pam.harvestcraft.tileentities.TileEntityApiary;
import com.pam.harvestcraft.tileentities.TileEntityGrinder;
import com.pam.harvestcraft.tileentities.TileEntityGroundTrap;
import com.pam.harvestcraft.tileentities.TileEntityMarket;
import com.pam.harvestcraft.tileentities.TileEntityPresser;
import com.pam.harvestcraft.tileentities.TileEntityShippingBin;
import com.pam.harvestcraft.tileentities.TileEntityWaterFilter;
import com.pam.harvestcraft.tileentities.TileEntityWaterTrap;
import com.pam.harvestcraft.worldgen.BeehiveWorldGen;
import com.pam.harvestcraft.worldgen.BushWorldGen;
import com.pam.harvestcraft.worldgen.FruitTreeWorldGen;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        CropRegistry.registerCrops();
        FruitRegistry.registerFruits();
        BlockRegistry.initBlockRegistry();
        MinecraftForge.EVENT_BUS.register(new BlockRegistry());
        ItemRegistry.registerItems();
        MinecraftForge.EVENT_BUS.register(new ItemRegistry());
        //GeneralOreRegistry.initOreRegistry(); Moved to line 2434 of ItemRegistry
        //ModItems.init();
        
    }

    public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new BushWorldGen(), 0);
        GameRegistry.registerWorldGenerator(new FruitTreeWorldGen(), 0);
        GameRegistry.registerWorldGenerator(new BeehiveWorldGen(), 0);
        
        onBlocksAndItemsLoaded();
    }

    public void postInit(FMLPostInitializationEvent e) {
    	Set<Item> temptationItems = ObfuscationReflectionHelper.getPrivateValue(EntityPig.class, null, "TEMPTATION_ITEMS", "field_184764_bw");
	    temptationItems.add(ItemRegistry.harvestcarrotItem);
	    temptationItems.add(ItemRegistry.harvestpotatoItem);
	    temptationItems.add(ItemRegistry.harvestbeetItem);
	    for (ItemStack stack : OreDictionary.getOres("listAllveggie")) {
	        temptationItems.add(stack.getItem());
	    }
	    
	    Set<Item> temptationItems2 = ObfuscationReflectionHelper.getPrivateValue(EntityChicken.class, null, "TEMPTATION_ITEMS", "field_184761_bD");
	    for (ItemStack stack : OreDictionary.getOres("listAllseed")) {
	        temptationItems2.add(stack.getItem());
	    }
		
		//Cow and Sheep dont have Temptation Items
	    /*
		Set<Item> temptationItems3 = ObfuscationReflectionHelper.getPrivateValue(EntityCow.class, null, "TEMPTATION_ITEMS", "field_184761_bD");
	    for (ItemStack stack : OreDictionary.getOres("listAllgrain")) {
	        temptationItems3.add(stack.getItem());
	    }
	    */
	    
	    

    }

    public void onBlocksAndItemsLoaded() {
        HarvestCraft.config.configureGardenDrops();

        

        RecipeRegistry.registerRecipes();
        SeedDropRegistry.getSeedDrops();

        MarketItems.registerItems();
        ShippingBinItems.registerItems();
        PacketHandler.init();

        GameRegistry.registerTileEntity(TileEntityApiary.class, "PamApiary");
        GameRegistry.registerTileEntity(TileEntityMarket.class, "PamMarket");
        GameRegistry.registerTileEntity(TileEntityShippingBin.class, "PamShippingbin");
        GameRegistry.registerTileEntity(TileEntityPresser.class, "PamPresser");
        GameRegistry.registerTileEntity(TileEntityGroundTrap.class, "PamGroundTrap");
        GameRegistry.registerTileEntity(TileEntityWaterTrap.class, "PamWaterTrap");
        GameRegistry.registerTileEntity(TileEntityWaterFilter.class, "PamWaterFilter");
        GameRegistry.registerTileEntity(TileEntityGrinder.class, "PamGrinder");
        
        if (ConfigHandler.enableHCFish)
        {
        MinecraftForge.EVENT_BUS.register(new LootTableLoadEventHandler());
        }
        
        RightClickHarvesting.instance.register();
        
        MinecraftForge.EVENT_BUS.register(new AnimalBreedingEvent());
        
        GameRegistry.registerFuelHandler(new HarvestCraftFuelHandler());
        
    }
}
