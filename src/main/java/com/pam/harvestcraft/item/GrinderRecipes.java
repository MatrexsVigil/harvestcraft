package com.pam.harvestcraft.item;

import java.util.HashMap;
import java.util.Map;

import com.pam.harvestcraft.blocks.CropRegistry;
import com.pam.harvestcraft.blocks.FruitRegistry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderRecipes {
    private static final Map<ItemStack, ItemStack[]> grindingList = new HashMap<ItemStack, ItemStack[]>();

    static {
    	//Ground Meat
        registerItemRecipe(Items.CHICKEN, ItemRegistry.groundchickenItem, ItemRegistry.groundchickenItem);
        registerItemRecipe(ItemRegistry.harvestchickenItem, ItemRegistry.groundchickenItem, ItemRegistry.groundchickenItem);
        registerItemRecipe(ItemRegistry.rawtofickenItem, ItemRegistry.groundchickenItem, ItemRegistry.groundchickenItem);
        
        registerItemRecipe(Items.PORKCHOP, ItemRegistry.groundporkItem, ItemRegistry.groundporkItem);
        registerItemRecipe(ItemRegistry.harvestporkchopItem, ItemRegistry.groundporkItem, ItemRegistry.groundporkItem);
        registerItemRecipe(ItemRegistry.rawtofaconItem, ItemRegistry.groundporkItem, ItemRegistry.groundporkItem);
        
        registerItemRecipe(Items.BEEF, ItemRegistry.groundbeefItem, ItemRegistry.groundbeefItem);
        registerItemRecipe(ItemRegistry.harvestbeefItem, ItemRegistry.groundbeefItem, ItemRegistry.groundbeefItem);
        registerItemRecipe(ItemRegistry.rawtofeakItem, ItemRegistry.groundbeefItem, ItemRegistry.groundbeefItem);
        
        registerItemRecipe(Items.MUTTON, ItemRegistry.groundmuttonItem, ItemRegistry.groundmuttonItem);
        registerItemRecipe(ItemRegistry.harvestmuttonItem, ItemRegistry.groundmuttonItem, ItemRegistry.groundmuttonItem);
        registerItemRecipe(ItemRegistry.rawtofuttonItem, ItemRegistry.groundmuttonItem, ItemRegistry.groundmuttonItem);
        
        registerItemRecipe(Items.RABBIT, ItemRegistry.groundrabbitItem, ItemRegistry.groundrabbitItem);
        registerItemRecipe(ItemRegistry.harvestrabbitItem, ItemRegistry.groundrabbitItem, ItemRegistry.groundrabbitItem);
        registerItemRecipe(ItemRegistry.rawtofabbitItem, ItemRegistry.groundrabbitItem, ItemRegistry.groundrabbitItem);
        
        registerItemRecipe(ItemRegistry.turkeyrawItem, ItemRegistry.groundturkeyItem, ItemRegistry.groundturkeyItem);
        registerItemRecipe(ItemRegistry.rawtofurkeyItem, ItemRegistry.groundturkeyItem, ItemRegistry.groundturkeyItem);
        
        registerItemRecipe(ItemRegistry.venisonrawItem, ItemRegistry.groundvenisonItem, ItemRegistry.groundvenisonItem);
        registerItemRecipe(ItemRegistry.rawtofenisonItem, ItemRegistry.groundvenisonItem, ItemRegistry.groundvenisonItem);
        
        registerItemRecipe(ItemRegistry.duckrawItem, ItemRegistry.groundduckItem, ItemRegistry.groundduckItem);
        registerItemRecipe(ItemRegistry.rawtofuduckItem, ItemRegistry.groundduckItem, ItemRegistry.groundduckItem);
        
        registerItemRecipe(Items.FISH, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.harvestfishItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.rawtofishItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.harvestsalmonItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.harvestclownfishItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.harvestpufferfishItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.calamarirawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.anchovyrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.bassrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.carprawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.catfishrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.charrrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.grouperrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.herringrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.mudfishrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.perchrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.snapperrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.tilapiarawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.troutrawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.tunarawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.walleyerawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.greenheartfishItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        registerItemRecipe(ItemRegistry.sardinerawItem, ItemRegistry.groundfishItem, ItemRegistry.groundfishItem);
        
        // Flour
        registerItemRecipe(Items.WHEAT, ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(ItemRegistry.harvestwheatItem, ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(Items.POTATO, ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(ItemRegistry.harvestpotatoItem, ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.BARLEY), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.OATS), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.RICE), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.RYE), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.PEAS), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.SOYBEAN), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(CropRegistry.getFood(CropRegistry.BEAN), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.ALMOND), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.COCONUT), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.BANANA), ItemRegistry.flourItem, ItemRegistry.flourItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.CHESTNUT), ItemRegistry.flourItem, ItemRegistry.flourItem);
        
        // Other
        registerItemRecipe(CropRegistry.getFood(CropRegistry.SEAWEED), ItemRegistry.saltItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.PEPPERCORN), ItemRegistry.blackpepperItem, ItemRegistry.veggiebaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.NUTMEG), ItemRegistry.groundnutmegItem, ItemRegistry.grainbaitItem);
        registerItemRecipe(FruitRegistry.getFood(FruitRegistry.CINNAMON), ItemRegistry.groundcinnamonItem, ItemRegistry.grainbaitItem);
        
        //registerItemRecipe(ItemRegistry.waxcombItem, ItemRegistry.beeswaxItem, ItemRegistry.beeswaxItem);
        //registerBlockRecipe(Blocks.PUMPKIN, ItemRegistry.oliveoilItem, ItemRegistry.veggiebaitItem);
        
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
        grindingList.put(input, outputs);
    }

    public static ItemStack[] getGrindingResult(ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack[]> entry : grindingList.entrySet()) {
            if (isSameItem(input, entry.getKey())) return entry.getValue();
        }

        return null;
    }

    private static boolean isSameItem(ItemStack stack, ItemStack stack2) {
        return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
    }
}
