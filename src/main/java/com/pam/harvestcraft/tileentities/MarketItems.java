package com.pam.harvestcraft.tileentities;

import java.util.ArrayList;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class MarketItems {

	private enum CurrencyType {
		DEFAULT, SEEDS, SAPLING, ANIMAL
	}

	private static final ArrayList<MarketData> items = new ArrayList<MarketData>();

	private static void registerItems(MarketData data) {
		items.add(data);
	}

	public static MarketData getData(int i) {
		return items.get(i);
	}

	public static int getSize() {
		return items.size();
	}

	public static void registerItems() {

		if(HarvestCraft.config.marketsellSeeds) {
			registerSeeds();
		}

		if(HarvestCraft.config.marketselltemperateSaplings) {
			registerTemperateSaplings();
		}

		if(HarvestCraft.config.marketselltropicalSaplings) {
			registerTropicalSaplings();
		}

		if(HarvestCraft.config.marketsellconiferousSaplings) {
			registerConiferousSaplings();
		}

		registerAnimalEggs();
		registerMisc();
	}

	private static void registerMisc() {
		final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyBonemeal, CurrencyType.DEFAULT);
		final ItemStack currency2 = getCurrency(HarvestCraft.config.marketcurrencyLead, CurrencyType.DEFAULT);
		final ItemStack currency3 = getCurrency(HarvestCraft.config.marketcurrencyNametag, CurrencyType.DEFAULT);
		final ItemStack currency4 = getCurrency(HarvestCraft.config.marketcurrencyBees, CurrencyType.DEFAULT);

		if (HarvestCraft.config.marketsellBonemeal){
		registerItems(
				new MarketData(new ItemStack(Items.DYE, 1, 15), currency, HarvestCraft.config.marketbonemealPrice));
		}
		if (HarvestCraft.config.marketsellLead){
			registerItems(
					new MarketData(new ItemStack(Items.LEAD), currency, HarvestCraft.config.marketleadPrice));
			}
		if (HarvestCraft.config.marketsellNametag){
			registerItems(
					new MarketData(new ItemStack(Items.NAME_TAG), currency, HarvestCraft.config.marketnametagPrice));
			}
		
		if (HarvestCraft.config.marketsellQueenbee){
			registerItems(
					new MarketData(new ItemStack(ItemRegistry.queenbeeItem), currency, HarvestCraft.config.marketqueenbeePrice));
			}
	}

	private static void registerNBT(ItemStack stack, ResourceLocation entityId) {
        NBTTagCompound nbt = new NBTTagCompound();
        NBTTagCompound nbt1 = new NBTTagCompound();
        nbt1.setString("id", entityId.toString());
        nbt.setTag("EntityTag", nbt1);
        stack.setTagCompound(nbt);
	}
	
	private static void registerAnimalEggs() {
		
		

		ItemStack pigEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(pigEgg, EntityList.getKey(EntityPig.class));
        
        ItemStack sheepEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(sheepEgg, EntityList.getKey(EntitySheep.class));
        
        ItemStack cowEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(cowEgg, EntityList.getKey(EntityCow.class));
        
        ItemStack chickenEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(chickenEgg, EntityList.getKey(EntityChicken.class));
        
        ItemStack horseEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(horseEgg, EntityList.getKey(EntityHorse.class));
        
        ItemStack llamaEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(llamaEgg, EntityList.getKey(EntityLlama.class));
        
        ItemStack ocelotEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(ocelotEgg, EntityList.getKey(EntityOcelot.class));
        
        ItemStack wolfEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(wolfEgg, EntityList.getKey(EntityWolf.class));
        
        ItemStack rabbitEgg = new ItemStack(Items.SPAWN_EGG);
        registerNBT(rabbitEgg, EntityList.getKey(EntityRabbit.class));


		if(FMLCommonHandler.instance().getEffectiveSide().isClient()) {
			ItemMonsterPlacer.applyEntityIdToItemStack(pigEgg, new ResourceLocation("minecraft", "pig"));
			ItemMonsterPlacer.applyEntityIdToItemStack(sheepEgg, new ResourceLocation("minecraft", "sheep"));
			ItemMonsterPlacer.applyEntityIdToItemStack(cowEgg, new ResourceLocation("minecraft", "cow"));
			ItemMonsterPlacer.applyEntityIdToItemStack(chickenEgg, new ResourceLocation("minecraft", "chicken"));
			ItemMonsterPlacer.applyEntityIdToItemStack(horseEgg, new ResourceLocation("minecraft", "horse"));
			ItemMonsterPlacer.applyEntityIdToItemStack(llamaEgg, new ResourceLocation("minecraft", "llama"));
			ItemMonsterPlacer.applyEntityIdToItemStack(ocelotEgg, new ResourceLocation("minecraft", "ocelot"));
			ItemMonsterPlacer.applyEntityIdToItemStack(wolfEgg, new ResourceLocation("minecraft", "wolf"));
			ItemMonsterPlacer.applyEntityIdToItemStack(rabbitEgg, new ResourceLocation("minecraft", "rabbit"));
		}

		if(HarvestCraft.config.marketsellPig) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyPig, CurrencyType.ANIMAL);
			registerItems(new MarketData(pigEgg, currency, HarvestCraft.config.marketpigPrice));
		}

		if(HarvestCraft.config.marketsellSheep) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencySheep, CurrencyType.ANIMAL);
			registerItems(new MarketData(sheepEgg, currency, HarvestCraft.config.marketsheepPrice));
		}

		if(HarvestCraft.config.marketsellCow) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyCow, CurrencyType.ANIMAL);
			registerItems(new MarketData(cowEgg, currency, HarvestCraft.config.marketcowPrice));
		}

		if(HarvestCraft.config.marketsellChicken) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyChicken, CurrencyType.ANIMAL);
			registerItems(new MarketData(chickenEgg, currency, HarvestCraft.config.marketchickenPrice));
		}

		if(HarvestCraft.config.marketsellHorse) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyHorse, CurrencyType.ANIMAL);
			registerItems(new MarketData(horseEgg, currency, HarvestCraft.config.markethorsePrice));
		}
		
		if(HarvestCraft.config.marketsellLlama) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyLlama, CurrencyType.ANIMAL);
			registerItems(new MarketData(llamaEgg, currency, HarvestCraft.config.marketllamaPrice));
		}
		if(HarvestCraft.config.marketsellOcelot) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyOcelot, CurrencyType.ANIMAL);
			registerItems(new MarketData(ocelotEgg, currency, HarvestCraft.config.marketocelotPrice));
		}
		if(HarvestCraft.config.marketsellWolf) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyWolf, CurrencyType.ANIMAL);
			registerItems(new MarketData(wolfEgg, currency, HarvestCraft.config.marketwolfPrice));
		}
		if(HarvestCraft.config.marketsellRabbit) {
			final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencyRabbit, CurrencyType.ANIMAL);
			registerItems(new MarketData(rabbitEgg, currency, HarvestCraft.config.marketrabbitPrice));
		}
	}

	private static void registerConiferousSaplings() {
		final ItemStack currency =
				getCurrency(HarvestCraft.config.marketcurrencyconiferousSaplings, CurrencyType.SAPLING);

		registerItems(new MarketData(new ItemStack(FruitRegistry.getSapling(FruitRegistry.MAPLE), 1), currency,
				HarvestCraft.config.marketsaplingPrice));
		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 1), currency, HarvestCraft.config.marketsaplingPrice));
	}

	private static void registerTropicalSaplings() {
		final ItemStack currency =
				getCurrency(HarvestCraft.config.marketcurrencytropicalSaplings, CurrencyType.SAPLING);

		for(Block sapling : FruitRegistry.warmSaplings.values()) {
			registerItems(new MarketData(new ItemStack(sapling, 1), currency, HarvestCraft.config.marketsaplingPrice));
		}
		registerItems(new MarketData(new ItemStack(FruitRegistry.getSapling(FruitRegistry.CINNAMON), 1), currency,
				HarvestCraft.config.marketsaplingPrice));
		registerItems(new MarketData(new ItemStack(FruitRegistry.getSapling(FruitRegistry.PAPERBARK), 1), currency,
				HarvestCraft.config.marketsaplingPrice));
		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 3), currency, HarvestCraft.config.marketsaplingPrice));
		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 4), currency, HarvestCraft.config.marketsaplingPrice));
	}

	private static void registerTemperateSaplings() {
		final ItemStack currency =
				getCurrency(HarvestCraft.config.marketcurrencytemperateSaplings, CurrencyType.SAPLING);

		for(Block sapling : FruitRegistry.temperateSaplings.values()) {
			registerItems(new MarketData(new ItemStack(sapling, 1), currency, HarvestCraft.config.marketsaplingPrice));
		}

		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 0), currency, HarvestCraft.config.marketsaplingPrice));
		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 2), currency, HarvestCraft.config.marketsaplingPrice));
		registerItems(
				new MarketData(new ItemStack(Blocks.SAPLING, 1, 5), currency, HarvestCraft.config.marketsaplingPrice));
	}

	private static void registerSeeds() {
		final ItemStack currency = getCurrency(HarvestCraft.config.marketcurrencySeeds, CurrencyType.SEEDS);

		for(Item seed : CropRegistry.getSeeds().values()) {
			registerItems(new MarketData(new ItemStack(seed), currency, HarvestCraft.config.marketseedPrice));

		}
		registerItems(new MarketData(new ItemStack(Items.WHEAT_SEEDS), currency, HarvestCraft.config.marketseedPrice));
		registerItems(
				new MarketData(new ItemStack(Items.PUMPKIN_SEEDS), currency, HarvestCraft.config.marketseedPrice));
		registerItems(new MarketData(new ItemStack(Items.MELON_SEEDS), currency, HarvestCraft.config.marketseedPrice));
		registerItems(
				new MarketData(new ItemStack(Items.BEETROOT_SEEDS), currency, HarvestCraft.config.marketseedPrice));
		registerItems(
				new MarketData(new ItemStack(Items.DYE, 1, 3), currency, HarvestCraft.config.marketseedPrice));
	}
	

	private static ItemStack getCurrency(int config, CurrencyType currencyType) {
		switch(config) {
			case 1:
				return new ItemStack(Items.DIAMOND);
			case 2:
				return new ItemStack(Items.GOLD_INGOT);
			case 3:
				return new ItemStack(Items.GOLD_NUGGET);
			case 4:
				return new ItemStack(Items.IRON_INGOT);
			case 5:
				if(currencyType.equals(CurrencyType.ANIMAL))
					return new ItemStack(Items.EGG);
				if(currencyType.equals(CurrencyType.SEEDS))
					return new ItemStack(Items.WHEAT_SEEDS);
				if(currencyType.equals(CurrencyType.SAPLING))
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
