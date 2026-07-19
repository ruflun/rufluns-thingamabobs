package io.github.ruflun.loot_table;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {

    public static final ResourceKey<LootTable> UPERCORE_OPEN = register("gameplay/upercore_open");



    private static ResourceKey<LootTable> register(String id) {
        return ResourceKey.create(
                Registries.LOOT_TABLE,
                RuflunSThingamabobs.id(id)
        );
    }

    public static void registerModLootTables() {
        RuflunSThingamabobs.LOGGER.info("Registering loot tables for " + RuflunSThingamabobs.MOD_ID);
    }
}
