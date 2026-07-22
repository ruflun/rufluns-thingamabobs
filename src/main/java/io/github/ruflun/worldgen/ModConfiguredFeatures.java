package io.github.ruflun.worldgen;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.block.ModBlocks;
import io.github.ruflun.tags.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    // Reusable resource keys, created because ModPlacedFeatures also needs them
    public static final ResourceKey<ConfiguredFeature<?, ?>> UPER_CORE_ORE_CFKEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, RuflunSThingamabobs.id("uper_core_ore"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOJAVE_ORES_CFKEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, RuflunSThingamabobs.id("mojave_ores"));

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // Rule tests
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest dirtReplaceable = new TagMatchTest(ModTags.Blocks.DIRT_ORE_REPLACEABLES);
        RuleTest mudReplaceable = new TagMatchTest(ModTags.Blocks.MUD_ORE_REPLACEABLES);

        // Registering
        // Uper core ore
        context.register( // Comments below for future references
                UPER_CORE_ORE_CFKEY, // New resource key named after the ore generation feature
                new ConfiguredFeature<>( // Creating a configured feature (don't forget to remove generics auto-typing!)
                        Feature.ORE, // Feature type
                        new OreConfiguration( // Creating an ore configuration since our feature type is ores
                                List.of( // List containing one or multiple targets for blocks, which takes a ruletest & the resulting block's default blockstate
                                        OreConfiguration.target(deepslateReplaceable, ModBlocks.UPER_CORE_ORE.defaultBlockState())
                                ),
                                4, // Vein size (bigger number = more ores. Number too big = bad decision)
                                0.55f // Discard on air chance (if the worldgen should not generate the ore if it's exposed to an air block)
                        )
                )
        );

        // Mojave ores
        context.register(
                MOJAVE_ORES_CFKEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(
                                List.of(
                                        OreConfiguration.target(dirtReplaceable, ModBlocks.MOJAVE_ORE.defaultBlockState()),
                                        OreConfiguration.target(mudReplaceable, ModBlocks.MUD_MOJAVE_ORE.defaultBlockState())
                                ),
                                20,
                                0.0f
                        )
                )
        );
    }
}
