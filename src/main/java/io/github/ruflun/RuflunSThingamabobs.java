package io.github.ruflun;

import io.github.ruflun.item.ModItems;
import io.github.ruflun.loot_table.ModLootTables;
import io.github.ruflun.sound.ModSounds;
import io.github.ruflun.tags.ModTags;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuflunSThingamabobs implements ModInitializer {
	public static final String MOD_ID = "rufrix";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Ruflun's Thingamabobs initialized");

		ModTags.registerModTags();
		ModLootTables.registerModLootTables();
		ModSounds.registerModSounds();
		ModItems.registerModItems();

		LOGGER.info("Ruflun's Thingamabobs successfully loaded");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
