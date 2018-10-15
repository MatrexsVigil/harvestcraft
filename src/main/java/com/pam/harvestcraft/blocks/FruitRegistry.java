package com.pam.harvestcraft.blocks;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.growables.BlockPamFruit;
import com.pam.harvestcraft.blocks.growables.BlockPamFruitLog;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling.SaplingType;
import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.item.items.ItemPamFood;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.FMLLog;

public class FruitRegistry {

	private static final String FRUIT_BLOCK_NAME = "pam{0}";
	private static final String ITEM_NAME = "{0}item";
	private static final String SAPLING_NAME = "{0}_sapling";

	public static final String APPLE = "apple";
	public static final String ALMOND = "almond";
	public static final String APRICOT = "apricot";
	public static final String AVOCADO = "avocado";
	public static final String BANANA = "banana";
	public static final String CASHEW = "cashew";
	public static final String CHERRY = "cherry";
	public static final String CHESTNUT = "chestnut";
	public static final String COCONUT = "coconut";
	public static final String DATE = "date";
	public static final String DRAGONFRUIT = "dragonfruit";
	public static final String DURIAN = "durian";
	public static final String FIG = "fig";
	public static final String GOOSEBERRY = "gooseberry";
	public static final String GRAPEFRUIT = "grapefruit";
	public static final String LEMON = "lemon";
	public static final String LIME = "lime";
	public static final String MANGO = "mango";
	public static final String NUTMEG = "nutmeg";
	public static final String OLIVE = "olive";
	public static final String ORANGE = "orange";
	public static final String PAPAYA = "papaya";
	public static final String PEACH = "peach";
	public static final String PEAR = "pear";
	public static final String PECAN = "pecan";
	public static final String PEPPERCORN = "peppercorn";
	public static final String PERSIMMON = "persimmon";
	public static final String PISTACHIO = "pistachio";
	public static final String PLUM = "plum";
	public static final String POMEGRANATE = "pomegranate";
	public static final String STARFRUIT = "starfruit";
	public static final String VANILLABEAN = "vanillabean";
	public static final String WALNUT = "walnut";
	public static final String SPIDERWEB = "spiderweb";
	public static final String HAZELNUT = "hazelnut";
	public static final String PAWPAW = "pawpaw";
	public static final String SOURSOP = "soursop";
	public static final String BREADFRUIT = "breadfruit";
	public static final String GUAVA = "guava";
	public static final String JACKFRUIT = "jackfruit";
	public static final String LYCHEE = "lychee";
	public static final String PASSIONFRUIT = "passionfruit";
	public static final String RAMBUTAN = "rambutan";
	public static final String TAMARIND = "tamarind";

	public static final String CINNAMON = "cinnamon";
	public static final String MAPLE = "maple";
	public static final String PAPERBARK = "paperbark";

	public static final HashMap<String, SaplingType> registeringFruits = new HashMap<String, SaplingType>();
	public static final HashMap<String, SaplingType> registeringLogFruits = new HashMap<String, SaplingType>();

	static {
		registeringFruits.put(APPLE, SaplingType.TEMPERATE);
		registeringFruits.put(ALMOND, SaplingType.WARM);
		registeringFruits.put(APRICOT, SaplingType.WARM);
		registeringFruits.put(AVOCADO, SaplingType.TEMPERATE);
		registeringFruits.put(BANANA, SaplingType.WARM);
		registeringFruits.put(CASHEW, SaplingType.WARM);
		registeringFruits.put(CHERRY, SaplingType.TEMPERATE);
		registeringFruits.put(CHESTNUT, SaplingType.TEMPERATE);
		registeringFruits.put(COCONUT, SaplingType.WARM);
		registeringFruits.put(DATE, SaplingType.WARM);
		registeringFruits.put(DRAGONFRUIT, SaplingType.WARM);
		registeringFruits.put(DURIAN, SaplingType.WARM);
		registeringFruits.put(FIG, SaplingType.WARM);
		registeringFruits.put(GOOSEBERRY, SaplingType.TEMPERATE);
		registeringFruits.put(GRAPEFRUIT, SaplingType.WARM);
		registeringFruits.put(LEMON, SaplingType.WARM);
		registeringFruits.put(LIME, SaplingType.WARM);
		registeringFruits.put(MANGO, SaplingType.WARM);
		registeringFruits.put(NUTMEG, SaplingType.TEMPERATE);
		registeringFruits.put(OLIVE, SaplingType.WARM);
		registeringFruits.put(ORANGE, SaplingType.WARM);
		registeringFruits.put(PAPAYA, SaplingType.WARM);
		registeringFruits.put(PEACH, SaplingType.WARM);
		registeringFruits.put(PEAR, SaplingType.TEMPERATE);
		registeringFruits.put(PECAN, SaplingType.WARM);
		registeringFruits.put(PEPPERCORN, SaplingType.WARM);
		registeringFruits.put(PERSIMMON, SaplingType.WARM);
		registeringFruits.put(PISTACHIO, SaplingType.WARM);
		registeringFruits.put(PLUM, SaplingType.TEMPERATE);
		registeringFruits.put(POMEGRANATE, SaplingType.WARM);
		registeringFruits.put(STARFRUIT, SaplingType.WARM);
		registeringFruits.put(VANILLABEAN, SaplingType.WARM);
		registeringFruits.put(WALNUT, SaplingType.TEMPERATE);
		registeringFruits.put(SPIDERWEB, SaplingType.TEMPERATE);
		registeringFruits.put(HAZELNUT, SaplingType.TEMPERATE);
		registeringFruits.put(PAWPAW, SaplingType.TEMPERATE);
		registeringFruits.put(SOURSOP, SaplingType.TEMPERATE);
		registeringFruits.put(BREADFRUIT, SaplingType.WARM);
		registeringFruits.put(GUAVA, SaplingType.WARM);
		registeringFruits.put(JACKFRUIT, SaplingType.WARM);
		registeringFruits.put(LYCHEE, SaplingType.WARM);
		registeringFruits.put(PASSIONFRUIT, SaplingType.WARM);
		registeringFruits.put(RAMBUTAN, SaplingType.WARM);
		registeringFruits.put(TAMARIND, SaplingType.WARM);
		
		registeringLogFruits.put(CINNAMON, SaplingType.WARM);
		registeringLogFruits.put(MAPLE, SaplingType.COLD);
		registeringLogFruits.put(PAPERBARK, SaplingType.WARM);
	}
	private static boolean isInitialised = false;

