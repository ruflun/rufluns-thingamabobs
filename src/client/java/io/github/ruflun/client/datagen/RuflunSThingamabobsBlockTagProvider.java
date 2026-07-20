package io.github.ruflun.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RuflunSThingamabobsBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public RuflunSThingamabobsBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {

    }

    @Override
    public @NonNull String getName() {
        return "RufrixBlockTagsProvider";
    }
}
