package com.pam.harvestcraft.tileentities;

import java.util.ArrayList;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShippingBinItems {

    private enum CurrencyType {
        DEFAULT, SEEDS, SAPLING, ANIMAL, FISH, MEAT, BEES
    }

    private static final ArrayList<ShippingBinData> items = new ArrayList<ShippingBinData>();

    private static void registerItems(ShippingBinData data) {
        items.add(data);
    }

    public static ShippingBinData getData(int i) {
        return items.get(i);
    }

    public static int getSize() {
        return items.size();
    }

    public static void registerItems() {
    	
        if (HarvestCraft.config.shippingbinbuyCrops) {
            registerCrops();  
        }
        if (HarvestCraft.config.shippingbinbuyFish) {
        	registerFish();
        }
        if (HarvestCraft.config.shippingbinbuyMeat) {
        	registerMeat();
        }
        if (HarvestCraft.config.shippingbinbuyBees) {
        	registerBees();
        }
    }

   
    private static void registerCrops() {
        final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencySeeds, CurrencyType.SEEDS);

        for (Item crop : CropRegistry.getFoods().values()) {
            registerItems(new ShippingBinData(currency, new ItemStack(crop), HarvestCraft.config.shippingbincropPrice));

        }
        
        if (ConfigHandler.shippingbinenablevanillaMCCrops)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.APPLE), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.WHEAT), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Blocks.PUMPKIN), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.MELON), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.BEETROOT), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.CARROT), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.POTATO), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.DYE, 1, 3), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.NETHER_WART), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.CHORUS_FRUIT), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.REEDS), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Blocks.CACTUS), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Blocks.BROWN_MUSHROOM), HarvestCraft.config.shippingbincropPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Blocks.RED_MUSHROOM), HarvestCraft.config.shippingbincropPrice));
        }

    }
    
    private static void registerFish() {
        final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyFish, CurrencyType.FISH);
        if (ConfigHandler.shippingbinenablevanillaMCFish)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.FISH, 1, -1), HarvestCraft.config.shippingbinfishPrice));
        }
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.anchovyrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.bassrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.carprawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.catfishrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.charrrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.clamrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.crabrawItem), HarvestCraft.config.shippingbinfishPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.crayfishrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.eelrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.frograwItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.grouperrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.herringrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.jellyfishrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.mudfishrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.octopusrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.perchrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.scalloprawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.shrimprawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.snailrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.snapperrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.tilapiarawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.troutrawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.tunarawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.turtlerawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.walleyerawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.sardinerawItem), HarvestCraft.config.shippingbinfishPrice));
    	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.rawtofishItem), HarvestCraft.config.shippingbinfishPrice));
    }
    
    private static void registerMeat() {
        final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyMeat, CurrencyType.MEAT);

        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.duckrawItem), HarvestCraft.config.shippingbinmeatPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.turkeyrawItem), HarvestCraft.config.shippingbinmeatPrice));
        registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.venisonrawItem), HarvestCraft.config.shippingbinmeatPrice));
	    
        if (ConfigHandler.shippingbinenablevanillaMCMeat)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.BEEF), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.PORKCHOP), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.MUTTON), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.RABBIT), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.CHICKEN), HarvestCraft.config.shippingbinmeatPrice));
        }
        if (ConfigHandler.shippingbinenablevanillaMCEgg)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.EGG), HarvestCraft.config.shippingbinmeatPrice));
        }
        if (ConfigHandler.shippingbinenablevanillaMCMonsterParts)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.ROTTEN_FLESH), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.SPIDER_EYE), HarvestCraft.config.shippingbinmeatPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(Items.BONE), HarvestCraft.config.shippingbinmeatPrice));
        }
    }
    
    private static void registerBees() {
        final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyBees, CurrencyType.BEES);
        if (ConfigHandler.shippingbinenablevanillaMCBees)
        {
        	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.waxcombItem), HarvestCraft.config.shippingbinbeesPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.honeycombItem), HarvestCraft.config.shippingbinbeesPrice));
        	registerItems(new ShippingBinData(currency, new ItemStack(ItemRegistry.grubItem), HarvestCraft.config.shippingbinbeesPrice));
        }
    }
    
    private static ItemStack getCurrency(int config, CurrencyType currencyType) {
        switch (config) {
            case 1:
                return new ItemStack(Items.DIAMOND);
            case 2:
                return new ItemStack(Items.GOLD_INGOT);
            case 3:
                return new ItemStack(Items.GOLD_NUGGET);
            case 4:
                return new ItemStack(Items.IRON_INGOT);
            case 5:
                if (currencyType.equals(CurrencyType.ANIMAL))
                    return new ItemStack(Items.EGG);
                if (currencyType.equals(CurrencyType.SEEDS))
                    return new ItemStack(Items.WHEAT_SEEDS);
                if (currencyType.equals(CurrencyType.SAPLING))
                    return new ItemStack(Blocks.SAPLING);
                else
                    return null;
            case 6:
                return new ItemStack(Items.APPLE);
            case 7:
                return new ItemStack(Items.DYE);
            case 8:
				return new ItemStack(ItemRegistry.garliccoinItem);
            case 0:
            default:
                return new ItemStack(Items.EMERALD);
        }
    }

}
