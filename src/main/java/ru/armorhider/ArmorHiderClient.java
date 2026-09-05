package ru.armorhider;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.lwjgl.glfw.GLFW;

public class ArmorHiderClient implements ClientModInitializer {

    private static KeyBinding toggle;

    @Override
    public void onInitializeClient() {
        toggle = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.armorhider.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.armorhider"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggle.wasPressed()) {
                boolean hidden = ArmorHider.toggle();
                notify(client, hidden ? "Броня скрыта" : "Броня видна", hidden);
            }
        });
    }

    private static void notify(MinecraftClient client, String message, boolean hidden) {
        if (client.player == null) return;
        client.player.sendMessage(
                Text.literal(message).formatted(hidden ? Formatting.AQUA : Formatting.GRAY), true);
    }
}
