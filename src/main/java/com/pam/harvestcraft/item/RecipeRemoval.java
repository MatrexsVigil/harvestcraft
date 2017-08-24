package com.pam.harvestcraft.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public class RecipeRemoval {

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
    	ResourceLocation bread = new ResourceLocation("minecraft:bread");
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(bread);
        
        ResourceLocation rabbitstew = new ResourceLocation("minecraft:rabbit_stew");
        modRegistry.remove(rabbitstew);
        
        ResourceLocation beetrootsoup = new ResourceLocation("minecraft:beetroot_soup");
        modRegistry.remove(beetrootsoup);
        
        ResourceLocation mushroomstew = new ResourceLocation("minecraft:mushroom_stew");
        modRegistry.remove(mushroomstew);
        
        ResourceLocation cookie = new ResourceLocation("minecraft:cookie");
        modRegistry.remove(cookie);
        
        ResourceLocation pumpkinpie = new ResourceLocation("minecraft:pumpkin_pie");
        modRegistry.remove(pumpkinpie);
        
        ResourceLocation bakedpotato = new ResourceLocation("minecraft:baked_potato");
        modRegistry.remove(bakedpotato);
    }
}
