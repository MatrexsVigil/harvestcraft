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

public class WaterFilterRecipes {
    private static final Map<ItemStack, ItemStack[]> waterfilterList = new HashMap<ItemStack, ItemStack[]>();

    static {
        registerItemRecipe(ItemRegistry.wovencottonItem, ItemRegistry.freshwaterItem, ItemRegistry.saltItem);

        //registerBlockRecipe(Blocks.LOG2, Items.PAPER, Items.PAPER);

    }

    private static void registerItemRecipe(Item input, Item leftItem, Item rightItem) {
    	final ItemStack outputLeft = leftItem != null ? new ItemStack(leftItem, HarvestCraft.config.waterfilterfreshwaterAmount, 0) : ItemStack.EMPTY;
        final ItemStack outputRight = rightItem != null ? new ItemStack(rightItem, HarvestCraft.config.waterfiltersaltAmount, 0) : ItemStack.EMPTY;

        makeItemStackRecipe(new ItemStack(input, 1, 32767), outputLeft, outputRight);
    }

    private static void registerBlockRecipe(Block input, Item leftItem, Item rightItem) {
        registerItemRecipe(Item.getItemFromBlock(input), leftItem, rightItem);
    }

    private static void makeItemStackRecipe(ItemStack input, ItemStack outputLeft, ItemStack outputRight) {
        final ItemStack[] outputs = new ItemStack[] {outputLeft, outputRight};
        waterfilterList.put(input, outputs);
    }

    public static ItemStack[] getFilterResult(ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack[]> entry : waterfilterList.entrySet()) {
            if (isSameItem(input, entry.getKey())) return entry.getValue();
        }

        return null;
    }

    private static boolean isSameItem(ItemStack stack, ItemStack stack2) {
        return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
    }
}
