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


	private static void addSmelting(Item input, Item output) {
		GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
	}

	private static void addSmelting(Block input, Item output) {
		GameRegistry.addSmelting(input, new ItemStack(output), 0.1F);
	}
}
