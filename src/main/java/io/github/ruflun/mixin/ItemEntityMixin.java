package io.github.ruflun.mixin;

import io.github.ruflun.tags.ModTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

	protected ItemEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

	@Shadow
	public abstract ItemStack getItem();

	@Inject(method = "tick", at = @At("HEAD"))
	private void rufrix$specialBehavior(CallbackInfo ci) {
		// Floating items funny
		if (getItem().is(ModTags.Items.FLOATING)) {
			setNoGravity(true);
			setDeltaMovement(getDeltaMovement().multiply(new Vec3(0.9, 0.9, 0.9)));
		}
	}
}