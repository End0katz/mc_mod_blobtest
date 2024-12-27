package com.end0katz.blobtest;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Blobtest implements ModInitializer {
	public static final String MOD_ID = "blobtest";

	public enum InitState {
		PRE, LOGGER, ITEMS, BLOCKS, ENTITIES, COMPLETED;
	}

	public static InitState initstate = InitState.PRE;

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void completed(String x){
		LOGGER.info("\t # %s".formatted(x));
	}

	@Override
	public void onInitialize() {

		LOGGER.info("------- Blobtest Initializing progress: -------");

		initstate = InitState.LOGGER;
		LOGGER.info("\t # Logger");

		initstate = InitState.ITEMS;



		LOGGER.info("------- Blobtest Initializing completed -------");
	}
}