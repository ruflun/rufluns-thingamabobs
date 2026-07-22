package io.github.ruflun.worldgen;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> UPER_CORE_ORE_PFKEY = ResourceKey.create(Registries.PLACED_FEATURE, RuflunSThingamabobs.id("uper_core_ore_placed"));
    public static final ResourceKey<PlacedFeature> MOJAVE_ORES_PFKEY = ResourceKey.create(Registries.PLACED_FEATURE, RuflunSThingamabobs.id("mojave_ores_placed"));

    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Uper core ore
        context.register(
                UPER_CORE_ORE_PFKEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.UPER_CORE_ORE_CFKEY),
                        List.of(
                                CountPlacement.of(2), // Ore placement attempt per chunks
                                RarityFilter.onAverageOnceEvery(4), // 1 in n chance to place that ore in the chunk
                                InSquarePlacement.spread(), // Required for ores to properly generate
                                HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.absolute(-59), VerticalAnchor.absolute(-40), 1)), // HeightPlacementRange has 3 different placement types. Defines the Y-level range & spread for ores.
                                BiomeFilter.biome() // Biome filter
                        )
                )
        );

        // Mojave ores
        context.register(
                MOJAVE_ORES_PFKEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.MOJAVE_ORES_CFKEY),
                        List.of(
                                CountPlacement.of(20),
                                RarityFilter.onAverageOnceEvery(2),
                                InSquarePlacement.spread(),
                                HeightRangePlacement.uniform(VerticalAnchor.absolute(55), VerticalAnchor.absolute(300)),
                                BiomeFilter.biome()
                        )
                )
        );
    }
}
