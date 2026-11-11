package com.themourad.essx;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.client.KeyMapping.Category;
import net.minecraft.client.input.KeyEvent;
import org.lwjgl.glfw.GLFW;

public final class EssxClient implements ClientModInitializer {
    private static KeyMapping openMenu;

    @Override
    public void onInitializeClient() {
        openMenu = KeyBindingHelper.registerKeyBinding(
            new KeyMapping(
                "key.essx.open",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                Category.MISC
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.consumeClick()) {
                if (client.player != null) {
                    Minecraft.getInstance().setScreen(new EssxScreen());
                }
            }
        });
    }
}
