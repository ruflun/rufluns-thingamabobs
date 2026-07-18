package io.github.ruflun.item;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Function;

public class MiscItems {
    // Test item (whose name is way too long)
    public static final Function<Item.Properties, Item> TEST_ITEM = properties -> new Item(properties
            .rarity(Rarity.EPIC)
            .stacksTo(4)
            .food(
                    new FoodProperties.Builder()
                            .nutrition(500)
                            .saturationModifier(500f)
                            .alwaysEdible()
                            .build(),
                    Consumables.defaultDrink()
                            .animation(ItemUseAnimation.DRINK)
                            .consumeSeconds(4f)
                            .soundAfterConsume(Holder.direct(SoundEvents.PLAYER_BREATH))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                    new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 67676767, 200),
                                    0.95f)
                            )
                            .build()
            )
    );
}
