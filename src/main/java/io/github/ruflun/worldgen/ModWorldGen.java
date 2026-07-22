package io.github.ruflun.worldgen;

import io.github.ruflun.RuflunSThingamabobs;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModWorldGen {

    // Biome settings: final touch for making worldgen work
    private static void initBiomeModifications() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.UPER_CORE_ORE_PFKEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.all(),
                GenerationStep.Decoration.RAW_GENERATION,
                ModPlacedFeatures.MOJAVE_ORES_PFKEY
        );
    }

    public static void registerWorldGen() {
        RuflunSThingamabobs.LOGGER.info("Registering world gen for " + RuflunSThingamabobs.MOD_ID);

        initBiomeModifications();
    }
}
