package ru.armorhider.mixin;

import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.armorhider.ArmorHider;

/** Элитры прячутся вместе с бронёй, той же кнопкой. */
@Mixin(ElytraFeatureRenderer.class)
public abstract class ElytraFeatureRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void armorhider$hideElytra(CallbackInfo ci) {
        if (ArmorHider.isHidden()) {
            ci.cancel();
        }
    }
}