	public static final HashMap<String, BlockPamSapling> temperateSaplings = new HashMap<String, BlockPamSapling>();
	public static final HashMap<String, BlockPamSapling> warmSaplings = new HashMap<String, BlockPamSapling>();
	public static final HashMap<String, BlockPamSapling> logSaplings = new HashMap<String, BlockPamSapling>();
	public static final HashMap<String, BlockPamSapling> coldSaplings = new HashMap<String, BlockPamSapling>();
	private static final HashMap<String, BlockPamSapling> saplings = new HashMap<String, BlockPamSapling>();

	public static final HashSet<BlockPamFruit> fruits = new HashSet<BlockPamFruit>();
	public static final HashMap<String, BlockPamFruitLog> logs = new HashMap<String, BlockPamFruitLog>();

	public static final HashMap<String, Item> foodItems = new HashMap<String, Item>();

	public static Collection<BlockPamSapling> getSaplings() {
		if(!isInitialised) {
			FMLLog.bigWarning("FruitRegistry has not been initialised yet.");
			return new HashSet<BlockPamSapling>();
		}

		return saplings.values();
	}

	public static BlockPamSapling getSapling(String fruitName) {
		if(!isInitialised) {
			FMLLog.bigWarning("FruitRegistry has not been initialised yet.");
			return null;
		}

		if(!saplings.containsKey(fruitName)) {
			FMLLog.bigWarning("%s is not registered in saplings map.", fruitName);
			return null;
		}

		return saplings.get(fruitName);
	}

	public static Item getFood(String fruitName) {
		if(!isInitialised) {
			FMLLog.bigWarning("FruitRegistry has not been initialised yet.");
			return null;
		}

		if(!foodItems.containsKey(fruitName)) {
			FMLLog.bigWarning("%s is not registered in food map.", fruitName);
			return null;
		}

		return foodItems.get(fruitName);
	}

	public static BlockPamFruitLog getLog(String fruitName) {
		if(!isInitialised) {
			FMLLog.bigWarning("FruitRegistry has not been initialised yet.");
			return null;
		}

		if(!logs.containsKey(fruitName)) {
			FMLLog.bigWarning("%s is not registered in log fruit map.", fruitName);
			return null;
		}

		return logs.get(fruitName);
	}

	public static void registerFruits() {
		if(isInitialised)
			return;

		for(Map.Entry<String, SaplingType> entry : registeringFruits.entrySet()) {
			registerFruit(entry.getKey(), entry.getValue());
		}

		for(Map.Entry<String, SaplingType> entry : registeringLogFruits.entrySet()) {
			registerLogFruit(entry.getKey(), entry.getValue());
		}

		saplings.putAll(temperateSaplings);
		saplings.putAll(warmSaplings);
		saplings.putAll(coldSaplings);
		saplings.putAll(logSaplings);

		isInitialised = true;
	}

