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
        output.accept(ModBlocks.UPER_CORE_ORE);
        output.accept(ModItems.UPER_CORE);
        output.accept(ModItems.UPER_ESSENCE);

        // KEEP THIS MONSTROSITY AT THE BOTTOM
        output.accept(ModBlocks.FREAKYMAN);
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
