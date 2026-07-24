package io.github.ruflun.block.generic;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class MojaveBlocks extends Block {

    public MojaveBlocks(Properties properties) {
        super(properties
                .strength(3, 6)
                .sound(SoundType.IRON)
                .requiresCorrectToolForDrops()
                .friction(0.9f)
                .speedFactor(0.9f)
                .jumpFactor(0.9f)
        );
    }
}