	private static void registerFruit(String fruitName, SaplingType saplingType) {
		final String saplingName = MessageFormat.format(SAPLING_NAME, fruitName);
		final BlockPamSapling sapling = new BlockPamSapling(saplingName, saplingType);
		final ItemBlock saplingItemBlock = new ItemBlock(sapling);
		BlockRegistry.registerBlock(saplingName, saplingItemBlock, sapling);

		if(saplingType.equals(SaplingType.TEMPERATE)) {
			temperateSaplings.put(fruitName, sapling);
		}
		else if(saplingType.equals(SaplingType.WARM)) {
			warmSaplings.put(fruitName, sapling);
		}

		BlockPamFruit pamFruit;

		/**
		 * switch (fruitName) {
		 * case APPLE:
		 * pamFruit = new BlockPamFruit(sapling, Items.APPLE);
		 * foodItems.put(fruitName, Items.APPLE);
		 * break;
		 * default:
		 * final Item foodItem = new ItemPamFood(HarvestCraft.config.cropfoodRestore,
		 * HarvestCraft.config.snacksaturation);
		 * foodItems.put(fruitName, foodItem);
		 * final Item fruit = ItemRegistry.registerItem(foodItem, getItemName(fruitName));
		 * pamFruit = new BlockPamFruit(sapling, fruit);
		 * fruits.add(pamFruit);
		 * break;
		 * }
		 */

		if(fruitName.equals(APPLE)) {
			pamFruit = new BlockPamFruit(sapling, Items.APPLE);
			foodItems.put(fruitName, Items.APPLE);
		} else
		if(fruitName.equals(SPIDERWEB)) {
			pamFruit = new BlockPamFruit(sapling, Items.STRING);
			foodItems.put(fruitName, Items.STRING);
		}
		else {
			final Item foodItem =
					new ItemPamFood(HarvestCraft.config.cropfoodRestore, HarvestCraft.config.snacksaturation);
			foodItems.put(fruitName, foodItem);
			final Item fruit = ItemRegistry.registerItem(foodItem, getItemName(fruitName));
			pamFruit = new BlockPamFruit(sapling, fruit);
			fruits.add(pamFruit);
		}

		sapling.setFruit(pamFruit);

		BlockRegistry.registerBlock(getFruitBlockName(fruitName), new ItemBlock(pamFruit), pamFruit);
	}

	private static String getFruitBlockName(String fruitName) {
		return MessageFormat.format(FRUIT_BLOCK_NAME, fruitName);
	}

	private static String getItemName(String fruitName) {
		// For some reason, the item for maple trees is maplesyrupItem, not mapleItem.
		// We fix this here.
		if(fruitName.equals(MAPLE))
			return "maplesyrupitem";

		return MessageFormat.format(ITEM_NAME, fruitName);
	}

	private static void registerLogFruit(String fruitName, SaplingType saplingType) {
		fruitName.toLowerCase(Locale.ROOT);
		final String saplingName = MessageFormat.format(SAPLING_NAME, fruitName);
		final BlockPamSapling sapling = new BlockPamSapling(saplingName, saplingType);
		final ItemBlock saplingItemBlock = new ItemBlock(sapling);
		BlockRegistry.registerBlock(saplingName, saplingItemBlock, sapling);

		if(saplingType.equals(SaplingType.TEMPERATE)) {
			temperateSaplings.put(fruitName, sapling);
		}
		else if(saplingType.equals(SaplingType.WARM)) {
			warmSaplings.put(fruitName, sapling);
		}
		else if(saplingType.equals(SaplingType.COLD)) {
			coldSaplings.put(fruitName, sapling);
		}

		logSaplings.put(fruitName, sapling);

		final BlockPamFruitLog logFruit;

		/**
		 * switch (fruitName) {
		 * case PAPERBARK:
		 * logFruit = new BlockPamFruitLog(sapling, Items.PAPER);
		 * foodItems.put(fruitName, Items.PAPER);
		 * break;
		 * default:
		 * final Item item = new ItemPamFood(HarvestCraft.config.cropfoodRestore, HarvestCraft.config.snacksaturation);
		 * foodItems.put(fruitName, item);
		 * final Item fruit = ItemRegistry.registerItem(item, getItemName(fruitName));
		 * logFruit = new BlockPamFruitLog(sapling, fruit);
		 * break;
		 * }
		 */

		if(fruitName.equals(PAPERBARK)) {
			logFruit = new BlockPamFruitLog(sapling, Items.PAPER);
			foodItems.put(fruitName, Items.PAPER);
		}
		else {
			final Item item = new ItemPamFood(HarvestCraft.config.cropfoodRestore, HarvestCraft.config.snacksaturation);
			foodItems.put(fruitName, item);
			final Item fruit = ItemRegistry.registerItem(item, getItemName(fruitName));
			logFruit = new BlockPamFruitLog(sapling, fruit);
		}

		logs.put(fruitName, logFruit);
		sapling.setFruit(logFruit);

		BlockRegistry.registerBlock(getFruitBlockName(fruitName), new ItemBlock(logFruit), logFruit);
	}
}
