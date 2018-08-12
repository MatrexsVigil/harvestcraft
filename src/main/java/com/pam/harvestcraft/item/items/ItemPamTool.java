package com.pam.harvestcraft.item.items;

import java.util.List;

import javax.annotation.Nullable;

import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPamTool extends Item {
    public ItemPamTool() {
        setMaxStackSize(1);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	if(this == ItemRegistry.potItem)
    	{
    		super.addInformation(stack, worldIn, tooltip, flagIn);
            tooltip.add(TextFormatting.GOLD + "How do I make a pot, Pam?! - Lewis");
    	}
        
    }
}