package com.pam.harvestcraft.item;

import java.util.HashMap;
import java.util.Map;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PresserRecipes {
    private static final Map<ItemStack, ItemStack[]> pressingList = new HashMap<ItemStack, ItemStack[]>();

    static {
    	//Bee Stuff
        registerItemRecipe(ItemRegistry.waxcombItem, ItemRegistry.beeswaxItem, ItemRegistry.beeswaxItem);
        registerItemRecipe(ItemRegistry.honeycombItem, ItemRegistry.honeyItem, ItemRegistry.beeswaxItem);
        
        //Juices
        registerItemRecipe(Items.APPLE, ItemRegistry.applejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(ItemRegistry.harvestappleItem, ItemRegistry.applejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(Items.CARROT, ItemRegistry.carrotjuiceItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(ItemRegistry.harvestcarrotItem, ItemRegistry.carrotjuiceItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.BLACKBERRY), ItemRegistry.blackberryjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.RASPBERRY), ItemRegistry.raspberryjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.BLUEBERRY), ItemRegistry.blueberryjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.CACTUSFRUIT), ItemRegistry.cactusfruitjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.CHERRY), ItemRegistry.cherryjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.CRANBERRY), ItemRegistry.cranberryjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.GRAPE), ItemRegistry.grapejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.KIWI), ItemRegistry.kiwijuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.LIME), ItemRegistry.limejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.MANGO), ItemRegistry.mangojuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PLUM), ItemRegistry.plumjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PEAR), ItemRegistry.pearjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.APRICOT), ItemRegistry.apricotjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.FIG), ItemRegistry.figjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.GRAPEFRUIT), ItemRegistry.grapefruitjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PERSIMMON), ItemRegistry.persimmonjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.ORANGE), ItemRegistry.orangejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PAPAYA), ItemRegistry.papayajuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PEACH), ItemRegistry.peachjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.POMEGRANATE), ItemRegistry.pomegranatejuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.STARFRUIT), ItemRegistry.starfruitjuiceItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.STRAWBERRY), ItemRegistry.strawberryjuiceItem, ItemRegistry.fruitbaitItem);
        
        //Cooking Oil
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.OLIVE), ItemRegistry.oliveoilItem, ItemRegistry.fruitbaitItem);
        registerItemRecipe(ItemRegistry.sunflowerseedsItem, ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.WALNUT), ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(CropRegistry.getSeed(CropRegistry.MUSTARD), ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.AVOCADO), ItemRegistry.oliveoilItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(CropRegistry.getSeed(CropRegistry.COTTON), ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        registerBlockRecipe(Blocks.PUMPKIN, ItemRegistry.oliveoilItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(Items.PUMPKIN_SEEDS, ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.TEALEAF), ItemRegistry.oliveoilItem, ItemRegistry.grainbaitItem);
        
        //Sesame Oil
        registerItemRecipe(CropRegistry.getSeed(CropRegistry.SESAME), ItemRegistry.sesameoilItem, ItemRegistry.grainbaitItem);
        
        //Sugar
        registerItemRecipe(Items.REEDS, Items.SUGAR, Items.SUGAR);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.BEET), Items.SUGAR, ItemRegistry.veggiebaitItem);
        
        //Paper
        registerBlockRecipe(Blocks.LOG, Items.PAPER, Items.PAPER);
        registerBlockRecipe(Blocks.LOG2, Items.PAPER, Items.PAPER);
        
        //Bubbly Water
        registerItemRecipe(ItemRegistry.freshwaterItem, ItemRegistry.bubblywaterItem, ItemRegistry.bubblywaterItem);
        
        //Tofu Stuff
        registerItemRecipe(CropRegistry.getFood(CropRegistry.SOYBEAN), ItemRegistry.silkentofuItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(ItemRegistry.silkentofuItem, ItemRegistry.firmtofuItem, ItemRegistry.soymilkItem);
        
        //Fresh Milk
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.ALMOND), ItemRegistry.freshmilkItem, ItemRegistry.grainbaitItem);
        
        //Coconut Milk
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.COCONUT), ItemRegistry.coconutmilkItem, ItemRegistry.veggiebaitItem);
        
        //Slime Ball
        if (HarvestCraft.config.enablemaplesyrupslimeballPresser)
        {
        	registerItemRecipe(FruitRegistry.getFood(FruitRegistry.MAPLE), Items.SLIME_BALL, ItemRegistry.freshwaterItem);
        }
        if (HarvestCraft.config.enablehoneyslimeballPresser)
        {
        	registerItemRecipe(ItemRegistry.honeyItem, Items.SLIME_BALL, ItemRegistry.freshwaterItem);
        }
    }

    private static void registerItemRecipe(Item input, Item leftItem, Item rightItem) {
        final ItemStack outputLeft = leftItem != null ? new ItemStack(leftItem) : ItemStack.EMPTY;
        final ItemStack outputRight = rightItem != null ? new ItemStack(rightItem) : ItemStack.EMPTY;

        makeItemStackRecipe(new ItemStack(input, 1, 32767), outputLeft, outputRight);
    }

    private static void registerBlockRecipe(Block input, Item leftItem, Item rightItem) {
        registerItemRecipe(Item.getItemFromBlock(input), leftItem, rightItem);
    }

    private static void makeItemStackRecipe(ItemStack input, ItemStack outputLeft, ItemStack outputRight) {
        final ItemStack[] outputs = new ItemStack[] {outputLeft, outputRight};
        pressingList.put(input, outputs);
    }

    public static ItemStack[] getPressingResult(ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack[]> entry : pressingList.entrySet()) {
            if (isSameItem(input, entry.getKey())) return entry.getValue();
        }

        return null;
    }

    private static boolean isSameItem(ItemStack stack, ItemStack stack2) {
        return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
    }
}
