package io.github.ruflun.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class OresConstructor {

    public static final class UPER_CORE_ORE extends Block {

        public UPER_CORE_ORE(Properties properties) {
            super(properties
                    .strength(4.5f, 25.0f)
                    .requiresCorrectToolForDrops()

            );
        }
    }
}
