package com.pam.harvestcraft.item;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public class RecipeRemoval {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistryModifiable<IRecipe> recipeRegistry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
        dummyOutRecipe(recipeRegistry, "minecraft:bread");
        dummyOutRecipe(recipeRegistry, "minecraft:rabbit_stew");
        dummyOutRecipe(recipeRegistry, "minecraft:beetroot_soup");
        dummyOutRecipe(recipeRegistry, "minecraft:mushroom_stew");
        dummyOutRecipe(recipeRegistry, "minecraft:cookie");
        dummyOutRecipe(recipeRegistry, "minecraft:pumpkin_pie");
        dummyOutRecipe(recipeRegistry, "minecraft:baked_potato");
    }

    /**
     * Prevents issues with vanilla advancements spamming the console
     * @param registry recipe registry
     * @param resourceLocationPath path to the recipe
     */
    public static void dummyOutRecipe(IForgeRegistryModifiable<IRecipe> registry, String resourceLocationPath) {
        ResourceLocation location = new ResourceLocation(resourceLocationPath);
        IRecipe recipe = registry.getValue(location);
        if(recipe != null) {
            registry.remove(location);
            registry.register(DummyRecipe.from(recipe));
        } else {
            FMLLog.warning("Unable to find recipe for "+resourceLocationPath);
        }
    }

}
