package com.end0katz.blobtest;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Blobtest implements ModInitializer {
	public static final String MOD_ID = "blobtest";

	public enum InitState {
		PRE(0), LOGGER(1), ITEMS(2), BLOCKS(3), ENTITIES(4), COMPLETED(5);

		private int x;

		private InitState(int x){
			this.x = x;
		}

		public boolean can_do(InitState other){
			return this.x >= other.x;
		}
	}

	public static InitState initstate = InitState.PRE;

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void completed(String x){
		LOGGER.info("     # %s".formatted(x));
	}

	@Override
	public void onInitialize() {

		LOGGER.info("------- Blobtest Initializing progress: -------");

		initstate = InitState.LOGGER;
		completed("Logger");

		initstate = InitState.ITEMS;
		Items.initialize();

		initstate = InitState.BLOCKS;
		Blocks.initialize();

		initstate = InitState.ENTITIES;
		Entities.initialize();

		initstate = InitState.COMPLETED;
		LOGGER.info("------- Blobtest Initializing completed -------");
	}
}