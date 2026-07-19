package io.github.ruflun.client.datagen;

import io.github.ruflun.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;

public class RuflunSThingamabobsModelProvider extends FabricModelProvider {
    public RuflunSThingamabobsModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.TEST_ITEM, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public @NonNull String getName() {
        return "RufrixModelProvider";
    }
}
