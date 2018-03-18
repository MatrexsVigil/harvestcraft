package com.pam.harvestcraft.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.blocks.ApiaryBlock;
import com.pam.harvestcraft.blocks.blocks.BeeBlock;
import com.pam.harvestcraft.blocks.blocks.BeehiveBlock;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;
import com.pam.harvestcraft.blocks.blocks.BlockPamCake;
import com.pam.harvestcraft.blocks.blocks.BlockPamCandle;
import com.pam.harvestcraft.blocks.blocks.BlockPamMarket;
import com.pam.harvestcraft.blocks.blocks.BlockPamShippingBin;
import com.pam.harvestcraft.blocks.blocks.GrinderBlock;
import com.pam.harvestcraft.blocks.blocks.GroundTrapBlock;
import com.pam.harvestcraft.blocks.blocks.PresserBlock;
import com.pam.harvestcraft.blocks.blocks.WaterFilterBlock;
import com.pam.harvestcraft.blocks.blocks.WaterTrapBlock;
import com.pam.harvestcraft.blocks.blocks.WellBlock;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public final class BlockRegistry {

	public static final List<Block> blocks = new ArrayList<Block>();
	
	// Market block
	public static final String marketItemName = "market";
	public static Block pamMarket;
	public static ItemBlock marketItemBlock;

	// Shipping Bin block
	public static final String shippingbinItemName = "shippingbin";
	public static Block pamShippingbin;
	public static ItemBlock shippingbinItemBlock;

	// Well Block
	public static final String wellItemName = "well";
	public static Block well;
	public static ItemBlock wellItemBlock;

	// Trap blocks
	public static GroundTrapBlock groundtrap;
	public static ItemBlock groundtrapItemBlock;
	public static WaterTrapBlock watertrap;
	public static ItemBlock watertrapItemBlock;
	
	// Water Filter
	public static final String waterfilterItemName = "waterfilter";
	public static Block waterfilter;
	public static ItemBlock waterfilterItemBlock;
	
	// Grinder
	public static final String grinderItemName = "grinder";
	public static Block grinder;
	public static ItemBlock grinderItemBlock;

	// Bee features
	public static BeehiveBlock beehive;
	public static ItemBlock beehiveItemBlock;

	public static ApiaryBlock apiary;
	public static ItemBlock apiaryItemBlock;

	public static PresserBlock presser;
	public static ItemBlock presserItemBlock;

	public static BeeBlock honey;
	public static ItemBlock honeyItemBlock;
	public static BeeBlock honeycomb;
	public static ItemBlock honeycombItemBlock;
	public static BeeBlock pressedwax;
	public static ItemBlock pressedwaxItemBlock;
	public static BeeBlock waxcomb;
	public static ItemBlock waxcombItemBlock;

	public static BlockPamCandle candleDeco1;
	public static ItemBlock candledeco1ItemBlock;
	public static BlockPamCandle candleDeco2;
	public static ItemBlock candledeco2ItemBlock;
	public static BlockPamCandle candleDeco3;
	public static ItemBlock candledeco3ItemBlock;
	public static BlockPamCandle candleDeco4;
	public static ItemBlock candledeco4ItemBlock;
	public static BlockPamCandle candleDeco5;
	public static ItemBlock candledeco5ItemBlock;
	public static BlockPamCandle candleDeco6;
	public static ItemBlock candledeco6ItemBlock;
	public static BlockPamCandle candleDeco7;
	public static ItemBlock candledeco7ItemBlock;
	public static BlockPamCandle candleDeco8;
	public static ItemBlock candledeco8ItemBlock;
	public static BlockPamCandle candleDeco9;
	public static ItemBlock candledeco9ItemBlock;
	public static BlockPamCandle candleDeco10;
	public static ItemBlock candledeco10ItemBlock;
	public static BlockPamCandle candleDeco11;
	public static ItemBlock candledeco11ItemBlock;
	public static BlockPamCandle candleDeco12;
	public static ItemBlock candledeco12ItemBlock;
	public static BlockPamCandle candleDeco13;
	public static ItemBlock candledeco13ItemBlock;
	public static BlockPamCandle candleDeco14;
	public static ItemBlock candledeco14ItemBlock;
	public static BlockPamCandle candleDeco15;
	public static ItemBlock candledeco15ItemBlock;
	public static BlockPamCandle candleDeco16;
	public static ItemBlock candledeco16ItemBlock;

	// Cakes
	public static BlockPamCake carrotcake;
	public static ItemBlock carrotcakeItemBlock;
	public static BlockPamCake cheesecake;
	public static ItemBlock cheesecakeItemBlock;
	public static BlockPamCake cherrycheesecake;
	public static ItemBlock cherrycheesecakeItemBlock;
	public static BlockPamCake chocolatesprinklecake;
	public static ItemBlock chocolatesprinklecakeItemBlock;
	public static BlockPamCake holidaycake;
	public static ItemBlock holidaycakeItemBlock;
	public static BlockPamCake lamingtoncake;
	public static ItemBlock lamingtoncakeItemBlock;
	public static BlockPamCake pavlovacake;
	public static ItemBlock pavlovacakeItemBlock;
	public static BlockPamCake pineappleupsidedowncake;
	public static ItemBlock pineappleupsidedowncakeItemBlock;
	public static BlockPamCake pumpkincheesecake;
	public static ItemBlock pumpkincheesecakeItemBlock;
	public static BlockPamCake redvelvetcake;
	public static ItemBlock redvelvetcakeItemBlock;

	// Garden blocks
	public static final HashMap<String, BlockBaseGarden> gardens = new HashMap<String, BlockBaseGarden>();
	public static final String aridGarden = "aridGarden";
	public static final String frostGarden = "frostGarden";
	public static final String tropicalGarden = "tropicalGarden";
	public static final String windyGarden = "windyGarden";
	public static final String shadedGarden = "shadedGarden";
	public static final String soggyGarden = "soggyGarden";

	private static boolean initialized = false;

	public static void initBlockRegistry() {
		registerMarket();
		registerWell();
		registerTraps();
		registerWaterFilter();
		registerGrinder();
		registerBeeFeatures();
		registerGardens();
		registerPresser();
		registerCakes();
		initialized = true;
	}

	public static BlockBaseGarden getGarden(String gardenName) {
		if(!initialized) {
			FMLLog.bigWarning("BlockRegistry has not been initialized yet.");
			return null;
		}

		if(!gardens.containsKey(gardenName)) {
			FMLLog.bigWarning("Garden %s is not registered.", gardenName);
			return null;
		}

		return gardens.get(gardenName);
	}

	private static void registerPresser() {
		presser = new PresserBlock();
		presserItemBlock = new ItemBlock(presser);
		ItemRegistry.items.put(PresserBlock.registryName, presserItemBlock);
		registerBlock(PresserBlock.registryName, presserItemBlock, presser);
	}

	private static void registerWell() {
		well = new WellBlock();
		wellItemBlock = new ItemBlock(well);
		ItemRegistry.items.put(WellBlock.registryName, wellItemBlock);
		registerBlock(WellBlock.registryName, wellItemBlock, well);
	}
	
	private static void registerWaterFilter() {
		waterfilter = new WaterFilterBlock();
		waterfilterItemBlock = new ItemBlock(waterfilter);
		ItemRegistry.items.put(WaterFilterBlock.registryName, waterfilterItemBlock);
		registerBlock(WaterFilterBlock.registryName, waterfilterItemBlock, waterfilter);
	}
	
	private static void registerGrinder() {
		grinder = new GrinderBlock();
		grinderItemBlock = new ItemBlock(grinder);
		ItemRegistry.items.put(GrinderBlock.registryName, grinderItemBlock);
		registerBlock(GrinderBlock.registryName, grinderItemBlock, grinder);
	}

	private static void registerBeeFeatures() {
		beehive = new BeehiveBlock();
		beehiveItemBlock = new ItemBlock(beehive);
		ItemRegistry.items.put(BeehiveBlock.registryName, beehiveItemBlock);
		registerBlock(BeehiveBlock.registryName, beehiveItemBlock, beehive);

		apiary = new ApiaryBlock();
		apiaryItemBlock = new ItemBlock(apiary);
		ItemRegistry.items.put(ApiaryBlock.registryName, apiaryItemBlock);
		registerBlock(ApiaryBlock.registryName, apiaryItemBlock, apiary);

		final String honeyName = "honey";
		final String honeycombName = "honeycomb";
		final String pressedwaxName = "pressedwax";
		final String waxcombName = "waxcomb";

		honey = new BeeBlock();
		honeyItemBlock = new ItemBlock(honey);
		ItemRegistry.items.put(honeyName, honeyItemBlock);
		registerBlock(honeyName, honeyItemBlock, honey);

		honeycomb = new BeeBlock();
		honeycombItemBlock = new ItemBlock(honeycomb);
		ItemRegistry.items.put(honeycombName, honeycombItemBlock);
		registerBlock(honeycombName, honeycombItemBlock, honeycomb);

		pressedwax = new BeeBlock();
		pressedwaxItemBlock = new ItemBlock(pressedwax);
		ItemRegistry.items.put(pressedwaxName, pressedwaxItemBlock);
		registerBlock(pressedwaxName, pressedwaxItemBlock, pressedwax);

		waxcomb = new BeeBlock();
		waxcombItemBlock = new ItemBlock(waxcomb);
		ItemRegistry.items.put(waxcombName, waxcombItemBlock);
		registerBlock(waxcombName, waxcombItemBlock, waxcomb);

		final String candleDeco1Name = "candleDeco1";
		final String candleDeco2Name = "candleDeco2";
		final String candleDeco3Name = "candleDeco3";
		final String candleDeco4Name = "candleDeco4";
		final String candleDeco5Name = "candleDeco5";
		final String candleDeco6Name = "candleDeco6";
		final String candleDeco7Name = "candleDeco7";
		final String candleDeco8Name = "candleDeco8";
		final String candleDeco9Name = "candleDeco9";
		final String candleDeco10Name = "candleDeco10";
		final String candleDeco11Name = "candleDeco11";
		final String candleDeco12Name = "candleDeco12";
		final String candleDeco13Name = "candleDeco13";
		final String candleDeco14Name = "candleDeco14";
		final String candleDeco15Name = "candleDeco15";
		final String candleDeco16Name = "candleDeco16";

		candleDeco1 = new BlockPamCandle();
		candledeco1ItemBlock = new ItemBlock(candleDeco1);
		ItemRegistry.items.put(candleDeco1Name, candledeco1ItemBlock);
		registerBlock(candleDeco1Name, candledeco1ItemBlock, candleDeco1);

		candleDeco2 = new BlockPamCandle();
		candledeco2ItemBlock = new ItemBlock(candleDeco2);
		ItemRegistry.items.put(candleDeco2Name, candledeco2ItemBlock);
		registerBlock(candleDeco2Name, candledeco2ItemBlock, candleDeco2);

		candleDeco3 = new BlockPamCandle();
		candledeco3ItemBlock = new ItemBlock(candleDeco3);
		ItemRegistry.items.put(candleDeco3Name, candledeco3ItemBlock);
		registerBlock(candleDeco3Name, candledeco3ItemBlock, candleDeco3);

		candleDeco4 = new BlockPamCandle();
		candledeco4ItemBlock = new ItemBlock(candleDeco4);
		ItemRegistry.items.put(candleDeco4Name, candledeco4ItemBlock);
		registerBlock(candleDeco4Name, candledeco4ItemBlock, candleDeco4);

		candleDeco5 = new BlockPamCandle();
		candledeco5ItemBlock = new ItemBlock(candleDeco5);
		ItemRegistry.items.put(candleDeco5Name, candledeco5ItemBlock);
		registerBlock(candleDeco5Name, candledeco5ItemBlock, candleDeco5);

		candleDeco6 = new BlockPamCandle();
		candledeco6ItemBlock = new ItemBlock(candleDeco6);
		ItemRegistry.items.put(candleDeco6Name, candledeco6ItemBlock);
		registerBlock(candleDeco6Name, candledeco6ItemBlock, candleDeco6);

		candleDeco7 = new BlockPamCandle();
		candledeco7ItemBlock = new ItemBlock(candleDeco7);
		ItemRegistry.items.put(candleDeco7Name, candledeco7ItemBlock);
		registerBlock(candleDeco7Name, candledeco7ItemBlock, candleDeco7);

		candleDeco8 = new BlockPamCandle();
		candledeco8ItemBlock = new ItemBlock(candleDeco8);
		ItemRegistry.items.put(candleDeco8Name, candledeco8ItemBlock);
		registerBlock(candleDeco8Name, candledeco8ItemBlock, candleDeco8);

		candleDeco9 = new BlockPamCandle();
		candledeco9ItemBlock = new ItemBlock(candleDeco9);
		ItemRegistry.items.put(candleDeco9Name, candledeco9ItemBlock);
		registerBlock(candleDeco9Name, candledeco9ItemBlock, candleDeco9);

		candleDeco10 = new BlockPamCandle();
		candledeco10ItemBlock = new ItemBlock(candleDeco10);
		ItemRegistry.items.put(candleDeco10Name, candledeco10ItemBlock);
		registerBlock(candleDeco10Name, candledeco10ItemBlock, candleDeco10);

		candleDeco11 = new BlockPamCandle();
		candledeco11ItemBlock = new ItemBlock(candleDeco11);
		ItemRegistry.items.put(candleDeco11Name, candledeco11ItemBlock);
		registerBlock(candleDeco11Name, candledeco11ItemBlock, candleDeco11);

		candleDeco12 = new BlockPamCandle();
		candledeco12ItemBlock = new ItemBlock(candleDeco12);
		ItemRegistry.items.put(candleDeco12Name, candledeco12ItemBlock);
		registerBlock(candleDeco12Name, candledeco12ItemBlock, candleDeco12);

		candleDeco13 = new BlockPamCandle();
		candledeco13ItemBlock = new ItemBlock(candleDeco13);
		ItemRegistry.items.put(candleDeco13Name, candledeco13ItemBlock);
		registerBlock(candleDeco13Name, candledeco13ItemBlock, candleDeco13);

		candleDeco14 = new BlockPamCandle();
		candledeco14ItemBlock = new ItemBlock(candleDeco14);
		ItemRegistry.items.put(candleDeco14Name, candledeco14ItemBlock);
		registerBlock(candleDeco14Name, candledeco14ItemBlock, candleDeco14);

		candleDeco15 = new BlockPamCandle();
		candledeco15ItemBlock = new ItemBlock(candleDeco15);
		ItemRegistry.items.put(candleDeco15Name, candledeco15ItemBlock);
		registerBlock(candleDeco15Name, candledeco15ItemBlock, candleDeco15);

		candleDeco16 = new BlockPamCandle();
		candledeco16ItemBlock = new ItemBlock(candleDeco16);
		ItemRegistry.items.put(candleDeco16Name, candledeco16ItemBlock);
		registerBlock(candleDeco16Name, candledeco16ItemBlock, candleDeco16);
	}

	private static void registerMarket() {
		pamMarket = new BlockPamMarket();
		marketItemBlock = new ItemBlock(pamMarket);
		ItemRegistry.items.put(marketItemName, marketItemBlock);

		registerBlock(marketItemName, marketItemBlock, pamMarket);

		pamShippingbin = new BlockPamShippingBin();
		shippingbinItemBlock = new ItemBlock(pamShippingbin);
		ItemRegistry.items.put(shippingbinItemName, shippingbinItemBlock);

		registerBlock(shippingbinItemName, shippingbinItemBlock, pamShippingbin);
	}

	private static void registerTraps() {
		groundtrap = new GroundTrapBlock();
		groundtrapItemBlock = new ItemBlock(groundtrap);
		ItemRegistry.items.put(GroundTrapBlock.registryName, groundtrapItemBlock);
		registerBlock(GroundTrapBlock.registryName, groundtrapItemBlock, groundtrap);

		watertrap = new WaterTrapBlock();
		watertrapItemBlock = new ItemBlock(watertrap);
		ItemRegistry.items.put(WaterTrapBlock.registryName, watertrapItemBlock);
		registerBlock(WaterTrapBlock.registryName, watertrapItemBlock, watertrap);
	}

	private static void registerGardens() {
		addGarden(aridGarden, BlockBaseGarden.Region.DESERT);
		addGarden(frostGarden, BlockBaseGarden.Region.PLAINS);
		addGarden(shadedGarden, BlockBaseGarden.Region.PLAINS);
		addGarden(soggyGarden, BlockBaseGarden.Region.PLAINS);
		addGarden(tropicalGarden, BlockBaseGarden.Region.PLAINS);
		addGarden(windyGarden, BlockBaseGarden.Region.PLAINS);
	}

	private static void registerCakes() {
		final String carrotcakeName = "carrotcake";
		final String cheesecakeName = "cheesecake";
		final String cherrycheesecakeName = "cherrycheesecake";
		final String chocolatesprinklecakeName = "chocolatesprinklecake";
		final String holidaycakeName = "holidaycake";
		final String lamingtoncakeName = "lamingtoncake";
		final String pavlovacakeName = "pavlovacake";
		final String pineappleupsidedowncakeName = "pineappleupsidedowncake";
		final String pumpkincheesecakeName = "pumpkincheesecake";
		final String redvelvetcakeName = "redvelvetcake";

		carrotcake = new BlockPamCake(4);
		carrotcakeItemBlock = new ItemBlock(carrotcake);
		ItemRegistry.items.put(carrotcakeName, carrotcakeItemBlock);
		registerBlock(carrotcakeName, carrotcakeItemBlock, carrotcake);
		cheesecake = new BlockPamCake(5);
		cheesecakeItemBlock = new ItemBlock(cheesecake);
		ItemRegistry.items.put(cheesecakeName, cheesecakeItemBlock);
		registerBlock(cheesecakeName, cheesecakeItemBlock, cheesecake);
		cherrycheesecake = new BlockPamCake(6);
		cherrycheesecakeItemBlock = new ItemBlock(cherrycheesecake);
		ItemRegistry.items.put(cherrycheesecakeName, cherrycheesecakeItemBlock);
		registerBlock(cherrycheesecakeName, cherrycheesecakeItemBlock, cherrycheesecake);
		chocolatesprinklecake = new BlockPamCake(4);
		chocolatesprinklecakeItemBlock = new ItemBlock(chocolatesprinklecake);
		ItemRegistry.items.put(chocolatesprinklecakeName, chocolatesprinklecakeItemBlock);
		registerBlock(chocolatesprinklecakeName, chocolatesprinklecakeItemBlock, chocolatesprinklecake);
		holidaycake = new BlockPamCake(5);
		holidaycakeItemBlock = new ItemBlock(holidaycake);
		ItemRegistry.items.put(holidaycakeName, holidaycakeItemBlock);
		registerBlock(holidaycakeName, holidaycakeItemBlock, holidaycake);
		lamingtoncake = new BlockPamCake(3);
		lamingtoncakeItemBlock = new ItemBlock(lamingtoncake);
		ItemRegistry.items.put(lamingtoncakeName, lamingtoncakeItemBlock);
		registerBlock(lamingtoncakeName, lamingtoncakeItemBlock, lamingtoncake);
		pavlovacake = new BlockPamCake(5);
		pavlovacakeItemBlock = new ItemBlock(pavlovacake);
		ItemRegistry.items.put(pavlovacakeName, pavlovacakeItemBlock);
		registerBlock(pavlovacakeName, pavlovacakeItemBlock, pavlovacake);
		pineappleupsidedowncake = new BlockPamCake(5);
		pineappleupsidedowncakeItemBlock = new ItemBlock(pineappleupsidedowncake);
		ItemRegistry.items.put(pineappleupsidedowncakeName, pineappleupsidedowncakeItemBlock);
		registerBlock(pineappleupsidedowncakeName, pineappleupsidedowncakeItemBlock, pineappleupsidedowncake);
		pumpkincheesecake = new BlockPamCake(4);
		pumpkincheesecakeItemBlock = new ItemBlock(pumpkincheesecake);
		ItemRegistry.items.put(pumpkincheesecakeName, pumpkincheesecakeItemBlock);
		registerBlock(pumpkincheesecakeName, pumpkincheesecakeItemBlock, pumpkincheesecake);
		redvelvetcake = new BlockPamCake(6);
		redvelvetcakeItemBlock = new ItemBlock(redvelvetcake);
		ItemRegistry.items.put(redvelvetcakeName, redvelvetcakeItemBlock);
		registerBlock(redvelvetcakeName, redvelvetcakeItemBlock, redvelvetcake);
	}

	private static void addGarden(String gardenName, BlockBaseGarden.Region region) {
		final BlockBaseGarden garden = new BlockBaseGarden(gardenName, region);
		gardens.put(gardenName, garden);
	}

	public static void registerBlock(String registerName, ItemBlock itemBlock, Block block) {
        block.setRegistryName(registerName);
        block.setUnlocalizedName(registerName);
        block.setCreativeTab(HarvestCraft.modTab);
        blocks.add(block);

        if (itemBlock != null)
        {
        itemBlock.setRegistryName(registerName);
        itemBlock.setUnlocalizedName(registerName);
        ItemRegistry.itemlist.add(itemBlock);
        }
        return;
    }

    public static void registerBlock(String registerName, Block block) {
        final ItemBlock itemBlock = new ItemBlock(block);
        registerBlock(registerName, itemBlock, block);
    }

    
    @SubscribeEvent
    public void onBlockRegistry(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> reg = e.getRegistry();
        reg.registerAll(blocks.toArray(new Block[0]));        
        //reg.register(BlockRegistry.pamfossilItemBlock);
    }
}
