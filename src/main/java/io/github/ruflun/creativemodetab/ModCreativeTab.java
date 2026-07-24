package io.github.ruflun.creativemodetab;

import io.github.ruflun.RuflunSThingamabobs;
import io.github.ruflun.block.ModBlocks;
import io.github.ruflun.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {

    public static final CreativeModeTab.DisplayItemsGenerator display = ((parameters, output) -> {
        output.accept(ModItems.INGOT_MOLD);

        output.accept(ModBlocks.MOJAVE_ROOTSEED);

        output.accept(ModBlocks.UPER_CORE_ORE);
        output.accept(ModItems.UPER_CORE);
        output.accept(ModItems.UPER_ESSENCE);

        output.accept(ModBlocks.MOJAVE_ORE);
        output.accept(ModBlocks.MUD_MOJAVE_ORE);
        output.accept(ModItems.MOJAVE_INGOT);
        output.accept(ModItems.MOJAVE_NUGGET);
        output.accept(ModBlocks.MOJAVE_BLOCK);
        output.accept(ModItems.RAW_MOJAVE);
        output.accept(ModBlocks.RAW_MOJAVE_BLOCK);

        // NOTE: Joke content & the Memetic Essence (main ingredients for joke blocks) shouldn't be available in the creative tab, as they're "secret" items.
    });



    public static final CreativeModeTab RUFLUNS_THINGAMABOBS = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            RuflunSThingamabobs.id("rufluns_thingamabobs"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.UPER_CORE))
                    .title(Component.translatable("creativeTab.rufrix"))
                    .displayItems(display)
                    .backgroundTexture(RuflunSThingamabobs.id("textures/gui/container/creative_inventory/tab_rufluns_thingamabobs.png"))
                    .build()
    );

    public static void registerModTab() {
        RuflunSThingamabobs.LOGGER.info("Registering creative tab for " + RuflunSThingamabobs.MOD_ID);
    }
}
