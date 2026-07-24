package io.github.ruflun.client.datagen;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RuflunSThingamabobsAdvancementProvider extends FabricAdvancementProvider {

    public RuflunSThingamabobsAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.@NonNull Provider registryLookup, @NonNull Consumer<AdvancementHolder> consumer) {
        AdvancementHolder ROOT = Advancement.Builder.advancement()
                .display(
                        ModItems.UPER_CORE,
                        Component.translatable("advancements.rufrix.root.title"),
                        Component.translatable("advancements.rufrix.root.description"),
                        RuflunSThingamabobs.id("textures/gui/advancements/backgrounds/rufluns_thingamabobs.png"),
                        AdvancementType.GOAL,
                        false, false, false
                )
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, RuflunSThingamabobs.id("root"));
    }
}
