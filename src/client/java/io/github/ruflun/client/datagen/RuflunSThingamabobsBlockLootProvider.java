package io.github.ruflun.client.datagen;

import io.github.ruflun.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RuflunSThingamabobsBlockLootProvider extends FabricBlockLootSubProvider {

    public RuflunSThingamabobsBlockLootProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        // Ore drops
    }

    @Override
    public @NonNull String getName() {
        return "RufrixBlockLootProvider";
    }
}
