package io.github.ruflun.client;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.client.datagen.*;
import io.github.ruflun.worldgen.ModConfiguredFeatures;
import io.github.ruflun.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class RuflunSThingamabobsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		RuflunSThingamabobs.LOGGER.info("Running data generation for " + RuflunSThingamabobs.MOD_ID);

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RuflunSThingamabobsBlockTagProvider::new);
		pack.addProvider(RuflunSThingamabobsItemTagProvider::new);
		pack.addProvider(RuflunSThingamabobsModelProvider::new);
		pack.addProvider(RuflunSThingamabobsBlockLootProvider::new);
		pack.addProvider(RuflunSThingamabobsAdvancementProvider::new);
		pack.addProvider(RuflunSThingamabobsWorldgenProvider::new);

		RuflunSThingamabobs.LOGGER.info("Finished data generation for " + RuflunSThingamabobs.MOD_ID);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registrySetBuilder) {
		registrySetBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::configure);
		registrySetBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::configure);
	}
}
