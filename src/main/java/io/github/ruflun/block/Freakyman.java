package io.github.ruflun.block;

import io.github.ruflun.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.function.BiFunction;

public class Freakyman extends Block {

    public Freakyman(Properties properties) {
        super(properties);
        properties
                .strength(999999999.9f, 999999999.9f)
                .friction(0.0f)
                .jumpFactor(10.0f)
                .sound(SoundType.FUNGUS)
                .noOcclusion()
                .lightLevel(f -> 15);
    }

    public static final BiFunction<Block, Item.Properties, BlockItem> blockItemProperties = (block, properties) -> new BlockItem(block, properties
            .rarity(Rarity.EPIC)
            .component(
                    DataComponents.LORE,
                    new ItemLore(List.of(
                            Component.translatable("tooltip.rufrix.freakyman.1").withColor(TextColor.GREEN),
                            Component.translatable("tooltip.rufrix.freakyman.2").withColor(TextColor.GREEN),
                            Component.translatable("tooltip.rufrix.freakyman.3").withColor(TextColor.GREEN),
                            Component.translatable("tooltip.rufrix.freakyman.4").withColor(TextColor.DARK_RED)
                    ))
            )
    );


    // haha funni grief block go boom
    private static InteractionResult yesRicoKaboom(Level level, Player player, BlockPos pos) {
        level.explode(
                null,
                pos.getX() + 0.5f,
                pos.getY() + 0.5f,
                pos.getZ() + 0.5f,
                50.0f,
                Level.ExplosionInteraction.BLOCK
        );
        BlockPos.MutableBlockPos pointer = new BlockPos.MutableBlockPos(0, 0, 0);
        RandomSource r = level.getRandom();
        for (int i = 0; i < 50; i++) {
            pointer.set(
                    pos.getX() + r.nextIntBetweenInclusive(-50, 50),
                    pos.getY() + r.nextIntBetweenInclusive(-50, 50),
                    pos.getZ() + r.nextIntBetweenInclusive(-50, 50)
            );
            level.setBlock(pointer, ModBlocks.FREAKYMAN.defaultBlockState(), Block.UPDATE_CLIENTS);
        }
        level.playSound(
                null,
                pos.getX() + 0.5f,
                pos.getY() + 0.5f,
                pos.getZ() + 0.5f,
                ModSounds.DOYOUAREHAVESTUPID,
                SoundSource.HOSTILE,
                1.5f,
                1.0f
        );


        return InteractionResult.SUCCESS;
    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hit
    ) {
        return yesRicoKaboom(level, player, pos);
    }

    @Override
    protected @NonNull InteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        return yesRicoKaboom(level, player, pos);
    }
}
