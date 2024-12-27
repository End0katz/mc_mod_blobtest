package com.end0katz.blobtest;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Blobtest implements ModInitializer {
	public static final String MOD_ID = "blobtest";
	public static HashMap<String, Boolean> LoadedThings = new HashMap<>();
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LoadedThings.putIfAbsent("Items:start", false);
		LoadedThings.putIfAbsent("Items:finish", false);

		try{Thread.sleep(10000L);} catch (InterruptedException e) {
			LOGGER.info("InterruptedExecution whilst sleeping: %s".formatted(e.getMessage()));
		}

		LOGGER.info("------- Blobtest Initializing progress: -------");
		LOGGER.info(" # Logger");
		for (String i: LoadedThings.keySet()){
			if (LoadedThings.get(i)){
				LOGGER.info(" # %s".formatted(i));
			} else {
				LOGGER.warn(" WARNING: %s did not load within 10 seconds".formatted(i));
			}
		}
		LOGGER.info("------- Blobtest Initializing completed -------");
	}
}