package io.github.ruflun.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class GenericItemsWithLore {

    // Normal items
    public static final Function<Item.Properties, Item> RAW_MOJAVE = (properties -> new Item(
            properties.component(DataComponents.LORE, new ItemLore(List.of(
                    Component.translatable("tooltip.rufrix.raw_mojave.1").withColor(TextColor.GRAY),
                    Component.translatable("tooltip.rufrix.raw_mojave.2").withColor(TextColor.GRAY)
            )))
    ));

    // Block items
    public static final BiFunction<Block, Item.Properties, BlockItem> MOJAVE_ORES = ((block, properties) -> new BlockItem(block,
            properties.component(DataComponents.LORE, new ItemLore(List.of(
                    Component.translatable("tooltip.rufrix.mojave_ores").withColor(TextColor.GRAY)
            )))
    ));
}
