package io.github.ruflun.client.datagen;

import io.github.ruflun.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RuflunSThingamabobsBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public RuflunSThingamabobsBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    // Shorthand method
    private static Identifier id(String id) { return Identifier.parse(id); }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        //=== MOD TAGS ===//

        // Blocks that can be used to open Uper Cores
        getOrCreateRawBuilder(ModTags.Blocks.UPERCORE_OPENER)
                .addElement(id("minecraft:bedrock"))
                .addElement(id("minecraft:obsidian"))
                .addElement(id("minecraft:crying_obsidian"))
                .addElement(id("minecraft:diamond_block"))
                .addElement(id("minecraft:netherite_block"));

        // Mojave ores
        getOrCreateRawBuilder(ModTags.Blocks.MOJAVE_ORES)
                .addElement(id("rufrix:mojave_ore"))
                .addElement(id("rufrix:mud_mojave_ore"));

        // Dirt & mud ore replaceables
        getOrCreateRawBuilder(ModTags.Blocks.DIRT_ORE_REPLACEABLES)
                .addElement(id("minecraft:dirt"))
                .addElement(id("minecraft:coarse_dirt"))
                .addElement(id("minecraft:rooted_dirt"));
        getOrCreateRawBuilder(ModTags.Blocks.MUD_ORE_REPLACEABLES)
                .addElement(id("minecraft:mud"))
                .addElement(id("minecraft:muddy_mangrove_roots"));



        //=== VANILLA TAGS ===//

        // Block mining material requirement
        getOrCreateRawBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .addElement(id("rufrix:uper_core_ore"));
        getOrCreateRawBuilder(BlockTags.NEEDS_STONE_TOOL)
                .addTag(id("rufrix:mojave_ores"))
                .addElement(id("rufrix:mojave_block"))
                .addElement(id("rufrix:raw_mojave_block"));

        // Block mining tool requirement
        getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addElement(id("rufrix:uper_core_ore"))
                .addElement(id("rufrix:mojave_block"))
                .addElement(id("rufrix:raw_mojave_block"))
                .addElement(id("rufrix:mojave_rootseed"));
        getOrCreateRawBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(id("rufrix:mojave_ores"));
    }

    @Override
    public @NonNull String getName() {
        return "RufrixBlockTagsProvider";
    }
}
