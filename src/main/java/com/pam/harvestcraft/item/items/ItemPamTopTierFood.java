package com.pam.harvestcraft.item.items;

import java.util.List;

import javax.annotation.Nullable;

import com.pam.harvestcraft.HarvestCraft;
import com.pam.harvestcraft.Reference;
import com.pam.harvestcraft.config.ConfigHandler;
import com.pam.harvestcraft.item.ItemRegistry;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPamTopTierFood extends ItemFood {

    public final float saturation;


    public ItemPamTopTierFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(HarvestCraft.modTab);
        this.setAlwaysEdible();
        this.saturation = saturation;

        
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.EAT;
    }
    
    @Override
    protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("strength"), ConfigHandler.buffTimeForTopTier, 0));
    	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("resistance"), ConfigHandler.buffTimeForTopTier, 0));
    	
    	if (this == ItemRegistry.glisteningsaladItem)
    	{
    		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("strength"), ConfigHandler.buffTimeForTopTier, 0));
        	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("resistance"), ConfigHandler.buffTimeForTopTier, 0));
        	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"), ConfigHandler.buffTimeForTopTier, 0));
        	
    	}
    }

    /*
    public ItemPamTopTierFood addDefaultStrengthPotionEffect() {
        setAlwaysEdible();

        final Potion potion = Potion.getPotionFromResourceLocation("strength");
        if (potion == null) {
            FMLLog.bigWarning("Could not set potion effect.");
            return this;
        }
        setPotionEffect(new PotionEffect(potion, ConfigHandler.buffTimeForTopTier, 0), 0.8F);
        return this;
    }
    
    public ItemPamTopTierFood addDefaultResistancePotionEffect() {
        setAlwaysEdible();

        final Potion potion = Potion.getPotionFromResourceLocation("resistance");
        if (potion == null) {
            FMLLog.bigWarning("Could not set potion effect.");
            return this;
        }
        setPotionEffect(new PotionEffect(potion, ConfigHandler.buffTimeForTopTier, 0), 0.8F);
        return this;
    }
    */
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TextFormatting.GOLD + "Top Tier Food: Always Edible: Buffs Player");
    }

}
