package com.themourad.essx;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public final class EssxClient implements ClientModInitializer {
    private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(
        Identifier.fromNamespaceAndPath("essx", "main")
    );

    private static final KeyMapping OPEN_MENU = KeyMappingHelper.registerKeyMapping(
        new KeyMapping(
            "key.essx.open",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_RIGHT_SHIFT,
            CATEGORY
        )
    );

    private static final KeyMapping CYCLE_COSMETIC = KeyMappingHelper.registerKeyMapping(
        new KeyMapping(
            "key.essx.cycle_cosmetic",
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_K,
            CATEGORY
        )
    );

    @Override
    public void onInitializeClient() {
        EssxLocalProfile.load(FabricLoader.getInstance().getConfigDir().resolve("essx"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_MENU.consumeClick()) {
                if (client.player != null) {
                    client.setScreen(new EssxScreen());
                }
            }
            while (CYCLE_COSMETIC.consumeClick()) {
                EssxLocalProfile.cycleCosmetic();
            }
        });
    }
}
