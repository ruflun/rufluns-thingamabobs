package io.github.ruflun.item;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.function.Function;

public class ModItems {

    // Registering individual items below
    public static final Item TEST_ITEM = register("test_item", MiscItems.TEST_ITEM);



    // Collection of registered items for easier iteration in the future
    private static ArrayList<Item> registered_items = new ArrayList<Item>();

    public static Item register(String name, Function<Item.Properties, Item> function) {
        Item reg = Registry.register(
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

        // Adding the registered item to the collection for needed iterations
        registered_items.add(reg);
        return reg;
    }



    // Creative mod tab



    public static void registerModItems() {
        RuflunSThingamabobs.LOGGER.info("Registering items for " + RuflunSThingamabobs.MOD_ID);
    }
}
