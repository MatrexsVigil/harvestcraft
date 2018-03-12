package com.pam.harvestcraft.blocks;

import java.text.MessageFormat;
import java.util.HashMap;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.growables.BlockPamCrop;
import com.pam.harvestcraft.item.items.ItemPamItemSeeds;
import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.item.items.ItemPamSeedFood;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraftforge.fml.common.FMLLog;

public class CropRegistry {

	public static final String CROP_BLOCK_NAME = "pam{0}crop";
	public static final String ITEM_NAME = "{0}item";
	public static final String SEED_ITEM_NAME = "{0}seeditem";

	public static final String BLACKBERRY = "blackberry";
	public static final String BLUEBERRY = "blueberry";
	public static final String CANDLEBERRY = "candleberry";
	public static final String RASPBERRY = "raspberry";
	public static final String STRAWBERRY = "strawberry";
	public static final String CACTUSFRUIT = "cactusfruit";
	public static final String ASPARAGUS = "asparagus";
	public static final String BARLEY = "barley";
	public static final String OATS = "oats";
	public static final String RYE = "rye";
	public static final String CORN = "corn";
	public static final String BAMBOOSHOOT = "bambooshoot";
	public static final String CANTALOUPE = "cantaloupe";
	public static final String CUCUMBER = "cucumber";
	public static final String WINTERSQUASH = "wintersquash";
	public static final String ZUCCHINI = "zucchini";
	public static final String BEET = "beet";
	public static final String ONION = "onion";
	public static final String PARSNIP = "parsnip";
	public static final String PEANUT = "peanut";
	public static final String RADISH = "radish";
	public static final String RUTABAGA = "rutabaga";
	public static final String SWEETPOTATO = "sweetpotato";
	public static final String TURNIP = "turnip";
	public static final String RHUBARB = "rhubarb";
	public static final String CELERY = "celery";
	public static final String GARLIC = "garlic";
	public static final String GINGER = "ginger";
	public static final String SPICELEAF = "spiceleaf";
	public static final String TEALEAF = "tealeaf";
	public static final String COFFEE = "coffeebean";
	public static final String MUSTARD = "mustardseeds";
	public static final String BROCCOLI = "broccoli";
	public static final String CAULIFLOWER = "cauliflower";
	public static final String LEEK = "leek";
	public static final String LETTUCE = "lettuce";
	public static final String SCALLION = "scallion";
	public static final String ARTICHOKE = "artichoke";
	public static final String BRUSSELSPROUT = "brusselsprout";
	public static final String CABBAGE = "cabbage";
	public static final String SPINACH = "spinach";
	public static final String WHITEMUSHROOM = "whitemushroom";
	public static final String BEAN = "bean";
	public static final String SOYBEAN = "soybean";
	public static final String BELLPEPPER = "bellpepper";
	public static final String CHILIPEPPER = "chilipepper";
	public static final String EGGPLANT = "eggplant";
	public static final String OKRA = "okra";
	public static final String PEAS = "peas";
	public static final String TOMATO = "tomato";
	public static final String COTTON = "cotton";
	public static final String PINEAPPLE = "pineapple";
	public static final String GRAPE = "grape";
	public static final String KIWI = "kiwi";
	public static final String CRANBERRY = "cranberry";
	public static final String RICE = "rice";
	public static final String SEAWEED = "seaweed";
	public static final String CURRYLEAF = "curryleaf";
	public static final String SESAME = "sesameseeds";
	public static final String WATERCHESTNUT = "waterchestnut";
	public static final String GIGAPICKLE = "gigapickle";

	public static final String[] cropNames = new String[] {BLACKBERRY, BLUEBERRY, CANDLEBERRY, RASPBERRY, STRAWBERRY,
			CACTUSFRUIT, ASPARAGUS, BARLEY, OATS, RYE, CORN, BAMBOOSHOOT, CANTALOUPE, CUCUMBER, WINTERSQUASH, ZUCCHINI,
			BEET, ONION, PARSNIP, PEANUT, RADISH, RUTABAGA, SWEETPOTATO, TURNIP, RHUBARB, CELERY, GARLIC, GINGER,
			SPICELEAF, TEALEAF, COFFEE, MUSTARD, BROCCOLI, CAULIFLOWER, LEEK, LETTUCE, SCALLION, ARTICHOKE,
			BRUSSELSPROUT, CABBAGE, SPINACH, WHITEMUSHROOM, BEAN, SOYBEAN, BELLPEPPER, CHILIPEPPER, EGGPLANT, OKRA,
			PEAS, TOMATO, COTTON, PINEAPPLE, GRAPE, KIWI, CRANBERRY, RICE, SEAWEED, CURRYLEAF, SESAME, WATERCHESTNUT, GIGAPICKLE};

