package com.pam.harvestcraft.item;

import static com.pam.harvestcraft.HarvestCraft.config;
import static com.pam.harvestcraft.item.GeneralOreRegistry.*;

import java.util.Map;

import com.pam.harvestcraft.HarvestCraft;
//import com.pam.harvestcraft.RecipeJSON;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;
import com.pam.harvestcraft.config.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeRegistry {

	public static void registerRecipes() {
		registerFoodRecipes();
		registerOtherRecipes();
		registerBeeRecipes();
		registerPresserRecipe();
		registerMarketRecipe();
		registerWellRecipes();
		registerSmelting();
	}

	private static void registerSmelting() {

		addSmelting(ItemRegistry.calamarirawItem, ItemRegistry.calamaricookedItem);
		addSmelting(ItemRegistry.turkeyrawItem, ItemRegistry.turkeycookedItem);
		addSmelting(ItemRegistry.venisonrawItem, ItemRegistry.venisoncookedItem);
		
		addSmelting(ItemRegistry.anchovyrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.bassrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.carprawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.catfishrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.charrrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.eelrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.grouperrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.herringrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.mudfishrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.perchrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.snapperrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.tilapiarawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.troutrawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.tunarawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.walleyerawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.sardinerawItem, Items.COOKED_FISH);
		addSmelting(ItemRegistry.clamrawItem, ItemRegistry.clamcookedItem);
		addSmelting(ItemRegistry.crabrawItem, ItemRegistry.crabcookedItem);
		addSmelting(ItemRegistry.crayfishrawItem, ItemRegistry.crayfishcookedItem);
		addSmelting(ItemRegistry.frograwItem, ItemRegistry.frogcookedItem);
		addSmelting(ItemRegistry.octopusrawItem, ItemRegistry.octopuscookedItem);
		addSmelting(ItemRegistry.scalloprawItem, ItemRegistry.scallopcookedItem);
		addSmelting(ItemRegistry.shrimprawItem, ItemRegistry.shrimpcookedItem);
		addSmelting(ItemRegistry.snailrawItem, ItemRegistry.snailcookedItem);
		addSmelting(ItemRegistry.turtlerawItem, ItemRegistry.turtlecookedItem);
		addSmelting(ItemRegistry.musselrawItem, ItemRegistry.musselcookedItem);
		
		if(HarvestCraft.config.enableTofuAsMeatInRecipes) {
			addSmelting(ItemRegistry.rawtofeakItem, ItemRegistry.cookedtofeakItem);
			addSmelting(ItemRegistry.rawtofaconItem, ItemRegistry.cookedtofaconItem);
			addSmelting(ItemRegistry.rawtofishItem, ItemRegistry.cookedtofishItem);
			addSmelting(ItemRegistry.rawtofeegItem, ItemRegistry.cookedtofeegItem);
			addSmelting(ItemRegistry.rawtofuttonItem, ItemRegistry.cookedtofuttonItem);
			addSmelting(ItemRegistry.rawtofickenItem, ItemRegistry.cookedtofickenItem);
			addSmelting(ItemRegistry.rawtofabbitItem, ItemRegistry.cookedtofabbitItem);
			addSmelting(ItemRegistry.rawtofurkeyItem, ItemRegistry.cookedtofurkeyItem);
			addSmelting(ItemRegistry.rawtofenisonItem, ItemRegistry.cookedtofenisonItem);
		}
	}

	private static void registerPresserRecipe() {
		addShapedOreRecipe(BlockRegistry.presser, "#O#", "# #", "#O#", '#', ingotIron, 'O', Blocks.PISTON);
		addShapedOreRecipe(BlockRegistry.presser, "#O#", "# #", "#O#", '#', ingotCopper, 'O', Blocks.PISTON);
		addShapedOreRecipe(BlockRegistry.presser, "#O#", "# #", "#O#", '#', ingotSteel, 'O', Blocks.PISTON);
		addShapedOreRecipe(BlockRegistry.presser, "#O#", "# #", "#O#", '#', ingotBronze, 'O', Blocks.PISTON);
	}

	private static void registerBeeRecipes() {
		addShapelessOreRecipe(ItemRegistry.royaljellyItem, new ItemStack(ItemRegistry.queenbeeItem, 1, OreDictionary.WILDCARD_VALUE));
		addShapelessOreRecipe(ItemRegistry.queenbeeItem, ItemRegistry.grubItem, ItemRegistry.royaljellyItem);
		addShapedOreRecipe(BlockRegistry.apiary, "#O#", "#O#", "#O#", '#', plankWood, 'O', Items.ITEM_FRAME);
		addShapelessOreRecipe(ItemRegistry.fruitbaitItem, "string", listAllfruit, listAllfruit, listAllfruit);
		addShapelessOreRecipe(ItemRegistry.grainbaitItem, "string", listAllgrain, listAllgrain, listAllgrain);
		addShapelessOreRecipe(ItemRegistry.veggiebaitItem, "string", listAllveggie, listAllveggie, listAllveggie);
	}

	private static void registerFoodRecipes() {

		for(BlockPamSapling sapling : FruitRegistry.getSaplings()) {
//			RecipeJSON.addShapelessRecipe(new ItemStack(sapling), new ItemStack(sapling.getFruitItem()),
//					new ItemStack(sapling.getFruitItem()), new ItemStack(sapling.getFruitItem()),
//					new ItemStack(Blocks.SAPLING, 1, OreDictionary.WILDCARD_VALUE));
		}

		if(config.enablecroptoseedRecipe) {
			for(Map.Entry<String, ItemSeedFood> food : CropRegistry.getFoods().entrySet()) {
				addShapelessOreRecipe(CropRegistry.getSeed(food.getKey()), food.getValue());

			}
		}

	}

	private static void registerMarketRecipe() {
		final Item marketRecipeItem;
		switch(config.marketblockrecipeItem) {
			case 1:
				marketRecipeItem = Items.DIAMOND;
			break;
			case 2:
				marketRecipeItem = Items.GOLD_INGOT;
			break;
			case 3:
				marketRecipeItem = Items.GOLD_NUGGET;
			break;
			case 4:
				marketRecipeItem = Items.IRON_INGOT;
			break;
			case 5:
				marketRecipeItem = Items.APPLE;
			break;
			case 0:
			default:
				marketRecipeItem = Items.EMERALD;
		}

		addShapedOreRecipe(new ItemStack(BlockRegistry.pamMarket, 1), "XOX", "OEO", "XOX", 'X', "plankWood", 'O',
				Blocks.WOOL, 'E', marketRecipeItem);
		addShapedOreRecipe(new ItemStack(BlockRegistry.pamShippingbin, 1), "XOX", "OEO", "XOX", 'X', "plankWood", 'O',
				Blocks.LOG, 'E', marketRecipeItem);
	}

	private static void registerWellRecipes() {
		addShapedOreRecipe(new ItemStack(BlockRegistry.well, 1), "XOX", "XOX", "XOX", 'X', "ingotIron", 'O',
				Blocks.STONE);
	}

	private static void registerOtherRecipes() {
		
		// Tools
		addShapedOreRecipe(ItemRegistry.potItem, true, "X@@", " @@", '@', ingotIron, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.skilletItem, true, "@  ", " @ ", "  X", '@', ingotIron, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.saucepanItem, true, "@ ", "X ", '@', ingotIron, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.bakewareItem, true, "@@@", "@ @", "@@@", '@', ingotBrick);
		addShapedOreRecipe(ItemRegistry.cuttingboardItem, true, "@  ", " X ", "  O", '@', ingotIron, 'X', stickWood,
				'O', plankWood);
		addShapedOreRecipe(ItemRegistry.mortarandpestleItem, true, "X@X", " X ", '@', stickWood, 'X', stone);
		addShapedOreRecipe(ItemRegistry.mixingbowlItem, true, "X@X", " X ", '@', stickWood, 'X', plankWood);
		addShapedOreRecipe(ItemRegistry.juicerItem, true, "@ ", "X ", '@', stone, 'X', Blocks.STONE_PRESSURE_PLATE);
		// Copper Tools
		addShapedOreRecipe(ItemRegistry.potItem, true, "X@@", " @@", '@', ingotCopper, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.skilletItem, true, "@  ", " @ ", "  X", '@', ingotCopper, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.saucepanItem, true, "@  ", "X  ", '@', ingotCopper, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.cuttingboardItem, true, "@  ", " X ", "  O", '@', ingotCopper, 'X', stickWood,
				'O', plankWood);
		// Steel Tools
		addShapedOreRecipe(ItemRegistry.potItem, true, "X@@", " @@", '@', ingotSteel, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.skilletItem, true, "@  ", " @ ", "  X", '@', ingotSteel, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.saucepanItem, true, "@  ", "X  ", '@', ingotSteel, 'X', stickWood);
		addShapedOreRecipe(ItemRegistry.cuttingboardItem, true, "@  ", " X ", "  O", '@', ingotSteel, 'X', stickWood,
				'O', plankWood);
		// Nether Brick Bakeware
		addShapedOreRecipe(ItemRegistry.bakewareItem, true, "@@@", "@ @", "@@@", '@', ingotBrickNether);

		// Cotton Seed & Switch Recipes
		addShapelessOreRecipe(new ItemStack(CropRegistry.getCrop(CropRegistry.COTTON), 2), cropCotton, cropCotton);

		// Woven Cloth Recipes
		addShapelessOreRecipe(new ItemStack(Items.STRING, 2), cropCotton, cropCotton, cropCotton);
		addShapelessOreRecipe(new ItemStack(ItemRegistry.wovencottonItem, 1), "string", "string");
		addShapelessOreRecipe(new ItemStack(ItemRegistry.wovencottonItem, 3), materialCloth, materialCloth,
				materialCloth);
		// Woven Cloth into Wool Recipe
		addShapelessOreRecipe(new ItemStack(Blocks.WOOL, 1, 0), materialCloth, materialCloth);

		// Cotton Armor Recipes
		addShapedOreRecipe(new ItemStack(Items.LEATHER_HELMET, 1), "XXX", "X X", 'X', ItemRegistry.wovencottonItem);
		addShapedOreRecipe(new ItemStack(Items.LEATHER_CHESTPLATE, 1), "X X", "XXX", "XXX", 'X',
				ItemRegistry.wovencottonItem);
		addShapedOreRecipe(new ItemStack(Items.LEATHER_LEGGINGS, 1), "XXX", "X X", "X X", 'X',
				ItemRegistry.wovencottonItem);
		addShapedOreRecipe(new ItemStack(Items.LEATHER_BOOTS, 1), "X X", "X X", 'X', ItemRegistry.wovencottonItem);

		addShapelessOreRecipe(CropRegistry.getSeed(CropRegistry.CANDLEBERRY),
				CropRegistry.getFood(CropRegistry.CANDLEBERRY));

		// Hardened Leather Recipes
		addShapelessOreRecipe(new ItemStack(ItemRegistry.hardenedleatherItem, 1), materialPressedwax, Items.LEATHER);
		addShapedOreRecipe(new ItemStack(ItemRegistry.hardenedleatherhelmItem, 1), "XXX", "X X", 'X',
				ItemRegistry.hardenedleatherItem);
		addShapedOreRecipe(new ItemStack(ItemRegistry.hardenedleatherchestItem, 1), "X X", "XXX", "XXX", 'X',
				ItemRegistry.hardenedleatherItem);
		addShapedOreRecipe(new ItemStack(ItemRegistry.hardenedleatherleggingsItem, 1), "XXX", "X X", "X X", 'X',
				ItemRegistry.hardenedleatherItem);
		addShapedOreRecipe(new ItemStack(ItemRegistry.hardenedleatherbootsItem, 1), "X X", "X X", 'X',
				ItemRegistry.hardenedleatherItem);

		// Random Recipes
		addShapelessOreRecipe(new ItemStack(Items.SLIME_BALL, 1), foodJellyfishraw);

		// Pumpkin Lanterns
		addShapelessOreRecipe(new ItemStack(Blocks.LIT_PUMPKIN, 1), GeneralOreRegistry.cropPumpkin, blockTorch);

		// Candles
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco1, 4), materialPressedwax, Items.STRING);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco2, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeOrange);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco3, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeMagenta);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco4, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeLime);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco5, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeYellow);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco6, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeBrightBlue);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco7, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyePink);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco8, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeDarkGrey);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco9, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeLightGrey);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco10, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeBlue);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco11, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyePurple);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco12, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeDarkBlue);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco13, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeBrown);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco14, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeGreen);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco15, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeRed);
		addShapelessOreRecipe(new ItemStack(BlockRegistry.candleDeco16, 4), BlockRegistry.candleDeco1,
				BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, BlockRegistry.candleDeco1, dyeBlack);

		// Bee Blocks
		addShapedOreRecipe(new ItemStack(BlockRegistry.honey, 1), "XXX", "XXX", "XXX", 'X', ItemRegistry.honeyItem);
		addShapedOreRecipe(new ItemStack(BlockRegistry.honeycomb, 1), "XXX", "XXX", "XXX", 'X',
				ItemRegistry.honeycombItem);
		addShapedOreRecipe(new ItemStack(BlockRegistry.pressedwax, 1), "XXX", "XXX", "XXX", 'X', materialPressedwax);
		addShapedOreRecipe(new ItemStack(BlockRegistry.waxcomb, 1), "XXX", "XXX", "XXX", 'X', ItemRegistry.waxcombItem);

		addShapelessOreRecipe(new ItemStack(ItemRegistry.honeyItem, 9), BlockRegistry.honey);
		addShapelessOreRecipe(new ItemStack(ItemRegistry.honeycombItem, 9), BlockRegistry.honeycomb);
		addShapelessOreRecipe(new ItemStack(ItemRegistry.beeswaxItem, 9), BlockRegistry.pressedwax);
		addShapelessOreRecipe(new ItemStack(ItemRegistry.waxcombItem, 9), BlockRegistry.waxcomb);

		// Logs
