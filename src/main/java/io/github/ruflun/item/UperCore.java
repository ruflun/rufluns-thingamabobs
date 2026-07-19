package io.github.ruflun.item;

import io.github.ruflun.loot_table.ModLootTables;
import io.github.ruflun.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class UperCore extends Item {
    public UperCore(Properties properties) {
        super(properties
                .stacksTo(16)
                .fireResistant()
                .component(
                        DataComponents.LORE,
                        new ItemLore(List.of(
                                Component.translatable("tooltip.rufrix.uper_core").withColor(TextColor.GRAY)
                        ))
                )
        );
    }

    @Override
    public @NonNull InteractionResult useOn(UseOnContext ctx) {
        // Letting the player break the core on hard blocks to give Uper essences
        Player plr = ctx.getPlayer();
        if (plr == null) return InteractionResult.FAIL;

        ItemStack core_stack = ctx.getItemInHand();
        if (plr.getCooldowns().isOnCooldown(core_stack)) return InteractionResult.FAIL;

        Level level = ctx.getLevel();
        if (level.isClientSide()) return  InteractionResult.SUCCESS;

        BlockPos pos = ctx.getClickedPos();
        BlockState state = level.getBlockState(pos);
        // Prevent the player from opening the core if they aren't slamming it against a hard block
        if (!state.is(ModTags.Blocks.UPERCORE_OPENER)) {
            plr.getCooldowns().addCooldown(core_stack, 25);
            level.playSound(null, pos, SoundEvents.STONE_STEP, SoundSource.BLOCKS);
            plr.sendOverlayMessage(Component.translatable("message.rufrix.upercore_cannot_open"));
            return InteractionResult.FAIL;
        }

        // Spawning the items via the dedicated loot table
        if (level instanceof ServerLevel serverLevel) {
            LootTable upercore_loot = serverLevel.getServer().reloadableRegistries().getLootTable(ModLootTables.UPERCORE_OPEN);
            LootParams upercore_loot_params = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, plr)
                    .withLuck(plr.getLuck())
                    .create(LootContextParamSets.CHEST);

            for (ItemStack drop_stack : upercore_loot.getRandomItems(upercore_loot_params)) {
                Containers.dropItemStack(
                        level,
                        pos.getX() + 0.5,
                        pos.getY(),
                        pos.getZ() + 0.5,
                        drop_stack);
            }
        }

        // After the loot is generated
        level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS);
        plr.getCooldowns().addCooldown(core_stack, 13);
        core_stack.shrink(1);

        return InteractionResult.SUCCESS;
    }
}
