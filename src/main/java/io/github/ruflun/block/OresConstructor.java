package io.github.ruflun.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

// Superclass for ores & any ore-like blocks (drops a resource when broken & has ore-like loot tables)
public class OresConstructor {

    public static final class UPER_CORE_ORE extends Block {

        public UPER_CORE_ORE(Properties properties) {
            super(properties
                    .strength(9.0f, 25.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            );
        }
    }

    public static final class MOJAVE_ORE extends Block {

        public MOJAVE_ORE(Properties properties) {
            super(properties
                    .strength(1.5f, 1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GRAVEL)
            );
        }
    }

    public static final class MUD_MOJAVE_ORE extends Block {
        public MUD_MOJAVE_ORE(Properties properties) {
            super(properties
                    .strength(1.5f, 1.5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.MUD)
            );
        }
    }
}
