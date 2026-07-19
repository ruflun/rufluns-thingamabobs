package io.github.ruflun.item;

import io.github.ruflun.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;

import java.util.List;

public class TestItem extends Item {

    public TestItem(Properties properties) {
        super(properties
                .rarity(Rarity.EPIC)
                .stacksTo(4)
                .component(
                        DataComponents.DEATH_PROTECTION,
                        new DeathProtection(List.of(
                                new ClearAllStatusEffectsConsumeEffect(),
                                new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.LEVITATION, 3, 200)
                                )
                        ))
                )
                .component(
                        DataComponents.LORE,
                        new ItemLore(List.of(
                                Component.translatable("tooltip.rufrix.test_item")
                                        .withColor(TextColor.DARK_PURPLE)
                        ))
                )
                .food(
                        new FoodProperties.Builder()
                                .nutrition(500)
                                .saturationModifier(500f)
                                .alwaysEdible()
                                .build(),
                        Consumables.defaultDrink()
                                .animation(ItemUseAnimation.BRUSH)
                                .consumeSeconds(4f)
                                .soundAfterConsume(Holder.direct(ModSounds.DOYOUAREHAVESTUPID))
                                .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 200),
                                        0.95f)
                                )
                                .build()
                )
        );
    }
}
