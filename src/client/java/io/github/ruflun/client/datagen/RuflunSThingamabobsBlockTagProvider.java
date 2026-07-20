package io.github.ruflun.client.datagen;

import io.github.ruflun.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
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



        //=== VANILLA TAGS ===//
    }

    @Override
    public @NonNull String getName() {
        return "RufrixBlockTagsProvider";
    }
}
