package com.arrodevv;

import com.arrodevv.block.ModBlocks;
import com.arrodevv.item.ModItemGroups;
import com.arrodevv.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfessionalRocketry implements ModInitializer {
	public static final String MODID = "professionalrocketry";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModBlocks.init();

		ModItemGroups.init();
	}
}