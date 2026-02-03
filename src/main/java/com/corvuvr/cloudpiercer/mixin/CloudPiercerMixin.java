package com.corvuvr.cloudpiercer.mixin;

import com.corvuvr.cloudpiercer.CloudPiercer;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Level.class)
public abstract class CloudPiercerMixin {

    @Inject(method="getRainLevel", at=@At("RETURN"), cancellable = true)
    protected void setRainLevel(CallbackInfoReturnable<Float> cir)
    {
        cir.setReturnValue(
            CloudPiercer.getRainIntensity((Level)(Object)this, 1.0F)
        );
    }

}
