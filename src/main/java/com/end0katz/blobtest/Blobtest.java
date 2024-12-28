package com.end0katz.blobtest;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blobtest implements ModInitializer {
	public static final String MOD_ID = "blobtest";

	public enum InitState {
		PRE, LOGGER, ITEMS, BLOCKS, ENTITIES, COMPLETED;

		//// private final int x;
		//// InitState(int x){
		//// 	this.x = x;
		//// }

		//// public boolean can_do(InitState other){
		//// 	return this.x >= other.x;
		//// }
	}

	public static InitState initstate = InitState.PRE;

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void completed(String x){
		LOGGER.info("     # %s".formatted(x));
	}
	public static void failed(String x){
		LOGGER.warn("     ! FAILED: %s".formatted(x));
	}

	@Override
	public void onInitialize() {

		LOGGER.info("------- Blobtest Initializing progress: -------");

		initstate = InitState.LOGGER;
		completed("Logger");

		initstate = InitState.ITEMS;
		completed("Set-ITEMS");
		Items.initialize();
		completed("Done-ITEMS");

		initstate = InitState.BLOCKS;
		Blocks.initialize();

		initstate = InitState.ENTITIES;
		Entities.initialize();

		initstate = InitState.COMPLETED;
		LOGGER.info("------- Blobtest Initializing completed -------");
	}
}