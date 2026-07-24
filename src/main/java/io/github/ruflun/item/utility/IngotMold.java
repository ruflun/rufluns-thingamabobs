package io.github.ruflun.item.utility;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.component.ItemLore;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class IngotMold extends Item {
    public IngotMold(Properties properties) {
        super(properties
                .stacksTo(1)
                .durability(48)
                .component(
                        DataComponents.LORE,
                        new ItemLore(List.of(
                                Component.translatable("tooltip.rufrix.ingot_mold").withColor(TextColor.GRAY)
                        ))
                )
        );
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(@NonNull ItemStack stack) {
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamageValue(stack.getDamageValue() + 1);
            return ItemStackTemplate.fromStack(moreDamaged);
        }

        return null;
    }
}