package com.pam.harvestcraft.addons;

import net.minecraftforge.fml.common.event.FMLInterModComms;

public class Waila {
	public static void init() {
		FMLInterModComms.sendMessage("Waila", "register",
				"com.pam.harvestcraft.addons.WailaPamHandler.callbackRegister");

		// Should this be part of the mod? Fixing vanilla beetroot.
		// FMLInterModComms.sendMessage("Waila", "register",
		// "com.pam.harvestcraft.addons.WailaVanillaHandler.callbackRegister");
	}
}
