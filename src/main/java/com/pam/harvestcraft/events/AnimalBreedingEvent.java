package com.pam.harvestcraft.events;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.oredict.OreDictionary;

public class AnimalBreedingEvent {

	@SubscribeEvent
	public void onInteraction(PlayerInteractEvent.EntityInteract event) {
		Set<Item> breedItems = OreDictionary.getOres("listAllgrain").stream().map(ItemStack::getItem).collect(Collectors.toSet());
		
		if (event.getEntity() instanceof EntityCow) {
	        handleBreedItem((EntityCow) event.getEntity(), breedItems, event.getEntityPlayer(), event.getHand());
	    } else if (event.getEntity() instanceof EntitySheep) {
	        handleBreedItem((EntityCow) event.getEntity(), breedItems, event.getEntityPlayer(), event.getHand());
	    }
	}

	private void handleBreedItem(EntityAnimal entity, Set<Item> breedItems, EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

        if (!itemstack.isEmpty())
        {
        	int inLove = ReflectionHelper.getPrivateValue(EntityAnimal.class, entity, "inLove", "field_70881_d");
            if (breedItems.contains(itemstack.getItem()) && entity.getGrowingAge() == 0 && inLove <= 0)
            {
            	itemstack.shrink(1);
            	entity.setInLove(player);
            }

            if (entity.isChild() && entity.isBreedingItem(itemstack))
            {
            	itemstack.shrink(1);
            	entity.ageUp((int)((float)(-entity.getGrowingAge() / 20) * 0.1F), true);
            }
        }
	}
}
