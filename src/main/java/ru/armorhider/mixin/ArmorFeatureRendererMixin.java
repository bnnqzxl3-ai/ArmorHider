package ru.armorhider.mixin;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.armorhider.ArmorHider;

/** Пока броня скрыта, её слой просто не рисуется. */
@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void armorhider$hideArmor(CallbackInfo ci) {
        if (ArmorHider.isHidden()) {
            ci.cancel();
        }
    }
}
