package io.github.ruflun.client;

import io.github.ruflun.client.datagen.RuflunSThingamabobsBlockLootProvider;
import io.github.ruflun.client.datagen.RuflunSThingamabobsBlockTagProvider;
import io.github.ruflun.client.datagen.RuflunSThingamabobsItemTagProvider;
import io.github.ruflun.client.datagen.RuflunSThingamabobsModelProvider;
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
	}
}
