package io.github.ruflun.client.datagen;

import io.github.ruflun.block.ModBlocks;
import io.github.ruflun.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class RuflunSThingamabobsBlockLootProvider extends FabricBlockLootSubProvider {

    public RuflunSThingamabobsBlockLootProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        // Ore drops
        add(ModBlocks.UPER_CORE_ORE, block -> createOreDrop(block, ModItems.UPER_CORE));

        // Block that drops themselves
        dropSelf(ModBlocks.RFLINTGLASSNOTFLINTHLUN);
    }

    @Override
    public @NonNull String getName() {
        return "RufrixBlockLootProvider";
    }
}
