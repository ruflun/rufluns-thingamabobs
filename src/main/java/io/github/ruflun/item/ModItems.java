package io.github.ruflun.item;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    // Registering individual items below
    public static final Item TEST_ITEM = register("test_item", TestItem::new);
    public static final Item UPER_ESSENCE = register("uper_essence", Item::new);
    public static final Item UPER_CORE = register("uper_core", UperCore::new);



    // Register method
    private static Item register(String name, Function<Item.Properties, Item> function) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(RuflunSThingamabobs.MOD_ID, name),
                function.apply(
                        new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        Identifier.fromNamespaceAndPath(RuflunSThingamabobs.MOD_ID, name)
                                )
                        )
                )
        );
    }

    public static void registerModItems() {
        RuflunSThingamabobs.LOGGER.info("Registering items for " + RuflunSThingamabobs.MOD_ID);
    }
}
