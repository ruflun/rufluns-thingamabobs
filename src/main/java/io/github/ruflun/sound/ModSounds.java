package io.github.ruflun.sound;

import io.github.ruflun.RuflunSThingamabobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final SoundEvent DOYOUAREHAVESTUPID = register("doyouarehavestupid");



    private static SoundEvent register(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(RuflunSThingamabobs.MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void registerModSounds() {
        RuflunSThingamabobs.LOGGER.info("Registering sounds for " + RuflunSThingamabobs.MOD_ID);
    }
}
