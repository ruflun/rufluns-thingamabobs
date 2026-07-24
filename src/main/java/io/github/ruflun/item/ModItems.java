package io.github.ruflun.item;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.item.utility.IngotMold;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    // Registering individual items below
    public static final Item UPER_ESSENCE = register("uper_essence", Item::new);
    public static final Item UPER_CORE = register("uper_core", UperCore::new);

    public static final Item RAW_MOJAVE = register("raw_mojave", GenericItemsWithLore.RAW_MOJAVE);
    public static final Item MOJAVE_INGOT = register("mojave_ingot", Item::new);
    public static final Item MOJAVE_NUGGET = register("mojave_nugget", Item::new);

    public static final Item INGOT_MOLD = register("ingot_mold", IngotMold::new);

    public static final Item TEST_ITEM = register("test_item", TestItem::new);



    // Register method
    private static Item register(String name, Function<Item.Properties, Item> function) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                RuflunSThingamabobs.id(name),
                function.apply(
                        new Item.Properties().setId(
                                ResourceKey.create(
                                        Registries.ITEM,
                                        RuflunSThingamabobs.id(name)
                                )
                        )
                )
        );
    }

    public static void registerModItems() {
        RuflunSThingamabobs.LOGGER.info("Registering items for " + RuflunSThingamabobs.MOD_ID);
    }
}