//		RecipeJSON.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 4, 1),
//				new ItemStack(FruitRegistry.getLog(FruitRegistry.MAPLE)));
//		RecipeJSON.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 4, 3),
//				new ItemStack(FruitRegistry.getLog(FruitRegistry.PAPERBARK)));
//		RecipeJSON.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 4, 3),
//				new ItemStack(FruitRegistry.getLog(FruitRegistry.CINNAMON)));

		// Ground Trap
		addShapedOreRecipe(new ItemStack(BlockRegistry.groundtrap, 1), new Object[] {"XTX",
				"OCO", "XOX", 'X', "stickWood", 'O', "string", 'C', Blocks.CHEST, 'T', Blocks.TRAPDOOR});
		// Water Trap
				addShapedOreRecipe(new ItemStack(BlockRegistry.watertrap, 1), new Object[] {"XFX",
				"OCO", "XOX", 'X', "stickWood", 'O', "string", 'C', Blocks.CHEST, 'F', Items.FISHING_ROD});
		// Baits
		addShapelessOreRecipe(new ItemStack(ItemRegistry.grainbaitItem, ConfigHandler.grainbaitrecipeamount), "string",
						"listAllgrain", "listAllgrain", "listAllgrain");
		addShapelessOreRecipe(new ItemStack(ItemRegistry.veggiebaitItem, ConfigHandler.veggiebaitrecipeamount), "string",
						"listAllveggie", "listAllveggie", "listAllveggie");
		addShapelessOreRecipe(new ItemStack(ItemRegistry.fruitbaitItem, ConfigHandler.fruitbaitrecipeamount), "string",
						"listAllfruit", "listAllfruit", "listAllfruit");
		addShapelessOreRecipe(new ItemStack(ItemRegistry.fishtrapbaitItem, ConfigHandler.fishtrapbaitrecipeamount), "string",
						"listAllfishraw", "listAllfishraw", "listAllfishraw");
	}

	private static void addShapelessOreRecipe(Block result, Object... recipe) {
		addShapelessOreRecipe(new ItemStack(result), recipe);
	}

	private static void addShapelessOreRecipe(Item result, Object... recipe) {
		addShapelessOreRecipe(new ItemStack(result), recipe);
	}

	private static void addShapelessOreRecipe(ItemStack result, Object... recipe) {
//		RecipeJSON.addShapelessRecipe(result, recipe);
		    }

	private static void addShapedOreRecipe(Block result, Object... recipe) {
		addShapedOreRecipe(new ItemStack(result), recipe);
	}

	private static void addShapedOreRecipe(Item result, Object... recipe) {
		addShapedOreRecipe(new ItemStack(result), recipe);
	}

	private static void addShapedOreRecipe(ItemStack result, Object... recipe) {
//		RecipeJSON.addShapedRecipe(result, recipe);
		    }

	private static void addSmelting(Item input, Item output) {
		GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
	}

	private static void addSmelting(Block input, Item output) {
		GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
	}
}
