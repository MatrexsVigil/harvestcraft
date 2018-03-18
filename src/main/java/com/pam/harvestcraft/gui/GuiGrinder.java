package com.pam.harvestcraft.gui;

import org.lwjgl.opengl.GL11;

import com.pam.harvestcraft.tileentities.TileEntityGrinder;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiGrinder extends GuiContainer {
    private final TileEntityGrinder entityGrinder;
    private static final ResourceLocation gui = new ResourceLocation("harvestcraft", "textures/gui/grinder.png");

    public GuiGrinder(InventoryPlayer player, TileEntityGrinder entityGrinder) {
        super(new ContainerGrinder(player, entityGrinder));

        this.entityGrinder = entityGrinder;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(gui);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        int progress = entityGrinder.getCookProgressScaled(24);
        drawTexturedModalRect(x + 76, y + 8, 176, 18, progress + 1, 16);

    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}