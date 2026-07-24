package io.github.ruflun.block.utility;

import io.github.ruflun.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;
import java.util.function.BiFunction;

public class MojaveRootseed extends Block {

    // Value used for the "radius" of the block's processing. (ex: putting a radius of 3 will make the block act in a 7x7x7 zone including itself in the center)
    private static final int blockRadius = 3;
    // List of blocks that can be converted
    private static final List<Block> validBlocks = List.of(
            Blocks.DIRT,
            Blocks.COARSE_DIRT,
            Blocks.ROOTED_DIRT,
            Blocks.MUD,
            Blocks.MUDDY_MANGROVE_ROOTS
    );
    // Conversion map for valid blocks
    private static final HashMap<Block, Block> conversionMap = new HashMap<Block, Block>(Map.of(
            Blocks.DIRT, ModBlocks.MOJAVE_ORE,
            Blocks.COARSE_DIRT, ModBlocks.MOJAVE_ORE,
            Blocks.ROOTED_DIRT, ModBlocks.MOJAVE_ORE,
            Blocks.MUD, ModBlocks.MUD_MOJAVE_ORE,
            Blocks.MUDDY_MANGROVE_ROOTS, ModBlocks.MUD_MOJAVE_ORE
    ));



    public MojaveRootseed(Properties properties) {
        super(properties
                .strength(4.5f, 3f)
                .sound(SoundType.BONE_BLOCK)
                .randomTicks()
        );
    }

    public static final BiFunction<Block, Item.Properties, BlockItem> blockItemProperties = (block, properties) -> {
        return new BlockItem(block, properties
                .component(
                        DataComponents.LORE,
                        new ItemLore(List.of(
                                Component.translatable("tooltip.rufrix.mojave_rootseed").withColor(TextColor.GRAY)
                        ))
                )
        );
    };

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.15f) {
            ArrayList<BlockPos> detectedBlocks = new ArrayList<>();
            for (BlockPos p : BlockPos.betweenClosed(
                    pos.offset(-blockRadius, -blockRadius, -blockRadius),
                    pos.offset(blockRadius, blockRadius, blockRadius))
            ) {
                if (validBlocks.contains(level.getBlockState(p).getBlock())) {
                    detectedBlocks.add(p.immutable());
                }
            }

            if (!detectedBlocks.isEmpty()) {
                BlockPos chosen = detectedBlocks.get(random.nextIntBetweenInclusive(0, detectedBlocks.size() - 1));
                level.setBlock(
                        chosen,
                        conversionMap.get(level.getBlockState(chosen).getBlock()).defaultBlockState(),
                        Block.UPDATE_CLIENTS
                );
            }
        }
    }
}
