package io.github.ruflun.client.datagen;

import io.github.ruflun.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuflunSThingamabobsItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    public RuflunSThingamabobsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture, @Nullable BlockTagsProvider blockTagsProvider) {
        super(output, registryLookupFuture, blockTagsProvider);
    }

    // Shorthand method
    private static Identifier id(String id) { return Identifier.parse(id); }

    public RuflunSThingamabobsItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        //=== MOD TAGS ===///

        // Essence items
        getOrCreateRawBuilder(ModTags.Items.ESSENCES)
                .addElement(id("rufrix:uper_essence"));

        // Floating items
        getOrCreateRawBuilder(ModTags.Items.FLOATING)
                .addTag(id("rufrix:essences"))
                .addElement(id("minecraft:breeze_rod"))
                .addElement(id("minecraft:wind_charge"));



        //=== VANILLA TAGS ===//
    }

    @Override
    public @NonNull String getName() {
        return "RufrixItemTagsProvider";
    }
}
