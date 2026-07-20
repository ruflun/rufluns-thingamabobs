package io.github.ruflun.client.datagen;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.block.ModBlocks;
import io.github.ruflun.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import org.jspecify.annotations.NonNull;

public class RuflunSThingamabobsModelProvider extends FabricModelProvider {

    public RuflunSThingamabobsModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        // Generic cube blocks
        blockModelGenerators.createTrivialCube(ModBlocks.FREAKYMAN);
        blockModelGenerators.createTrivialCube(ModBlocks.UPER_CORE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        // Flat items (classical)
        itemModelGenerators.generateFlatItem(ModItems.TEST_ITEM, ModelTemplates.FLAT_ITEM);

        // Custom 3D model items via Blockbench
        itemModelGenerators.itemModelOutput.accept(
                ModItems.UPER_CORE,
                ItemModelUtils.plainModel(RuflunSThingamabobs.id("item/uper_core"))
        );
    }

    @Override
    public @NonNull String getName() {
        return "RufrixModelProvider";
    }
}
