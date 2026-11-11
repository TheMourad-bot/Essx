package com.themourad.essx;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;

public final class EssxClient implements ClientModInitializer {
    private static final KeyMapping.Category ESSX_CATEGORY =
        KeyMapping.Category.register(Identifier.fromNamespaceAndPath("essx", "main"));

    private static KeyMapping openMenu;

    @Override
    public void onInitializeClient() {
        openMenu = KeyMappingHelper.registerKeyMapping(
            new KeyMapping(
                "key.essx.open",
                InputConstants.Type.KEYSYM,
                InputConstants.KEY_RIGHT_SHIFT,
                ESSX_CATEGORY
            )
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.consumeClick()) {
                if (client.player != null) {
                    client.setScreen(new EssxScreen());
                }
            }
        });
    }
}
