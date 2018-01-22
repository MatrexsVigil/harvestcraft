package com.pam.harvestcraft.blocks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.blocks.blocks.BlockBaseGarden;
import com.pam.harvestcraft.blocks.growables.BlockPamCrop;
import com.pam.harvestcraft.blocks.growables.BlockPamFruit;
import com.pam.harvestcraft.blocks.growables.BlockPamFruitLog;
import com.pam.harvestcraft.blocks.growables.BlockPamSapling;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemModels {
    private static final HashMap<Item, ItemModelList> models = new HashMap<Item, ItemModelList>();

    public static void preInit() {
        defineItemModels();
        prepareModels();
    }

    public static void init() {
        registerModels();
    }

    private static void defineItemModels() {

        for (BlockBaseGarden garden : BlockRegistry.gardens.values()) {
            registerItemModels(getItem(garden), new ItemModelList("gardens/")
                    .add(0, garden.getName()));
        }
        for (BlockPamCrop crop : CropRegistry.getCrops().values()) {
            registerItemModels(getItem(crop), new ItemModelList("crops/")
                    .add(0, crop.getStageId(0))
                    .add(1, crop.getStageId(1))
                    .add(2, crop.getStageId(2))
                    .add(3, crop.getStageId(3)));
        }
        for (BlockPamSapling sapling : FruitRegistry.getSaplings()) {
            registerItemModels(getItem(sapling), new ItemModelList("saplings/")
                    .add(0, sapling.getName()));
        }

        for (BlockPamFruit fruit : FruitRegistry.fruits) {
            registerItemModels(getItem(fruit), new ItemModelList("fruits/")
                    .add(0, fruit.getStageId(0))
                    .add(1, fruit.getStageId(1))
                    .add(2, fruit.getStageId(2)));
        }

        for (BlockPamFruitLog fruit : FruitRegistry.logs.values()) {
            registerItemModels(getItem(fruit), new ItemModelList("fruits/")
                    .add(0, fruit.getStageId(0))
                    .add(1, fruit.getStageId(1))
                    .add(2, fruit.getStageId(2)));
        }
    }

    private static void registerItemModels(Item item, ItemModelList list) {
        models.put(item, list);
    }

    private static void prepareModels() {
        for (Map.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            Collection<String> registrations = entry.getValue().getRegistrations().values();

            for (String registration : registrations) {
                if (item == null || registration == null) continue;

                ModelBakery.registerItemVariants(item, new ResourceLocation(registration));
            }
        }
    }

    private static void registerModels() {
        for (HashMap.Entry<Item, ItemModelList> entry : models.entrySet()) {
            Item item = entry.getKey();

            HashMap<Integer, String> registrations = entry.getValue().getRegistrations();

            for (Map.Entry<Integer, String> registration : registrations.entrySet()) {
                int meta = registration.getKey();
                String path = registration.getValue();

                ModelResourceLocation resource = new ModelResourceLocation(path, "inventory");

                Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, resource);
            }
        }
    }

    private static Item getItem(Block block) {
        return Item.getItemFromBlock(block);
    }
}