	private static boolean isInitialized = false;

	private static final HashMap<String, Item> seeds = new HashMap<String, Item>();
	private static final HashMap<String, ItemSeedFood> foods = new HashMap<String, ItemSeedFood>();

	private static final HashMap<String, BlockPamCrop> crops = new HashMap<String, BlockPamCrop>();

	public static HashMap<String, Item> getSeeds() {
		return seeds;
	}

	public static HashMap<String, ItemSeedFood> getFoods() {
		return foods;
	}

	public static HashMap<String, BlockPamCrop> getCrops() {
		if(!isInitialized) {
			FMLLog.bigWarning("Crop registry is not initialized.");
			return new HashMap<String, BlockPamCrop>();
		}
		return crops;
	}

	public static boolean isInitialized() {
		return isInitialized;
	}

	public static Item getSeed(String cropName) {
		if(!isInitialized()) {
			FMLLog.bigWarning("Crop registry has not been initialized yet.");
			return null;
		}

		if(!seeds.containsKey(cropName)) {
			FMLLog.bigWarning("No seed for key %s", cropName);
			return null;
		}

		return seeds.get(cropName);
	}

	public static ItemSeedFood getFood(String cropName) {
		if(!isInitialized()) {
			FMLLog.bigWarning("Crop registry has not been initialized yet.");
			return null;
		}

		if(!foods.containsKey(cropName)) {
			FMLLog.bigWarning("No food for key %s", cropName);
			return null;
		}

		return foods.get(cropName);
	}

	public static BlockPamCrop getCrop(String cropName) {
		if(!isInitialized()) {
			FMLLog.bigWarning("Crop registry has not been initialized yet.");
			return null;
		}

		if(!crops.containsKey(cropName)) {
			FMLLog.bigWarning("No crop for key %s", cropName);
			return null;
		}

		return crops.get(cropName);
	}

	public static void registerCrops() {
		if(isInitialized)
			return;

		for(String cropName : cropNames) {
			registerCrop(cropName);
		}

		isInitialized = true;
	}

	private static void registerCrop(String cropName) {
		final String registryName = MessageFormat.format(CROP_BLOCK_NAME, cropName);
		final BlockPamCrop cropBlock = new BlockPamCrop(registryName, cropName);

		BlockRegistry.registerBlock(registryName, null, cropBlock);

		final ItemSeedFood item = createItem(cropBlock);
		ItemRegistry.registerItem(item, MessageFormat.format(ITEM_NAME, cropName));
		cropBlock.setFood(item);

		final Item seedItem = createSeed(cropBlock);
		ItemRegistry.registerItem(seedItem, getSeedName(cropName));
		cropBlock.setSeed(seedItem);

		seeds.put(cropName, seedItem);
		foods.put(cropName, item);
		crops.put(cropName, cropBlock);
	}

	private static String getSeedName(String cropName) {
		// Some seeds were named inconsistently. To create compatibility with world running on
		// HarvestCraft before version 1.9b, we fix these names here.

		if(cropName.equals(COFFEE)) {
			return "coffeeseeditem";
		}

		if(cropName.equals(MUSTARD)) {
			return "mustardseeditem";
		}

		if(cropName.equals(TEALEAF)) {
			return "teaseeditem";
		}

		return MessageFormat.format(SEED_ITEM_NAME, cropName);
	}

	private static ItemPamSeedFood createItem(BlockPamCrop cropBlock) {
		return new ItemPamSeedFood(HarvestCraft.config.cropfoodRestore, HarvestCraft.config.cropsaturationRestore,
				cropBlock);
	}

	private static Item createSeed(BlockPamCrop cropBlock) {
		return new ItemPamItemSeeds(cropBlock, Blocks.FARMLAND);
	}
}
