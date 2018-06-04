package com.pam.harvestcraft.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ConfigHandler {

    private final Configuration config;

    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_CROPS = "crops";
    private static final String CATEGORY_GARDENS = "gardens";
    private static final String CATEGORY_SALT = "salt";
    private static final String CATEGORY_BEE = "beekeeping";
    private static final String CATEGORY_MARKET_SALES = "market sales";
    private static final String CATEGORY_MARKET_PRICES = "market prices";
    private static final String CATEGORY_MARKET_CURRENCY = "market currency";
    private static final String CATEGORY_CANDLES = "candles";
    private static final String CATEGORY_DIMENSIONS = "dimensions";
    private static final String CATEGORY_SEEDS = "seeds";
    private static final String CATEGORY_MISC_RECIPES = "miscellaneous recipes";
    private static final String CATEGORY_SHIPPINGBIN_PURCHASES = "shipping bin purchases";
    private static final String CATEGORY_SHIPPINGBIN_PRICES = "shipping bin prices";
    //public static final String CATEGORY_WHITELIST = "whitelist";

    /**
     * Defaults
     */
    private static final int defaultCropFoodRestore = 1;
    private static final double defaultSaturationSmall = 0.6D;
    private static final double defaultSaturationMeal = 1.2D;
    private static final double defaultSaturationMeatyMeal = 1.600000023841858D;
    private static final double defaultCropGrowthSpeed = 0.0D;

    /**
     * Config
     */
    public boolean squiddropCalamari;
    public boolean smeltsquidintocookedFish;

    public int cropfoodRestore;
    public float cropsaturationRestore;
    public static boolean cropsdropSeeds;
    
    public static float cropGrowthSpeed;

    public float snacksaturation;
    public float mealsaturation;
    public float meatymealsaturation;

    public int freshmilkfrombucket;
    public int freshwaterfrombucket;
    public boolean enablesaltfromwaterbucketrecipe;
    public int seedrarity;
    public boolean enablegigapickleCrop;
    
    public int waterfilterfreshwaterAmount;
    public int waterfiltersaltAmount;
    public int waterfilterTime;
    
    public static int saltrecipeAmount;
    public static boolean enableHCFish;
    
    public static boolean enablevanillafoodBalance;
    
    public static int topTierFood;
    public static int buffTimeForTopTier;
    
    //public static boolean bagPickUp;
    //public static boolean hotbarBagPickUp;
    //public static boolean whitelist;
    //public static String seed, crop, sapling;

    public boolean enablecroptoseedRecipe;
    public boolean enableTofuAsMeatInRecipes;
    public boolean enableTofuAsMilkInRecipes;

    public boolean enablelistAllwaterfreshwater;
    public boolean enablelistAllwatervanillawaterbucket;
    
    public boolean enablemaplesyrupslimeballPresser;
    public boolean enablehoneyslimeballPresser;


    public final HashMap<String, Boolean> seedDropFromGrass = new HashMap<String, Boolean>();

    private final Map<String, String[]> gardenDropConfig = new HashMap<String, String[]>();


    // Block configuration variables
    public int gardenRarity;
    public int gardendropAmount;
    public int gardenSpreadMax;
    public boolean enablegardenSpread;
    public int gardenspreadRate;
    public boolean enablearidgardenGeneration;
    public boolean enablefrostgardenGeneration;
    public boolean enabletropicalgardenGeneration;
    public boolean enablewindygardenGeneration;
    public boolean enableshadedgardenGeneration;
    public boolean enablesoggygardenGeneration;
    public boolean enablecropspecialplanting;

    // Market configuration
    public boolean marketsellSeeds;
    public boolean marketselltemperateSaplings;
    public boolean marketselltropicalSaplings;
    public boolean marketsellconiferousSaplings;
    public boolean marketsellPig;
    public boolean marketsellSheep;
    public boolean marketsellCow;
    public boolean marketsellChicken;
    public boolean marketsellHorse;
    public boolean marketsellLlama;
    public boolean marketsellOcelot;
    public boolean marketsellWolf;
    public boolean marketsellRabbit;
    public boolean marketsellLead;
    public boolean marketsellNametag;
    public boolean marketsellQueenbee;
    public boolean marketsellBonemeal;
    public int marketblockrecipeItem;
    public int marketseedPrice;
    public int marketsaplingPrice;
    public int marketpigPrice;
    public int marketsheepPrice;
    public int marketcowPrice;
    public int marketchickenPrice;
    public int markethorsePrice;
    public int marketllamaPrice;
    public int marketocelotPrice;
    public int marketwolfPrice;
    public int marketrabbitPrice;
    public int marketleadPrice;
    public int marketnametagPrice;
    public int marketbonemealPrice;
    public int marketqueenbeePrice;
    public int marketcurrencySeeds;
    public int marketcurrencytemperateSaplings;
    public int marketcurrencytropicalSaplings;
    public int marketcurrencyconiferousSaplings;
    public int marketcurrencyPig;
    public int marketcurrencySheep;
    public int marketcurrencyCow;
    public int marketcurrencyChicken;
    public int marketcurrencyHorse;
    public int marketcurrencyLlama;
    public int marketcurrencyOcelot;
    public int marketcurrencyWolf;
    public int marketcurrencyRabbit;
    public int marketcurrencyLead;
    public int marketcurrencyNametag;
    public int marketcurrencyBonemeal;
    public int marketcurrencyFish;
    public int marketcurrencyMeat;
    public int marketcurrencyBees;
    
    public boolean enableEasyHarvest;
    
    //Shipping Bin
    public boolean shippingbinbuyCrops;
    public int shippingbincropPrice;
    public boolean shippingbinbuyFish;
    public int shippingbinfishPrice;
    public boolean shippingbinbuyMeat;
    public int shippingbinmeatPrice;
    public boolean shippingbinbuyBees;
    public int shippingbinbeesPrice;
    public static boolean shippingbinenablevanillaMCCrops;
    public static boolean shippingbinenablevanillaMCFish;
    public static boolean shippingbinenablevanillaMCMeat;
    public static boolean shippingbinenablevanillaMCEgg;
    public static boolean shippingbinenablevanillaMCMonsterParts;
    public static boolean shippingbinenablevanillaMCBees;
    
    // Beehive config
    public boolean enableBeehiveGeneration;
    public int beehiveRarity;
    public boolean queenbeelastresultequalsQueen;
    public boolean enablebeegrubaslistAllmeat;


    public ConfigHandler(Configuration config) {
        this.config = config;

        initSettings();
    }

    private void initSettings() {
        config.load();

        initGeneralSettings();
        initCropSettings();
        initSeedDropSettings();
        initGardenSettings();
        initMarketSettings();
        initBeesSettings();
        initMiscRecipesSettings();

        if (config.hasChanged()) {
            config.save();
        }
    }

    private void initBeesSettings() {
        enableBeehiveGeneration = config.getBoolean("enableBeehiveGeneration", CATEGORY_BEE, true, "Enable generation of beehives.");
        beehiveRarity = config.getInt("beehiveRarity", CATEGORY_BEE, 10, 0, Short.MAX_VALUE, "The higher the value, the more beehives are generated.");
        queenbeelastresultequalsQueen = config.getBoolean("apiarylastresultequalsQueen", CATEGORY_BEE, true, "If true, the last item produced by a queen bee will be another queen bee.");
        enablebeegrubaslistAllmeat  = config.getBoolean("enablebeegrubaslistAllmeat", CATEGORY_BEE, true, "Allows grubs and cooked grubs to be used in listAllrawmeat and listAllcookedmeat.");
    }

    private void initGeneralSettings() {
        squiddropCalamari = config.getBoolean("squiddropCalamari", CATEGORY_GENERAL, true, "Enables squid mobs to drop raw calamari.");
        smeltsquidintocookedFish = config.getBoolean("smeltsquidintocookedFish", CATEGORY_GENERAL, false, "Enable to have raw calamari smelt into cooked fish instead.");
        enableEasyHarvest = config.getBoolean("enableEasyHarvest", CATEGORY_GENERAL, true, "Enables harvesting by right-clicking.");
        enableHCFish = config.getBoolean("enableHCFish", CATEGORY_GENERAL, true, "Enables catching of HarvestCraft fish using the normal fishing rod.");
        enablevanillafoodBalance = config.getBoolean("enablevanillafoodBalance", CATEGORY_GENERAL, true, "Makes changes to vanilla food item and drop hunger restore and saturation values to be balanced with HarvestCraft food.");
        topTierFood = config.get(CATEGORY_GENERAL, "topTierFood", 10, 
        		"Default: 10, Choose 5, 6, 7, 8, 9, or 10 shank foods which become top tier.  Foods at this level or above give buffs.  Top tier foods are always edible, so be careful!  Set to 0 to have no top tier foods.").getInt();
        buffTimeForTopTier = config.get(CATEGORY_GENERAL, "buffTimeForTopTier", 3600, "Default: 3600 or 3 minutes").getInt();
        waterfilterfreshwaterAmount = config.get(CATEGORY_GENERAL, "waterfilterfreshwaterAmount", 8, "How many Fresh Water you get per Woven Cloth in the Water Filter.  Default 8.  Use whole numbers between 0 and 64.").getInt();
        waterfiltersaltAmount = config.get(CATEGORY_GENERAL, "waterfiltersaltAmount", 8, "How many Salt you get per Woven Cloth in the Water Filter.  Default 8.  Use whole numbers between 0 and 64.").getInt();
        waterfilterTime = config.get(CATEGORY_GENERAL, "waterfilterTime", 516, "How long the Water Filter takes to run.  Default 516.  For comparison, the Presser time is 125.").getInt();
    }

    private void initCropSettings() {
        cropfoodRestore = config.get(CATEGORY_CROPS, "cropfoodRestore", defaultCropFoodRestore).getInt();
        cropsaturationRestore = (float) config.get(CATEGORY_CROPS, "cropsaturationRestore", defaultSaturationSmall).getDouble();
        snacksaturation = (float) config.get(CATEGORY_CROPS, "snacksaturation", defaultSaturationSmall).getDouble();
        mealsaturation = (float) config.get(CATEGORY_CROPS, "mealsaturation", defaultSaturationMeal).getDouble();
        meatymealsaturation = (float) config.get(CATEGORY_CROPS, "meatymealsaturation", defaultSaturationMeatyMeal).getDouble();
        enablecropspecialplanting = config.get(CATEGORY_CROPS, "enablecropspecialplanting", true).getBoolean();
        cropsdropSeeds = config.get(CATEGORY_CROPS, "cropsdropSeeds", false).getBoolean();
        cropGrowthSpeed = (float) config.get(CATEGORY_CROPS, "cropGrowthSpeed", defaultCropGrowthSpeed, "Default: 0.0, This number is added/subtracted from normal fertile crop growth (3.0) and adjacent fertile crop growth (4.0).").getDouble();
        enablegigapickleCrop = config.get(CATEGORY_CROPS, "enablegigapickleCrop", true, "Disable to keep giga pickle crop seeds from appearing in dungeon chests").getBoolean();
    }

    private void initGardenSettings() {
        gardenRarity = config.get(CATEGORY_GARDENS, "gardenRarity", 2).getInt();
        gardendropAmount = config.get(CATEGORY_GARDENS, "gardendropAmount", 3).getInt();
        enablegardenSpread = config.get(CATEGORY_GARDENS, "enablegardenSpread", true).getBoolean();
        gardenspreadRate = config.getInt("gardenSpreadRate", CATEGORY_GARDENS, 30, 1, 100, "Garden spread rate. 100 means a garden spawns every tick. 1 means a garden spawns with a probability of 1% per tick.");
        gardenSpreadMax = config.get(CATEGORY_GARDENS, "gardenspreadMax", 8).getInt();
        enablearidgardenGeneration = config.get(CATEGORY_GARDENS, "enablearidgardenGeneration", true).getBoolean();
        enablefrostgardenGeneration = config.get(CATEGORY_GARDENS, "enablefrostgardenGeneration", true).getBoolean();
        enabletropicalgardenGeneration = config.get(CATEGORY_GARDENS, "enabletropicalgardenGeneration", true).getBoolean();
        enablewindygardenGeneration = config.get(CATEGORY_GARDENS, "enablewindygardenGeneration", true).getBoolean();
        enableshadedgardenGeneration = config.get(CATEGORY_GARDENS, "enableshadedgardenGeneration", true).getBoolean();
        enablesoggygardenGeneration = config.get(CATEGORY_GARDENS, "enablesoggygardenGeneration", true).getBoolean();

        // Garden drop configuration
        gardenDropConfig.put("aridGarden", config.getStringList("aridGarden", "drops",
                new String[]{"harvestcraft:cactusfruititem", "minecraft:cactus", }, ""));
        gardenDropConfig.put("frostGarden", config.getStringList("frostGarden", "drops",
                new String[]{"harvestcraft:raspberryitem", "harvestcraft:oatsitem", "harvestcraft:ryeitem",
                        "harvestcraft:celeryitem", "harvestcraft:peasitem", "harvestcraft:beetitem",
                        "harvestcraft:rutabagaitem", "harvestcraft:broccoliitem", "harvestcraft:caulifloweritem",
                        "harvestcraft:cabbageitem", "harvestcraft:spinachitem", "harvestcraft:cottonitem"}, ""));
        gardenDropConfig.put("shadedGarden", config.getStringList("shadedGarden", "drops",
                new String[]{"harvestcraft:whitemushroomitem", "harvestcraft:blackberryitem", "harvestcraft:zucchiniitem",
                        "harvestcraft:radishitem", "harvestcraft:rhubarbitem", "harvestcraft:tealeafitem",
                        "harvestcraft:garlicitem", "harvestcraft:sweetpotatoitem", "harvestcraft:turnipitem",
                        "harvestcraft:spiceleafitem", "harvestcraft:beanitem", "harvestcraft:leekitem",
                        "harvestcraft:scallionitem", "harvestcraft:tomatoitem", "harvestcraft:cottonitem"}, ""));
        gardenDropConfig.put("soggyGarden", config.getStringList("soggyGarden", "drops",
                new String[]{"harvestcraft:brusselsproutitem", "harvestcraft:spiceleafitem", "harvestcraft:blueberryitem",
                        "harvestcraft:asparagusitem", "harvestcraft:cranberryitem", "harvestcraft:riceitem",
                        "harvestcraft:seaweeditem", "harvestcraft:waterchestnutitem", "harvestcraft:okraitem", "harvestcraft:cottonitem"}, ""));
        gardenDropConfig.put("tropicalGarden", config.getStringList("tropicalGarden", "drops",
                new String[]{"harvestcraft:grapeitem", "harvestcraft:pineappleitem", "harvestcraft:kiwiitem",
                        "harvestcraft:sesameseedsitem", "harvestcraft:curryleafitem", "harvestcraft:bambooshootitem",
                        "harvestcraft:cantaloupeitem", "harvestcraft:gingeritem", "harvestcraft:coffeebeanitem",
                        "harvestcraft:soybeanitem", "harvestcraft:eggplantitem", "harvestcraft:cottonitem"}, ""));
        gardenDropConfig.put("windyGarden", config.getStringList("windyGarden", "drops",
                new String[]{"harvestcraft:strawberryitem", "harvestcraft:barleyitem", "harvestcraft:cornitem",
                        "harvestcraft:cucumberitem", "harvestcraft:wintersquashitem", "harvestcraft:mustardseedsitem",
                        "harvestcraft:onionitem", "harvestcraft:parsnipitem", "harvestcraft:peanutitem",
                        "minecraft:potato", "minecraft:carrot", "harvestcraft:lettuceitem",
                        "harvestcraft:artichokeitem", "harvestcraft:bellpepperitem", "harvestcraft:chilipepperitem",
                        "minecraft:wheat", "harvestcraft:cottonitem"}, ""));
    }
    
    private void initMarketSettings() {
        marketsellSeeds = config.get(CATEGORY_MARKET_SALES, "marketsellSeeds", true).getBoolean();
        marketselltemperateSaplings = config.get(CATEGORY_MARKET_SALES, "marketselltemperateSaplings", true).getBoolean();
        marketselltropicalSaplings = config.get(CATEGORY_MARKET_SALES, "marketselltropicalSaplings", true).getBoolean();
        marketsellconiferousSaplings = config.get(CATEGORY_MARKET_SALES, "marketsellconiferousSaplings", true).getBoolean();
        marketsellPig = config.get(CATEGORY_MARKET_SALES, "marketsellPig", true).getBoolean();
        marketsellSheep = config.get(CATEGORY_MARKET_SALES, "marketsellSheep", true).getBoolean();
        marketsellCow = config.get(CATEGORY_MARKET_SALES, "marketsellCow", true).getBoolean();
        marketsellChicken = config.get(CATEGORY_MARKET_SALES, "marketsellChicken", true).getBoolean();
        marketsellHorse = config.get(CATEGORY_MARKET_SALES, "marketsellHorse", true).getBoolean();
        marketsellLlama = config.get(CATEGORY_MARKET_SALES, "marketsellLlama", true).getBoolean();
        marketsellOcelot = config.get(CATEGORY_MARKET_SALES, "marketsellOcelot", true).getBoolean();
        marketsellWolf = config.get(CATEGORY_MARKET_SALES, "marketsellWolf", true).getBoolean();
        marketsellRabbit = config.get(CATEGORY_MARKET_SALES, "marketsellRabbit", true).getBoolean();
        marketsellLead = config.get(CATEGORY_MARKET_SALES, "marketsellLead", true).getBoolean();
        marketsellNametag = config.get(CATEGORY_MARKET_SALES, "marketsellNametag", true).getBoolean();
        marketsellBonemeal = config.get(CATEGORY_MARKET_SALES, "marketsellBonemeal", true).getBoolean();
        marketsellQueenbee = config.get(CATEGORY_MARKET_SALES, "marketsellQueenbee", true).getBoolean();
        marketseedPrice = config.get(CATEGORY_MARKET_PRICES, "marketseedPrice", 1).getInt();
        marketsaplingPrice = config.get(CATEGORY_MARKET_PRICES, "marketsaplingPrice", 3).getInt();
        marketpigPrice = config.get(CATEGORY_MARKET_PRICES, "marketpigPrice", 6).getInt();
        marketsheepPrice = config.get(CATEGORY_MARKET_PRICES, "marketsheepPrice", 6).getInt();
        marketcowPrice = config.get(CATEGORY_MARKET_PRICES, "marketcowPrice", 9).getInt();
        marketchickenPrice = config.get(CATEGORY_MARKET_PRICES, "marketchickenPrice", 3).getInt();
        markethorsePrice = config.get(CATEGORY_MARKET_PRICES, "markethorsePrice", 12).getInt();
        marketllamaPrice = config.get(CATEGORY_MARKET_PRICES, "marketllamaPrice", 12).getInt();
        marketocelotPrice = config.get(CATEGORY_MARKET_PRICES, "marketocelotPrice", 9).getInt();
        marketwolfPrice = config.get(CATEGORY_MARKET_PRICES, "marketwolfPrice", 9).getInt();
        marketrabbitPrice = config.get(CATEGORY_MARKET_PRICES, "marketrabbitPrice", 3).getInt();
        marketleadPrice = config.get(CATEGORY_MARKET_PRICES, "marketleadPrice", 1).getInt();
        marketnametagPrice = config.get(CATEGORY_MARKET_PRICES, "marketnametagPrice", 1).getInt();
        marketbonemealPrice = config.get(CATEGORY_MARKET_PRICES, "marketbonemealPrice", 3).getInt();
        marketqueenbeePrice = config.get(CATEGORY_MARKET_PRICES, "marketqueenbeePrice", 3).getInt();
        marketcurrencySeeds = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencySeeds", 0).getInt();
        marketcurrencytemperateSaplings = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencytemperateSaplings", 0).getInt();
        marketcurrencytropicalSaplings = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencytropicalSaplings", 0).getInt();
        marketcurrencyconiferousSaplings = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyconiferousSaplings", 0).getInt();
        marketcurrencyPig = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyPig", 0).getInt();
        marketcurrencySheep = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencySheep", 0).getInt();
        marketcurrencyCow = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyCow", 0).getInt();
        marketcurrencyChicken = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyChicken", 0).getInt();
        marketcurrencyHorse = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyHorse", 0).getInt();
        marketcurrencyLlama = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyLlama", 0).getInt();
        marketcurrencyOcelot = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyOcelot", 0).getInt();
        marketcurrencyWolf = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyWolf", 0).getInt();
        marketcurrencyRabbit = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyRabbit", 0).getInt();
        marketcurrencyLead = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyLead", 0).getInt();
        marketcurrencyNametag = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyNametag", 0).getInt();
        marketcurrencyBonemeal = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyBonemeal", 0).getInt();
        marketcurrencyFish = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyFish", 0).getInt();
        marketcurrencyMeat = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyMeat", 0).getInt();
        marketcurrencyBees = config.get(CATEGORY_MARKET_CURRENCY, "marketcurrencyBees", 0).getInt();
        
        shippingbinbuyCrops = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinbuyCrops", true).getBoolean();
        shippingbincropPrice = config.get(CATEGORY_SHIPPINGBIN_PRICES, "shippingbincropPrice", 32).getInt();
        shippingbinbuyFish = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinbuyFish", true).getBoolean();
        shippingbinfishPrice = config.get(CATEGORY_SHIPPINGBIN_PRICES, "shippingbinfishPrice", 16).getInt();
        shippingbinbuyMeat = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinbuyMeat", true).getBoolean();
        shippingbinmeatPrice = config.get(CATEGORY_SHIPPINGBIN_PRICES, "shippingbinmeatPrice", 16).getInt();
        shippingbinbuyBees = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinbuyBees", true).getBoolean();
        shippingbinbeesPrice = config.get(CATEGORY_SHIPPINGBIN_PRICES, "shippingbinbeesPrice", 16).getInt();
        shippingbinenablevanillaMCCrops = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCCrops", true).getBoolean();
        shippingbinenablevanillaMCFish = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCFish", true).getBoolean();
        shippingbinenablevanillaMCMeat = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCMeat", true).getBoolean();
        shippingbinenablevanillaMCEgg = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCEgg", true).getBoolean();
        shippingbinenablevanillaMCMonsterParts = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCMonsterParts", true).getBoolean();
        shippingbinenablevanillaMCBees = config.get(CATEGORY_SHIPPINGBIN_PURCHASES, "shippingbinenablevanillaMCBees", true).getBoolean();
    }

    private void initSeedDropSettings() {
        seedrarity = config.get(CATEGORY_SEEDS, "seedrarity", 1).getInt();

        
        
        initSeedDropFromGrassSetting("asparagusseeddropfromgrass", CropRegistry.ASPARAGUS);
        initSeedDropFromGrassSetting("barleyseeddropfromgrass", CropRegistry.BARLEY);
        initSeedDropFromGrassSetting("beanseeddropfromgrass", CropRegistry.BEAN);
        initSeedDropFromGrassSetting("beetseeddropfromgrass", CropRegistry.BEET);
        initSeedDropFromGrassSetting("broccoliseeddropfromgrass", CropRegistry.BROCCOLI);
        initSeedDropFromGrassSetting("cauliflowerseeddropfromgrass", CropRegistry.CAULIFLOWER);
        initSeedDropFromGrassSetting("celeryseeddropfromgrass", CropRegistry.CELERY);
        initSeedDropFromGrassSetting("cranberryseeddropfromgrass", CropRegistry.CRANBERRY);
        initSeedDropFromGrassSetting("garlicseeddropfromgrass", CropRegistry.GARLIC);
        initSeedDropFromGrassSetting("gingerseeddropfromgrass", CropRegistry.GINGER);
        initSeedDropFromGrassSetting("leekseeddropfromgrass", CropRegistry.LEEK);
        initSeedDropFromGrassSetting("lettuceseeddropfromgrass", CropRegistry.LETTUCE);
        initSeedDropFromGrassSetting("oatsseeddropfromgrass", CropRegistry.OATS);
        initSeedDropFromGrassSetting("onionseeddropfromgrass", CropRegistry.ONION);
        initSeedDropFromGrassSetting("parsnipseeddropfromgrass", CropRegistry.PARSNIP);
        initSeedDropFromGrassSetting("peanutseeddropfromgrass", CropRegistry.PEANUT);
        initSeedDropFromGrassSetting("pineappleseeddropfromgrass", CropRegistry.PINEAPPLE);
        initSeedDropFromGrassSetting("radishseeddropfromgrass", CropRegistry.RADISH);
        initSeedDropFromGrassSetting("riceseeddropfromgrass", CropRegistry.RICE);
        initSeedDropFromGrassSetting("rutabagaseeddropfromgrass", CropRegistry.RUTABAGA);
        initSeedDropFromGrassSetting("ryeseeddropfromgrass", CropRegistry.RYE);
        initSeedDropFromGrassSetting("scallionseeddropfromgrass", CropRegistry.SCALLION);
        initSeedDropFromGrassSetting("soybeanseeddropfromgrass", CropRegistry.SOYBEAN);
        initSeedDropFromGrassSetting("spiceleafseeddropfromgrass", CropRegistry.SPICELEAF);
        initSeedDropFromGrassSetting("sweetpotatoseeddropfromgrass", CropRegistry.SWEETPOTATO);
        initSeedDropFromGrassSetting("teaseeddropfromgrass", CropRegistry.TEALEAF);
        initSeedDropFromGrassSetting("turnipseeddropfromgrass", CropRegistry.TURNIP);
        initSeedDropFromGrassSetting("whitemushroomseeddropfromgrass", CropRegistry.WHITEMUSHROOM);

        initSeedDropFromGrassSetting("artichokeseeddropfromgrass", CropRegistry.ARTICHOKE);
        initSeedDropFromGrassSetting("bellpepperseeddropfromgrass", CropRegistry.BELLPEPPER);
        initSeedDropFromGrassSetting("blackberryseeddropfromgrass", CropRegistry.BLACKBERRY);
        initSeedDropFromGrassSetting("blueberryseeddropfromgrass", CropRegistry.BLUEBERRY);
        initSeedDropFromGrassSetting("brusselsproutseeddropfromgrass", CropRegistry.BRUSSELSPROUT);
        initSeedDropFromGrassSetting("cabbageseeddropfromgrass", CropRegistry.CABBAGE);
        initSeedDropFromGrassSetting("cactusfruitseeddropfromgrass", CropRegistry.CACTUSFRUIT);
        initSeedDropFromGrassSetting("candleberryseeddropfromgrass", CropRegistry.CANDLEBERRY);
        initSeedDropFromGrassSetting("cantaloupeseeddropfromgrass", CropRegistry.CANTALOUPE);
        initSeedDropFromGrassSetting("chilipepperseeddropfromgrass", CropRegistry.CHILIPEPPER);
        initSeedDropFromGrassSetting("coffeeseeddropfromgrass", CropRegistry.COFFEE);
        initSeedDropFromGrassSetting("cornseeddropfromgrass", CropRegistry.CORN);
        initSeedDropFromGrassSetting("cottonseeddropfromgrass", CropRegistry.COTTON);
        initSeedDropFromGrassSetting("cucumberseeddropfromgrass", CropRegistry.CUCUMBER);
        initSeedDropFromGrassSetting("eggplantseeddropfromgrass", CropRegistry.EGGPLANT);
        initSeedDropFromGrassSetting("grapeseeddropfromgrass", CropRegistry.GRAPE);
        initSeedDropFromGrassSetting("kiwiseeddropfromgrass", CropRegistry.KIWI);
        initSeedDropFromGrassSetting("mustardseeddropfromgrass", CropRegistry.MUSTARD);
        initSeedDropFromGrassSetting("okraseeddropfromgrass", CropRegistry.OKRA);
        initSeedDropFromGrassSetting("peasseeddropfromgrass", CropRegistry.PEAS);
        initSeedDropFromGrassSetting("raspberryseeddropfromgrass", CropRegistry.RASPBERRY);
        initSeedDropFromGrassSetting("rhubarbseeddropfromgrass", CropRegistry.RHUBARB);
        initSeedDropFromGrassSetting("seaweedseeddropfromgrass", CropRegistry.SEAWEED);
        initSeedDropFromGrassSetting("strawberryseeddropfromgrass", CropRegistry.STRAWBERRY);
        initSeedDropFromGrassSetting("tomatoseeddropfromgrass", CropRegistry.TOMATO);
        initSeedDropFromGrassSetting("wintersquashseeddropfromgrass", CropRegistry.WINTERSQUASH);
        initSeedDropFromGrassSetting("zucchiniseeddropfromgrass", CropRegistry.ZUCCHINI);
        initSeedDropFromGrassSetting("bambooshootseeddropfromgrass", CropRegistry.BAMBOOSHOOT);
        initSeedDropFromGrassSetting("spinachseeddropfromgrass", CropRegistry.SPINACH);
        initSeedDropFromGrassSetting("curryleafseeddropfromgrass", CropRegistry.CURRYLEAF);
        initSeedDropFromGrassSetting("sesameseedsseeddropfromgrass", CropRegistry.SESAME);
        initSeedDropFromGrassSetting("waterchestnutseeddropfromgrass", CropRegistry.WATERCHESTNUT);
    }

    private void initMiscRecipesSettings() {
        enablesaltfromwaterbucketrecipe = config.get(CATEGORY_MISC_RECIPES, "enablesaltfromwaterbucketrecipe", true).getBoolean();
        enablecroptoseedRecipe = config.get(CATEGORY_MISC_RECIPES, "enablecroptoseedRecipe", true).getBoolean();
        enableTofuAsMeatInRecipes = config.get(CATEGORY_MISC_RECIPES, "enabletofuasmeatinRecipes", true).getBoolean();
        enableTofuAsMilkInRecipes = config.get(CATEGORY_MISC_RECIPES, "enabletofuasmilkinRecipes", true).getBoolean();
        enablelistAllwaterfreshwater = config.get(CATEGORY_MISC_RECIPES, "enablelistAllwaterfreshwater", true).getBoolean();
        enablelistAllwatervanillawaterbucket = config.get(CATEGORY_MISC_RECIPES, "enablelistAllwatervanillawaterbucket", true).getBoolean();
        marketblockrecipeItem = config.get(CATEGORY_MISC_RECIPES, "marketblockrecipeItem", 0).getInt();
        enablemaplesyrupslimeballPresser = config.get(CATEGORY_MISC_RECIPES, "enablemaplesyrupslimeballPresser", true).getBoolean();
        enablehoneyslimeballPresser = config.get(CATEGORY_MISC_RECIPES, "enablehoneyslimeballPresser", true).getBoolean();
    }

    private void initSeedDropFromGrassSetting(String key, String item) {
        boolean doDrop = config.get(CATEGORY_SEEDS, key, false).getBoolean();

        seedDropFromGrass.put(item, doDrop);
    }

    /**
     * Configures drops from the various gardens; this needs to happen after the item registries are updated
     */
    public void configureGardenDrops() {
        final Pattern ITEM_STACK_PATTERN = Pattern.compile("(?:([0-9]+)x)?([\\w:]+)(?:[@:]([0-9]+))?");
        final Matcher ITEM_STACK_MATCHER = ITEM_STACK_PATTERN.matcher("");

        for (String garden : gardenDropConfig.keySet()) {
            HarvestCraft.log.info("Registering drops for %s.", garden);

            final List<ItemStack> drops = new ArrayList<ItemStack>();
            final String[] itemNames = gardenDropConfig.get(garden);

            for (String baseItemName : itemNames) {
                ITEM_STACK_MATCHER.reset(baseItemName);
                if (ITEM_STACK_MATCHER.find()) {
                    final String itemName = ITEM_STACK_MATCHER.group(2);
                    int metadata = 0;
                    if (ITEM_STACK_MATCHER.group(3) != null) {
                        metadata = Integer.parseInt(ITEM_STACK_MATCHER.group(3));
                    }
                    int stackSize = 1;
                    if (ITEM_STACK_MATCHER.group(1) != null) {
                        stackSize = Integer.parseInt(ITEM_STACK_MATCHER.group(1));
                    }
                    final ItemStack drop = GameRegistry.makeItemStack(itemName, metadata, stackSize, null);

                    // Check to make sure we got a valid item
                    if (drop != null) {
                        drops.add(drop);
                    } else {
                        // Otherwise, let the user know about it...
                        HarvestCraft.log.error("Unable to find item %s to add to this garden.", baseItemName);
                    }
                }
            }

            BlockBaseGarden.drops.put(garden, drops);
        }
    }
}
