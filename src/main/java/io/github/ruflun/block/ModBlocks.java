package io.github.ruflun.block;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {

    public static final Block FREAKYMAN = register("freakyman", Freakyman::new, Freakyman.blockItemProperties);
    public static final Block UPER_CORE_ORE = register("uper_core_ore", OresConstructor.UPER_CORE_ORE::new, true);



    private static Block register(String name, Function<BlockBehaviour.Properties, Block> function, boolean registerSimpleBlockItem) {
        Block block = rawRegisterBlock(name, function);
        if (registerSimpleBlockItem) registerBlockitem(name, block, BlockItem::new);
        return block;
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> function, BiFunction<Block, Item.Properties, BlockItem> itemFunction) {
        Block block = rawRegisterBlock(name, function);
        registerBlockitem(name, block, itemFunction);
        return block;
    }

    private static Block rawRegisterBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                RuflunSThingamabobs.id(name),
                function.apply(BlockBehaviour.Properties.of().setId(
                        ResourceKey.create(
                                Registries.BLOCK,
                                RuflunSThingamabobs.id(name)
                        )
                ))
        );
    }

    private static void registerBlockitem(String name, Block block, BiFunction<Block, Item.Properties, BlockItem> function) {
        Registry.register(
                BuiltInRegistries.ITEM,
                RuflunSThingamabobs.id(name),
                function.apply(
                        block,
                        new Item.Properties()
                                .useBlockDescriptionPrefix()
                                .setId(ResourceKey.create(
                                        Registries.ITEM,
                                        RuflunSThingamabobs.id(name)
                                ))
                )
        );
    }

    public static void registerModBlocks() {
        RuflunSThingamabobs.LOGGER.info("Registering blocks for " + RuflunSThingamabobs.MOD_ID);
    }
}
