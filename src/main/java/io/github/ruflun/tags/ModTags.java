package io.github.ruflun.tags;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final class Blocks {
        // Blocks that can be used to open an Uper Core
        public static final TagKey<Block> UPERCORE_OPENER = register(Registries.BLOCK, "upercore_opener");

        // Mojave ores
        public static final TagKey<Block> MOJAVE_ORES = register(Registries.BLOCK, "mojave_ores");

        // Dirt & mud ores replaceable
        public static final TagKey<Block> DIRT_ORE_REPLACEABLES = register(Registries.BLOCK, "dirt_ore_replaceables");
        public static final TagKey<Block> MUD_ORE_REPLACEABLES = register(Registries.BLOCK, "mud_ore_replaceables");
    }

    public static final class Items {
        // Essence items registered by the mod
        public static final TagKey<Item> ESSENCES = register(Registries.ITEM, "essences");

        // Items that should float midair, Terraria souls style
        public static final TagKey<Item> FLOATING = register(Registries.ITEM, "floating");
    }



    private static <T> TagKey<T> register(ResourceKey<Registry<T>> tagKey, String id) {
        return TagKey.create(tagKey, RuflunSThingamabobs.id(id));
    }

    public static void registerModTags() {
        RuflunSThingamabobs.LOGGER.info("Registering tags for " + RuflunSThingamabobs.MOD_ID);
    }
}
