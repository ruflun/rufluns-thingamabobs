package io.github.ruflun.client;

import io.github.ruflun.client.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class RuflunSThingamabobsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RuflunSThingamabobsBlockTagProvider::new);
		pack.addProvider(RuflunSThingamabobsItemTagProvider::new);
		pack.addProvider(RuflunSThingamabobsModelProvider::new);
		pack.addProvider(RuflunSThingamabobsBlockLootProvider::new);
		pack.addProvider(RuflunSThingamabobsAdvancementProvider::new);
	}
}
