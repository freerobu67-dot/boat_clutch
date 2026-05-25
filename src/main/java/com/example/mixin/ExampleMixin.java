package com.example.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class ExampleMixin {

    @Inject(method = "startRiding", at = @At("TAIL"))
    private void freezeOnVehicleEnter(Entity vehicle, boolean force, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player) (Object) this;

        if (vehicle.getType().getDescriptionId().contains("boat")) {
            // 1. Clears vertical Y momentum to stall you mid-air exactly like 1.16
            Vec3 currentVelocity = player.getDeltaMovement();
            player.setDeltaMovement(new Vec3(currentVelocity.x, 0.0, currentVelocity.z));
            player.hurtMarked = true; 

            // 2. Wipes the fall distance tracker
            player.fallDistance = 0.0F;
        }
    }
}
