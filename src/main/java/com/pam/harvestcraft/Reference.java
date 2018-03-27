package com.pam.harvestcraft;

import net.minecraft.client.resources.I18n;

/**
 * Strings starting with "PROP:" are replaced by Gradle.
 */
public class Reference {
	public static final String MODID = "harvestcraft";
	public static final String NAME = "Pam's HarvestCraft";
	public static final String VERSION = "1.12.2t";
	public static final String CLIENT_PROXY_CLASS = "com.pam.harvestcraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.pam.harvestcraft.proxy.ServerProxy";

	public static final String ITALIC = (char) 167 + "o";
	public static final String BRIGHT_BLUE = (char) 167 + "b";

	/*public static String getSaturationText(float saturation) {
		if(saturation <= HarvestCraft.config.snacksaturation) {
			return ITALIC + I18n.format("item.desc.snack");
		}

		if(saturation <= HarvestCraft.config.mealsaturation) {
			return ITALIC + I18n.format("item.desc.lightmeal");
		}

		if(saturation <= HarvestCraft.config.meatymealsaturation) {
			return ITALIC + I18n.format("item.desc.largemeal");
		}

		return "";
	}*/
}